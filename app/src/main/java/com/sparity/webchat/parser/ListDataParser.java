package com.sparity.webchat.parser;

import com.sparity.webchat.models.ListArrayModel;
import com.sparity.webchat.models.ListModel;
import com.sparity.webchat.models.LoginModel;
import com.sparity.webchat.models.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shankar on 9/15/2017.
 */

public class ListDataParser implements Parser<Model> {
    @Override
    public Model parse(String s) {
        ListArrayModel mListModel = new ListArrayModel();
        ArrayList<ListModel> listModels = new ArrayList();
        try {
            JSONObject jsonObject = new JSONObject(s);

            if (jsonObject.has("code"))
                mListModel.setCode(jsonObject.optString("code"));
            if (jsonObject.has("others")) {
                JSONArray jsonOthersArray = jsonObject.optJSONArray("others");
                if (jsonOthersArray.length() > 0) {
                    for (int i = 0; i < jsonOthersArray.length(); i++) {
                        JSONObject othersJsonObj = (JSONObject) jsonOthersArray.get(i);
                        ListModel listModel = new ListModel();
                        if (othersJsonObj.has("id"))
                            listModel.setId(othersJsonObj.optString("id"));
                        if (othersJsonObj.has("email"))
                            listModel.setEmail(othersJsonObj.optString("email"));
                        if (othersJsonObj.has("username"))
                            listModel.setUsername(othersJsonObj.optString("username"));
                        if (othersJsonObj.has("image"))
                            listModel.setImage(othersJsonObj.optString("image"));
                        if (othersJsonObj.has("createdAt"))
                            listModel.setCreatedAt(othersJsonObj.optString("createdAt"));
                        if (othersJsonObj.has("updatedAt"))
                            listModel.setUpdatedAt(othersJsonObj.optString("updatedAt"));
                        if (othersJsonObj.has("room"))
                            listModel.setRoom(othersJsonObj.optString("room"));

                        listModels.add(listModel);
                    }
                }
            }
            mListModel.setListModels(listModels);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mListModel;
    }
}