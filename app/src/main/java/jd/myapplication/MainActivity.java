package jd.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jd.database.DatabaseAccess;
import jd.database.MyDatabaseService;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    String tmp,oname,contact,loc;String registration;
    ListView list;
//    List<String> web = new ArrayList<String>();
    List<String> web = new ArrayList<>();

//    MyDatabaseService dbs;
    TextView textView;
    VehicleDTO othis,objDB;


//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        othis = new VehicleDTO();
        web.add(othis.getRegistration());
        CustomList adapter = new
                CustomList(MainActivity.this, web);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                final Intent intent = new Intent(getBaseContext() , InfoActivity.class);
                intent.putExtra("Obj",web.get(0));
                Toast.makeText(MainActivity.this, "You Clicked at " + web.get(+position), Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        Button b = (Button)findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG,"Token : "+token);

                Toast.makeText(MainActivity.this,token,Toast.LENGTH_LONG).show();
            }
        });
    }
}
