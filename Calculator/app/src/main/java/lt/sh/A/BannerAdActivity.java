package lt.sh.A;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;

import org.json.JSONObject;

import gse.calculator.R;

public class BannerAdActivity extends Activity {
    private String adPlaceId;
    AdView adView;
    AdView adView1;
    AdView adView10;
    AdView adView2;
    AdView adView3;
    AdView adView4;
    AdView adView5;
    AdView adView6;
    AdView adView7;
    AdView adView8;
    AdView adView9;
    AdViewListener adViewListener = new AdViewListener() {
        public void onAdClick(JSONObject paramAnonymousJSONObject) {
        }

        public void onAdFailed(String paramAnonymousString) {
            Log.w("", "onAdFailed " + paramAnonymousString);
        }

        public void onAdReady(AdView paramAnonymousAdView) {
            Log.w("", "onAdReady " + paramAnonymousAdView);
        }

        public void onAdShow(JSONObject paramAnonymousJSONObject) {
            Log.w("", "onAdShow " + paramAnonymousJSONObject.toString());
        }

        public void onAdSwitch() {
            Log.w("", "onAdSwitch");
        }
    };
    private Handler handler = new Handler();
    private LinearLayout layoutADD;

    private void ADDADView() {
        this.adView1 = new AdView(this, this.adPlaceId);
        this.adView2 = new AdView(this, this.adPlaceId);
        this.adView3 = new AdView(this, this.adPlaceId);
        this.adView4 = new AdView(this, this.adPlaceId);
        this.adView5 = new AdView(this, this.adPlaceId);
        this.adView6 = new AdView(this, this.adPlaceId);
        this.adView7 = new AdView(this, this.adPlaceId);
        this.adView8 = new AdView(this, this.adPlaceId);
        this.adView9 = new AdView(this, this.adPlaceId);
        this.adView10 = new AdView(this, this.adPlaceId);
        this.layoutADD.addView(this.adView1);
        this.layoutADD.addView(this.adView2);
        this.layoutADD.addView(this.adView3);
        this.layoutADD.addView(this.adView4);
        this.layoutADD.addView(this.adView5);
        this.layoutADD.addView(this.adView6);
        this.layoutADD.addView(this.adView7);
        this.layoutADD.addView(this.adView8);
        this.layoutADD.addView(this.adView9);
        this.layoutADD.addView(this.adView10);
        Toast.makeText(this, "20秒后开始清除广告", 0).show();
        if (this.handler == null)
            return;
        this.handler.postDelayed(new Runnable() {
                                     public void run() {
                                         BannerAdActivity.this.removeAD();
                                     }
                                 }
                , 20000L);
    }

    private void destroyAdView(AdView paramAdView) {
        if (paramAdView != null)
            paramAdView.destroy();
    }

    private void removeAD() {
        this.layoutADD.removeAllViews();
        Toast.makeText(this, "10秒后开始加载广告", Toast.LENGTH_SHORT).show();
        if (this.handler == null)
            return;
        this.handler.postDelayed(new Runnable() {
                                     public void run() {
                                         BannerAdActivity.this.ADDADView();
                                     }
                                 }
                , 10000L);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.layout_banner);
        this.layoutADD = ((LinearLayout) findViewById(R.id.layout_add));
        AdSettings.setKey(new String[]{"baidu", "中 国 "});
        this.adPlaceId = getResources().getString(R.string.app_bannerid);
        ADDADView();
    }

    protected void onDestroy() {
        destroyAdView(this.adView1);
        destroyAdView(this.adView2);
        destroyAdView(this.adView3);
        destroyAdView(this.adView4);
        destroyAdView(this.adView5);
        destroyAdView(this.adView6);
        destroyAdView(this.adView7);
        destroyAdView(this.adView8);
        destroyAdView(this.adView9);
        destroyAdView(this.adView10);
        this.handler = null;
        super.onDestroy();
    }
}