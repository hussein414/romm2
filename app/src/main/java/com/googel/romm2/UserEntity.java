package com.googel.romm2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
//Entity class
@Entity(tableName = "users")
public class UserEntity {
    //true key to id
    @PrimaryKey(autoGenerate = true)
    Integer id;
    //info userId
    @ColumnInfo(name = "userId")
    String userId;
    //info password
    @ColumnInfo(name = "password")
    String password;
    //info name
    @ColumnInfo(name = "name")
    String name;

    // get and set
    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
