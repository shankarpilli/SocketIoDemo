package com.sparity.webchat.parser;

import com.sparity.webchat.models.LoginModel;
import com.sparity.webchat.models.Model;

import org.json.JSONObject;

/**
 * Created by Shankar on 9/14/2017.
 */

public class LoginParser implements Parser<Model> {
    @Override
    public Model parse(String s) {
        LoginModel mLoginModel = new LoginModel();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject userJsonObject = jsonObject.optJSONObject("user");
            mLoginModel.setId(userJsonObject.optString("id"));
            mLoginModel.setEmail(userJsonObject.optString("email"));
            mLoginModel.setUsername(userJsonObject.optString("username"));
            mLoginModel.setImage(userJsonObject.optString("image"));
            mLoginModel.setBio(userJsonObject.optString("bio"));
            mLoginModel.setCreatedAt(userJsonObject.optString("createdAt"));
            mLoginModel.setUpdatedAt(userJsonObject.optString("updatedAt"));
            mLoginModel.setToken(userJsonObject.optString("token"));
            mLoginModel.setCode(jsonObject.optString("code"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mLoginModel;
    }
}