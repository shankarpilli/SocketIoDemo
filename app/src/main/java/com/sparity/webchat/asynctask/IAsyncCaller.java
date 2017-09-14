package com.sparity.webchat.asynctask;


import com.sparity.webchat.models.Model;

/**
 * Created by Madhu
 */

public interface IAsyncCaller {
    void onComplete(Model model);
}
