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

public class FormLogistic extends AppCompatActivity {

    private Button btnNExt, btnBack;
    private String cbo_receive_ox_cylinder_log, cbo_logbook_cylinder_log, cbo_use_logb_lox_tank, cbo_supply_consuminh;
    private TextView txt_receive_ox_cyl_other, txt_comments_rece_log, txt_comments_logbook_log, txt_comments_lox_tank, txt_comments_sup_consum;
    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_logistic);

      //  getSupportActionBar().hide();
        IniciaCompnentes();


        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receive_ox_cylinder_log = cbo_receive_ox_cylinder_log;
                String receive_ox_cyl_other = txt_receive_ox_cyl_other.getText().toString();
                String comments_rece_log = txt_comments_rece_log.getText().toString();
                String logbook_cylinder_log = cbo_logbook_cylinder_log;
                String comments_logbook_log = txt_comments_logbook_log.getText().toString();
                String use_logb_lox_tank = cbo_use_logb_lox_tank;
                String comments_lox_tank = txt_comments_lox_tank.getText().toString();
                String supply_consuminh = cbo_supply_consuminh;
                String comments_sup_consum = txt_comments_sup_consum.getText().toString();

                if (TextUtils.isEmpty(receive_ox_cyl_other) || TextUtils.isEmpty(comments_rece_log)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setReceive_ox_cylinder_log(receive_ox_cylinder_log);
                    Assessment.assessment_model.setReceive_ox_cyl_other(receive_ox_cyl_other);
                    Assessment.assessment_model.setComments_rece_log(comments_rece_log);
                    Assessment.assessment_model.setLogbook_cylinder_log(logbook_cylinder_log);
                    Assessment.assessment_model.setComments_logbook_log(comments_logbook_log);
                    Assessment.assessment_model.setUse_logb_lox_tank(use_logb_lox_tank);
                    Assessment.assessment_model.setComments_lox_tank(comments_lox_tank);
                    Assessment.assessment_model.setSupply_consuminh(cbo_supply_consuminh);
                    Assessment.assessment_model.setComments_sup_consum(comments_sup_consum);

                    Intent i = new Intent(FormLogistic.this, FormMaintaMedEquip.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormLogistic.this, FormMainPiping.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_log(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkDPM:
                if (checked)
                    cbo_receive_ox_cylinder_log = "DPM";
                break;
            case R.id.chkDDM:
                if (checked)
                    cbo_receive_ox_cylinder_log = "DDM";
                break;
            case R.id.chkPrivateSector:
                if (checked)
                    cbo_receive_ox_cylinder_log = "Private Sector";
                break;
            case R.id.chkNGO:
                if (checked)
                    cbo_receive_ox_cylinder_log = "NGO";
                break;
            case R.id.chkDontKnow:
                if (checked)
                    cbo_receive_ox_cylinder_log = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked1_log(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLBC:
                if (checked)
                    cbo_logbook_cylinder_log = "Yes";
                break;
            case R.id.chkNoLBC:
                if (checked)
                    cbo_logbook_cylinder_log = "No";
                break;
        }
    }

    public void onRadioButtonClicked2_log(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesLOX:
                if (checked)
                    cbo_use_logb_lox_tank = "Yes";
                break;
            case R.id.chkNoLOX:
                if (checked)
                    cbo_use_logb_lox_tank = "No";
                break;
        }
    }

    public void onRadioButtonClicked3_log(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.chkDPMCO:
                if (checked)
                    cbo_supply_consuminh = "DPM";
                break;
            case R.id.chkDDMCO:
                if (checked)
                    cbo_supply_consuminh = "DDM";
                break;
            case R.id.chkPipelineCO:
                if (checked)
                    cbo_supply_consuminh = "Private Sector";
                break;
            case R.id.chkNGOCO:
                if (checked)
                    cbo_supply_consuminh = "NGO";
                break;
            case R.id.chkDontNCO:
                if (checked)
                    cbo_supply_consuminh = "Don't know";
                break;
        }
    }

    public void IniciaCompnentes(){

        btnBack = findViewById(R.id.btn_backLOG);
        btnNExt = findViewById(R.id.btn_nextLOG);


        txt_receive_ox_cyl_other= findViewById(R.id.txtOther);
        txt_comments_rece_log= findViewById(R.id.txtComments);
        txt_comments_logbook_log= findViewById(R.id.txtCommentsLBC);
        txt_comments_lox_tank= findViewById(R.id.txtCommentsLOX);
        txt_comments_sup_consum= findViewById(R.id.txtCommentsCO);
    }

    private void LimparCampos(){
        txt_receive_ox_cyl_other.setText("");
        txt_comments_rece_log.setText("");
        txt_comments_logbook_log.setText("");
        txt_comments_lox_tank.setText("");
        txt_comments_sup_consum.setText("");
    }
}