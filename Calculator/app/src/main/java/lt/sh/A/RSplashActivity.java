package lt.sh.A;

/**
 * Created by GSE on 2016/8/7.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import gse.calculator.R;

public class RSplashActivity extends Activity
{
    public boolean canJumpImmediately = false;

    private void jump()
    {
        startActivity(new Intent(this, InterstitialAdActivity.class));
        finish();
    }

    private void jumpWhenCanClick()
    {
        Log.d("test", "this.hasWindowFocus():" + hasWindowFocus());
        if (this.canJumpImmediately)
        {
            startActivity(new Intent(this, InterstitialAdActivity.class));
            finish();
            return;
        }
        this.canJumpImmediately = true;
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable()
                                  {
                                      public void run()
                                      {
                                          RSplashActivity.this.jump();
                                      }
                                  }
                , 2000L);
    }

    protected void onPause()
    {
        super.onPause();
        this.canJumpImmediately = false;
    }

    protected void onResume()
    {
        super.onResume();
        if (this.canJumpImmediately)
            jumpWhenCanClick();
        this.canJumpImmediately = true;
    }
}