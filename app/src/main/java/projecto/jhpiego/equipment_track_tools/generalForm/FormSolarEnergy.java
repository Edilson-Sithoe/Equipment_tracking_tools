package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormSolarEnergy extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtOtherSE, txtCapacitySE,txtFreqPMSE, txtNameOfMantSE, txtComentSE;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW,cboMain_gen_pmcm,cboMain_gen_lb, cboMain_gene_pm, cboMain_bate_install;
    private String cboMain_supp,cboMain_gen_fuel;
    private String cboMain_old,cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_solar_energy);

    //    getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String solar_power = cboMain_gen_hf;
                String area_provider = cboMain_supp;
                String area_provider_other = txtOtherSE.getText().toString();
                String old_sys_solar = cboMain_old;
                String solar_psy_working = cboMain_old;
                String condition_equipm = cboMain_gen_work;
                String capacity_solar_power = txtCapacitySE.getText().toString();
                String batteries_installed =  cboMain_bate_install;
                String active_pm_solar = cboMain_gene_pm;
                String carries_solar = cboMain_gen_pm;
                String frequency_pm = txtFreqPMSE.getText().toString();
                String name_main_solar = txtNameOfMantSE.getText().toString();
                String logbook_pm_solar = cboMain_gen_pmcm;
                String logbook_upd_solar = cboMain_gen_lb;
                String comments_solar = txtComentSE.getText().toString();

                if (TextUtils.isEmpty(frequency_pm) ||TextUtils.isEmpty(name_main_solar)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkSupUPSSTwhoo(solar_power);
                    Assessment.assessment_model.setChkProvUPTwhooS(area_provider);
                    Assessment.assessment_model.setTxtOtherUPSTwhoo(txtOtherSE.getText().toString());
                    Assessment.assessment_model.setChkOldSystemUPSTwhoo(old_sys_solar);
                    Assessment.assessment_model.setChkWorkingUPSTwhoo(solar_psy_working);
                    Assessment.assessment_model.setChkCondEquipmUPSTwhoo(condition_equipm);
                    Assessment.assessment_model.setTxtCapacityUPSv(capacity_solar_power);
                    Assessment.assessment_model.setChkPMPUPSTwhoo(batteries_installed);
                    Assessment.assessment_model.setTxtActivePM_solar(active_pm_solar);
                    Assessment.assessment_model.setChkCarrByUPSTwhoo(carries_solar);
                    Assessment.assessment_model.setTxtFreqPMUPSTwhoo(txtFreqPMSE.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMantUPSv(txtNameOfMantSE.getText().toString());
                    Assessment.assessment_model.setChkPMCMUPSTwhoo(logbook_pm_solar);
                    Assessment.assessment_model.setChklogbBookUPSTwhoo(logbook_upd_solar);
                    Assessment.assessment_model.setTxtComentUPSTwhoo(txtComentSE.getText().toString());

                    Intent i = new Intent(FormSolarEnergy.this, FormOxigenSystem.class);
                    startActivity(i);
                }
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(FormSolarEnergy.this, FormUPSTwoo.class);
                startActivity(back);
            }
        });

    }

    public void onRadioButtonClicked_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkYesUPS:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNoUPS:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
            case R.id.idChkD:
                if (checked)
                    cboMain_gen_hf = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_two_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkWhoHospUPS:
                if (checked)
                    cboMain_supp = "The whole hospital";
                break;
            case R.id.idChkOpTheatreUPS:
                if (checked)
                    cboMain_supp = "Operating theatre";
                break;
            case R.id.idChkEmergRoomUPS:
                if (checked)
                    cboMain_supp = "Emergency Room";
                break;
            case R.id.idChkLabUPS:
                if (checked)
                    cboMain_supp = "Laboratory";
                break;
        }
    }

    public void onRadioButtonClicked_three_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLessUPS:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10UPS:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20UPS:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20UPS:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked_four_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkUPSY:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkUPSN:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkUPSPartly:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkUPSDontN:
                if (checked)
                    cboMain_gen_work = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_five_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkGIUUPS:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNUUPS:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNRUPS:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTRUPS:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBRUPS:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNRUPS:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPhaUPS:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontNUPS:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_six_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkYesUPS:
                if (checked)
                    cboMain_bate_install = "Yes";
                break;
            case R.id.idChkNoUPS:
                if (checked)
                    cboMain_bate_install = "No";
                break;
            case R.id.idChkD:
                if (checked)
                    cboMain_bate_install = "No";
                break;
        }
    }

    public void onRadioButtonClicked_seven_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMYUPS:
                if (checked)
                    cboMain_gen_pm = "Yes";
                break;
            case R.id.idChkPMNUPS:
                if (checked)
                    cboMain_gen_pm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_eight_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMITPHFUPS:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDIUPS:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontractedUPS:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked_nine_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMCMYUPS:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMNUPS:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_ten_se(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLoBYUPS:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBNUPS:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backSE);
        btnNExt = findViewById(R.id.btn_next);

        txtOtherSE = findViewById(R.id.idTxtOtherSE);
        txtCapacitySE = findViewById(R.id.idTxtCapSE);

        txtFreqPMSE = findViewById(R.id.idTxtFreqSE);
        txtNameOfMantSE = findViewById(R.id.idTxtNameOfMantSE);

        txtComentSE = findViewById(R.id.idTxtComentSE);
    }

    public void LimparCampos() {
        txtCapacitySE.setText("");
        txtCapacitySE.setText("");
        txtFreqPMSE.setText("");
        txtComentSE.setText("");
        txtNameOfMantSE.setText("");
        txtOtherSE.setText("");
    }
}