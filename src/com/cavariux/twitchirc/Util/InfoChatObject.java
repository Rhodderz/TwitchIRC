package com.cavariux.twitchirc.Util;

import com.cavariux.twitchirc.Core.TwitchBot;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InfoChatObject {
    private Logger LOGGER;
    private String Item;
    private String Value;

    public InfoChatObject(String obj) throws IndexOutOfBoundsException {
        LOGGER = Logger.getLogger(TwitchBot.class.getName());

        //Split at =
        Item = obj.split("=")[0];
        //Some values like "emotes" might not have a value set
        try {
            if (obj.split("=").length < 1){
                Value = obj.split("=")[1];
            } else {
                Value = " ";
            }
        }catch (ArrayIndexOutOfBoundsException aioob){
            LOGGER.log(Level.SEVERE, "PAIN: " + Item);
            LOGGER.log(Level.SEVERE, "PAIN Number: " + obj.split("=").length);
        }
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
