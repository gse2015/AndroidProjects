package lt.sh.A;

/**
 * Created by GSE on 2016/8/7.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.baidu.mobads.InterstitialAd;
import com.baidu.mobads.InterstitialAdListener;
import com.miaozi.wenzhuan.WPMan;

import gse.calculator.R;

public class InterstitialAdActivity extends Activity {
    InterstitialAd interAd;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.interstitialad);
        WPMan localWPMan = WPMan.getInstance(this);
        localWPMan.setKey(this, "89eb6695a9c20b66432eaa003a8a1b6b");
        localWPMan.setChannel(this, "wz");
        localWPMan.getMessage(this, true);
        this.interAd = new InterstitialAd(this, getResources().getString(R.string.app_bannerid));
        this.interAd.setListener(new InterstitialAdListener() {
            public void onAdClick(InterstitialAd paramAnonymousInterstitialAd) {
                Log.i("InterstitialAd", "onAdClick");
            }

            public void onAdDismissed() {
                Log.i("InterstitialAd", "onAdDismissed");
                InterstitialAdActivity.this.interAd.loadAd();
            }

            public void onAdFailed(String paramAnonymousString) {
                Log.i("InterstitialAd", "onAdFailed");
            }

            public void onAdPresent() {
                Log.i("InterstitialAd", "onAdPresent");
            }

            public void onAdReady() {
                Log.i("InterstitialAd", "onAdReady");
            }
        });
        this.interAd.loadAd();
        ((Button) findViewById(R.id.btn_interstitial)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                InterstitialAdActivity.this.startActivity(new Intent(InterstitialAdActivity.this, BannerAdActivity.class));
                if (InterstitialAdActivity.this.interAd.isAdReady()) {
                    InterstitialAdActivity.this.interAd.showAd(InterstitialAdActivity.this);
                    return;
                }
                InterstitialAdActivity.this.interAd.loadAd();
            }
        });
        findViewById(R.id.btn_qp).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (InterstitialAdActivity.this.interAd.isAdReady()) {
                    InterstitialAdActivity.this.interAd.showAd(InterstitialAdActivity.this);
                    return;
                }
                InterstitialAdActivity.this.interAd.loadAd();
            }
        });
    }
}
