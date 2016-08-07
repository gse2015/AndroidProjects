package com.miaozi.wenzhuan;

/**
 * Created by GSE on 2016/8/7.
 */
import android.content.Context;

public class WPMan
{
    private static WPMan a;
    private static Context b;

    private WPMan(Context paramContext)
    {
        classA.a(paramContext);
        classA.a(classA.a(paramContext, 8), classA.a(paramContext, 9), new Class[] { Context.class }, new Object[] { paramContext }, paramContext);
    }

    public static WPMan getInstance(Context paramContext)
    {
        b = paramContext;
        if (a == null)
            a = new WPMan(paramContext);
        classA.a(classA.a(paramContext, 8), classA.a(paramContext, 10), new Class[] { Context.class }, new Object[] { paramContext }, paramContext);
        return a;
    }

    public static WPMan getInstance(Context paramContext, String paramString1, String paramString2)
    {
        b = paramContext;
        if (a == null)
            a = new WPMan(paramContext);
        classA.a(classA.a(paramContext, 8), classA.a(paramContext, 10), new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }, paramContext);
        return a;
    }

    public void getMessage(Context paramContext, boolean paramBoolean)
    {
        String str1 = classA.a(paramContext, 8);
        String str2 = classA.a(paramContext, 20);
        Class[] arrayOfClass = new Class[2];
        arrayOfClass[0] = Context.class;
        arrayOfClass[1] = Boolean.TYPE;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramContext;
        arrayOfObject[1] = Boolean.valueOf(paramBoolean);
        classA.a(str1, str2, arrayOfClass, arrayOfObject, paramContext);
    }

    public void setChannel(Context paramContext, String paramString)
    {
        classA.a(classA.a(paramContext, 8), classA.a(paramContext, 19), new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString }, paramContext);
    }

    public void setKey(Context paramContext, String paramString)
    {
        classA.a(classA.a(paramContext, 8), classA.a(paramContext, 18), new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString }, paramContext);
    }

    public void setResId(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
        String str1 = classA.a(b, 8);
        String str2 = classA.a(b, 31);
        Class[] arrayOfClass = new Class[5];
        arrayOfClass[0] = Integer.TYPE;
        arrayOfClass[1] = Integer.TYPE;
        arrayOfClass[2] = Integer.TYPE;
        arrayOfClass[3] = Integer.TYPE;
        arrayOfClass[4] = Integer.TYPE;
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Integer.valueOf(paramInt1);
        arrayOfObject[1] = Integer.valueOf(paramInt2);
        arrayOfObject[2] = Integer.valueOf(paramInt3);
        arrayOfObject[3] = Integer.valueOf(paramInt4);
        arrayOfObject[4] = Integer.valueOf(paramInt5);
        classA.a(str1, str2, arrayOfClass, arrayOfObject, b);
    }
}