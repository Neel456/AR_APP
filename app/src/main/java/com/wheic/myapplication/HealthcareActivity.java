package com.wheic.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HealthcareActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare);

        b=findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        //com.example.practice_recyclerview_and_db
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.practice_recyclerview_and_db ");
                if (launchIntent != null)
                {
                    startActivity(launchIntent);
                }
                else {
                    Toast.makeText(HealthcareActivity.this, "No such package", Toast.LENGTH_LONG).show();
                }
            }

        });


    }
}
