package com.pushwoosh.demoapp;

import android.os.Handler;
import android.util.Log;

import androidx.annotation.MainThread;

import com.pushwoosh.notification.NotificationServiceExtension;
import com.pushwoosh.notification.PushMessage;

public class NotificationServiceExtensionDemo extends NotificationServiceExtension  {

    private static final String TAG = "NotificationServiceExtensionDemo";

    @Override
    public boolean onMessageReceived(final PushMessage message) {
        super.onMessageReceived(message);
        Log.d(TAG, "PushMessage received: " + message.toJson().toString());

            if (isAppOnForeground() && getApplicationContext() != null) {
                Handler mainHandler = new Handler(getApplicationContext().getMainLooper());
                mainHandler.post(() -> handlePush(message));
                return true;
            }

        return false;
    }

    @Override
    protected void startActivityForPushMessage(PushMessage message) {
        super.startActivityForPushMessage(message);
        handlePush(message);
    }

    @MainThread
    private void handlePush(PushMessage message) {
        Log.d(TAG,"PushMessage accepted: " + message.toJson().toString());
    }
}
