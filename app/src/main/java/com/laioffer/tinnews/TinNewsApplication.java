package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.laioffer.tinnews.database.TinNewsDatabase;

public class TinNewsApplication extends Application {

    private static TinNewsDatabase database;
    //create a database and add an accessor
    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(this, TinNewsDatabase.class, "tinnews_db").build();
        //每次call database拿到的是老的instance
        //不能在main activity里面创建，this产生了问题
        //static class全局，无法回收
        //database lifecycle > activity
        //memory leak main activity，本该被回收但是回收不掉因为正在被database使用
        //reference counter
    }

    public static TinNewsDatabase getDatabase() {
        return database;
    }
}
