package anyanwu3252.fe_215cs02003252;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import anyanwu3252.fe_215cs02003252.pref.OrderInfo;

/*
       ANYANWU MIRACLE - 215CS02003252
 */

public class MainActivity extends AppCompatActivity {

    private EditText editName, editAddress, editAge, editDays, editMedication, editSurgical, editLab, editRehab;
    private RadioButton radioMale, radioFemale;
    private String name, address, age, days, medication, surgical, lab, rehab, male, female;
    private int intAge, intDays;
    private Double doubleMedication, doubleSurgical, doubleLab, doubleRehab;

    private AppCompatButton btnClear, btnCalculate;

    private OrderInfo orderInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderInfo = new OrderInfo(this);

        editName = findViewById(R.id.editName);
        editAddress = findViewById(R.id.editAddress);
        editAge = findViewById(R.id.editAge);
        editDays = findViewById(R.id.editDays);
        editMedication = findViewById(R.id.editMedication);
        editSurgical = findViewById(R.id.editSurgical);
        editLab = findViewById(R.id.editLab);
        editRehab = findViewById(R.id.editRehab);
        radioFemale = findViewById(R.id.radio_female);
        radioMale = findViewById(R.id.radio_male);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    // do something
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editAddress.setText("");
                editAge.setText("");
                editDays.setText("");
                editMedication.setText("");
                editSurgical.setText("");
                editLab.setText("");
                editRehab.setText("");
                radioFemale.setChecked(false);
                radioMale.setChecked(false);
            }
        });
    }

    public boolean validate(){
        boolean isValid = true;

        name = editName.getText().toString().trim();
        address = editAddress.getText().toString().trim();
        age = editAge.getText().toString().trim();
        days = editDays.getText().toString().trim();
        medication = editMedication.getText().toString().trim();
        surgical = editSurgical.getText().toString().trim();
        lab = editLab.getText().toString().trim();
        rehab = editRehab.getText().toString().trim();
        male = radioMale.getText().toString().trim();
        female = radioFemale.getText().toString().trim();

        if (name.isEmpty()){
            isValid = false;
            editName.setError("Field cannot be empty");
        } else editName.setError(null);

        if (address.isEmpty()){
            isValid = false;
            editAddress.setError("Field cannot be empty");
        } else editAddress.setError(null);


        if (age.isEmpty()){
            isValid = false;
            editAge.setError("Field cannot be empty");
        } else editAge.setError(null);


        if (days.isEmpty()){
            isValid = false;
            editDays.setError("Field cannot be empty");
        } else editDays.setError(null);


        if (medication.isEmpty()){
            isValid = false;
            editMedication.setError("Field cannot be empty");
        } else editMedication.setError(null);


        if (surgical.isEmpty()){
            isValid = false;
            editSurgical.setError("Field cannot be empty");
        }else editSurgical.setError(null);


        if (lab.isEmpty()){
            isValid = false;
            editLab.setError("Field cannot be empty");
        }else editLab.setError(null);

        if (rehab.isEmpty()){
            isValid = false;
            editRehab.setError("Field cannot be empty");
        }else editRehab.setError(null);

        if (male.isEmpty() || female.isEmpty()){
            isValid = false;
            radioFemale.setError("Field cannot be empty");
        }else radioFemale.setError(null);



        return isValid;
    }
}
