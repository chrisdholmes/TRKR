package com.cs211d.holmes.trkr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 3/14/18.
 */

public class MoodTRKR extends AppCompatActivity implements View.OnClickListener
{
    Spinner before;
    Spinner after;
    EditText incident;
    SQLiteDatabase trkrDB;
    TextView verification;

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.mood_trkr_activity);

        before = findViewById(R.id.beforesp);
        after = findViewById(R.id.aftersp);
        incident = findViewById(R.id.incidentedx);
        verification = findViewById(R.id.verification);
        trkrDB = openOrCreateDatabase("mooddb.db",
                Context.MODE_PRIVATE, null);

        String sqlcmd = "CREATE TABLE IF NOT EXISTS INFO(" +
                "id integer auto_increment," +
                "before text NOT NULL," +
                "after text NOT NULL," +
                "incident text);";
        trkrDB.execSQL(sqlcmd);


    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.submitbtn:
                String beforeDATA = before.getSelectedItem().toString();
                String afterDATA = after.getSelectedItem().toString();
                String incidentDATA = incident.getText().toString();

                if(incidentDATA.equals(null)){
                    Log.d("DEBUG: ", "INCIDENT CAN NOT BE NULL");
                }

                ContentValues cv = new ContentValues();

                cv.put("before",beforeDATA);
                cv.put("after",afterDATA);
                cv.put("incident",incidentDATA);

                long recNum = trkrDB.insertOrThrow("info",null,cv);

                Log.d("DEBUG:","recNum = " + recNum + " data submission successful");

                verification.setText("Submitted");

                retrieveMood();


        }
    }
    public void retrieveMood()
    {
        Cursor c = trkrDB.query("info",null, null,
                null, null, null, null, null);
        int cCount = c.getColumnCount();

        ArrayList<String> mood = new ArrayList<>();
        if (c != null)
            for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
            {
               int i = 1;
               while(i < c.getColumnCount()){
                   Log.d(c.getColumnName(i),c.getString(i) + " test");
                   i++;
               }
            }

    }

}
