package com.sparity.webchat.models;

import java.util.ArrayList;

/**
 * Created by Shankar on 9/16/2017.
 */

public class DataArrayModel extends Model {
    private ArrayList<DataModel> dataModels;
    private String code;

    public ArrayList<DataModel> getDataModels() {
        return dataModels;
    }

    public void setDataModels(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
