package com.miaozi.wenzhuan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class WLActivity extends Activity
        implements View.OnClickListener, AdapterView.OnItemClickListener
{
    public void onClick(View paramView)
    {
        classA.a(classA.a(this, 30), classA.a(this, 28), new Class[] { View.class }, new Object[] { paramView }, this);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        classA.a(this);
        classA.a(classA.a(this, 30), classA.a(this, 7), new Class[] { Activity.class }, new Object[] { this }, this);
    }

    public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
        String str1 = classA.a(this, 30);
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
}