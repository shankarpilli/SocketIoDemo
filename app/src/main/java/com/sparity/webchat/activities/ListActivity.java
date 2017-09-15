package com.sparity.webchat.activities;

import android.content.Intent;
import android.os.Bundle;

import com.sparity.webchat.BaseActivity;
import com.sparity.webchat.R;
import com.sparity.webchat.asynctask.IAsyncCaller;
import com.sparity.webchat.aynctaskold.ServerIntractorAsync;
import com.sparity.webchat.models.ListArrayModel;
import com.sparity.webchat.models.LoginModel;
import com.sparity.webchat.models.Model;
import com.sparity.webchat.parser.ListDataParser;
import com.sparity.webchat.utility.APIConstants;
import com.sparity.webchat.utility.Constants;
import com.sparity.webchat.utility.Utility;

import org.json.JSONObject;

public class ListActivity extends BaseActivity implements IAsyncCaller {

    private LoginModel mLoginModel;
    private ListArrayModel mListArrayModel;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        intent = getIntent();
        if (intent.hasExtra(Constants.LOGIN_DATA))
            mLoginModel = (LoginModel) intent.getSerializableExtra(Constants.LOGIN_DATA);
        if (mLoginModel != null) {
            getListData();
        }
    }

    /**
     * This method is used to show the list
     */
    private void getListData() {
        try {
            JSONObject jsonObject = new JSONObject();
            ListDataParser listDataParser = new ListDataParser();
            ServerIntractorAsync serverJSONAsyncTask = new ServerIntractorAsync(
                    this, Utility.getResourcesString(this, R.string.please_wait), true,
                    APIConstants.OTHERS, jsonObject,
                    APIConstants.REQUEST_TYPE.GET, this, listDataParser);
            Utility.execute(serverJSONAsyncTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used get the output of the service with a model
     */
    @Override
    public void onComplete(Model model) {
        if (model != null) {
            if (model instanceof ListArrayModel) {
                mListArrayModel = (ListArrayModel) model;
            }
        }
    }
}
