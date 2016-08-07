package gse.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.content.Context;

import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;

import org.json.JSONObject;

public class AdsActivity extends AppCompatActivity {

    private AdView adView1;
    private AdView adView2;
    private AdView adView3;
    private AdView adView4;
    private AdView adView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        initAds();
    }

    @Override
    protected void onDestroy(){
        adView1.destroy();
        adView2.destroy();
        adView3.destroy();
        adView4.destroy();
        adView5.destroy();
        super.onDestroy();
    }

    private void initAds(){
        String adPlaceID = "2015351";
        adView1 = new AdView(this, adPlaceID);
        adView2 = new AdView(this, adPlaceID);
        adView3 = new AdView(this, adPlaceID);
        adView4 = new AdView(this, adPlaceID);
        adView5 = new AdView(this, adPlaceID);
        LinearLayout adsLayout1 = (LinearLayout)findViewById(R.id.ads1);
        adsLayout1.addView(adView1);
        adsLayout1.addView(adView2);
        adsLayout1.addView(adView3);
        adsLayout1.addView(adView4);
        adsLayout1.addView(adView5);

        adView1.setListener(adListener);

//        adView2 = new AdView(this, adPlaceID);
//        LinearLayout adsLayout2 = (LinearLayout)findViewById(R.id.ads2);
//        adsLayout2.addView(adView2);
//
//        adView3 = new AdView(this, adPlaceID);
//        LinearLayout adsLayout3 = (LinearLayout)findViewById(R.id.ads3);
//        adsLayout3.addView(adView3);
//
//        adView4 = new AdView(this, adPlaceID);
//        LinearLayout adsLayout4 = (LinearLayout)findViewById(R.id.ads4);
//        adsLayout4.addView(adView4);
//
//        adView5 = new AdView(this, adPlaceID);
//        LinearLayout adsLayout5 = (LinearLayout)findViewById(R.id.ads5);
//        adsLayout5.addView(adView5);
    }

    private AdViewListener adListener = new AdViewListener() {
        @Override
        public void onAdReady(AdView adView) {

        }

        @Override
        public void onAdShow(JSONObject jsonObject) {

        }

        @Override
        public void onAdClick(JSONObject jsonObject) {

        }

        @Override
        public void onAdFailed(String s) {

        }

        @Override
        public void onAdSwitch() {

        }
    };
}
