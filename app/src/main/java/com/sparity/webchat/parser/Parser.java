package com.sparity.webchat.parser;


import com.sparity.webchat.models.Model;

/**
 * Created by Shankar Rao on 3/28/2016.
 */
public interface Parser<T extends Model> {

    T parse(String s);
}