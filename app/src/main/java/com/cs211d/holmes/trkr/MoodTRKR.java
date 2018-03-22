package com.cs211d.holmes.trkr;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.TextView;

/**
 * This Activity is designed to store memories a user enters
 * into a sqlite database. It three Strings called before, after,
 * and incident which are all moments associated with a memory.
 *
 */

public class MoodTRKR extends AppCompatActivity implements View.OnClickListener
{
    private Spinner before;
    private Spinner after;
    private EditText incident;
    private static final String TAG = "MoodTRKR: ";
    private TextView verification;
    private Intent iSplash;

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.mood_trkr_activity);

        //Next three variables store three Strings for saving into Databases
        before = findViewById(R.id.beforesp);
        after = findViewById(R.id.aftersp);
        incident = findViewById(R.id.incidentedx);

        //verification is for informing the user the submission was successful
        verification = findViewById(R.id.verification);

        iSplash = new Intent(getApplicationContext(), TRKR.class);
    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.submitbtn:
                storeMood();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(iSplash);
        finish();
    }

    public void storeMood(){
        String beforeDATA = before.getSelectedItem().toString();
        String afterDATA = after.getSelectedItem().toString();
        String incidentDATA = incident.getText().toString();


        Log.d(TAG, beforeDATA + " " + afterDATA + " " + incidentDATA);

        MoodDataBaseHelper mdbh = MoodDataBaseHelper.getInstance(this);

        mdbh.insertMood(beforeDATA, incidentDATA, afterDATA);

        verification.setText("Submitted");
    }

}
