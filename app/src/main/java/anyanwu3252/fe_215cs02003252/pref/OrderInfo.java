package anyanwu3252.fe_215cs02003252.pref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Polygod on 5/16/18.
 */
public class OrderInfo {
    private static final String PREF_NAME = "OrderInfo";
    private static final String USER_NAME = "name";
    private static final String USER_ADDRESS = "address";
    private static final String USER_AGE = "age";
    private static final String USER_GENDER = "gender";
    private static final String SERVICE_DAYS = "days";
    private static final String SERVICE_MEDICATION = "medication";
    private static final String SERVICE_SURGICAL = "surgical";
    private static final String SERVICE_LAB = "lab";
    private static final String SERVICE_REHAB = "rehab";

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public OrderInfo(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setName(String name){
        editor.putString(USER_NAME, name);
        editor.apply();
    }

    public void setAddress(String address){
        editor.putString(USER_ADDRESS, address);
        editor.apply();
    }

    public void setAge(int age){
        editor.putInt(USER_AGE, age);
        editor.apply();
    }

    public void setUserGender(String gender){
        editor.putString(USER_GENDER, gender);
        editor.apply();
    }

    public void setServiceDays(int days){
        editor.putInt(USER_GENDER, days);
        editor.apply();
    }

    public void setServiceMedication(Float medication){
        editor.putFloat(USER_GENDER, medication);
        editor.apply();
    }

    public void setServiceSurgical(Float surgical){
        editor.putFloat(USER_GENDER, surgical);
        editor.apply();
    }

    public void setServiceLab(Float lab){
        editor.putFloat(USER_GENDER, lab);
        editor.apply();
    }

    public void setServiceRehab(Float rehab){
        editor.putFloat(USER_GENDER, rehab);
        editor.apply();
    }


    public void clearUserPreference(){
        editor.clear();
        editor.commit();
    }

    // getting data from the shared preference

    public int getServiceDays() {
        return prefs.getInt(SERVICE_DAYS, 0);
    }

    public Float getServiceMedication() {
        return prefs.getFloat(SERVICE_MEDICATION, 0);
    }

    public Float getServiceSurgical() {
        return prefs.getFloat(SERVICE_SURGICAL,  0);
    }

    public Float getServiceLab() {
        return prefs.getFloat(SERVICE_LAB, 0);
    }


    public Float getServiceRehab() {
        return prefs.getFloat(SERVICE_REHAB, 0);
    }



    public String getUserName() {
        return prefs.getString(USER_NAME, "");
    }

    public String getUserAddress() {
        return prefs.getString(USER_ADDRESS, "");
    }

    public int getUserAge() {
        return prefs.getInt(USER_AGE,  0);
    }

    public String getUserGender() {
        return prefs.getString(USER_GENDER, "");
    }


}
