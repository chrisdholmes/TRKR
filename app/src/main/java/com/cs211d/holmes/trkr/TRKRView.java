package com.cs211d.holmes.trkr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;


/**
 * Created by root on 3/20/18.
 */

public class TRKRView extends View
{
    private Paint paint;
    private ArrayList<MoodData> moodAList;

    public TRKRView(Context con, AttributeSet attr)
    {
        super(con, attr);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        moodAList = new ArrayList<>();
    }

    public TRKRView(Context con)
    {
        super(con);
    }

    public void drawMood(MoodData mood)
    {
        moodAList.add(mood);
        invalidate();
    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

        if(moodAList.isEmpty()){
            c.drawText("EMPTY",20, 75, paint);
        } else {
            int x = 20;
            int y = 40;
            for(MoodData mood: moodAList){
                String moodDisplayText = mood.getTimeStamp() + " " + mood.getBefore() + " " + mood.getIncident() + " " +
                        mood.getAfter();
                c.drawText(moodDisplayText, x, y + 10, paint);
            }
        }
    }
}
