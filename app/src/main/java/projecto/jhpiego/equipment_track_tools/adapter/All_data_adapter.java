package projecto.jhpiego.equipment_track_tools.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import projecto.jhpiego.equipment_track_tools.R;

public class All_data_adapter extends RecyclerView.Adapter<All_data_adapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList facil_id, facil_name, province;

    Animation translate_anim;

    public All_data_adapter(Context context, Activity activity, ArrayList facil_id, ArrayList facil_name, ArrayList province) {
        this.context = context;
        this.activity = activity;
        this.facil_id = facil_id;
        this.facil_name = facil_name;
        this.province = province;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.all_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.facil_id.setText(String.valueOf(facil_id.get(position)));
        holder.facil_name.setText(String.valueOf(facil_name.get(position)));
        holder.province.setText(String.valueOf(province.get(position)));

      /*  holder.mainLayout_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, )
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView facil_id, facil_name, province;
        LinearLayout mainLayout_data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            facil_id = itemView.findViewById(R.id.facil_id);
            facil_name = itemView.findViewById(R.id.facil_name);
            province = itemView.findViewById(R.id.province);

            mainLayout_data = itemView.findViewById(R.id.mainLayout_data);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout_data.setAnimation(translate_anim);

        }
    }
}
