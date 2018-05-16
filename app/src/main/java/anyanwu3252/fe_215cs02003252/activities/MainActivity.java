package anyanwu3252.fe_215cs02003252.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import anyanwu3252.fe_215cs02003252.R;
import anyanwu3252.fe_215cs02003252.pref.OrderInfo;

/*
       ANYANWU MIRACLE - 215CS02003252
 */

public class MainActivity extends AppCompatActivity {

    private EditText editName, editAddress, editAge, editDays, editMedication, editSurgical, editLab, editRehab;

    private RadioButton radioMale, radioFemale;

    private String name, address, age, days, medication, surgical, lab, rehab, gender;

    private AppCompatButton btnClear, btnCalculate;

    private OrderInfo orderInfo;

    private final int AMOUNT = 500;

    private Intent i;

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

                    if (radioMale.isChecked()){
                        gender = "Male";
                    } else gender = "Female";

                    // writing to sharedpreference
                    orderInfo.setAddress(address);
                    orderInfo.setAge(Integer.parseInt(age));
                    orderInfo.setName(name);
                    orderInfo.setUserGender(gender);
                    orderInfo.setServiceDays(Integer.parseInt(days));
                    orderInfo.setServiceLab(Float.valueOf(lab));
                    orderInfo.setServiceMedication(Float.valueOf(medication));
                    orderInfo.setServiceRehab(Float.valueOf(rehab));
                    orderInfo.setServiceSurgical(Float.valueOf(surgical));

                    orderInfo.setStayCharges(calcStayCharges());
                    orderInfo.setMiscCharges(calcMiscCharges());
                    orderInfo.setTotalCharges(totalCharges());

                    onSuccess();
                } else {
                    Toast.makeText(getApplicationContext(), "Could not process information", Toast.LENGTH_LONG).show();
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


    public void onSuccess(){
        i = new Intent(this, SummaryActivity.class);
        startActivity(i);
    }


    /*
        RETURNS: true if isValid
     */
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

        return isValid;
    }


    public float calcStayCharges(){
        float baseCharge;

        baseCharge = AMOUNT * Integer.parseInt(days);

        return baseCharge;
    }

    public float calcMiscCharges(){
        float miscCharges;

        miscCharges = Float.parseFloat(medication + surgical + lab + rehab);

        return miscCharges;
    }

    public float totalCharges(){
        float totalCharges;

        totalCharges = calcMiscCharges() + calcMiscCharges();

        return totalCharges;
    }


}
