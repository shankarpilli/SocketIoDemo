package com.sparity.webchat;

import android.app.Application;

import com.sparity.webchat.utility.APIConstants;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class ChatApplication extends Application {

    private Socket mSocket;

    {
        try {
            mSocket = IO.socket(APIConstants.CHAT_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
