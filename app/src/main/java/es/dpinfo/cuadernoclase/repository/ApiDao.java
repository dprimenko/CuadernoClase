package es.dpinfo.cuadernoclase.repository;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;

/**
 * Created by dprimenko on 16/02/17.
 */
public class ApiDao {

    private RequestQueue queue;
    private AllStudentsRequestListener allStudentsRequestListener;

    private static final String URL_STUDENTS = "https://david.alumno.club/alumnos";

    public interface AllStudentsRequestListener {
        void onSuccessAllStudentsRequest(JSONObject response);
        void onErrorAllStudentsRequest(String error);
    }

    private static ApiDao ourInstance = new ApiDao();
    public static synchronized ApiDao getInstance() {return ourInstance; }
    private ApiDao() {}

    public void requestAllStudents(Fragment fragment) {

        try {
            allStudentsRequestListener = (AllStudentsRequestListener) fragment;
        } catch (ClassCastException e) {
            throw new ClassCastException(fragment.toString() + "must implement AllStudentsRequestListener");
        }

        getAllStudents(fragment.getActivity());
    }

    private void getAllStudents(Context context) {
        queue = Volley.newRequestQueue(context);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, URL_STUDENTS, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        allStudentsRequestListener.onSuccessAllStudentsRequest(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        allStudentsRequestListener.onErrorAllStudentsRequest(error.toString());
                    }
                }
        );

        queue.add(getRequest);

    }
}
