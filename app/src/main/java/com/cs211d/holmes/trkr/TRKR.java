package com.cs211d.holmes.trkr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This is the primary Menu for the application.
 * It provides the user with two Buttons.
 * One titled store will allow a user to store a memory and the moods before and after the memory.
 * The other titled Display will allow a user to Load stored memories.
 */
public class TRKR extends AppCompatActivity implements View.OnClickListener
{
    private Intent iMoodTRKR;
    private Intent iDisplayTRKR;
    private Button displayButton;
    private Button storeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trkr);
        //intent object for the saving activity
        iMoodTRKR = new Intent(getApplicationContext(), MoodTRKR.class);
        //intent object for the displaying activity
        iDisplayTRKR = new Intent(getApplicationContext(), DisplayTRKR.class);

        displayButton = findViewById(R.id.displaybtn);
        storeButton = findViewById(R.id.storebtn);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            //Opens display Activity and then closes
            case R.id.displaybtn:
                startActivity(iDisplayTRKR);
                finish();
                break;
            //Open saving Activity and then closes
            case R.id.storebtn:
                startActivity(iMoodTRKR);
                finish();
                break;
        }
    }
}
