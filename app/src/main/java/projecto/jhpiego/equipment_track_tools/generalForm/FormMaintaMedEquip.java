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

public class FormMaintaMedEquip extends AppCompatActivity {
    private Button btnBack, btnNExt;

    private String cbo_inventory_med_equip;
    private String cbo_format_med_equip;
    private String cbo_show_status_equip;
    private TextView txt_how_the_repair;
    private String cbo_level_contract_pm;
    private TextView txt_level_contract_pm_ot;
    private String cbo_active_pm_mme;
    private String cbo_protocol_follow_fill_in;
    private String cbo_recorder_specific_way;
    private String cbo_control_cost_assoc;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_mainta_med_equip);

      //  getSupportActionBar().hide();
        InicicarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inventory_med_equip = cbo_inventory_med_equip;
                String format_med_equip = cbo_format_med_equip;
                String show_status_equip = cbo_show_status_equip;
                String how_the_repair = txt_how_the_repair.getText().toString();
                String level_contract_pm = cbo_level_contract_pm;
                String level_contract_pm_ot = txt_level_contract_pm_ot.getText().toString();
                String active_pm_mme = cbo_active_pm_mme;
                String protocol_follow_fill_in = cbo_protocol_follow_fill_in;
                String recorder_specific_way = cbo_recorder_specific_way;
                String control_cost_assoc = cbo_control_cost_assoc;

                if (TextUtils.isEmpty(how_the_repair) || TextUtils.isEmpty(level_contract_pm_ot)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setInventory_med_equip(inventory_med_equip);
                    Assessment.assessment_model.setFormat_med_equip(format_med_equip);
                    Assessment.assessment_model.setShow_status_equip(show_status_equip);
                    Assessment.assessment_model.setHow_the_repair(how_the_repair);
                    Assessment.assessment_model.setLevel_contract_pm(level_contract_pm);
                    Assessment.assessment_model.setLevel_contract_pm_ot(level_contract_pm_ot);
                    Assessment.assessment_model.setActive_pm_mme(active_pm_mme);
                    Assessment.assessment_model.setProtocol_follow_fill_in(protocol_follow_fill_in);
                    Assessment.assessment_model.setRecorder_specific_way(recorder_specific_way);
                    Assessment.assessment_model.setControl_cost_assoc(control_cost_assoc);

                    Intent i = new Intent(FormMaintaMedEquip.this, FormSupervisory.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormMaintaMedEquip.this, FormLogistic.class);
                startActivity(i);
            }
        });
    }

    public void onRadioButtonClicked_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesIME:
                if (checked)
                    cbo_inventory_med_equip = "Yes";
                break;
            case R.id.chkNoIME:
                if (checked)
                    cbo_inventory_med_equip = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkPaperInventory:
                if (checked)
                    cbo_format_med_equip = "Paper Inventory";
                break;
            case R.id.chkInventoryExcel:
                if (checked)
                    cbo_format_med_equip = "Inventory in Excel";
                break;
            case R.id.chkSoftwareLocal:
                if (checked)
                    cbo_format_med_equip = "Software local";
                break;
            case R.id.chkWebPlatform:
                if (checked)
                    cbo_format_med_equip = "Web plataform";
                break;
        }
    }

    public void onRadioButtonClicked2_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesIS:
                if (checked)
                    cbo_show_status_equip = "Yes";
                break;
            case R.id.chkNoIS:
                if (checked)
                    cbo_show_status_equip = "No";
                break;
        }
    }

    public void onRadioButtonClicked3_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.chkMISAU:
                if (checked)
                    cbo_level_contract_pm = "MISAU (Central level)";
                break;
            case R.id.chkDPS:
                if (checked)
                    cbo_level_contract_pm = "DPS (Provincial level)";
                break;
            case R.id.chkHFL:
                if (checked)
                    cbo_level_contract_pm = "Health facility level";
                break;
        }
    }

    public void onRadioButtonClicked4_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesPMPro:
                if (checked)
                    cbo_active_pm_mme = "Yes";
                break;
            case R.id.chkNoPMProg:
                if (checked)
                    cbo_active_pm_mme = "No";
                break;
        }
    }

    public void onRadioButtonClicked5_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSP:
                if (checked)
                    cbo_protocol_follow_fill_in = "Yes";
                break;
            case R.id.chkNoSP:
                if (checked)
                    cbo_protocol_follow_fill_in = "No";
                break;
        }
    }

    public void onRadioButtonClicked6_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesSW:
                if (checked)
                    cbo_recorder_specific_way = "Yes";
                break;
            case R.id.chkNoSW:
                if (checked)
                    cbo_recorder_specific_way = "No";
                break;
        }
    }

    public void onRadioButtonClicked7_med_equip(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesCAM:
                if (checked)
                    cbo_control_cost_assoc = "Yes";
                break;
            case R.id.chkNoCAM:
                if (checked)
                    cbo_control_cost_assoc = "No";
                break;
        }
    }

    public void InicicarComponentes() {
        btnBack = findViewById(R.id.btn_backIN);
        btnNExt = findViewById(R.id.btn_next);

        txt_how_the_repair = findViewById(R.id.txtMedEqui);
        txt_level_contract_pm_ot = findViewById(R.id.txtOther);


    }

    public void Limpar() {
        txt_how_the_repair.setText("");
        txt_level_contract_pm_ot.setText("");
    }
}