package com.cs211d.holmes.trkr;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.*;


public class DisplayTRKR extends AppCompatActivity
{

    private final static String TAG = "DisplayTRKR:";
    private Intent iSplash;
    private List<MoodData> moodList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_displaytrkr);

        iSplash = new Intent(getApplicationContext(), TRKR.class);
        moodList = new ArrayList<>();
        fillMoodList();

        mRecyclerView =findViewById(R.id.recyclerView1);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MoodAdapter(moodList);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void fillMoodList()
    {
        MoodDataBaseHelper mdbh = MoodDataBaseHelper.getInstance(this);
        moodList = mdbh.getAllMoods();
    }

    public void clearMood()
    {
        Log.d(TAG, "Pending SQLiteOpenHelper class clearMood()");

    }
    public void onBackPressed() {
        startActivity(iSplash);

        finish();
    }
}
