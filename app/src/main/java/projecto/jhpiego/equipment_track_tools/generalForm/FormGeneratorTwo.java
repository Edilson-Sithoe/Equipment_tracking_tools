package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormGeneratorTwo extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtComent, txtNameOfMant,txtFreqPM, txtOther, txtCapacity, txtOtherSupp;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW,cboMain_gen_pmcm,cboMain_gen_lb, cboMain_gene_pm;
    private String cboMain_supp,cboMain_gen_fuel;
    private String cboMain_old,cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_generator_two);

     //   getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gene = cboMain_gen_hf;
                String suppEl = cboMain_supp;
                String othSuppEl = txtOtherSupp.getText().toString();
                String hold_sys = cboMain_old;
                String genWork = cboMain_gen_work;
                String condEquip = cboMain_gen_cond;
                String ats = cboMain_gen_ats;
                String atsWor = cboMain_gen_atsW;
                String fuelToday = cboMain_gen_fuel;
                String capacity = txtCapacity.getText().toString();
                String pmp_rogram = cboMain_gene_pm;
                String carry_by = cboMain_gen_pm;
                String frequ_pm = txtFreqPM.getText().toString();
                String name = txtNameOfMant.getText().toString();
                String logbook = cboMain_gen_pmcm;
                String logbookupd = cboMain_gen_lb;
                String comments = txtComent.getText().toString();

                if (TextUtils.isEmpty(capacity) || TextUtils.isEmpty(frequ_pm) || TextUtils.isEmpty(name)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkGeneTwoo(gene);
                    Assessment.assessment_model.setChkSuppElectTwoo(suppEl);
                    Assessment.assessment_model.setTxtOtherSuppEleTwoo(othSuppEl);
                    Assessment.assessment_model.setChkHoldSysteTwoo(hold_sys);
                    Assessment.assessment_model.setChkGenWorkTwoo(genWork);
                    Assessment.assessment_model.setChkConditionEquipTwoo(condEquip);
                    Assessment.assessment_model.setChkATSTwoo(ats);
                    Assessment.assessment_model.setChkATSWorkinTwoo(atsWor);
                    Assessment.assessment_model.setChkFuelTodayTwoo(fuelToday);
                    Assessment.assessment_model.setTxtCapacityTwoo(txtCapacity.getText().toString());
                    Assessment.assessment_model.setChkPMProgramTwoo(pmp_rogram);
                    Assessment.assessment_model.setChkCarrByTwoo(carry_by);
                    Assessment.assessment_model.setTxtFreqPMTwoo(txtFreqPM.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMantTwoo(txtNameOfMant.getText().toString());
                    Assessment.assessment_model.setChkLogBookTwoo(logbook);
                    Assessment.assessment_model.setChkLogBoobUpdTwoo(logbookupd);
                    Assessment.assessment_model.setTxtComentTwoo(txtComent.getText().toString());

                    Intent i = new Intent(FormGeneratorTwo.this, FormGeneratorThree.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormGeneratorTwo.this, FormGeneratorOne.class);
                startActivity(i);
            }
        });


    }
    public void onRadioButtonClicked_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkYes:
                if (checked)
                    cboMain_gen_hf = "Yes";
                break;
            case R.id.idChkNo:
                if (checked)
                    cboMain_gen_hf = "No";
                break;
            case R.id.IdChkDontKnow:
                if (checked)
                    cboMain_gen_hf = "I Don't Know";
                break;
        }
    }

    public void onRadioButtonClicked_two_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkWhoHosp:
                if (checked)
                    cboMain_supp = "The whole hospital";
                break;
            case R.id.idChkOpTheatre:
                if (checked)
                    cboMain_supp = "Operating theatre";
                break;
            case R.id.idChkEmergRoom:
                if (checked)
                    cboMain_supp = "Emergency Room";
                break;
            case R.id.idChkLab:
                if (checked)
                    cboMain_supp = "Laboratory";
                break;
        }
    }

    public void onRadioButtonClicked_three_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLess:
                if (checked)
                    cboMain_old = "Less than 3 years";
                break;
            case R.id.idChkB3_10:
                if (checked)
                    cboMain_old = "Between 3-10 years";
                break;
            case R.id.idChkB11_20:
                if (checked)
                    cboMain_old = "Between 11-20 years";
                break;
            case R.id.idChkMore20:
                if (checked)
                    cboMain_old = "More than 20 years";
                break;
        }
    }

    public void onRadioButtonClicked_four_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkGENY:
                if (checked)
                    cboMain_gen_work = "Yes";
                break;
            case R.id.idChkGENN:
                if (checked)
                    cboMain_gen_work = "No";
                break;
            case R.id.idChkGENPartly:
                if (checked)
                    cboMain_gen_work = "Partly";
                break;
            case R.id.idChkGENDontN:
                if (checked)
                    cboMain_gen_work = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_five_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkGIU:
                if (checked)
                    cboMain_gen_cond = "Good and in use";
                break;
            case R.id.idChkGBNU:
                if (checked)
                    cboMain_gen_cond = "Good, but not in use";
                break;
            case R.id.idChkIU_BNR:
                if (checked)
                    cboMain_gen_cond = "In use, but needs repair";
                break;
            case R.id.idChkIUNNTR:
                if (checked)
                    cboMain_gen_cond = "In use, but needs to be replaced";
            case R.id.idchkOOSBR:
                if (checked)
                    cboMain_gen_cond = "Out of service, but repairable";
            case R.id.idChkOOSAndNR:
                if (checked)
                    cboMain_gen_cond = "Out of service and needs to be replaced";
            case R.id.idChkStilInstPha:
                if (checked)
                    cboMain_gen_cond = "Still in the installation phase";
            case R.id.idChkDontN:
                if (checked)
                    cboMain_gen_cond = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked_six_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkY:
                if (checked)
                    cboMain_gen_ats = "Yes";
                break;
            case R.id.idChkN:
                if (checked)
                    cboMain_gen_ats = "No";
                break;
            case R.id.idchkDN:
                if (checked)
                    cboMain_gen_ats = "I Don't Know";
                break;
        }
    }

    public void onRadioButtonClicked_seven_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkATSY:
                if (checked)
                    cboMain_gen_atsW = "Yes";
                break;
            case R.id.idChkATSN:
                if (checked)
                    cboMain_gen_atsW = "No";
                break;
            case R.id.idChkATSPartly:
                if (checked)
                    cboMain_gen_atsW = "Partly";
                break;
            case R.id.idChkATDontN:
                if (checked)
                    cboMain_gen_atsW = "I Don't Know";
                break;
        }
    }

    public void onRadioButtonClicked_eight_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkFuelY:
                if (checked)
                    cboMain_gen_fuel = "Yes";
                break;
            case R.id.idChkFuelN:
                if (checked)
                    cboMain_gen_fuel = "No";
                break;
        }
    }

    public void onRadioButtonClicked_nine_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMY:
                if (checked)
                    cboMain_gene_pm = "Yes";
                break;
            case R.id.idChkPMN:
                if (checked)
                    cboMain_gene_pm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_ten_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMITPHF:
                if (checked)
                    cboMain_gen_pm = "Internal Technical Personnel of the Health Facility";
                break;
            case R.id.idChkPMPDI:
                if (checked)
                    cboMain_gen_pm = "Personnel from the Department of Infrastructure";
                break;
            case R.id.idChkSubcontracted:
                if (checked)
                    cboMain_gen_pm = "Subcontracted";
                break;
        }
    }

    public void onRadioButtonClicked_eleven_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMCMY:
                if (checked)
                    cboMain_gen_pmcm = "Yes";
                break;
            case R.id.idChkPMCMN:
                if (checked)
                    cboMain_gen_pmcm = "No";
                break;
        }
    }

    public void onRadioButtonClicked_twelve_gtwo(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLoBY:
                if (checked)
                    cboMain_gen_lb = "Yes";
                break;
            case R.id.idChkLoBN:
                if (checked)
                    cboMain_gen_lb = "No";
                break;
        }
    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_back);
        btnNExt = findViewById(R.id.btn_next);

        txtComent = findViewById(R.id.idTxtComent);
        txtNameOfMant = findViewById(R.id.idTxtNameOfMant);
        txtOtherSupp = findViewById(R.id.idTxtOther);
        txtFreqPM = findViewById(R.id.idTxtFreq);
        txtOther = findViewById(R.id.idTxtOther);
        txtCapacity = findViewById(R.id.idTxtCapGen);
    }

    public void LimparCampos() {
        txtOther.setText("");
        txtComent.setText("");
        txtFreqPM.setText("");
        txtNameOfMant.setText("");
    }
}