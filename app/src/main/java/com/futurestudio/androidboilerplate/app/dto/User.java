package com.futurestudio.androidboilerplate.app.dto;

/**
 * Created by npeitek on 11/7/13.
 */
public class User
{
    private String email;
    private String password;
    private String auth_token;
    private String auth_token_issued;
    private String picture;

    public User(String email)
    {
        this.email = email;
    }

    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getEmailShort()
    {
        String[] emailParts = email.split("@");
        return emailParts[0];
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAuth_token()
    {
        return auth_token;
    }

    public void setAuth_token(String auth_token)
    {
        this.auth_token = auth_token;
    }

    public String getAuth_token_issued()
    {
        return auth_token_issued;
    }

    public void setAuth_token_issued(String auth_token_issued)
    {
        this.auth_token_issued = auth_token_issued;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
