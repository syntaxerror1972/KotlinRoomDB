package com.syntaxerror.kotlinroomdb.ui
/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRoomDB.
 * Package Id : com.syntaxerror.kotlinroomdb
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
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import com.syntaxerror.kotlinroomdb.R
import com.syntaxerror.kotlinroomdb.data.db.UserDB
import com.syntaxerror.kotlinroomdb.data.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database : UserDB
    lateinit var txtUserDetails : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUserDetails = findViewById(R.id.txtUserDetails)
        database = Room.databaseBuilder(applicationContext,UserDB::class.java,"user").build()
    }

    fun loadDBDetails(view : View){
        database.userDAO().getUserList().observe(this, Observer {
            txtUserDetails.text = ""
            var sb = StringBuilder()
            sb.append("")
            it.forEach {
                sb.append("********* User "+it.id.toString()+" Details **********\n")
                sb.append("User Name : "+it.userName.toString()+"\n")
                sb.append("User Email : "+it.email.toString()+"\n")
                sb.append("User Mobile : "+it.mobile.toString()+"\n")
                sb.append("User City : "+it.city.toString()+"\n\n")
            }
            txtUserDetails.text = sb.toString()
        })
    }

    fun addUser(view : View){
        var userObj = User(0,"Shrawan Shinde","syntaxerror1972@gmail.com","9167187772","Kolhapur")
        GlobalScope.launch {
            database.userDAO().addUser(userObj)
        }
    }

}