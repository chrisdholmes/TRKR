package com.cs211d.holmes.trkr;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by root on 3/15/18.
 */

public class DisplayTRKR extends AppCompatActivity
{
    TextView displaytv;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_displaytrkr);

        displaytv = findViewById(R.id.displaytv);

    }
    public void displayMood()
    {


    }
    public void storeMood(String before, String after, String incident)
    {
        ContentValues cv = new ContentValues();

        cv.put("beforeMood",before);
        cv.put("afterMood",after);
        cv.put("incident",incident);

        //long recNum = trkrDB.insertOrThrow("info",null,cv);

        Log.d("DEBUG:", " data submission successful");
    }
}
