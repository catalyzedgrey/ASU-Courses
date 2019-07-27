package com.asu.asucourses.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.asu.asucourses.R;
import com.asu.asucourses.adapters.ExpandableAdapter;
import com.asu.asucourses.adapters.TrackAdapter;
import com.asu.asucourses.interfaces.IService;
import com.asu.asucourses.models.Course;
import com.asu.asucourses.models.Instructor;
import com.asu.asucourses.models.Track;
import com.asu.asucourses.services.TrackService;
import com.asu.asucourses.utils.Constants;

import java.util.ArrayList;
import java.util.List;

//import com.asu.asucourses.interfaces.OnItemClickListener;

public class MainActivity extends AppCompatActivity implements IService {
    private RecyclerView recyclerView;
    private TrackAdapter trackAdapter;
    private ExpandableAdapter adapter;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Track> tracks = new ArrayList<>();


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
        Course c = new Course("1", "Physics", "M", (float) 2.0, "5",
                new Instructor("1", "Jhon", "k", "as", "asas"));
        courses.add(c);
        courses.add(c);
        Track t = new Track("1", "Computer", courses);
        tracks.add(t);
    }

    private void init() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.RecyclerViewMainActivity);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ExpandableAdapter(this, tracks);
        recyclerView.setAdapter(adapter);
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
        adapter.refreshParent();
        adapter.refreshChild();
    }
}
