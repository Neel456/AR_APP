package com.wheic.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import com.wheic.myapplication.adapters.Data;
import com.wheic.myapplication.adapters.ModelAdapter;
import com.wheic.myapplication.adapters.model;

import java.util.ArrayList;

public class show_models extends AppCompatActivity  implements ModelAdapter.onClickListener {

    ArrayList<model> educationData= Data.getEducationData();
    ArrayList<model> healthData= Data.getHealthcareData();
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_models);


        try {

            rv = findViewById(R.id.list1);
            rv.setHasFixedSize(false);
            manager = new LinearLayoutManager(show_models.this, LinearLayoutManager.VERTICAL, false);
            rv.setLayoutManager(manager);

            adapter=new ModelAdapter(show_models.this,educationData,healthData);
            rv.setAdapter(adapter);

        }
        catch (Exception e)
        {
            Log.d("Error",""+e);
        }

    }

    @Override
    public void onItemClicked(int i) {

//        Toast.makeText(this,  "Name:"+" "+data.get(i).getName()+'\n'
//                        +"Details:"+" "+data.get(i).getDetails()+'\n',
//                Toast.LENGTH_LONG).show();


    }
}
