package com.hfad.workout;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity
    implements WorkoutListFragment.WorkoutListListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override // From the WLL interface
    public void itemClicked(long id) {
   View fragmentContainer = findViewById(R.id.fragment_container);
        if ( fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setWorkout(id); // So we made a new fragment and set its workout
            ft.replace(R.id.fragment_container, details); // We're replacing the fragment in the container
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id);
            startActivity(intent);
        }
    }
}