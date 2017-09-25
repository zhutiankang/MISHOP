package com.northlight.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.northlight.latte.app.AccoutManager;
import com.northlight.latte.ec.database.DatabaseManager;
import com.northlight.latte.ec.database.UserProfile;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/23 14:22
 */

public class SignHandler {

    public static void onSignUp(String response,ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getUserProfileDao().insert(profile);

        //已经注册并登录成功
        AccoutManager.setSignState(true);
        signListener.onSignUpSuccess();
    }
    public static void onSignIn(String response,ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getUserProfileDao().insert(profile);

        //已经注册并登录成功
        AccoutManager.setSignState(true);
        signListener.onSignInSuccess();
    }
}
