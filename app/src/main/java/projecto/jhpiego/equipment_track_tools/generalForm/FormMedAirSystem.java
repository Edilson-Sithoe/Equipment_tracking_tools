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

public class FormMedAirSystem extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private String cbo_medical_air_mas, cbo_old_system_mas,cbo_system_working_mmas, cbo_condition_system_mas, cbo_active_pm_mas;
    private String cbo_activies_carries_by_mas;
    private TextView txt_system_capacity_mas,txt_frequency_system_mas, txt_name_maintenance_mas, txt_average_mas, txt_budget_mas, txt_comments_mas;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_med_air_system);

    //    getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String medical_air_mas = cbo_medical_air_mas;
                String old_system_mas = cbo_old_system_mas;
                String system_capacity_mas = txt_system_capacity_mas.getText().toString();
                String system_working_mmas = cbo_system_working_mmas;
                String condition_system_mas =  cbo_condition_system_mas;
                String active_pm_mas = cbo_active_pm_mas;
                String frequency_system_mas = txt_frequency_system_mas.getText().toString();
                String activies_carries_by_mas = cbo_activies_carries_by_mas;
                String name_maintenance_mas = txt_name_maintenance_mas.getText().toString();
                String average_mas = txt_average_mas.getText().toString();
                String budget_mas = txt_budget_mas.getText().toString();
                String comments_mas = txt_comments_mas.getText().toString();

                if (TextUtils.isEmpty(system_capacity_mas) ||TextUtils.isEmpty(frequency_system_mas)||TextUtils.isEmpty(name_maintenance_mas)
                        ||TextUtils.isEmpty(average_mas)|| TextUtils.isEmpty(budget_mas)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setMedical_air_mas(medical_air_mas);
                    Assessment.assessment_model.setOld_system_mas(old_system_mas);
                    Assessment.assessment_model.setSystem_capacity_mas(txt_system_capacity_mas.getText().toString());
                    Assessment.assessment_model.setSystem_working_mmas(system_working_mmas);
                    Assessment.assessment_model.setCondition_system_mas(condition_system_mas);
                    Assessment.assessment_model.setActive_pm_mas(active_pm_mas);
                    Assessment.assessment_model.setFrequency_system_mas(txt_frequency_system_mas.getText().toString());
                    Assessment.assessment_model.setActivies_carries_by_mas(activies_carries_by_mas);
                    Assessment.assessment_model.setName_maintenance_mas(txt_name_maintenance_mas.getText().toString());
                    Assessment.assessment_model.setAverage_mas(txt_average_mas.getText().toString());
                    Assessment.assessment_model.setBudget_mas(txt_budget_mas.getText().toString());
                    Assessment.assessment_model.setComments_mas(txt_comments_mas.getText().toString());

                    Intent i = new Intent(FormMedAirSystem.this, FormMainPiping.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormMedAirSystem.this, FormVaccumSystem.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_med(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMAS:
                if (checked)
                    cbo_medical_air_mas = "Yes";
                break;
            case R.id.chkNoMAS:
                if (checked)
                    cbo_medical_air_mas = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_med(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkLessMAS:
                if (checked)
                    cbo_old_system_mas = "Less than 3 years";
                break;
            case R.id.chkB3_10MAS:
                if (checked)
                    cbo_old_system_mas = "Between 3-10 years";
                break;
            case R.id.chkB11_20MAS:
                if (checked)
                    cbo_old_system_mas = "Between 11-20 years";
                break;
            case R.id.chkMore20MAS:
                if (checked)
                    cbo_old_system_mas = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked2_med(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSWMAS:
                if (checked)
                    cbo_system_working_mmas = "Yes";
                break;
            case R.id.chkNoSWMAS:
                if (checked)
                    cbo_system_working_mmas = "No";
                break;
            case R.id.chkPartlySWMAS:
                if (checked)
                    cbo_system_working_mmas = "Partly";
                break;
            case R.id.chkDontNSWMAS:
                if (checked)
                    cbo_system_working_mmas = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked3_med(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkGIUMAS:
                if (checked)
                    cbo_condition_system_mas = "Good and in use";
                break;
            case R.id.chkGBNUMAS:
                if (checked)
                    cbo_condition_system_mas = "Good, but not in use";
                break;
            case R.id.chkIU_BNRMAS:
                if (checked)
                    cbo_condition_system_mas = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRMAS:
                if (checked)
                    cbo_condition_system_mas = "In use, but needs to be replaced";
            case R.id.chkOOSBRMAS:
                if (checked)
                    cbo_condition_system_mas = "Out of service, but repairable";
            case R.id.chkOOSAndNRMAS:
                if (checked)
                    cbo_condition_system_mas = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaMAS:
                if (checked)
                    cbo_condition_system_mas = "Still in the installation phase";
            case R.id.chkDontNMAS:
                if (checked)
                    cbo_condition_system_mas = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked4_med(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMMAS:
                if (checked)
                    cbo_active_pm_mas = "Yes";
                break;
            case R.id.chkNoPMMAS:
                if (checked)
                    cbo_active_pm_mas = "No";
                break;
        }
    }

    public void onRadioButtonClicked5_med(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFMAS:
                if (checked)
                    cbo_activies_carries_by_mas = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIMAS:
                if (checked)
                    cbo_activies_carries_by_mas = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCMAS:
                if (checked)
                    cbo_activies_carries_by_mas = "Subcontracted";
                break;
        }
    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backMAS);
        btnNExt = findViewById(R.id.btn_next);

        txt_system_capacity_mas = findViewById(R.id.txtLPMMAS);
        txt_frequency_system_mas = findViewById(R.id.txtFPMMAS);
        txt_name_maintenance_mas = findViewById(R.id.txtSubCMAS);
        txt_average_mas = findViewById(R.id.txtMAPMMAS);
        txt_budget_mas = findViewById(R.id.txtBudgteMAS);
        txt_comments_mas = findViewById(R.id.txtCommentMAS);
    }

    public void LimparCampos(){
        txt_system_capacity_mas.setText("");
        txt_frequency_system_mas.setText("");
        txt_name_maintenance_mas.setText("");
        txt_average_mas.setText("");
        txt_budget_mas.setText("");
        txt_comments_mas.setText("");
    }
}