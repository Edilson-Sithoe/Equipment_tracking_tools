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

public class FormUPSOne extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private EditText txtOtherUPS, txtCapacityUPS,txtFreqPMUPS, txtNameOfMantUPS, txtComentUPS;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    private String cboMain_gen_hf, cboMain_gen_atsW,cboMain_gen_pmcm,cboMain_gen_lb,cboMain_gene_pm;
    private String cboMain_supp,cboMain_gen_fuel;
    private String cboMain_old,cboMain_gen_pm;
    private String cboMain_gen_work, cboMain_gen_cond, cboMain_gen_ats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_upsone);

      //  getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sup_upss = cboMain_gen_hf;
                String prov_ups = cboMain_supp;
                String txtOther_ups = txtOtherUPS.getText().toString();
                String oldSys_ups = cboMain_old;
                String working_ups = cboMain_gen_work;
                String condEquip_ups = cboMain_gen_cond;
                String capacity_ups =  txtCapacityUPS.getText().toString();
                String pmp_ups = cboMain_gene_pm;
                String carrie_by_ups = cboMain_gen_pm;
                String frequency_ups = txtFreqPMUPS.getText().toString();
                String nameOfMain_ups = txtNameOfMantUPS.getText().toString();
                String pmcm_ups = cboMain_gen_pmcm;
                String logbook_ups = cboMain_gen_lb;
                String comments_ups = txtComentUPS.getText().toString();

                if (TextUtils.isEmpty(capacity_ups) || TextUtils.isEmpty(nameOfMain_ups) ||TextUtils.isEmpty(frequency_ups)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setChkSupUPSS(sup_upss);
                    Assessment.assessment_model.setChkProvUPS(prov_ups);
                    Assessment.assessment_model.setTxtOtherUPS(txtOther_ups);
                    Assessment.assessment_model.setChkOldSystemUPS(oldSys_ups);
                    Assessment.assessment_model.setChkWorkingUPS(working_ups);
                    Assessment.assessment_model.setChkCondEquipmUPS(condEquip_ups);
                    Assessment.assessment_model.setTxtCapacityUPS(txtCapacityUPS.getText().toString());
                    Assessment.assessment_model.setChkPMPUPS(pmp_ups);
                    Assessment.assessment_model.setChkCarrByUPS(carrie_by_ups);
                    Assessment.assessment_model.setTxtFreqPMUPS(txtFreqPMUPS.getText().toString());
                    Assessment.assessment_model.setTxtNameOfMantUPS(txtNameOfMantUPS.getText().toString());
                    Assessment.assessment_model.setChkPMCMUPS(pmcm_ups);
                    Assessment.assessment_model.setChklogbBookUPS(logbook_ups);
                    Assessment.assessment_model.setTxtComentUPS(comments_ups);

                    Intent i = new Intent(FormUPSOne.this, FormUPSTwoo.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormUPSOne.this, FormStabilizer.class);
                startActivity(i);
            }
        });


    }
    public void onRadioButtonClicked_ups(View view) {
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
        }
    }

    public void onRadioButtonClicked_two_ups(View view) {
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
    public void onRadioButtonClicked_three_ups(View view) {
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

    public void onRadioButtonClicked_four_ups(View view) {
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
    public void onRadioButtonClicked_five_ups(View view) {
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

    public void onRadioButtonClicked_six_ups(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkPMYUPS:
                if (checked)
                    cboMain_gene_pm = "Yes";
                break;
            case R.id.idChkPMNUPS:
                if (checked)
                    cboMain_gene_pm = "No";
                break;
        }
    }
    public void onRadioButtonClicked_seven_ups(View view) {
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
    public void onRadioButtonClicked_eight_ups(View view) {
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

    public void onRadioButtonClicked_nine_ups(View view) {
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
        btnBack = findViewById(R.id.btn_back);
        btnNExt = findViewById(R.id.btn_next);

/*        chkYUPS = findViewById(R.id.idChkYesUPS);
        chkNUPS = findViewById(R.id.idChkNoUPS);

        chkWhoHospUPS = findViewById(R.id.idChkWhoHospUPS);
        chkOpTheatreUPS = findViewById(R.id.idChkOpTheatreUPS);
        chkEmergRoomUPS = findViewById(R.id.idChkEmergRoomUPS);
        chkLabUPS = findViewById(R.id.idChkLabUPS);
        chkMaterUPS = findViewById(R.id.idChkMaternUPS);*/

        txtOtherUPS = findViewById(R.id.idTxtOtherUPS);

      /*  chkLessUPS = findViewById(R.id.idChkLessUPS);
        chkB3_10UPS = findViewById(R.id.idChkB3_10UPS);
        chkB11_20UPS = findViewById(R.id.idChkB11_20UPS);
        chkMore20UPS = findViewById(R.id.idChkMore20UPS);

        chkUPSY = findViewById(R.id.idChkUPSY);
        chkUPSN = findViewById(R.id.idChkUPSN);
        chkUPSPartly = findViewById(R.id.idChkUPSPartly);
        chkUPSDontN = findViewById(R.id.idChkUPSDontN);

        chkGIUUPS = findViewById(R.id.idChkGIUUPS);
        chkGBNUUPS = findViewById(R.id.idChkGBNUUPS);
        chkIU_BNRUPS = findViewById(R.id.idChkIU_BNRUPS);
        chkIUNNTRUPS = findViewById(R.id.idChkIUNNTRUPS);
        chkOOSBRUPS = findViewById(R.id.idchkOOSBRUPS);
        chkOOSAndNRUPS = findViewById(R.id.idChkOOSAndNRUPS);
        chkStilInstPhaUPS = findViewById(R.id.idChkStilInstPhaUPS);
        chkDontNUPS = findViewById(R.id.idChkDontNUPS);*/

        txtCapacityUPS = findViewById(R.id.idTxtCapUPS);

     /*   chkPMYUPS = findViewById(R.id.idChkPMYUPS);
        chkPMNUPS = findViewById(R.id.idChkPMNUPS);

        chkPMITPHFUPS = findViewById(R.id.idChkPMITPHFUPS);
        chkPMPDIUPS = findViewById(R.id.idChkPMPDIUPS);
        chkSubcontractedUPS = findViewById(R.id.idChkSubcontractedUPS);*/

        txtFreqPMUPS = findViewById(R.id.idTxtFreqUPS);
        txtNameOfMantUPS = findViewById(R.id.idTxtNameOfMantUPS);

     /*   chkPMCMYUPS = findViewById(R.id.idChkPMCMYUPS);
        chkPMCMNUPS = findViewById(R.id.idChkPMCMNUPS);
        chkLoBYUPS = findViewById(R.id.idChkLoBYUPS);
        chkLoBNUPS = findViewById(R.id.idChkLoBNUPS);*/

        txtComentUPS = findViewById(R.id.idTxtComentUPS);
    }

    public void LimparCampos() {
        txtCapacityUPS.setText("");
        txtCapacityUPS.setText("");
        txtFreqPMUPS.setText("");
        txtComentUPS.setText("");
        txtNameOfMantUPS.setText("");
    }
}