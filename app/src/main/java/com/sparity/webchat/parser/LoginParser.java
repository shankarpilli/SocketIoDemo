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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mLoginModel;
    }
}