package com.arium.rival

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.googlesignin.GoogleSignIn
import com.example.googlesignin.listener.IGetIDToken

class MainActivity : AppCompatActivity(), IGetIDToken {


    var googleSignIn: GoogleSignIn? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val googleClientId = ""
        googleSignIn = GoogleSignIn(this, googleClientId, this)
        googleSignIn?.signIn()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        googleSignIn?.onActivityResult(requestCode, data)
    }

    override fun onGetIdToken(idToken: String) {
        Toast.makeText(this, idToken, Toast.LENGTH_LONG).show()
    }

    override fun onGotAnException(exception: Exception) {
        Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
    }
}