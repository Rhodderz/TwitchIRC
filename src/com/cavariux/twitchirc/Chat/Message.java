package com.cavariux.twitchirc.Chat;

import com.cavariux.twitchirc.Core.TwitchBot;
import com.cavariux.twitchirc.Util.InfoChatObject;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Message Object [For all messages PRV, GLOBAL etc]
 * @author Rhodri Metcalfe-Davies
 * @version 1.0-Beta
 */

public class Message {
    //Cant work out what to call these at present
    //[ 0  :           1         :    2   }
    //[INFO: USER COMMAND CHANNEL: MESSAGE]
    private ArrayList<String> messageObjects;
    private ArrayList<InfoChatObject> infoObjects;
    //[ 0      1       2   ]
    //[USER COMMAND CHANNEL]
    private ArrayList<String>ircInfo;

    private String user;
    private String rawCommand;
    private String channelName;
    private Channel channel;
    private String message;

    public Message(String raw, TwitchBot bot){
        messageObjects = new ArrayList<>();
        infoObjects = new ArrayList<>();
        ircInfo = new ArrayList<>();

        messageObjects.addAll(Arrays.asList(raw.split(":")));

        for(String obj : messageObjects.get(0).split(";")){
            infoObjects.add(new InfoChatObject(obj));
        }

        ircInfo.addAll(Arrays.asList(messageObjects.get(1).split(" ")));

        user = ircInfo.get(0);
        rawCommand = ircInfo.get(1);
        channelName = ircInfo.get(2);
        channel = Channel.getChannel(channelName, bot);

        message = messageObjects.get(2);
    }

    public ArrayList<InfoChatObject> getInfoObjects() {
        return infoObjects;
    }

    public ArrayList<String> getMessageObjects() {
        return messageObjects;
    }

    public ArrayList<String> getIrcInfo() {
        return ircInfo;
    }

    public String getUserName() {
        return user;
    }

    public User getUser(){
        return User.getUser(user);
    }

    public String getRawCommand() {
        return rawCommand;
    }

    public String getChannelName() {
        return channelName;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getMessage() {
        return message;
    }

    public String getBadge() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("badges"))
                return ico.getValue();
        throw new NullPointerException("Badge not found");
    }

    public String getUserColour() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("color"))
                return ico.getValue();
        throw new NullPointerException("Color not found");
    }

    public String getDisplayName() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("display-name"))
                return ico.getValue();
        throw new NullPointerException("Display name not found");
    }

    public String getEmotes() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("emotes"))
                return ico.getValue();
        throw new NullPointerException("Emotes not found");
    }

    public String getMSGID() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("id"))
                return ico.getValue();
        throw new NullPointerException("ID not found");
    }

    public boolean isMod() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("mod"))
                return Boolean.valueOf(ico.getValue());
        throw new NullPointerException("Mod tag not found");
    }

    public String getRoomID() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("room-id"))
                return ico.getValue();
        throw new NullPointerException("Room id not found");
    }

    public String getRawTimeStamp() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("sent-ts"))
                return ico.getValue();
        throw new NullPointerException("Timestamp not found");
    }

    public Date getTimeStamp() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("sent-ts"))
                return new Date(Long.parseLong(ico.getValue())*1000); //Java expects ms so times 1000
        throw new NullPointerException("Timestamp not found");
    }

    public Boolean isSubscriber() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("subscriber"))
                return Boolean.valueOf(ico.getValue());
        throw new NullPointerException("Subscriber flag not found");
    }

    public String getRawTMITimeStamp() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("tmi-sent-ts"))
                return ico.getValue();
        throw new NullPointerException("Timestamp not found");
    }

    public Date getTMITimeStamp() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("tmi-sent-ts"))
                return new Date(Long.parseLong(ico.getValue())*1000); //Java expects ms so times 1000
        throw new NullPointerException("Timestamp not found");
    }

    public Boolean isTurbo() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("turbo"))
                return Boolean.valueOf(ico.getValue());
        throw new NullPointerException("Turbo flag not found");
    }

    public String getUserID() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("user-id"))
                return ico.getValue();
        throw new NullPointerException("User ID flag not found");
    }

    public String getUserType() throws NullPointerException{
        for(InfoChatObject ico : infoObjects)
            if(ico.getItem().equalsIgnoreCase("user-type"))
                return ico.getValue();
        throw new NullPointerException("User Type flag not found");
    }
}
