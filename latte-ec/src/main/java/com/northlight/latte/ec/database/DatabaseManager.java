package com.northlight.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/22 17:00
 */

public class DatabaseManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mUserProfileDao = null;
    //在这里添加新表的dao

    private DatabaseManager(){}

    private static final class Holder{
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance(){
        return Holder.INSTANCE;
    }

    public DatabaseManager init(Context context){
        initDao(context);
        return this;
    }

    private void initDao(Context context){
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"fest_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mUserProfileDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getUserProfileDao(){
        return mUserProfileDao;
    }

    //新表getdao方法
}
