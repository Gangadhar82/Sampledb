package com.mmadapps.sampledb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView listviewl;
    ArrayList<bean> beanArrayList2=new ArrayList<>();
    Helper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listviewl= (ListView) findViewById(R.id.listView);
        listviewl.setAdapter(new CustomAdapter());

        try {
            helper=new Helper(this);
            helper.openDataBase();
            beanArrayList2=helper.getmobileinfo();
            helper.close();
//            Toast.makeText(MainActivity.this,
//                    ""+beanArrayList2.get(0).getId()+beanArrayList.get(0).getName()+beanArrayList.get(0).getPhnum(),Toast.LENGTH_SHORT).show();


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public class CustomAdapter extends BaseAdapter {

        private LayoutInflater inflater=null;

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return beanArrayList2.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return beanArrayList2.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public class Holder
        {
            TextView tv1,tv2,tv3;

        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            inflater= (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            Holder holder=new Holder();
            View rowView;
            rowView = inflater.inflate(R.layout.rowitem, parent,false);
            holder.tv1=(TextView) rowView.findViewById(R.id.textView1);
            holder.tv2=(TextView) rowView.findViewById(R.id.textView2);
            holder.tv3=(TextView) rowView.findViewById(R.id.textView3);
            holder.tv1.setText(beanArrayList2.get(position).getId());
            holder.tv2.setText(beanArrayList2.get(position).getName());
            holder.tv3.setText(beanArrayList2.get(position).getPhnum());

            return rowView;
        }

}}
