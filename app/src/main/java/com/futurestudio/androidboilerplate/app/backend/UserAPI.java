package com.futurestudio.androidboilerplate.app.backend;

import android.content.Context;

import com.futurestudio.androidboilerplate.app.dto.User;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class UserAPI extends ApiClient {

    public static void postUserSignup(Context context, User user, AsyncHttpResponseHandler responseHandler) {
        HttpEntity entity = getHttpEntity(user);

        client.post(context, getAbsoluteUrl("/user/signup"), entity, CONTENT_TYPE_JSON, responseHandler);
    }

    public static void postUserLogin(Context context, User user, AsyncHttpResponseHandler responseHandler) {
        HttpEntity entity = getHttpEntity(user);

        client.post(context, getAbsoluteUrl("/user/login"), entity, CONTENT_TYPE_JSON, responseHandler);
    }

    public static void getUserInfo(Context context, AsyncHttpResponseHandler responseHandler) {
        Header[] headers = addAuthenticationTokenToHeader(context);

        client.get(context, getAbsoluteUrl("/user/info"), headers, null, responseHandler);
    }

    public static void getUserRecipes(Context context, AsyncHttpResponseHandler responseHandler) {
        Header[] headers = addAuthenticationTokenToHeader(context);

        client.get(context, getAbsoluteUrl("/user/recipes"), headers, null, responseHandler);
    }
}
