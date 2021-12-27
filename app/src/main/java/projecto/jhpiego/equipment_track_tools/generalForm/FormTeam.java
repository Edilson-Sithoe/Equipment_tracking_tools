package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormTeam extends AppCompatActivity {
    private Button btn_next, btnBack;
    private String cbo_tecn_specil_available;
    private TextView txt_total_number_tecni;
    private TextView txt_number_tec_specia_health;
    private TextView txt_number_biomedical;
    private String cbo_safety_program_ox2;
    private TextView txt_responsable_savefy_program;
    private String cbo_national_sec_system;
    String[] mensagens = {"Fill in all fields", "Fail to registration", "Registration performed successfully"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_team);

     //   getSupportActionBar().hide();
        InicializarComponentoes();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tecn_specil_available = cbo_tecn_specil_available;
                String total_number_tecni = txt_total_number_tecni.getText().toString();
                String number_tec_specia_health = txt_number_tec_specia_health.getText().toString();
                String number_biomedical = txt_number_biomedical.getText().toString();
                String safety_program_ox2 = cbo_safety_program_ox2;
                String responsable_savefy_program = txt_responsable_savefy_program.getText().toString();
                String national_sec_system = cbo_national_sec_system;

                if (TextUtils.isEmpty(total_number_tecni) || TextUtils.isEmpty(number_tec_specia_health) || TextUtils.isEmpty(responsable_savefy_program)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setTecn_specil_available(tecn_specil_available);
                    Assessment.assessment_model.setTotal_number_tecni(total_number_tecni);
                    Assessment.assessment_model.setNumber_tec_specia_health(number_tec_specia_health);
                    Assessment.assessment_model.setNumber_biomedical(number_biomedical);
                    Assessment.assessment_model.setSafety_program_ox2(safety_program_ox2);
                    Assessment.assessment_model.setResponsable_savefy_program(responsable_savefy_program);
                    Assessment.assessment_model.setNational_sec_system(national_sec_system);

                    Intent i = new Intent(FormTeam.this, FormTrainDocCylinders.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormTeam.this, FormSupervisory.class);
                startActivity(i);
            }
        });
    }

    public void onRadioButtonClicked_team(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesTM:
                if (checked)
                    cbo_tecn_specil_available = "Yes";
                break;
            case R.id.chkNoTM:
                if (checked)
                    cbo_tecn_specil_available = "No";
                break;
        }
    }

    public void onRadioButtonClicked2_team(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSPO2:
                if (checked)
                    cbo_safety_program_ox2 = "Yes";
                break;
            case R.id.chkNoSPO2:
                if (checked)
                    cbo_safety_program_ox2 = "No";
                break;
        }
    }

    public void onRadioButtonClicked3_team(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesNSS:
                if (checked)
                    cbo_national_sec_system = "Yes";
                break;
            case R.id.chkNoNSS:
                if (checked)
                    cbo_national_sec_system = "No";
                break;
        }
    }


    public void InicializarComponentoes() {
        btnBack = findViewById(R.id.btn_backTEAM);
        btn_next = findViewById(R.id.btn_next);

        txt_total_number_tecni = findViewById(R.id.txtTHFTM);
        txt_number_tec_specia_health = findViewById(R.id.txtTSHFTM);
        txt_number_biomedical = findViewById(R.id.txtBMETM);
        txt_responsable_savefy_program = findViewById(R.id.txtROFSPO2);

    }

    public void Limpar() {
        txt_total_number_tecni.setText("");
        txt_number_tec_specia_health.setText("");
        txt_number_biomedical.setText("");
        txt_responsable_savefy_program.setText("");
    }
}