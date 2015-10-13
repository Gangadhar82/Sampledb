package com.mmadapps.sampledb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3;
    Button save,show;
    Helper helper;
    ArrayList<bean> beanArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText3);
        save= (Button) findViewById(R.id.button);
        show= (Button) findViewById(R.id.button2);
         helper=new Helper(this);
        createDatabase();


        adddata();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });



    }

   /* private void getdata() {

        try {
            helper.openDataBase();
            beanArrayList2=helper.getmobileinfo();
            helper.close();
            Toast.makeText(MainActivity.this,
                    ""+beanArrayList2.get(0).getId()+beanArrayList.get(0).getName()+beanArrayList.get(0).getPhnum(),Toast.LENGTH_SHORT).show();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

    public void adddata()
    {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean bean1 = new bean();
                bean1.setId(editText1.getText().toString());
                bean1.setName(editText2.getText().toString());
                bean1.setPhnum(editText3.getText().toString());
                beanArrayList.add(bean1);

                boolean isInserted = helper.insertvalData(beanArrayList);
                if (isInserted = true) {
                    Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_LONG).show();
                   // getdata();


                } else {
                    Toast.makeText(MainActivity.this, "not inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void createDatabase() {
        try {
            helper = new Helper(getApplicationContext());
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
