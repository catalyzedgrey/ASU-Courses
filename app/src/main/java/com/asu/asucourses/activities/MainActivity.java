package com.asu.asucourses.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asu.asucourses.R;

public class MainActivity extends AppCompatActivity {
    Button all, buildingEngineering, communicationSystemsEngineering, computerEngineering, energyEngineering, environmentalArchitecture,
            humanities, landscapeArchitecture, manufacturingEngineering, materialsEngineering, mechatronicsEngineering;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        buildingEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        communicationSystemsEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        computerEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        energyEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        environmentalArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        humanities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        landscapeArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        manufacturingEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        materialsEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
        mechatronicsEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CoursesListActivity.class);
                startActivity(i);
                /*when courses list activity is done we will add the put extra here*/
            }
        });
    }

    private void init() {
        all = findViewById(R.id.allBtn);
        buildingEngineering = findViewById(R.id.buildingEngineeringBtn);
        communicationSystemsEngineering = findViewById(R.id.communicationSystemsEngineeringBtn);
        computerEngineering = findViewById(R.id.computerEngineeringBtn);
        energyEngineering = findViewById(R.id.energyEngineeringBtn);
        environmentalArchitecture = findViewById(R.id.environmentalArchitectureBtn);
        humanities = findViewById(R.id.humanitiesBtn);
        landscapeArchitecture = findViewById(R.id.landscapeArchitectureBtn);
        manufacturingEngineering = findViewById(R.id.manufacturingEngineeringBtn);
        materialsEngineering = findViewById(R.id.materialsEngineeringBtn);
        mechatronicsEngineering = findViewById(R.id.mechatronicsEngineeringBtn);
    }
}
