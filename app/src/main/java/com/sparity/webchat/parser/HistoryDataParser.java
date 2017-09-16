package com.sparity.webchat.parser;

import com.sparity.webchat.models.DataArrayModel;
import com.sparity.webchat.models.DataModel;
import com.sparity.webchat.models.ListArrayModel;
import com.sparity.webchat.models.ListModel;
import com.sparity.webchat.models.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shankar on 9/15/2017.
 */

public class HistoryDataParser implements Parser<Model> {
    @Override
    public Model parse(String s) {
        DataArrayModel mDataArrayModel = new DataArrayModel();
        ArrayList<DataModel> dataModels = new ArrayList();
        try {
            JSONObject jsonObject = new JSONObject(s);

            if (jsonObject.has("code"))
                mDataArrayModel.setCode(jsonObject.optString("code"));
            if (jsonObject.has("history")) {
                JSONArray jsonOthersArray = jsonObject.optJSONArray("history");
                if (jsonOthersArray.length() > 0) {
                    for (int i = 0; i < jsonOthersArray.length(); i++) {
                        JSONObject othersJsonObj = (JSONObject) jsonOthersArray.get(i);
                        DataModel dataModel = new DataModel();
                        if (othersJsonObj.has("senderId"))
                            dataModel.setSenderId(othersJsonObj.optString("senderId"));
                       /*if (othersJsonObj.has("room"))
                            dataModel.setRoom(othersJsonObj.optString("room"));*/
                        if (othersJsonObj.has("message"))
                            dataModel.setMessage(othersJsonObj.optString("message"));
                        if (othersJsonObj.has("timestamp"))
                            dataModel.setTimestamp(othersJsonObj.optString("timestamp"));
                        dataModels.add(dataModel);
                    }
                }
            }
            mDataArrayModel.setDataModels(dataModels);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mDataArrayModel;
    }
}