package com.asu.asucourses.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.asu.asucourses.R;
import com.asu.asucourses.application.User;

public class MainActivity extends AppCompatActivity {
    Button all, buildingEngineering, communicationSystemsEngineering, computerEngineering, energyEngineering, environmentalArchitecture,
            humanities, landscapeArchitecture, manufacturingEngineering, materialsEngineering, mechatronicsEngineering;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setButtonListeners();
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

    private void setButtonListeners(){
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        MenuItem myCoursesMenuItem = findViewById(R.id.my_courses_item_menu);
        // Todo: Uncomment this for now
//        if(User.isLogged){
//            myCoursesMenuItem.setVisible(true);
//        }else{
//            myCoursesMenuItem.setVisible(false);
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.login_item_menu:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.my_courses_item_menu:
                intent = new Intent(this, CoursesListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
