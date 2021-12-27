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


public class FormTrainDocManif extends AppCompatActivity {
    private Button btn_next, btnBack;
    private String cbo_tecni_traine_related_manifolf,cbo_frequency_trainig_manifold;
    private TextView txt_how_many_techn_trained_man_out, txt_comments_train_man_out;
    String [] mensagens = {"Preencha todos os campos","Falha ao registar","Registado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_train_doc_manif);

    //    getSupportActionBar().hide();
        InitComponents();


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tecni_traine_related_manifolf = cbo_tecni_traine_related_manifolf;
                String frequency_trainig_manifold = cbo_frequency_trainig_manifold;
                String how_many_techn_trained_man_out = txt_how_many_techn_trained_man_out.getText().toString();
                String comments_train_man_out = txt_comments_train_man_out.getText().toString();

                if (TextUtils.isEmpty(how_many_techn_trained_man_out)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setTecni_traine_related_manifolf(tecni_traine_related_manifolf);
                    Assessment.assessment_model.setFrequency_trainig_manifold(frequency_trainig_manifold);
                    Assessment.assessment_model.setHow_many_techn_trained_man_out(how_many_techn_trained_man_out);
                    Assessment.assessment_model.setComments_train_man_out(comments_train_man_out);

                    Intent formMAS = new Intent(FormTrainDocManif.this, FormDocTrainLiqOxTank.class);
                    startActivity(formMAS);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormTrainDocManif.this, FormDocTrainConc.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_doc_manif(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMS:
                if (checked)
                    cbo_tecni_traine_related_manifolf = "Yes";
                break;
            case R.id.chkNoMS:
                if (checked)
                    cbo_tecni_traine_related_manifolf = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_doc_manif(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6:
                if (checked)
                    cbo_frequency_trainig_manifold = "Every 6 months";
                break;
            case R.id.chkEveryYear:
                if (checked)
                    cbo_frequency_trainig_manifold = "Every yea";
                break;
            case R.id.chkEvery2Year:
                if (checked)
                    cbo_frequency_trainig_manifold = "Every 2 years";
                break;
            case R.id.chkEvery5Year:
                if (checked)
                    cbo_frequency_trainig_manifold = "Every 5 years";
                break;
            case R.id.chkOnRequest:
                if (checked)
                    cbo_frequency_trainig_manifold = "On request";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backTDM);
        btn_next = findViewById(R.id.btn_next);

        txt_how_many_techn_trained_man_out = findViewById(R.id.txtMTTH);
        txt_comments_train_man_out = findViewById(R.id.txtCommentsTraiC);
    }

    public void Limpar() {
        txt_how_many_techn_trained_man_out.setText("");
        txt_comments_train_man_out.setText("");
    }
}