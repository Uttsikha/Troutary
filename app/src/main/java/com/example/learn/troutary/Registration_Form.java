package com.example.learn.troutary;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration_Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText farmname;
    EditText proprietor;
    EditText email;
    EditText citizenship;
    String checkfarmname;
    String checkproprietor;
    String checkemail;
    String checkcitizenship;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__form);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        // Spinner element
        Spinner farmnature = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        farmnature.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Table fish");
        categories.add("Fingerling");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        farmnature.setAdapter(dataAdapter);
        // Spinner element
        Spinner racewaynumber = (Spinner) findViewById(R.id.no);

        // Spinner click listener
        racewaynumber.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories1 = new ArrayList<String>();
        categories1.add("1");
        categories1.add("2");

        categories1.add("3");

        categories1.add("4");

        categories1.add("5");

        categories1.add("6");

        categories1.add("7");

        categories1.add("8");

        categories1.add("9");

        categories1.add("10");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        racewaynumber.setAdapter(dataAdapter1);

        Spinner wardno = (Spinner) findViewById(R.id.ward);

        // Spinner click listener
        wardno.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("1");
        categories2.add("2");

        categories2.add("3");

        categories2.add("4");

        categories2.add("5");

        categories2.add("6");

        categories2.add("7");

        categories2.add("8");

        categories2.add("9");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        wardno.setAdapter(dataAdapter2);
        Spinner vdc = (Spinner) findViewById(R.id.vdc);

        // Spinner click listener
        vdc.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("Dhunche");
        categories3.add("Syafru");

        categories3.add("Bhorle");

        categories3.add("Bridhim");

        categories3.add("Chilime");

        categories3.add("Dandagoun");

        categories3.add("Gatlang");

        categories3.add("Goljung");

        categories3.add("Haku");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        vdc.setAdapter(dataAdapter3);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
//        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //      Toast.makeText(parent.getContext(), "Farm nature: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void registered(View view) {
        farmname = (EditText) findViewById(R.id.farmname);
        proprietor = (EditText) findViewById(R.id.proprietor);
        email = (EditText) findViewById(R.id.emailid);
        citizenship = (EditText) findViewById(R.id.citizenship);

        checkfarmname = farmname.getText().toString();
        checkproprietor = proprietor.getText().toString();
        checkemail = email.getText().toString();
        checkcitizenship = citizenship.getText().toString();

        checkDataEntered();

    }

    boolean isEmail(EditText text) {
        CharSequence mail = email.getText().toString();
        return (!TextUtils.isEmpty(mail) && Patterns.EMAIL_ADDRESS.matcher(mail).matches());
    }

    boolean isAlpha(String text) {
        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher ms = ps.matcher(text);
        return (ms.matches());

    }


    void checkDataEntered() {

        //   if (isEmpty(email)) {
        // if (email.getText().toString().trim().equalsIgnoreCase("")) {

        if (checkfarmname.matches("") || checkproprietor.matches("")
                || checkemail.matches("") || checkcitizenship.matches("")) {
            Toast.makeText(this, "Requires all data", Toast.LENGTH_SHORT).show();
        } else {
            if (isAlpha(checkfarmname) == false) {
                farmname.requestFocus();
                farmname.setError("Farm name should contain alphabets only.");
            }

            if (isAlpha(checkproprietor) == false) {
                proprietor.requestFocus();
                proprietor.setError("Owner name should be appropriate.");
            }
            if(checkcitizenship.length()<7){
                citizenship.requestFocus();
                citizenship.setError("Citizenship number should be at least 7 digits long");
            }
            if (isEmail(email) == false) {
                email.requestFocus();
                email.setError("Enter valid email");
            } else {
                Toast.makeText(this, "Your registration application is submitted.", Toast.LENGTH_LONG).show();
            }
        }
    }
}








