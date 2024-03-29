package com.kingsms.archivesms.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.kingsms.archivesms.model.login.LoginResponse;

import java.util.Locale;



public class Utilities {


    public static  SharedPreferences sharedPreferences;
    public static  String SharedPreferencesName="user_info";
    public static  String SharedPreferences_token_key="token";


    public static void saveUserInfo(Context context , LoginResponse loginResponse)
    {
        sharedPreferences = context.getSharedPreferences(SharedPreferencesName, 0);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(loginResponse);
        editor.putString(SharedPreferences_token_key , json);
        editor.commit();

    }
    public static void clearUserInfo(Context context )
    {
        sharedPreferences = context.getSharedPreferences(SharedPreferencesName, 0);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.clear();
        editor.commit();

    }


    public static LoginResponse retrieveUserInfo(Context context)
    {
        sharedPreferences = context.getSharedPreferences(SharedPreferencesName, 0);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SharedPreferences_token_key,null);
        LoginResponse obj = gson.fromJson(json , LoginResponse.class);

        return obj;
    }


    //   return internet status
    public static boolean checkConnection(Context mContext)
    {
            if (ConnectivityReceiver.isConnected()) {
               return  true;
            } else {
                return false;
            }

    }



    public static String getLanguage()
    {
        return Locale.getDefault().getLanguage();
    }





}
