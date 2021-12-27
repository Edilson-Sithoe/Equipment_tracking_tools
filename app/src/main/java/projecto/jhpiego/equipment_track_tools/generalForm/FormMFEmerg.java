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

public class FormMFEmerg extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private TextView txtcapacity_manifold_emerg,txtdiameter_system_emerg;
    private TextView txthow_many_cylinder_conect_total_emerg, txtaverage_per_month_emerg, txtmost_common_model_cylinder_other_emerg,txtfrequency_pm_mani_emerg;
    private TextView txtname_maintenance_maniFold_emerg,txtaverage_cost_per_year_maniFold_emerg,txtbugdet_maitenance_program_emerg,txtname_cylinder_supply_emerg,txtcomments_manifold_emerg;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_facility_ox_emerg,cbo_manifold_used_emerg,cbo_follow_areas_emerg,cbo_old_sys_emerg,cbo_mani_aut_manu_emerg,  cbo_record_upd;
    private String cbo_most_common_emerg,cbo_connection_cylinder_emerg,cbo_logbook_upd_emerg,cboMain_gen_cond_emerg,cbo_carrie_by_emerg,  cbo_pm_cm_emerg;
    private String cbo_health_fac_receive_emerg, cbo_po_sys_working_emerg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_mfemerg);

      //  getSupportActionBar().hide();
        InitComponents();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manifold_in_health_emerg = cbo_facility_ox_emerg;
                String type_supply_used_manifold_emerg = cbo_manifold_used_emerg;
                String old_system_manifold_emerg = cbo_old_sys_emerg;
                String kind_manifold_emerg = cbo_mani_aut_manu_emerg;
                String capacity_manifold_emerg =  txtcapacity_manifold_emerg.getText().toString();
                String diameter_system_emerg = txtdiameter_system_emerg.getText().toString();
                String how_many_cylinder_conect_total_emerg = txthow_many_cylinder_conect_total_emerg.getText().toString();
                String average_per_month_emerg = txtaverage_per_month_emerg.getText().toString();
                String most_common_model_cylinder_emerg = cbo_most_common_emerg;
                String most_common_model_cylinder_other_emerg = txtmost_common_model_cylinder_other_emerg.getText().toString();
                String type_conection_cylinder_maniFold_emerg = cbo_connection_cylinder_emerg;
                String manifold_working_emerg = cbo_po_sys_working_emerg;
                String condition_system_emerg = cboMain_gen_cond_emerg;
                String active_pm_program_manif_emerg = cbo_logbook_upd_emerg;
                String frequency_pm_mani_emerg = txtfrequency_pm_mani_emerg.getText().toString();
                String activities_by_emerg = cbo_carrie_by_emerg;
                String name_maintenance_maniFold_emerg = txtname_maintenance_maniFold_emerg.getText().toString();
                String average_cost_per_year_maniFold_emerg = txtaverage_cost_per_year_maniFold_emerg.getText().toString();
                String bugdet_maitenance_program_emerg = txtbugdet_maitenance_program_emerg.getText().toString();
                String logbbook_maintenance_emerg = cbo_pm_cm_emerg;
                String logbbook_update_manifold_emerg = cbo_logbook_upd_emerg;
                String name_cylinder_supply_emerg = txtname_cylinder_supply_emerg.getText().toString();
                String how_does_receive_cylinder_emerg = cbo_health_fac_receive_emerg;
                String comments_manifold_emerg = txtcomments_manifold_emerg.getText().toString();


                if (TextUtils.isEmpty(capacity_manifold_emerg) ||TextUtils.isEmpty(diameter_system_emerg)||TextUtils.isEmpty(how_many_cylinder_conect_total_emerg)
                        ||TextUtils.isEmpty(average_per_month_emerg)|| TextUtils.isEmpty(frequency_pm_mani_emerg)||TextUtils.isEmpty(name_maintenance_maniFold_emerg)||
                        TextUtils.isEmpty(average_cost_per_year_maniFold_emerg) ||TextUtils.isEmpty(bugdet_maitenance_program_emerg) ||
                        TextUtils.isEmpty(name_cylinder_supply_emerg)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178,34,34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setManifold_in_health_emerg(manifold_in_health_emerg);
                    Assessment.assessment_model.setType_supply_used_manifold_emerg(type_supply_used_manifold_emerg);
                    Assessment.assessment_model.setOld_system_manifold_emerg(old_system_manifold_emerg);
                    Assessment.assessment_model.setKind_manifold_emerg(kind_manifold_emerg);
                    Assessment.assessment_model.setCapacity_manifold_emerg(txtcapacity_manifold_emerg.getText().toString());
                    Assessment.assessment_model.setDiameter_system_emerg(txtdiameter_system_emerg.getText().toString());
                    Assessment.assessment_model.setHow_many_cylinder_conect_total_emerg(txthow_many_cylinder_conect_total_emerg.getText().toString());
                    Assessment.assessment_model.setAverage_per_month_emerg(txtaverage_per_month_emerg.getText().toString());
                    Assessment.assessment_model.setMost_common_model_cylinder_emerg(most_common_model_cylinder_emerg);
                    Assessment.assessment_model.setMost_common_model_cylinder_other_emerg(txtmost_common_model_cylinder_other_emerg.getText().toString());
                    Assessment.assessment_model.setType_conection_cylinder_mani_emerg(type_conection_cylinder_maniFold_emerg);
                    Assessment.assessment_model.setManifold_working_emerg(manifold_working_emerg);
                    Assessment.assessment_model.setCondition_system_emerg(condition_system_emerg);
                    Assessment.assessment_model.setActive_pm_program_manif_emerg(active_pm_program_manif_emerg);
                    Assessment.assessment_model.setFrequency_pm_mani_emerg(txtfrequency_pm_mani_emerg.getText().toString());
                    Assessment.assessment_model.setActivities_by_emerg(activities_by_emerg);
                    Assessment.assessment_model.setName_maintenance_maniFold_emerg(txtname_maintenance_maniFold_emerg.getText().toString());
                    Assessment.assessment_model.setAverage_cost_per_year_emerg(txtaverage_cost_per_year_maniFold_emerg.getText().toString());
                    Assessment.assessment_model.setBugdet_maitenance_program_emerg(txtbugdet_maitenance_program_emerg.getText().toString());
                    Assessment.assessment_model.setLogbbook_maintena_emerg(logbbook_maintenance_emerg);
                    Assessment.assessment_model.setLogbbook_update_manifold_emerg(logbbook_update_manifold_emerg);
                    Assessment.assessment_model.setName_cylinder_supply_emerg(txtname_cylinder_supply_emerg.getText().toString());
                    Assessment.assessment_model.setHow_does_receive_cylinder_emerg(how_does_receive_cylinder_emerg);
                    Assessment.assessment_model.setComments_manifold_emerg(txtcomments_manifold_emerg.getText().toString());

                    Intent i = new Intent(FormMFEmerg.this, FormLiquidOx.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backMFT = new Intent(FormMFEmerg.this, FormManiFoldTwoo.class);
                startActivity(backMFT);
            }
        });

    }
    public void onRadioButtonClicked_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesME:
                if (checked)
                    cbo_facility_ox_emerg = "Yes";
                break;
            case R.id.idChkNoME:
                if (checked)
                    cbo_facility_ox_emerg = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPrimaME:
                if (checked)
                    cbo_manifold_used_emerg = "Primary";
                break;
            case R.id.chkSecondME:
                if (checked)
                    cbo_manifold_used_emerg = "Secondary";
                break;
            case R.id.chkEmergME:
                if (checked)
                    cbo_manifold_used_emerg = "Emergency";
                break;
        }
    }

    public void onRadioButtonClicked2_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkLessME:
                if (checked)
                    cbo_old_sys_emerg = "Less than 3 years";
                break;
            case R.id.chkB3_10ME:
                if (checked)
                    cbo_old_sys_emerg = "Between 3-10 years";
                break;
            case R.id.idChkB11_20ME:
                if (checked)
                    cbo_old_sys_emerg = "Between 11-20 years";
                break;
            case R.id.idChkMore20ME:
                if (checked)
                    cbo_old_sys_emerg = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked3_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkMANME:
                if (checked)
                    cbo_mani_aut_manu_emerg = "Manual";
                break;
            case R.id.chkAUTOME:
                if (checked)
                    cbo_mani_aut_manu_emerg = "Automatic";
                break;
        }
    }

    public void onRadioButtonClicked4_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEME:
                if (checked)
                    cbo_most_common_emerg = "E (1m3/680L)";
                break;
            case R.id.chkFME:
                if (checked)
                    cbo_most_common_emerg = "F (1.5/1360L)";
                break;
            case R.id.chkGME:
                if (checked)
                    cbo_most_common_emerg = "G (3.5m3/3400L)\"";
                break;
            case R.id.chkJME:
                if (checked)
                    cbo_most_common_emerg = "J (7.5m3/7800L)";
                break;
            case R.id.chkDontNoME:
                if (checked)
                    cbo_most_common_emerg = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked5_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPINME:
                if (checked)
                    cbo_connection_cylinder_emerg = "Pin index";
                break;
            case R.id.chkPINSMF:
                if (checked)
                    cbo_connection_cylinder_emerg = "Pin-index side spindle valve";
                break;
            case R.id.chkBullnoseME:
                if (checked)
                    cbo_connection_cylinder_emerg = "Bullnose valve";
                break;
            case R.id.chkHandwheelME:
                if (checked)
                    cbo_connection_cylinder_emerg = "Handwheel side outlet";
                break;
        }
    }

    public void onRadioButtonClicked6_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYME:
                if (checked)
                    cbo_po_sys_working_emerg = "Yes";
                break;
            case R.id.chkNME:
                if (checked)
                    cbo_po_sys_working_emerg = "No";
                break;
            case R.id.chkPartlyME:
                if (checked)
                    cbo_po_sys_working_emerg = "Partly";
                break;
            case R.id.chkDontNME:
                if (checked)
                    cbo_po_sys_working_emerg = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked7_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkGIUME:
                if (checked)
                    cboMain_gen_cond_emerg = "Good and in use";
                break;
            case R.id.chkGBNUME:
                if (checked)
                    cboMain_gen_cond_emerg = "Good, but not in use";
                break;
            case R.id.chkIU_BNRME:
                if (checked)
                    cboMain_gen_cond_emerg = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRME:
                if (checked)
                    cboMain_gen_cond_emerg = "In use, but needs to be replaced";
            case R.id.chkOOSBRME:
                if (checked)
                    cboMain_gen_cond_emerg = "Out of service, but repairable";
            case R.id.chkOOSAndNRME:
                if (checked)
                    cboMain_gen_cond_emerg = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaME:
                if (checked)
                    cboMain_gen_cond_emerg = "Still in the installation phase";
            case R.id.chkDontKnowME:
                if (checked)
                    cboMain_gen_cond_emerg = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked8_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESPMME:
                if (checked)
                    cbo_logbook_upd_emerg = "Yes";
                break;
            case R.id.chkNOPMME:
                if (checked)
                    cbo_logbook_upd_emerg = "No";
                break;
        }
    }

    public void onRadioButtonClicked9_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFME:
                if (checked)
                    cbo_carrie_by_emerg = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDIME:
                if (checked)
                    cbo_carrie_by_emerg = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubCME:
                if (checked)
                    cbo_carrie_by_emerg = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicke10_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMCMME:
                if (checked)
                    cbo_pm_cm_emerg = "Yes";
                break;
            case R.id.chkNOSPMCMME:
                if (checked)
                    cbo_pm_cm_emerg = "No";
                break;
        }
    }

    public void onRadioButtonClicke11_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESKBME:
                if (checked)
                    cbo_record_upd = "Yes";
                break;
            case R.id.chkNOLBME:
                if (checked)
                    cbo_record_upd = "No";
                break;
        }
    }

    public void onRadioButtonClicked12_emerg(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDailyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Daily";
                break;
            case R.id.chkWeeklyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Weekly";
                break;
            case R.id.chkFortnightlyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Fortnightly";
                break;
            case R.id.chkMonthlyME:
                if (checked)
                    cbo_health_fac_receive_emerg = "Monthly";
                break;
            case R.id.chkOnrequestME:
                if (checked)
                    cbo_health_fac_receive_emerg = "On request";
                break;
        }
    }

    public void InitComponents(){
        btnBack = findViewById(R.id.btn_backME);
        btnNExt = findViewById(R.id.btn_next);

     /*   chkYesMF = findViewById(R.id.idChkYesME);
        chkNoMF = findViewById(R.id.idChkNoME);

        chkPrimaMF = findViewById(R.id.chkPrimaME);
        chkSecondMF = findViewById(R.id.chkSecondME);
        chkEmergMF = findViewById(R.id.chkEmergME);

        chkLess = findViewById(R.id.chkLessME);
        chkB3_10 = findViewById(R.id.chkB3_10ME);
        chkB11_20 = findViewById(R.id.idChkB11_20ME);
        chkMore20 = findViewById(R.id.idChkMore20ME);

        chkMANMF = findViewById(R.id.chkMANME);
        chkAUTOMF = findViewById(R.id.chkAUTOME);*/

        txtcapacity_manifold_emerg = findViewById(R.id.txtLPMME);

        txtdiameter_system_emerg = findViewById(R.id.txtMMME);

        txthow_many_cylinder_conect_total_emerg = findViewById(R.id.txtCCMF);

        txtaverage_per_month_emerg = findViewById(R.id.txtAGVMonthME);

     /*   chkEMF = findViewById(R.id.chkEME);
        chkFMF = findViewById(R.id.chkFME);
        chkGMF = findViewById(R.id.chkGME);
        chkJMF = findViewById(R.id.chkJME);
        chkDontNoMF = findViewById(R.id.chkDontNoME);*/
        txtmost_common_model_cylinder_other_emerg = findViewById(R.id.txtOtherME);

     /*   chkPINMF = findViewById(R.id.chkPINME);
        chkPINMF = findViewById(R.id.chkPINME);
        chkBullnoseMF = findViewById(R.id.chkBullnoseME);
        chkHandwheelMF = findViewById(R.id.chkHandwheelME);

        chkYMF = findViewById(R.id.chkYME);
        chkNMF = findViewById(R.id.chkNME);
        chkPartlyMF = findViewById(R.id.chkPartlyME);
        chkDontNMF = findViewById(R.id.chkDontNME);

        chkGIUMF = findViewById(R.id.chkGIUME);
        chkGBNUMF = findViewById(R.id.chkGBNUME);
        chkIU_BNRMF = findViewById(R.id.chkIU_BNRME);
        chkIUNNTRMF = findViewById(R.id.chkIUNNTRME);
        chkOOSBRMF = findViewById(R.id.chkOOSBRME);
        chkOOSAndNRMF = findViewById(R.id.chkOOSAndNRME);
        chkStilInstPhaMF = findViewById(R.id.chkStilInstPhaME);
        chkDontNMF = findViewById(R.id.chkDontNME);

        chkYESPMMF = findViewById(R.id.chkYESPMME);*
        chkNOPMMF = findViewById(R.id.chkNOPMME);*/

        txtfrequency_pm_mani_emerg = findViewById(R.id.txtFPMME);

       /* chkPHFMF = findViewById(R.id.chkPHFME);
        chkPDIMF = findViewById(R.id.chkPDIME);
        chkSubCMF = findViewById(R.id.chkSubCME);*/

        txtname_maintenance_maniFold_emerg = findViewById(R.id.txtNMCME);
        txtaverage_cost_per_year_maniFold_emerg = findViewById(R.id.txtAVGCostME);
        txtbugdet_maitenance_program_emerg = findViewById(R.id.txtBMPME);


      /*  chkYesPMCMMF = findViewById(R.id.chkYesPMCMME);
        chkNOSPMCMMF = findViewById(R.id.chkNOSPMCMME);

        chkYESKBMF = findViewById(R.id.chkYESKBME);
        chkNOLBMF = findViewById(R.id.chkNOLBME);*/

        txtname_cylinder_supply_emerg = findViewById(R.id.txtCSME);

     /*   chkDailyMF = findViewById(R.id.chkDailyME);
        chkWeeklyMF = findViewById(R.id.chkWeeklyME);
        chkFortnightlyMF = findViewById(R.id.chkFortnightlyME);
        chkMonthlyMF = findViewById(R.id.chkMonthlyME);
        chkOnrequestMF = findViewById(R.id.chkOnrequestME);*/

        txtcomments_manifold_emerg = findViewById(R.id.txtCommentsME);
    }

    public void LimparCampos(){
        txtcapacity_manifold_emerg.setText("");
        txtdiameter_system_emerg.setText("");
        txthow_many_cylinder_conect_total_emerg.setText("");
        txtaverage_per_month_emerg.setText("");
        txtmost_common_model_cylinder_other_emerg.setText("");
        txtfrequency_pm_mani_emerg.setText("");
        txtname_maintenance_maniFold_emerg.setText("");
        txtaverage_cost_per_year_maniFold_emerg.setText("");
        txtbugdet_maitenance_program_emerg.setText("");
        txtname_cylinder_supply_emerg.setText("");
        txtcomments_manifold_emerg.setText("");
    }
}