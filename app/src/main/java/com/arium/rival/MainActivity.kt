package com.arium.rival

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.googlesignin.GoogleSignIn
import com.example.googlesignin.listener.ISignInResult
import com.example.googlesignin.models.SignInResult

class MainActivity : AppCompatActivity(), ISignInResult {


    var googleSignIn: GoogleSignIn? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // define this variable in your localProperties
        val googleClientId = BuildConfig.googleApiClientID

        googleSignIn = GoogleSignIn(this, googleClientId, this)
        googleSignIn?.init()
        googleSignIn?.signIn()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        googleSignIn?.onActivityResult(requestCode, data)
    }

    override fun onGetTheSignInResult(signInResult: SignInResult?) {
        Toast.makeText(this, signInResult?.displayName, Toast.LENGTH_LONG).show()
    }

    override fun onGotAnException(exception: Exception) {
        Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
    }

    override fun onTheCanceledExceptionHappened() {
        Toast.makeText(this, "onTheCanceledExceptionHappened", Toast.LENGTH_LONG).show()
    }

    override fun onNothingHappened() {
        Toast.makeText(this, "Nothing happened", Toast.LENGTH_LONG).show()
    }


}