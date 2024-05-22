package com.laioffer.tinnews.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.laioffer.tinnews.model.Article;

@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class TinNewsDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
    //class and method are abstract, we do not need to implement it, the room
    //annotation processor will implement it for us
    //version specifies the current version
    //we dont need to dump a database schema to file system, exportSchema = false
    //entity specifies what database contains
}
