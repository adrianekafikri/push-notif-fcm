package com.lab.electrif.pushnotiffcm

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import java.io.FileInputStream
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RefreshToken().execute()
    }

    inner class RefreshToken : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg params: Void?): String? {
            val googleCredential = GoogleCredential
                    .fromStream(assets.open("json/push-notif-bbf69-firebase-adminsdk-80goe-1904ce915d.json"))
                    .createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase", "https://www.googleapis.com/auth/cloud-platform", "https://www.googleapis.com/auth/firebase.readonly"))
            googleCredential.refreshToken()
            return googleCredential.accessToken
        }

        override fun onPostExecute(result: String?) {
            Log.d("adri", "OAuth Token : $result")
        }
    }
}
