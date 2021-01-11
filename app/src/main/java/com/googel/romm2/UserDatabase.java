package com.googel.romm2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// database class
@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String dbName = "user";
    private static UserDatabase userDatabase;
    //get database instance
    public static synchronized UserDatabase getInstance( Context context ) {

        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }
    // trim abstract to userDao
    public  abstract UserDao userDao();
}
