package com.miaozi.wenzhuan;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class WDActivity extends Activity
        implements View.OnClickListener, AdapterView.OnItemClickListener
{
    public void onClick(View paramView)
    {
        classA.a(classA.a(this, 25), classA.a(this, 28), new Class[] { View.class }, new Object[] { paramView }, this);
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
        super.onConfigurationChanged(paramConfiguration);
        classA.a(classA.a(this, 25), classA.a(this, 26), new Class[] { Configuration.class }, new Object[] { paramConfiguration }, this);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        classA.a(this);
        classA.a(classA.a(this, 25), classA.a(this, 7), new Class[] { Activity.class }, new Object[] { this }, this);
    }

    protected void onDestroy()
    {
        classA.a(classA.a(this, 25), classA.a(this, 15), new Class[0], new Object[0], this);
        super.onDestroy();
    }

    public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
        String str1 = classA.a(this, 25);
        String str2 = classA.a(this, 29);
        Class[] arrayOfClass = new Class[4];
        arrayOfClass[0] = AdapterView.class;
        arrayOfClass[1] = View.class;
        arrayOfClass[2] = Integer.TYPE;
        arrayOfClass[3] = Long.TYPE;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = paramAdapterView;
        arrayOfObject[1] = paramView;
        arrayOfObject[2] = Integer.valueOf(paramInt);
        arrayOfObject[3] = Long.valueOf(paramLong);
        classA.a(str1, str2, arrayOfClass, arrayOfObject, this);
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (paramInt == 4)
        {
            classA.a(classA.a(this, 25), classA.a(this, 27), new Class[0], new Object[0], this);
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }
}