package com.sparity.webchat.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Shankar on 9/15/2017.
 */

public class ListArrayModel extends Model implements Serializable{
    private ArrayList<ListModel> listModels;
    private String code;

    public ArrayList<ListModel> getListModels() {
        return listModels;
    }

    public void setListModels(ArrayList<ListModel> listModels) {
        this.listModels = listModels;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
