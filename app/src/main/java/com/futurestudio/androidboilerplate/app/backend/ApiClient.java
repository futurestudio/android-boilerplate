package com.futurestudio.androidboilerplate.app.backend;

import android.content.Context;

import com.futurestudio.androidboilerplate.app.AppSingleton;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;

public class ApiClient
{
    public static AsyncHttpClient client = new AsyncHttpClient();
    public static final String CONTENT_TYPE_JSON = "application/json";

    public static String getApiLocation()
    {
        // todo set deployment URL
        return "https://your-url.com";
    }

    public static String getAbsoluteUrl(String relativeUrl) {
        return ApiClient.getApiLocation() + relativeUrl;
    }

    public static HttpEntity getHttpEntity(Object object)
    {
        Gson gson = new Gson();
        HttpEntity entity = null;

        try
        {
            entity = new StringEntity(gson.toJson(object), "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return entity;
    }

    public static Header[] addAuthenticationTokenToHeader(Context context)
    {
        return new Header[]{
                new BasicHeader("auth_token", AppSingleton.getInstance().getUser(context).getAuth_token())
        };
    }
}
