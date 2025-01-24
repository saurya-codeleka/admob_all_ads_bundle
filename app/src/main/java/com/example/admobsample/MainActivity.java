package com.example.admobsample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codeleka.libs.admobadscc.AdCode;
import com.codeleka.libs.admobadscc.AdsPref;
import com.codeleka.libs.admobadscc.Banner;
import com.codeleka.libs.admobadscc.helper.AdCallBack;

public class MainActivity extends AppCompatActivity {

    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdsPref adsPref = new AdsPref(this);

        adsPref.saveAds("on",
                "ca-app-pub-3940256099942544~3347511713",
                "ca-app-pub-3940256099942544/6300978111",
                "ca-app-pub-3940256099942544/2014213617",
                "ca-app-pub-3940256099942544/1033173712",
                "ca-app-pub-3940256099942544/5224354917",
                "ca-app-pub-3940256099942544/2247696110",
                "ca-app-pub-3940256099942544/9257395921", 3, 6);

        AdCode.init(this, true, true);


//        =============== Banner ================

        banner = new Banner(this);
        banner.loadBanner();




//      ===================== Interstitial =============

        AdCode.loadInterstitialAds(this);

        Button show_int = findViewById(R.id.show_int);
        show_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdCode.showInterstitial(MainActivity.this, new AdCallBack() {
                    @Override
                    public void onNext() {
                        //
                    }

                    @Override
                    public void onReward() {

                    }
                });
            }
        });


//        ==================== Interstitial Counter ====================


        Button show_int_int = findViewById(R.id.show_int_int);
        show_int_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdCode.showInterstitialCounter(MainActivity.this, new AdCallBack() {
                    @Override
                    public void onNext() {

                    }

                    @Override
                    public void onReward() {

                    }
                });
            }
        });


//        ==================== Rewarded ================

        AdCode.loadRew(this);

        Button rew = findViewById(R.id.show_rew);
        rew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdCode.showRewarded(MainActivity.this, new AdCallBack() {
                    @Override
                    public void onNext() {

                    }

                    @Override
                    public void onReward() {

                    }
                });

            }
        });


//        ================================= Native ============

        AdCode.loadNativeAd(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        banner.destroy();
    }
}