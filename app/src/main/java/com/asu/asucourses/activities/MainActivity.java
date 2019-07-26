package com.asu.asucourses.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.asu.asucourses.R;
import com.asu.asucourses.adapters.TrackAdapter;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.interfaces.IService;
//import com.asu.asucourses.interfaces.OnItemClickListener;
import com.asu.asucourses.models.Track;
import com.asu.asucourses.services.TrackService;
import com.asu.asucourses.utils.Constants;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IService {
    private RecyclerView recyclerView;
    private TrackAdapter trackAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareData();
        init();
        //Todo: add on-click Listeners for items

    }

    private void prepareData() {
        new TrackService(this).execute(Constants.trackUrl);
    }

    private void init() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView = findViewById(R.id.RecyclerViewMainActivity);
        recyclerView.setLayoutManager(mLayoutManager);
        trackAdapter = new TrackAdapter();
//        trackAdapter = new TrackAdapter(new OnItemClickListener() {
//            @Override
//            public void onTrackClick(Track item) {
//
//
//            }
//            @Override
//            public void onCourseClick(Course item) {
//                Toast.makeText(MainActivity.this, "anything", Toast.LENGTH_LONG).show();
//                //Todo uncomment when CourseDetailsActivity is up and running
////                Intent i = new Intent(CoursesListActivity.class, CourseDetails.class);//open course details
////                startActivity(i);
//            }
//        });
        recyclerView.setAdapter(trackAdapter);
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
        switch (item.getItemId()) {
            case R.id.login_item_menu:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.my_courses_item_menu:
//                intent = new Intent(this, CoursesListActivity.class);
//                startActivity(intent);
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTaskCompleted(List objects) {
        trackAdapter.refreshTrackAdapter(objects);
    }
}
