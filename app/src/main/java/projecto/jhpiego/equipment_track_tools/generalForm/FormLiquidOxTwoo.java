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

public class FormLiquidOxTwoo extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private TextView txt_average_consuming_oxygen_twoo, txt_last_month_consuminh_twoo, txt_tank_owner_other_twoo;
    private TextView txt_capacity_lox_tank_m3_twoo, txt_capacity_lox_tank_ton_twoo, txt_frequency_ox_tank_twoo,  txt_name_maintenance_company_ox_tank_twoo;
    private TextView txt_average_cost_ox_tank_twoo, txt_budget_lox_tank_twoo,  txt_name_supply_ox_tank_twoo,  txt_how_many_tecn_available_twoo,  txt_comment_ox_tank_twoo;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cbo_liquid_oxygen_twoo, cbo_tank_owner_twoo, cbo_old_system_oxygen_twoo, cbo_system_working_ox_tank_twoo, cbo_condition_system_ox_tank_twoo;
    private String cbo_active_pm_program_twoo,  cbo_activie_carrie_by_ox_tank_twoo,  cbo_logbook_mainte_tank_twoo,  cbo_logbook_update_ox_tank_twoo,  cbo_health_receive_lox_twoo;
    private String cbo_shortages_lox_twoo,  cbo_specialized_internal_twoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_liquid_ox_twoo);

     //   getSupportActionBar().hide();
        InitComponents();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String liquid_oxygen_twoo = cbo_liquid_oxygen_twoo;
                String average_consuming_oxygen_twoo = txt_average_consuming_oxygen_twoo.getText().toString();
                String last_month_consuminh_twoo = txt_last_month_consuminh_twoo.getText().toString();
                String tank_owner_twoo = cbo_tank_owner_twoo;
                String tank_owner_other_twoo =  txt_tank_owner_other_twoo.getText().toString();
                String old_system_oxygen_twoo = cbo_old_system_oxygen_twoo;
                String capacity_lox_tank_m3_twoo = txt_capacity_lox_tank_m3_twoo.getText().toString();
                String capacity_lox_tank_ton_twoo = txt_capacity_lox_tank_ton_twoo.getText().toString();
                String system_working_ox_tank_twoo = cbo_system_working_ox_tank_twoo;
                String condition_system_ox_tank_twoo = cbo_condition_system_ox_tank_twoo;
                String active_pm_program_twoo = cbo_active_pm_program_twoo;
                String activie_carrie_by_ox_tank_twoo = cbo_activie_carrie_by_ox_tank_twoo;
                String frequency_ox_tank_twoo = txt_frequency_ox_tank_twoo.getText().toString();
                String name_maintenance_company_ox_tank_twoo = txt_name_maintenance_company_ox_tank_twoo.getText().toString();
                String average_cost_ox_tank_twoo = txt_average_cost_ox_tank_twoo.getText().toString();
                String budget_lox_tank_twoo = txt_budget_lox_tank_twoo.getText().toString();
                String logbook_mainte_tank_twoo = cbo_logbook_mainte_tank_twoo;
                String logbook_update_ox_tank_twoo = cbo_logbook_update_ox_tank_twoo;
                String name_supply_ox_tank_twoo = txt_name_supply_ox_tank_twoo.getText().toString();
                String health_receive_lox_twoo = cbo_health_receive_lox_twoo;
                String shortages_lox_twoo = cbo_shortages_lox_twoo;
                String specialized_internal_twoo = cbo_specialized_internal_twoo;
                String how_many_tecn_available_twoo = txt_how_many_tecn_available_twoo.getText().toString();
                String comment_ox_tank_twoo = txt_comment_ox_tank_twoo.getText().toString();


                if (TextUtils.isEmpty(average_consuming_oxygen_twoo) ||TextUtils.isEmpty(last_month_consuminh_twoo)||TextUtils.isEmpty(capacity_lox_tank_m3_twoo)
                        ||TextUtils.isEmpty(capacity_lox_tank_ton_twoo)|| TextUtils.isEmpty(frequency_ox_tank_twoo)||TextUtils.isEmpty(name_maintenance_company_ox_tank_twoo)||
                        TextUtils.isEmpty(average_cost_ox_tank_twoo) ||TextUtils.isEmpty(budget_lox_tank_twoo) ||
                        TextUtils.isEmpty(name_supply_ox_tank_twoo) ||TextUtils.isEmpty(how_many_tecn_available_twoo)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setLiquid_oxygen(liquid_oxygen_twoo);
                    Assessment.assessment_model.setAverage_consuming_oxygen(txt_average_consuming_oxygen_twoo.getText().toString());
                    Assessment.assessment_model.setLast_month_consuminh(txt_last_month_consuminh_twoo.getText().toString());
                    Assessment.assessment_model.setTank_owner(tank_owner_twoo);
                    Assessment.assessment_model.setTank_owner_other(txt_tank_owner_other_twoo.getText().toString());
                    Assessment.assessment_model.setOld_system_oxygen(old_system_oxygen_twoo);
                    Assessment.assessment_model.setCapacity_lox_tank_m3(txt_capacity_lox_tank_m3_twoo.getText().toString());
                    Assessment.assessment_model.setCapacity_lox_tank_ton(txt_capacity_lox_tank_ton_twoo.getText().toString());
                    Assessment.assessment_model.setSystem_working_ox_tank(system_working_ox_tank_twoo);
                    Assessment.assessment_model.setCondition_system_ox_tank(condition_system_ox_tank_twoo);
                    Assessment.assessment_model.setActive_pm_program(active_pm_program_twoo);
                    Assessment.assessment_model.setActivie_carrie_by_ox_tank(activie_carrie_by_ox_tank_twoo);
                    Assessment.assessment_model.setFrequency_ox_tank(txt_frequency_ox_tank_twoo.getText().toString());
                    Assessment.assessment_model.setName_maintenance_company_ox_tank(txt_name_maintenance_company_ox_tank_twoo.getText().toString());
                    Assessment.assessment_model.setAverage_cost_ox_tank(txt_average_cost_ox_tank_twoo.getText().toString());
                    Assessment.assessment_model.setBudget_lox_tank(txt_budget_lox_tank_twoo.getText().toString());
                    Assessment.assessment_model.setLogbook_mainte_tank(logbook_mainte_tank_twoo);
                    Assessment.assessment_model.setLogbook_update_ox_tank(logbook_update_ox_tank_twoo);
                    Assessment.assessment_model.setName_supply_ox_tank(txt_name_supply_ox_tank_twoo.getText().toString());
                    Assessment.assessment_model.setHealth_receive_lox(health_receive_lox_twoo);
                    Assessment.assessment_model.setShortages_lox(shortages_lox_twoo);
                    Assessment.assessment_model.setSpecialized_internal(specialized_internal_twoo);
                    Assessment.assessment_model.setHow_many_tecn_available(txt_how_many_tecn_available_twoo.getText().toString());
                    Assessment.assessment_model.setComment_ox_tank(txt_comment_ox_tank_twoo.getText().toString());

                    Intent i = new Intent(FormLiquidOxTwoo.this, FormOxFactoryPSA.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLOXT = new Intent(FormLiquidOxTwoo.this, FormLiquidOx.class);
                startActivity(backLOXT);
            }
        });

    }

    public void onRadioButtonClicked_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLOX:
                if (checked)
                    cbo_liquid_oxygen_twoo = "Yes";
                break;
            case R.id.chkNoMFLOX:
                if (checked)
                    cbo_liquid_oxygen_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkMISAULOX:
                if (checked)
                    cbo_tank_owner_twoo = "MISAU-Hospital";
                break;
            case R.id.chkSupLOX:
                if (checked)
                    cbo_tank_owner_twoo = "Supplier";
                break;
        }
    }

    public void onRadioButtonClicked2_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkLessLOX:
                if (checked)
                    cbo_old_system_oxygen_twoo = "Less than 3 years";
                break;
            case R.id.chkB3_10LOX:
                if (checked)
                    cbo_old_system_oxygen_twoo = "Between 3-10 years";
                break;
            case R.id.chkMore20LOX:
                if (checked)
                    cbo_old_system_oxygen_twoo = "Between 11-20 years";
                break;
            case R.id.idChkMore20:
                if (checked)
                    cbo_old_system_oxygen_twoo = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked3_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYLOX:
                if (checked)
                    cbo_system_working_ox_tank_twoo = "Yes";
                break;
            case R.id.chkNLOX:
                if (checked)
                    cbo_system_working_ox_tank_twoo = "No";
                break;
            case R.id.chkPartlyLOX:
                if (checked)
                    cbo_system_working_ox_tank_twoo = "Partly";
                break;
            case R.id.chkDontNLOX:
                if (checked)
                    cbo_system_working_ox_tank_twoo = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked4_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.chkGIULOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "Good and in use";
                break;
            case R.id.chkGBNULOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "Good, but not in use";
                break;
            case R.id.chkIU_BNRLOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "In use, but needs repair";
                break;
            case R.id.chkIUNNTRLOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "In use, but needs to be replaced";
            case R.id.chkOOSBRLOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "Out of service, but repairable";
            case R.id.chkOOSAndNRLOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "Out of service and needs to be replaced";
            case R.id.chkStilInstPhaLOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "Still in the installation phase";
            case R.id.chkDontKnowLOX:
                if (checked)
                    cbo_condition_system_ox_tank_twoo = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked5_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYESPMLOX:
                if (checked)
                    cbo_active_pm_program_twoo = "Yes";
                break;
            case R.id.chkNOPMLOX:
                if (checked)
                    cbo_active_pm_program_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked6_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPHFLOX:
                if (checked)
                    cbo_activie_carrie_by_ox_tank_twoo = "Internal Technical Personnel of the health facility";
                break;
            case R.id.chkPDILOX:
                if (checked)
                    cbo_activie_carrie_by_ox_tank_twoo = "Personnel of the Department of Infrastructure";
                break;
            case R.id.chkSubLOX:
                if (checked)
                    cbo_activie_carrie_by_ox_tank_twoo = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked7_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMCMLOX:
                if (checked)
                    cbo_logbook_mainte_tank_twoo = "Yes";
                break;
            case R.id.chkNoPMCMLOX:
                if (checked)
                    cbo_logbook_mainte_tank_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked8_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLBLOX:
                if (checked)
                    cbo_logbook_update_ox_tank_twoo = "Yes";
                break;
            case R.id.chkNoLBLOX:
                if (checked)
                    cbo_logbook_update_ox_tank_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked9_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDailyLOX:
                if (checked)
                    cbo_health_receive_lox_twoo = "Daily";
                break;
            case R.id.chkWeeklyLOX:
                if (checked)
                    cbo_health_receive_lox_twoo = "Weekly";
                break;
            case R.id.chkFortnightlyLOX:
                if (checked)
                    cbo_health_receive_lox_twoo = "Fortnightly";
                break;
            case R.id.chkMonthlyLOX:
                if (checked)
                    cbo_health_receive_lox_twoo = "Monthly";
                break;
            case R.id.chkOnrequestLOX:
                if (checked)
                    cbo_health_receive_lox_twoo = "On request";
                break;
        }
    }

    public void onRadioButtonClicked10_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYEShorLOX:
                if (checked)
                    cbo_shortages_lox_twoo = "Yes";
                break;
            case R.id.chkNoShorLOX:
                if (checked)
                    cbo_shortages_lox_twoo = "No";
                break;
        }
    }

    public void onRadioButtonClicked11_lox_two(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSITLOX:
                if (checked)
                    cbo_specialized_internal_twoo = "Yes";
                break;
            case R.id.chkNoSITLOX:
                if (checked)
                    cbo_specialized_internal_twoo = "No";
                break;
        }
    }

    public void InitComponents(){
        btnNExt = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.btn_backLOX);
    /*    chkYesLOX = findViewById(R.id.chkYesLOX);
                chkNoMFLOX = findViewById(R.id.chkNoMFLOX);*/
        txt_average_consuming_oxygen_twoo = findViewById(R.id.txtAVGLOX);
        txt_last_month_consuminh_twoo = findViewById(R.id.txtMCLOX);
            /*    chkMISAULOX = findViewById(R.id.chkMISAULOX);
                chkSupLOX = findViewById(R.id.chkSupLOX);
                txtOtherLOX = findViewById(R.id.txtOtherLOX);

                chkLessLOX = findViewById(R.id.chkLessLOX);
                chkB3_10LOX = findViewById(R.id.chkB3_10LOX);
                chkB11_20LOX = findViewById(R.id.chkB11_20LOX);
                chkMore20LOX = findViewById(R.id.chkMore20LOX);*/
        txt_tank_owner_other_twoo = findViewById(R.id.txtOtherLOX);
        txt_capacity_lox_tank_m3_twoo = findViewById(R.id.txtCapaTLOX);
            /*    chkYLOX = findViewById(R.id.chkYLOX);
                chkNLOX = findViewById(R.id.chkNLOX);
                chkPartlyLOX = findViewById(R.id.chkPartlyLOX);
                chkDontNLOX = findViewById(R.id.chkDontNLOX);

                chkGIULOX = findViewById(R.id.chkGIULOX);
                chkGBNULOX = findViewById(R.id.chkGBNULOX);
                chkIU_BNRLOX = findViewById(R.id.chkIU_BNRLOX);
                chkIUNNTRLOX = findViewById(R.id.chkIUNNTRLOX);
                chkOOSBRLOX = findViewById(R.id.chkOOSBRLOX);
                chkOOSAndNRLOX = findViewById(R.id.chkOOSAndNRLOX);
                chkStilInstPhaLOX = findViewById(R.id.chkStilInstPhaLOX);
                chkDontKnowLOX = findViewById(R.id.chkDontKnowLOX);

                chkYESPMLOX = findViewById(R.id.chkYESPMLOX);
                chkNOPMLOX = findViewById(R.id.chkNOPMLOX);

                chkPHFLOX = findViewById(R.id.chkPHFLOX);
                chkPDILOX = findViewById(R.id.chkPDILOX);
                chkSubLOX = findViewById(R.id.chkSubLOX);*/
        txt_capacity_lox_tank_ton_twoo = findViewById(R.id.txtCapTonsLOX);
        txt_frequency_ox_tank_twoo = findViewById(R.id.txtFPMMLOX);
        txt_name_maintenance_company_ox_tank_twoo = findViewById(R.id.txtNMCLOX);
        txt_average_cost_ox_tank_twoo = findViewById(R.id.txtAVGCPMLOX);
            /*    chkYesPMCMLOX = findViewById(R.id.chkYesPMCMLOX);
                chkNoPMCMLOX = findViewById(R.id.chkNoPMCMLOX);

                chkYesLBLOX = findViewById(R.id.chkYesLBLOX);
                chkNoLBLOX = findViewById(R.id.chkNoLBLOX);*/
        txt_budget_lox_tank_twoo = findViewById(R.id.txtBudgetLOX);
              /*  chkDailyLOX = findViewById(R.id.chkDailyLOX);
                chkWeeklyLOX = findViewById(R.id.chkWeeklyLOX);
                chkFortnightlyLOX = findViewById(R.id.chkFortnightlyLOX);
                chkMonthlyLOX = findViewById(R.id.chkMonthlyLOX);
                chkOnrequestLOX = findViewById(R.id.chkOnrequestLOX);

                chkYEShorLOX = findViewById(R.id.chkYEShorLOX);
                chkNoShorLOX = findViewById(R.id.chkNoShorLOX);

                chkYesSITLOX = findViewById(R.id.chkYesSITLOX);
                chkNoSITLOX = findViewById(R.id.chkNoSITLOX);*/
        txt_name_supply_ox_tank_twoo = findViewById(R.id.txtNSLOX);
        txt_how_many_tecn_available_twoo = findViewById(R.id.txtTechAvLOX);
        txt_comment_ox_tank_twoo = findViewById(R.id.txtCommentLOX);
    }

    public void LimparCampos(){
        txt_average_consuming_oxygen_twoo.setText("");
        txt_last_month_consuminh_twoo.setText("");
        txt_tank_owner_other_twoo.setText("");
        txt_capacity_lox_tank_m3_twoo.setText("");
        txt_capacity_lox_tank_ton_twoo.setText("");
        txt_frequency_ox_tank_twoo.setText("");
        txt_name_maintenance_company_ox_tank_twoo.setText("");
        txt_average_cost_ox_tank_twoo.setText("");
        txt_budget_lox_tank_twoo.setText("");
        txt_name_supply_ox_tank_twoo.setText("");
        txt_how_many_tecn_available_twoo.setText("");
        txt_comment_ox_tank_twoo.setText("");
    }
}