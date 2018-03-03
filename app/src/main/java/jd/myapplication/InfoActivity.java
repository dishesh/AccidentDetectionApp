package jd.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        VehicleDTO othis;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button btn_back;
        TextView oname,contact,location,Reg_Num;
        Reg_Num = (TextView)findViewById(R.id.reg_num_lbl);
        oname = (TextView)findViewById(R.id.Oname);
        contact = (TextView)findViewById(R.id.Cnum);
        location = (TextView)findViewById(R.id.Location);
        btn_back = (Button)findViewById(R.id.btn_back);


        if(getIntent().getExtras() !=null){
            othis = (VehicleDTO)getIntent().getExtras().get("Object");
            Reg_Num.setText(othis.getRegistration());
            oname.setText(othis.owner);
            contact.setText(othis.getContact());
            location.setText(othis.getLocation());
        }


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),MainActivity.class);
                Toast.makeText(InfoActivity.this,"BACK",Toast.LENGTH_SHORT).show();
                startActivity(i);
      //          String token = FirebaseInstanceId.getInstance().getToken();

            }
        });



    }
}
