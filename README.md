# Android Sample

## To launch and utilize a sample with Pushwoosh Android SDK integration, clone or download the repository archive.

<img src="https://github.com/Pushwoosh/pushwoosh-android-sample/blob/main/Screenshots/Android_1.png" alt="Alt text" width="300"> <img src="https://github.com/Pushwoosh/pushwoosh-android-sample/blob/main/Screenshots/Android_2.png" alt="Alt text" width="300">

### 1. Add 'google-services.json' file in android -> app folder.

### 2. Add GoogleServices gradle plugin to your project's build.gradle

```
// you should already have buildscript and dependencies blocks in your project's build.gradle so just put the classpath line there

buildscript {
  dependencies {
  classpath 'com.google.gms:google-services:4.3.3'
  }
}

```

### 3. Apply GoogleServicesPlugin in your app's build.gradle

```
// add these lines to the very end of your build.gradle

apply {
 plugin com.google.gms.googleservices.GoogleServicesPlugin
}

```

### 4. Next, open your project in Android Studio. Go Tools > Firebase > Cloud Messaging and click "Set up Firebase Cloud Messaging".
Connect your app with Firebase, grant Android Studio access to your Google account (if needed), and choose your Firebase project.

### 5. Then add FCM to your application and accept changes

### 6. Add the following metadata to AndroidManifest.xml:

```
<meta-data android:name="com.pushwoosh.appid" android:value="XXXXX-XXXXX" />
<meta-data android:name="com.pushwoosh.senderid" android:value="@string/fcm_sender_id" /> 

```
Where:

```com.pushwoosh.appid``` is your Pushwoosh Application Code

```com.pushwoosh.senderid``` is the Sender ID you received from Firebase Console 


### The guide for SDK integration is available on Pushwoosh [website](https://docs.pushwoosh.com/platform-docs/pushwoosh-sdk/android-push-notifications/firebase-integration/integrate-pushwoosh-android-sdk).

Pushwoosh team
http://www.pushwoosh.com
