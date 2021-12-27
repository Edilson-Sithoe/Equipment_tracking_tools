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


public class FormDocTrainConc extends AppCompatActivity {
    private Button btn_next, btnBack;
    private TextView txt_how_many_users_formed   ;
    private TextView txt_how_many_tecnic_trained   ;
    private TextView txt_comments_train_conc   ;
    private String cbo_end_users_conc, cbo_frequency_training,cbo_tecn_formed_aspect_conc,cbo_frequency_training_conc_twoo;
    String [] mensagens = {"Preencha todos os campos","Falha ao registar","Registado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doc_train_conc);

     //   getSupportActionBar().hide();
        InitComponents();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String end_users_conc = cbo_end_users_conc;
                String frequency_training = cbo_frequency_training;
                String how_many_users_formed = txt_how_many_users_formed.getText().toString();
                String tecn_formed_aspect_conc = cbo_tecn_formed_aspect_conc;
                String frequency_training_conc_twoo = cbo_frequency_training_conc_twoo;
                String how_many_tecnic_trained = txt_how_many_tecnic_trained.getText().toString();
                String comments_train_conc = txt_comments_train_conc.getText().toString();

                if (TextUtils.isEmpty(how_many_users_formed) ||TextUtils.isEmpty(how_many_tecnic_trained)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setEnd_users_conc(end_users_conc);
                    Assessment.assessment_model.setFrequency_training(frequency_training);
                    Assessment.assessment_model.setHow_many_users_formed(how_many_users_formed);
                    Assessment.assessment_model.setTecn_formed_aspect_conc(tecn_formed_aspect_conc);
                    Assessment.assessment_model.setFrequency_training_conc_twoo(frequency_training_conc_twoo);
                    Assessment.assessment_model.setHow_many_tecnic_trained(how_many_tecnic_trained);
                    Assessment.assessment_model.setComments_train_conc(comments_train_conc);

                    Intent formMAS = new Intent(FormDocTrainConc.this, FormTrainDocManif.class);
                    startActivity(formMAS);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormDocTrainConc.this, FormTrainDocCylinders.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_train_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMS:
                if (checked)
                    cbo_end_users_conc = "Yes";
                break;
            case R.id.chkNoMS:
                if (checked)
                    cbo_end_users_conc = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_train_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6:
                if (checked)
                    cbo_frequency_training = "Every 6 months";
                break;
            case R.id.chkEveryYear:
                if (checked)
                    cbo_frequency_training = "Every yea";
                break;
            case R.id.chkEvery2Year:
                if (checked)
                    cbo_frequency_training = "Every 2 years";
                break;
            case R.id.chkEvery5Year:
                if (checked)
                    cbo_frequency_training = "Every 5 years";
                break;
            case R.id.chkOnRequest:
                if (checked)
                    cbo_frequency_training = "On request";
                break;
        }
    }

    public void onRadioButtonClicked2_train_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMandS:
                if (checked)
                    cbo_tecn_formed_aspect_conc = "Yes";
                break;
            case R.id.chkNoSMandS:
                if (checked)
                    cbo_tecn_formed_aspect_conc = "No";
                break;
        }
    }

    public void onRadioButtonClicked3_train_conc(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6US:
                if (checked)
                    cbo_frequency_training_conc_twoo = "Every 6 months";
                break;
            case R.id.chkEveryYearUS:
                if (checked)
                    cbo_frequency_training_conc_twoo = "Every yea";
                break;
            case R.id.chkEvery2YearUS:
                if (checked)
                    cbo_frequency_training_conc_twoo = "Every 2 years";
                break;
            case R.id.chkEvery5YearUS:
                if (checked)
                    cbo_frequency_training_conc_twoo = "Every 5 years";
                break;
            case R.id.chkOnRequestUS:
                if (checked)
                    cbo_frequency_training_conc_twoo = "On request";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backDOCCon);
        btn_next = findViewById(R.id.btn_next);

        txt_how_many_users_formed = findViewById(R.id.txtEndUser);
        txt_how_many_tecnic_trained = findViewById(R.id.txtMTTH);
        txt_comments_train_conc = findViewById(R.id.txtCommentsTraiC);
    }

    public void Limpar() {
        txt_how_many_users_formed.setText("");
        txt_how_many_tecnic_trained.setText("");
        txt_comments_train_conc.setText("");
    }
}