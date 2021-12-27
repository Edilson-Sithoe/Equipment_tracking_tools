package projecto.jhpiego.equipment_track_tools.view.inventory;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Update_equipm_inventory extends AppCompatActivity {

    private Button btn_update, btn_back, btn_delete;
    private EditText txtDept, txtTypeEquip, txtInvent_number, txtMake,txtModel,txtSerialNumber;
    private EditText txtEquipCondition, txtYearInstall, txtDataMaint, txtMain_contract, txtComment;
    private String cboMain_contract_edit;

    String id, dept, typeEquip, invent_number, make, model, serialNumber;
    String equipCondition, yearInstall, dataMaint, main_contract, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_equipm_inventory);
        InitComponents();

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(dept);
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database_connection database_connection = new Database_connection(Update_equipm_inventory.this);
                database_connection.updateData(id, dept, typeEquip, invent_number, make, model, serialNumber, equipCondition, yearInstall, main_contract, dataMaint, comment);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("department") && getIntent().hasExtra("type_equipment") &&
        getIntent().hasExtra("invent_number") && getIntent().hasExtra("make") && getIntent().hasExtra("model") &&
                getIntent().hasExtra("serial_number") && getIntent().hasExtra("equipment_condition") && getIntent().hasExtra("year_install") &&
        getIntent().hasExtra("data_maintenance") && getIntent().hasExtra("comment")) {

            // Getting Data from Intent
            id = getIntent().getStringExtra("id");
            dept = getIntent().getStringExtra("dept");
            typeEquip = getIntent().getStringExtra("typeEquip");
            invent_number = getIntent().getStringExtra("invent_number");
            make = getIntent().getStringExtra("make");
            model = getIntent().getStringExtra("model");
            serialNumber = getIntent().getStringExtra("serialNumber");
            equipCondition = getIntent().getStringExtra("equipCondition");
            yearInstall = getIntent().getStringExtra("yearInstall");
            main_contract = getIntent().getStringExtra("main_contract");
            dataMaint = getIntent().getStringExtra("dataMaint");
            comment = getIntent().getStringExtra("comment");

            // Setting Intent Data
            txtDept.setText(dept);
            txtTypeEquip.setText(typeEquip);
            txtInvent_number.setText(invent_number);
            txtMake.setText(make);
            txtModel.setText(model);
            txtSerialNumber.setText(serialNumber);
            txtEquipCondition.setText(equipCondition);
            txtYearInstall.setText(yearInstall);
            txtMain_contract.setText(main_contract);
            txtDataMaint.setText(dataMaint);
            txtComment.setText(comment);
        } else {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover "+dept+ " ?");
        builder.setMessage("Pretende apagar "+dept+" ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Update_equipm_inventory.this);
                database_connection.deleteOneRow(id);
                finish();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    public void onRadioButtonClicked_edit(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_yes_edit:
                if (checked)
                    cboMain_contract_edit = "Sim";
                break;
            case R.id.radio_no_edit:
                if (checked)
                    cboMain_contract_edit = "Não";
                break;
        }
    }

    public void InitComponents(){
        btn_back = findViewById(R.id.btn_backInvent);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        txtDept = findViewById(R.id.txtDept_edit);
        txtTypeEquip = findViewById(R.id.txtTypeEquip_edit);
        txtInvent_number = findViewById(R.id.txtIventNumber_edit);
        txtMake = findViewById(R.id.txtMake_edit);
        txtModel = findViewById(R.id.txtModel_edit);
        txtSerialNumber = findViewById(R.id.txtSerialNumber_edit);
        txtEquipCondition = findViewById(R.id.txtEquipCond_edit);
        txtYearInstall = findViewById(R.id.txtYearInstall_edit);
        txtDataMaint = findViewById(R.id.txtDataMaintenance_edit);
        txtComment = findViewById(R.id.txtComment_edit);
    }

}