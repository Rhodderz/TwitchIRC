package com.cavariux.twitchirc.Util;

public class ChatObject {
    private String Item;
    private String Value;

    public ChatObject(String obj){
        //Split at =
        Item = obj.split("=")[0];
        Value = obj.split("=")[1];
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
