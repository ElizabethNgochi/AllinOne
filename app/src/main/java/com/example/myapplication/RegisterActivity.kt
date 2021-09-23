package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    var firstName : EditText? = null
    var secondName : EditText? = null
    var userEmail : EditText? = null
    var userPassword : EditText? = null
    var registerButton : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firstName =findViewById(R.id.mFirstName)
        secondName =findViewById(R.id.mSecondName)
        userEmail =findViewById(R.id.mEmail)
        userPassword =findViewById(R.id.mPassword)
        registerButton =findViewById(R.id.mRegister)

        registerButton!!.setOnClickListener {
            var nameFirst = firstName!!.text.toString().trim()
            var nameSecond = secondName!!.text.toString().trim()
            var email = userEmail!!.text.toString().trim()
            var password = userPassword!!.text.toString().trim()
            if (nameFirst.isEmpty()){
                firstName!!.setError("Please fill this input")
                firstName!!.requestFocus()
            }else if (nameSecond.isEmpty()) {
                secondName!!.setError("Please fill this input")
                secondName!!.requestFocus()
            }else if (email.isEmpty()){
                userEmail!!.setError("Please fill this input")
                userEmail!!.requestFocus()
            }else if (password.isEmpty()){
                userPassword!!.setError("Please fill this input")
                userPassword!!.requestFocus()
            }else{
                //Proceed to save data
                var time = System.currentTimeMillis().toString()
                var userData = User(nameFirst,nameSecond, email, password, time)
                var databaseRef = FirebaseDatabase.getInstance().
                getReference().child("Users/$time")
                //Finally store data
                databaseRef.setValue(userData).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"User saved successfully",
                            Toast.LENGTH_SHORT).show()

                        var intent = Intent(this, TabbedActivity::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this, "Saving failed",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}