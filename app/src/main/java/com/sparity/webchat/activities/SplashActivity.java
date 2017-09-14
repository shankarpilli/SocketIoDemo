package com.sparity.webchat.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.sparity.webchat.R;
import com.sparity.webchat.utility.Constants;
import com.sparity.webchat.utility.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends Activity {

    @BindView(R.id.tv_chat_icon)
    TextView tv_chat_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        tv_chat_icon.setTypeface(Utility.setTypeFace_Image(this));
        Handler mSplashHandler = new Handler();
        Runnable action = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginChatActivity.class);
                startActivity(intent);
                finish();
            }
        };
        mSplashHandler.postDelayed(action, Constants.SPLASH_TIME_OUT);
    }
}