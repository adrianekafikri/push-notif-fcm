package com.lab.electrif.pushnotiffcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by Adrian Eka Fikri on 6/4/2018.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    val TAG = "adri"

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG, "From: " + remoteMessage?.from);

        if (remoteMessage?.data?.size ?: 0 > 0){
            Log.d(TAG, "Message data payload: " + remoteMessage?.data);

        }

        if (remoteMessage?.notification != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.notification?.getBody());
        }
    }
}