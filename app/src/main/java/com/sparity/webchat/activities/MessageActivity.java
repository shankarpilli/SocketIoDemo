package com.sparity.webchat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sparity.webchat.R;
import com.sparity.webchat.models.ListModel;
import com.sparity.webchat.models.LoginModel;
import com.sparity.webchat.utility.Constants;


public class MessageActivity extends AppCompatActivity {

    private Intent intent;
    public LoginModel mLoginModel;
    public ListModel mListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        intent = getIntent();
        if (intent.hasExtra(Constants.LOGIN_DATA)) {
            mLoginModel = (LoginModel) intent.getSerializableExtra(Constants.LOGIN_DATA);
        }
        if (intent.hasExtra(Constants.CURRENT_CHAT_USER_DATA)) {
            mListModel = (ListModel) intent.getSerializableExtra(Constants.CURRENT_CHAT_USER_DATA);
        }
        setContentView(R.layout.activity_message);
    }
}
