package padilah.farid.sqlite.sqlitewithactive.transaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.sqlite.sqlitewithactive.R;
import padilah.farid.sqlite.sqlitewithactive.adapter.StudentAdapter;
import padilah.farid.sqlite.sqlitewithactive.database.DbHelper;
import padilah.farid.sqlite.sqlitewithactive.model.Student;

public class ShowActivity extends AppCompatActivity {
    DbHelper dbHelper;
    StudentAdapter studentAdapter;
    List<Student> listStudet = new ArrayList<>();
    @BindView(R.id.rv_student)
    RecyclerView rvStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        dbHelper = new DbHelper(this);

        //get Data
        listStudet = dbHelper.tampilData();

        studentAdapter = new StudentAdapter(this, listStudet, dbHelper);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvStudent.setLayoutManager(layoutManager);
        rvStudent.setItemAnimator(new DefaultItemAnimator());
        rvStudent.setAdapter(studentAdapter);
        studentAdapter.notifyDataSetChanged();
    }
}
