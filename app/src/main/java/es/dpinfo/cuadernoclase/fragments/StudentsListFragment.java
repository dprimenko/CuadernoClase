package es.dpinfo.cuadernoclase.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import es.dpinfo.cuadernoclase.R;
import es.dpinfo.cuadernoclase.adapters.StudentsAdapter;
import es.dpinfo.cuadernoclase.models.Student;
import es.dpinfo.cuadernoclase.repository.ApiDao;

/**
 * Created by dprimenko on 16/02/17.
 */
public class StudentsListFragment extends Fragment implements ApiDao.AllStudentsRequestListener {

    private ListView lwStudents;
    private LinearLayout llStudentsList;
    private StudentsAdapter adapter;


    public static final StudentsListFragment newInstance() {
        return new StudentsListFragment();
    }

    public StudentsListFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_students_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        llStudentsList = (LinearLayout) view.findViewById(R.id.ll_students_list);
        lwStudents = (ListView) view.findViewById(R.id.lw_students);
        adapter = new StudentsAdapter(getActivity(), R.layout.item_student);
        lwStudents.setAdapter(adapter);

        ApiDao.getInstance().requestAllStudents(this);
    }

    @Override
    public void onSuccessAllStudentsRequest(JSONObject response) {
        List<Student> students = new ArrayList<>();
        JSONArray jsonStudents = null;

        try {
            jsonStudents = response.getJSONArray("alumnos");

            for (int i = 0; i < jsonStudents.length(); i++) {
                JSONObject jsonStudent = jsonStudents.getJSONObject(i);
                Student student = new Student();

                student.setmId(jsonStudent.getInt("id"));
                student.setmNombre(jsonStudent.getString("nombre"));
                student.setmApellidos(jsonStudent.getString("apellidos"));
                student.setmDireccion(jsonStudent.getString("direccion"));
                student.setmCiudad(jsonStudent.getString("ciudad"));
                student.setmCp(jsonStudent.getString("cp"));
                student.setmTelefono(jsonStudent.getString("telefono"));
                student.setmEmail(jsonStudent.getString("email"));

                students.add(student);
            }

            adapter.addStudents(students);

        } catch (JSONException e) {
            e.printStackTrace();
            Snackbar.make(llStudentsList, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorAllStudentsRequest(String error) {
        Snackbar.make(llStudentsList, error, Snackbar.LENGTH_LONG).show();
    }
}
