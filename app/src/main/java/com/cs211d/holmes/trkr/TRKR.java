package com.cs211d.holmes.trkr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TRKR extends AppCompatActivity implements View.OnClickListener
{
    private Intent i;
    private EditText splashPwd;
    private Button splashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trkr);
        i = new Intent(getApplicationContext(), MoodTRKR.class);
        splashPwd = findViewById(R.id.splashedx);
        splashButton = findViewById(R.id.splashbtn);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.splashbtn:
                String password = splashPwd.getText().toString();
                if(password.equals(null))
                {
                    Toast toast = Toast.makeText(this.getApplicationContext(),
                            "Please enter password",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(password.equals("margarette516") || password.equals("mg516"))
                {
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(this.getApplicationContext(),
                            "Bad password",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }


        }
    }
}
