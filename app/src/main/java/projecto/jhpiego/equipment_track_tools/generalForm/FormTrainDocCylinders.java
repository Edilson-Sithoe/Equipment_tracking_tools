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

public class FormTrainDocCylinders extends AppCompatActivity {
    private Button btn_next, btnBack;

    private TextView txt_how_many_users_trained   ;
    private TextView txt_tecnic_trained   ;
    private TextView txt_comments_train_cylinder   ;
    private String cbo_end_users, cbo_how_often_end_user_train,cbo_tecn_formed_aspect,cbo_how_often_train_users   ;
    String[] mensagens = {"Fill in all fields", "Fail to registration", "Registration performed successfully"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_train_doc_cylinders);

     //   getSupportActionBar().hide();
        InitComponents();


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String end_users = cbo_end_users;
                String how_often_end_user_train = cbo_how_often_end_user_train;
                String how_many_users_trained = txt_how_many_users_trained.getText().toString();
                String tecn_formed_aspect = cbo_tecn_formed_aspect;
                String how_often_train_users = cbo_how_often_train_users;
                String tecnic_trained = txt_tecnic_trained.getText().toString();
                String comments_train_cylinder = txt_comments_train_cylinder.getText().toString();

                if (TextUtils.isEmpty(how_many_users_trained) ||TextUtils.isEmpty(tecnic_trained)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setEnd_users(end_users);
                    Assessment.assessment_model.setHow_often_end_user_train(how_often_end_user_train);
                    Assessment.assessment_model.setHow_many_users_trained(how_many_users_trained);
                    Assessment.assessment_model.setTecn_formed_aspect(tecn_formed_aspect);
                    Assessment.assessment_model.setHow_often_train_users(how_often_train_users);
                    Assessment.assessment_model.setTecnic_trained(tecnic_trained);
                    Assessment.assessment_model.setComments_train_cylinder(comments_train_cylinder);

                    Intent formMAS = new Intent(FormTrainDocCylinders.this, FormDocTrainConc.class);
                    startActivity(formMAS);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormTrainDocCylinders.this, FormTeam.class);
                startActivity(i);
            }
        });

    }

    public void onRadioButtonClicked_train_cyl(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMS:
                if (checked)
                    cbo_end_users = "Yes";
                break;
            case R.id.chkNoMS:
                if (checked)
                    cbo_end_users = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_train_cyl(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6:
                if (checked)
                    cbo_how_often_end_user_train = "Every 6 months";
                break;
            case R.id.chkEveryYear:
                if (checked)
                    cbo_how_often_end_user_train = "Every yea";
                break;
            case R.id.chkEvery2Year:
                if (checked)
                    cbo_how_often_end_user_train = "Every 2 years";
                break;
            case R.id.chkEvery5Year:
                if (checked)
                    cbo_how_often_end_user_train = "Every 5 years";
                break;
            case R.id.chkOnRequest:
                if (checked)
                    cbo_how_often_end_user_train = "On request";
                break;
        }
    }

    public void onRadioButtonClicked2_train_cyl(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkYesMandS:
                if (checked)
                    cbo_tecn_formed_aspect = "Yes";
                break;
            case R.id.chkNoSMandS:
                if (checked)
                    cbo_tecn_formed_aspect = "No";
                break;
        }
    }

    public void onRadioButtonClicked3_train_cyl(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.chkEvery6US:
                if (checked)
                    cbo_how_often_train_users = "Every 6 months";
                break;
            case R.id.chkEveryYearUS:
                if (checked)
                    cbo_how_often_train_users = "Every yea";
                break;
            case R.id.chkEvery2YearUS:
                if (checked)
                    cbo_how_often_train_users = "Every 2 years";
                break;
            case R.id.chkEvery5YearUS:
                if (checked)
                    cbo_how_often_train_users = "Every 5 years";
                break;
            case R.id.chkOnRequestUS:
                if (checked)
                    cbo_how_often_train_users = "On request";
                break;
        }
    }

    public void InitComponents() {
        btnBack = findViewById(R.id.btn_backDOCT);
        btn_next = findViewById(R.id.btn_next);

        txt_how_many_users_trained = findViewById(R.id.txtEndUser);
        txt_tecnic_trained = findViewById(R.id.txtMTTH);
        txt_comments_train_cylinder = findViewById(R.id.txtCommentsTraiC);
    }

    public void Limpar() {
        txt_how_many_users_trained.setText("");
        txt_tecnic_trained.setText("");
        txt_comments_train_cylinder.setText("");
    }
}