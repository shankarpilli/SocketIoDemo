package com.sparity.webchat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.sparity.webchat.BaseActivity;
import com.sparity.webchat.MainActivity;
import com.sparity.webchat.R;
import com.sparity.webchat.asynctask.IAsyncCaller;
import com.sparity.webchat.asynctask.ServerJSONAsyncTask;
import com.sparity.webchat.models.LoginModel;
import com.sparity.webchat.models.Model;
import com.sparity.webchat.parser.LoginParser;
import com.sparity.webchat.utility.APIConstants;
import com.sparity.webchat.utility.Utility;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginChatActivity extends BaseActivity implements IAsyncCaller {

    @BindView(R.id.edt_user_name)
    EditText edt_user_name;

    @BindView(R.id.edt_password)
    EditText edt_password;
    private LoginModel mLoginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_login_chat);
        ButterKnife.bind(this);
    }

    /**
     * This method is used to call login
     */
    @OnClick(R.id.tv_login)
    void callLogin() {
        if (isValidFields()) {
            navigateDashBoard();
        }
    }

    /**
     * Navigate to dash board
     */
    private void navigateDashBoard() {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();

            linkedHashMap.put("username", edt_user_name.getText().toString());
            linkedHashMap.put("password", edt_password.getText().toString());

            LoginParser visitorParser = new LoginParser();
            ServerJSONAsyncTask serverJSONAsyncTask = new ServerJSONAsyncTask(
                    this, Utility.getResourcesString(this, R.string.please_wait), true,
                    APIConstants.LOGIN, linkedHashMap,
                    APIConstants.REQUEST_TYPE.POST, this, visitorParser);
            Utility.execute(serverJSONAsyncTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check for the validations
     */
    private boolean isValidFields() {
        boolean isValid = true;
        if (Utility.isValueNullOrEmpty(edt_user_name.getText().toString())) {
            Utility.setSnackBar(this, edt_user_name, "Please enter username");
            edt_user_name.requestFocus();
            isValid = false;
        } else if (edt_password.getText().toString().length() < 4) {
            Utility.setSnackBar(this, edt_password, "Please enter password");
            edt_password.requestFocus();
            isValid = false;
        }
        return isValid;
    }


    /**
     * This method is used get the output of the service with a model
     */
    @Override
    public void onComplete(Model model) {
        if (model != null) {
            if (model instanceof LoginModel) {
                mLoginModel = (LoginModel) model;
                navigateToIntent();
            }
        }
    }

    /**
     * This method is used to navigate intent
     */
    private void navigateToIntent() {
        Intent intent = new Intent(LoginChatActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
