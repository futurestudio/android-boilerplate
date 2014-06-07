package com.futurestudio.androidboilerplate.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import com.futurestudio.androidboilerplate.app.dto.User;
import com.google.gson.Gson;


/**
 * singleton with lots of diverse information
 * it handles information for the app control flow (selected item etc), user information and more
 *
 * @author Norman
 */
public class AppSingleton
{
    private static final String APP_USER = "APP_USER_JSON";
    private static AppSingleton instance;

    // save data
    private User user;
    private Bitmap userProfilePicture;

    private AppSingleton()
    {
    }

    public static AppSingleton getInstance()
    {
        if (instance == null)
        {
            instance = new AppSingleton();
        }

        return instance;
    }

    public static void setInstance(AppSingleton instance) {
        AppSingleton.instance = instance;
    }

    public synchronized User getUser(Context context)
    {
        if (user == null && context != null)
        {
            SharedPreferences prefs = context.getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);

            String userAsString = prefs.getString(APP_USER, null);
            user = new Gson().fromJson(userAsString, User.class);
        }

        return user;
    }

    public synchronized void setUser(Context context, User user)
    {
        this.user = user;

        String userAsString = new Gson().toJson(user);
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);
        prefs.edit().putString(APP_USER, userAsString).commit();

        // delete profile picture
        // otherwise, if the user changes the user it could lead to problems
        if (user == null){
            setUserProfilePicture(null);
        }
    }

    public Bitmap getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(Bitmap userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }
}
