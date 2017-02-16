package es.dpinfo.cuadernoclase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import es.dpinfo.cuadernoclase.fragments.StudentsListFragment;

/**
 * Created by dprimenko on 16/02/17.
 */
public class MainActivity extends AppCompatActivity {

    private StudentsListFragment studentsListFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsListFragment = StudentsListFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, studentsListFragment).commit();
    }
}
