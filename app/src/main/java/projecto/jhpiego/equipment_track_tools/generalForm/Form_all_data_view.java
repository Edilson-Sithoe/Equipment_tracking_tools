package projecto.jhpiego.equipment_track_tools.generalForm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.adapter.All_data_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment_aux;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class Form_all_data_view extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
  //  Assessment_aux assessment_aux;
    Database_connection database_connection;
    ArrayList<String> facil_id, facil_name, province;
    All_data_adapter all_data_adapter;

    ImageView imageView;
    TextView textView;

    String[] mensagens = {"No data to show"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_all_data_view);

        Init_components();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form_all_data_view.this, FormInterviewID.class);
                startActivity(intent);
            }
        });

        database_connection = new Database_connection(Form_all_data_view.this);
        facil_id = new ArrayList<>();
        facil_name = new ArrayList<>();
        province = new ArrayList<>();

        Display_data();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void Display_data() {
        Cursor cursor = database_connection.readAllData_form();
        if (cursor.getCount() == 0) {
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                facil_id.add(cursor.getString(0));
                facil_name.add(cursor.getString(1));
                province.add(cursor.getString(2));
            }
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            confirmDialog();

        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover todos registos?");
        builder.setMessage("Pretende apagar todos registos?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Form_all_data_view.this);
                database_connection.deleteAllData_form();
                Intent intent = new Intent(Form_all_data_view.this, Form_all_data_view.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    private void Init_components() {
        recyclerView = findViewById(R.id.recycler_view_all_data);
        add_button = findViewById(R.id.add_btn_data);
        imageView = findViewById(R.id.id_image);
        textView = findViewById(R.id.id_no_data);
    }

}