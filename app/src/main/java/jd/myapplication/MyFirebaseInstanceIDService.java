package jd.myapplication;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Dishesh on 28-02-2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{
    private static final String TAG ="MyFirebaseInstanceIDService";

    @SuppressLint("LongLogTag")
    @Override
    public void onTokenRefresh() {
//        super.onTokenRefresh();

        String refToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token + "+refToken);


    }
}
