package com.example.group46;

//Class to hold the Youtube API Key
public class YoutubeAPIHolder {

    public YoutubeAPIHolder() { }

    //Storing the API Key
    private static final String API_KEY = "AIzaSyBzFudfauzUdFenBk7ArZ1CJ0wzh3XPNiA";

    //Returning the API Key
    public static String getApiKey(){
        return API_KEY;
    }
}
