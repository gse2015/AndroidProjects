package com.miaozi.wenzhuan;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class WOService extends Service
{
    public IBinder onBind(Intent paramIntent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        classA.a(this);
        classA.a(classA.a(this, 12), classA.a(this, 7), new Class[] { Context.class }, new Object[] { this }, this);
    }

    public void onDestroy()
    {
        classA.a(classA.a(this, 12), classA.a(this, 15), new Class[] { Context.class }, new Object[] { this }, this);
        super.onDestroy();
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
        super.onStartCommand(paramIntent, paramInt1, paramInt2);
        String str1 = classA.a(this, 12);
        String str2 = classA.a(this, 14);
        Class[] arrayOfClass = new Class[3];
        arrayOfClass[0] = Intent.class;
        arrayOfClass[1] = Integer.TYPE;
        arrayOfClass[2] = Integer.TYPE;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramIntent;
        arrayOfObject[1] = Integer.valueOf(paramInt1);
        arrayOfObject[2] = Integer.valueOf(paramInt2);
        classA.a(str1, str2, arrayOfClass, arrayOfObject, this);
        return 1;
    }
}