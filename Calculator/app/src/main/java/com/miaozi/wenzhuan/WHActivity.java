package com.miaozi.wenzhuan;

import android.app.Activity;
import android.os.Bundle;

public class WHActivity extends Activity
{
    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        classA.a(this);
        classA.a(classA.a(this, 33), classA.a(this, 7), new Class[] { Activity.class }, new Object[] { this }, this);
    }

    protected void onDestroy()
    {
        classA.a(classA.a(this, 33), classA.a(this, 15), new Class[] { Activity.class }, new Object[] { this }, this);
        super.onDestroy();
    }
}