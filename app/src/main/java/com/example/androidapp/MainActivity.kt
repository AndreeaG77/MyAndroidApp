package com.example.androidapp

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import android.view.View
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {
    var TAG = "andreeag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printHashKey()

        // val username: TextView = findViewById(R.id.username)
        // val password: TextView = findViewById(R.id.password)
        // val loginB: MaterialButton = findViewById(R.id.loginB)

        //loginB.setOnClickListener{
        //   fun onClick(view: View){
        //      if(username.text.toString().equals("admin") && password.text.toString().equals("admin")){
        //          Toast.makeText(this, "LOGIN SUCCESFUL", Toast.LENGTH_SHORT).show()
        //      } else{
        //         Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show()
        //     }
        //  }
        //}
    }
    fun printHashKey() {
        try {
            val info: PackageInfo = this.packageManager.getPackageInfo(this.packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey = String(Base64.encode(md.digest(),0))
                Log.d(TAG, "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.d(TAG, "printHashKey()", e)
        } catch (e: Exception) {
            Log.d(TAG, "printHashKey()", e)
        }
    }
}