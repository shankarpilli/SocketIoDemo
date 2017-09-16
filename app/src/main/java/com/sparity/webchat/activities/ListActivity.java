package com.sparity.webchat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.sparity.webchat.BaseActivity;
import com.sparity.webchat.ChatApplication;
import com.sparity.webchat.R;
import com.sparity.webchat.adpters.UserListAdapter;
import com.sparity.webchat.asynctask.IAsyncCaller;
import com.sparity.webchat.aynctaskold.ServerIntractorAsync;
import com.sparity.webchat.models.ListArrayModel;
import com.sparity.webchat.models.LoginModel;
import com.sparity.webchat.models.Model;
import com.sparity.webchat.parser.ListDataParser;
import com.sparity.webchat.utility.APIConstants;
import com.sparity.webchat.utility.Constants;
import com.sparity.webchat.utility.Utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ListActivity extends BaseActivity implements IAsyncCaller {

    private LoginModel mLoginModel;
    private ListArrayModel mListArrayModel;
    private Intent intent;
    private UserListAdapter userListAdapter;
    @BindView(R.id.list_view)
    ListView list_view;
    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ChatApplication app = (ChatApplication) getApplication();
        mSocket = app.getSocket();

        ButterKnife.bind(this);
        intent = getIntent();
        if (intent.hasExtra(Constants.LOGIN_DATA))
            mLoginModel = (LoginModel) intent.getSerializableExtra(Constants.LOGIN_DATA);
        if (mLoginModel != null) {
            getListData();
        }
        mSocket.connect();
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
                setDataToList();
            }
        }
    }

    /**
     * This method is used to set data to the list
     */
    private void setDataToList() {
        userListAdapter = new UserListAdapter(ListActivity.this, mListArrayModel.getListModels());
        list_view.setAdapter(userListAdapter);

        for (int i = 0; i < mListArrayModel.getListModels().size(); i++) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("room", mListArrayModel.getListModels().get(i).getRoom());
                jsonObject.put("senderId", mLoginModel.getId());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            mSocket.emit(Constants.SUBSCRIBE, jsonObject);
        }
    }

    @OnItemClick(R.id.list_view)
    void onItemClick(int position) {
        Intent intent = new Intent(ListActivity.this, MessageActivity.class);
        intent.putExtra(Constants.LOGIN_DATA, mLoginModel);
        intent.putExtra(Constants.CURRENT_CHAT_USER_DATA, mListArrayModel.getListModels().get(position));
        startActivity(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
    }
}
