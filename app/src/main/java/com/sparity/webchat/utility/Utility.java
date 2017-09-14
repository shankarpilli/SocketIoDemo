package com.sparity.webchat.utility;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Shankar on 9/14/2017.
 */

public class Utility {


    /**
     * This method is used to get the typeface for the material icons
     */
    public static Typeface setTypeFace_Image(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "matireal_icons_regular.ttf");
    }
}
