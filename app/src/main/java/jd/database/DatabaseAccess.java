package jd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jd.myapplication.VehicleDTO;

public class DatabaseAccess extends SQLiteOpenHelper{
VehicleDTO obj ;
List<VehicleDTO> dbList =  new ArrayList<>();
// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Database";

    // Contacts table name
    private static final String TABLE_VEHICLE = "VehicleData";

    // Contacts Table Columns names
    private static final String REG_NO = "Reg_Num";
    private static final String OWNER = "Owner";
    private static final String CONTACT = "Contact";
    private static final String LOCATION = "Location";

    public DatabaseAccess(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


//    public List<VehicleDTO> getALLData(){
//        Cursor cursor = this.getReadableDatabase().rawQuery("select * from " + TABLE_VEHICLE + "", null);
//            if (cursor.moveToFirst()) {
//                while (!cursor.isAfterLast()) {
//                    VehicleDTO dto = new VehicleDTO(cursor.getColumnName(0), cursor.getColumnName(1),
//                            cursor.getColumnName(2), cursor.getColumnName(3));
//                    dbList.add(dto);
//                    cursor.moveToNext();
//                }
//                return dbList;
//            } else {
//                final boolean add = dbList.add(new VehicleDTO());
//                return dbList;
//            }
//
//    }
//    public void addVehicle(VehicleDTO vehicleSetOBJ) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(REG_NO, vehicleSetOBJ.getRegistration());
//        values.put(OWNER, vehicleSetOBJ.getOwner());
//        values.put(CONTACT, vehicleSetOBJ.getContact());
//        values.put(LOCATION, vehicleSetOBJ.getLocation());
//
//        // Inserting Row
//        db.insert(TABLE_VEHICLE, null, values);
//        db.close(); // Closing database connection
//    }


//    public VehicleDTO getVehicle(int regNum) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_VEHICLE, new String[] { REG_NO,
//                        OWNER,CONTACT,LOCATION }, REG_NO + "=?",
//                new String[] { String.valueOf(regNum) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        VehicleDTO vehicleGetOBJ = new VehicleDTO((cursor.getString(0)),
//                cursor.getString(1), cursor.getString(2),cursor.getString(3));
//        // return contact
//        return vehicleGetOBJ;
//    }
    // Creating Tables

    //    public void onCreate(SQLiteDatabase db) {
//        obj = new VehicleDTO();
//        String CREATE_TABLE_VEHICLE = "CREATE TABLE " + TABLE_VEHICLE + "("
//                + REG_NO + " STRING PRIMARY KEY," + OWNER + " TEXT,"
//                + CONTACT + " TEXT," + LOCATION + " TEXT )";
//        db.execSQL(CREATE_TABLE_VEHICLE);
//    }

    // Upgrading database
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VEHICLE);
//
//        // Create tables again
//        onCreate(db);
//    }

}