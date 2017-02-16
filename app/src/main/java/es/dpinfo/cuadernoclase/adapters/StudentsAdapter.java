package es.dpinfo.cuadernoclase.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.dpinfo.cuadernoclase.R;
import es.dpinfo.cuadernoclase.models.Student;

/**
 * Created by dprimenko on 16/02/17.
 */
public class StudentsAdapter extends ArrayAdapter<Student>{


    private StudentHolder holder;

    public StudentsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void addStudents(List<Student> students) {
        addAll(students);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Student student = getItem(position);

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_student, parent, false);

            holder = new StudentHolder();
            holder.txvName = (TextView) view.findViewById(R.id.txv_name_item);
            holder.txvEmail = (TextView) view.findViewById(R.id.txv_email_item);

            view.setTag(holder);

        } else {
            holder = (StudentHolder) view.getTag();
        }

        holder.txvName.setText(student.getmNombre() + " " + student.getmApellidos());
        holder.txvEmail.setText(student.getmEmail());

        return view;
    }


    class StudentHolder {
        TextView txvName;
        TextView txvEmail;
    }
}
