package com.example.admobsample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codeleka.libs.admobadscc.AdCode;
import com.codeleka.libs.admobadscc.helper.AdCallBack;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        AdCode.IS_FLASH = true;



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nextTask();
                    }
                });
            }
        },2000);



    }

    @Override
    protected void onResume() {
        super.onResume();
        AdCode.IS_FLASH = true;
    }

    private void nextTask() {


        AdCode.showOpenAdOnFlash(FlashActivity.this, new AdCallBack() {
            @Override
            public void onNext() {
                AdCode.IS_FLASH = false;
                Intent intent = new Intent(FlashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onReward() {

            }
        });
    }
}