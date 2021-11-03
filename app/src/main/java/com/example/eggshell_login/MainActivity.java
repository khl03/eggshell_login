package com.example.eggshell_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    private ImageButton nong, su, chuk, yeon;
    private Button main_cost, main_store;
    private ViewFlipper vf;
    private long backBtnTime = 0;

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    public  void onBackPressed(){
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(this, "one more", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_cost = findViewById(R.id.main_cost);

        main_store = findViewById(R.id.main_store);

        vf = findViewById(R.id.vf);

        main_cost.setOnClickListener(this);

        main_store.setOnClickListener(this);

        yeon = findViewById(R.id.yeon);
        yeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webViewActivity.class);
                startActivity(intent);
            }
        });

        nong = findViewById(R.id.nong);
        nong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webViewActivity.class);
                startActivity(intent);
            }
        });

        su = findViewById(R.id.su);
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webViewActivity.class);
                startActivity(intent);
            }
        });

        chuk = findViewById(R.id.chuk);
        chuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),webViewActivity.class);
                startActivity(intent);
            }
        });

        Intent intent1 = new Intent(this, LodingActivity.class);
        startActivity(intent1);

    }

    public void onClick(View v){

        switch(v.getId())

        {

            case R.id.main_cost:

                vf.showPrevious();

                toast("가격 시세");

                break;

            case R.id.main_store:

                vf.showNext();

                toast("판매 업체");

                break;

        }

    }

    public void toast(String text){

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }
}