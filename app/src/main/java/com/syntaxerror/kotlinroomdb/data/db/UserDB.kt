package com.syntaxerror.kotlinroomdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.syntaxerror.kotlinroomdb.data.dao.UserDAO
import com.syntaxerror.kotlinroomdb.data.model.User

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB.
 * Package Id : com.syntaxerror.kotlinroomdb.data.db
 * Created By :  Shrawan Shinde
 * Created Date :  26,September,2022
 *
 *** Contact Details ***
 *
 * Name : Shrawan B. Shinde
 * Email : syntaxerror1972@gmail.com
 * Github Link : https://github.com/syntaxerror1972/KotlinRoomDB
 * LinkedIn Link : https://in.linkedin.com/in/shrawan-shinde-59ba57a1
 * Copyright (c) 2022. All rights reserved.
 *
 **************************************************************************************
 */

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDAO() : UserDAO
}