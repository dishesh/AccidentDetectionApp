package jd.database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.android.gms.internal.zzedf;
import com.google.android.gms.internal.zzeeq;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.zip.Checksum;

import static android.content.ContentValues.TAG;

/**
 * Created by Dishesh on 28-02-2018.
 */

public class MyDatabaseService extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "Database.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseService(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}