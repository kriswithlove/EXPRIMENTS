package com.example.krisim.domfb2;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by KRISIM on 14-01-2016.
 */
public class MyApplication extends Application {
    @Override
public void onCreate(){
        super.onCreate();
         printHashKey();
    }
    public void printHashKey() {
        try {

            PackageInfo info;
            info = getPackageManager().getPackageInfo("com.example.krisim.domfb2", PackageManager.GET_SIGNATURES);
             /* info = getPackageManager().getPackageInfo(
                    "com.facebook.samples.hellofacebook",
                    PackageManager.GET_SIGNATURES);*/
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
              //  String hashKey = new String(Base64.encode(md.digest(), 0));
               // Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
                Log.d("KeyHash ANIKET:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (NoSuchAlgorithmException e) {
          //  Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
           // Log.e(TAG, "printHashKey()", e);
        }
    }


}

