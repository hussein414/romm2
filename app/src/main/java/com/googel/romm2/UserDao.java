package com.googel.romm2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

// Dao class enterFace
@Dao
public interface UserDao {
    //adding insert Dao method
    @Insert void RegisterUser( UserEntity userEntity);
    //adding login dao method
    @Query("SELECT * from users where userId=(:userId)and password=(:password)")
    UserEntity login(String userId,String password);

}
