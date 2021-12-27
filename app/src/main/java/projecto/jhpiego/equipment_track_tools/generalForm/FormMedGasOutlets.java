package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment_aux;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;


public class FormMedGasOutlets extends AppCompatActivity {
    private Button btnSave, btnBack;
    private String cbo_end_users_gas_outlets,cbo_frequency_trainig_gas_out;
    private TextView txt_how_many_end_users, txt_comments_med_gas_outlets;
    String [] mensagens = {"Preencha todos os campos","Falha ao registar","Registado com sucesso"};
    public static final String TAG = "FormMedGasOutlets";

    Database_connection DB;

    FormIdentiInterView formIdentiInterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_med_gas_outlets);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      //  getSupportActionBar().hide();
        InitComponents();

        DB = new Database_connection(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String end_users_gas_outlets = cbo_end_users_gas_outlets;
           //    String frequency_trainig_gas_out = cbo_frequency_trainig_gas_out;
               String how_many_end_users = txt_how_many_end_users.getText().toString();
               String comments_med_gas_outlets = txt_comments_med_gas_outlets.getText().toString();

               if (TextUtils.isEmpty(how_many_end_users)) {
                   Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                   snackbar.setBackgroundTint(Color.RED);
                   snackbar.setTextColor(Color.WHITE);
                   snackbar.show();
               } else {

                   Assessment.assessment_model.setEnd_users_gas_outlets(end_users_gas_outlets);
                 //  Assessment.assessment_model.setFrequency_trainig_gas_out(frequency_trainig_gas_out);
                   Assessment.assessment_model.setHow_many_end_users(how_many_end_users);
                   Assessment.assessment_model.setComments_med_gas_outlets(comments_med_gas_outlets);

                   Boolean insert = DB.assessment();
                   if (insert == true) {
                       Snackbar snackbar = Snackbar.make(v, mensagens[2], Snackbar.LENGTH_SHORT);
                       snackbar.setBackgroundTint(Color.BLUE);
                       snackbar.setTextColor(Color.WHITE);
                       snackbar.show();
                       Limpar();
                  /*
                      // Intent i = new Intent(FormMedGasOutlets.this, TelaPrincipal.class);
                      // startActivity(i);*/
                   }else {
                       Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                       snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                       snackbar.setTextColor(Color.WHITE);
                       snackbar.show();
                   }
               }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormMedGasOutlets.this, FormOxFactory.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_med_gas_out(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    cbo_end_users_gas_outlets = "Yes";
                break;
            case R.id.radio_no:
                if (checked)
                    cbo_end_users_gas_outlets = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_med_gas_out(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_six:
                if (checked)
                    Assessment.assessment_model.setFrequency_trainig_gas_out("Every 6 month");
                else
                    break;
            case R.id.radio_year:
                if (checked)
                    Assessment.assessment_model.setFrequency_trainig_gas_out("Every year");
                else

                    break;
            case R.id.radio_two_year:
                if (checked)
                    Assessment.assessment_model.setFrequency_trainig_gas_out("Every 2 year");
                else
                    break;
            case R.id.radio_five_year:
                if (checked)
                    Assessment.assessment_model.setFrequency_trainig_gas_out("Every 5 year");
                else
                    break;
            case R.id.radio_request:
                if (checked)
                    Assessment.assessment_model.setFrequency_trainig_gas_out("On-request");
                else
                    break;
        }
    }


    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backMGS);
        btnSave = findViewById(R.id.btn_save);

        txt_how_many_end_users = findViewById(R.id.txtMTTH);
        txt_comments_med_gas_outlets = findViewById(R.id.txtCommentsTraiC);
    }

    public void Limpar() {
        txt_how_many_end_users.setText("");
        txt_comments_med_gas_outlets.setText("");
    }
}