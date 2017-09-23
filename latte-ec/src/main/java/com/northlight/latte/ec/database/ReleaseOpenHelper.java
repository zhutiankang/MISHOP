package com.northlight.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.northlight.latte.ec.database.DaoMaster.OpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/9/22 16:58
 */

public class ReleaseOpenHelper extends OpenHelper {
    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
