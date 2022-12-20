package com.example.loginroomdatabase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loginroomdatabase.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel

    lateinit var context: Context

    lateinit var strUsername: String
    lateinit var strPassword: String
    lateinit var button: Button
    lateinit var button1: Button
    lateinit var textView: TextView
    lateinit var textView1: TextView
    lateinit var textview2:TextView
    lateinit var textview3:TextView
    lateinit var textview4:TextView
    lateinit var textView5: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.btnAddLogin)
        button1=findViewById(R.id.btnReadLogin)
        textView=findViewById(R.id.txtUsername)
        textView1=findViewById(R.id.txtPassword)
        textview2=findViewById(R.id.lblInsertResponse)
        textview3=findViewById(R.id.lblReadResponse)
        textview4=findViewById(R.id.lblUseraname)
        textView5=findViewById(R.id.lblPassword)

        context = this@MainActivity

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        button.setOnClickListener {

            strUsername = textView.text.toString().trim()
            strPassword = textView1.text.toString().trim()

            if (strPassword.isEmpty()) {
                textView.error = "Please enter the username"
            }
            else if (strPassword.isEmpty()) {
                textView1.error = "Please enter the username"
            }
            else {
                loginViewModel.insertData(context, strUsername, strPassword)
                textview2.text = "Inserted Successfully"
            }
        }

        button1.setOnClickListener {

            strUsername = textView.text.toString().trim()

            loginViewModel.getLoginDetails(context, strUsername)!!.observe(this, Observer {

                if (it == null) {
                    textview3.text = "Data Not Found"
                    textview4.text = "- - -"
                    textView5.text = "- - -"
                }
                else {
                    textview4.text = it.Username
                    textView5.text = it.Password

                    textview3.text = "Data Found Successfully"
                }
            })
        }
    }
}