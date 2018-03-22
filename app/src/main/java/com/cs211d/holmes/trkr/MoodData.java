package com.cs211d.holmes.trkr;

import android.content.ContentValues;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by root on 3/20/18.
 */

public class MoodData
{

    public static final String TABLE_NAME = "moods";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BEFORE = "before";
    public static final String COLUMN_INCIDENT = "incident";
    public static final String COLUMN_AFTER = "after";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String timestamp;
    private String before;
    private String incident;
    private String after;

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_BEFORE + " TEXT,"
                    + COLUMN_INCIDENT + " TEXT,"
                    + COLUMN_AFTER + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    public MoodData(){

    }
    public MoodData(int id, String before, String incident, String after, String timestamp){
        this.before = before;
        this.after = after;
        this.incident = incident;
        this.id = id;
        this.timestamp = timestamp;
    }


    public String getTimeStamp()
    {
        return timestamp;
    }

    public void setTimeStamp(String timestamp){
        this.timestamp = timestamp;
    }
    public String getBefore()
    {
        return before;
    }

    public void setBefore(String before)
    {
        this.before = before;
    }

    public String getAfter()
    {
        return after;
    }

    public void setAfter(String after)
    {
        this.after = after;
    }

    public String getIncident()
    {
        return incident;
    }

    public void setIncident(String incident)
    {
        this.incident = incident;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getStatement(){
        return this.timestamp + " " + this.id + " "
                + this.before + " " + this.after + " " +
                this.incident;
    }


}
