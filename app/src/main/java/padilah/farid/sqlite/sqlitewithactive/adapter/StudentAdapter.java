package padilah.farid.sqlite.sqlitewithactive.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import padilah.farid.sqlite.sqlitewithactive.R;
import padilah.farid.sqlite.sqlitewithactive.database.DbHelper;
import padilah.farid.sqlite.sqlitewithactive.model.Student;
import padilah.farid.sqlite.sqlitewithactive.transaction.UpdateActivity;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;
    private Context context;
    private DbHelper dbHelper;

    public StudentAdapter(Context context, List<Student> studentList, DbHelper dbHelper) {
        this.context = context;
        this.studentList = studentList;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_student, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"NewApi", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        holder.nama.setText(studentList.get(position).getNama());
        holder.nim.setText(studentList.get(position).getNim());
        holder.alamat.setText(studentList.get(position).getJurusan());
        holder.jurusan.setText(studentList.get(position).getAlamat());

        Student student = studentList.get(position);
        holder.bindTo(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nama, nim, alamat, jurusan;
        private Button edit, hapus;
        private Student student;

        ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            nim = itemView.findViewById(R.id.nim);
            alamat = itemView.findViewById(R.id.alamat);
            jurusan = itemView.findViewById(R.id.jurusan);
            hapus = itemView.findViewById(R.id.hapus);
            edit = itemView.findViewById(R.id.edit);

            hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dbHelper.DeleteData(student.getId());
                    studentList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("id", student.getId());
                    intent.putExtra("nama", student.getNama());
                    intent.putExtra("nim", student.getNim());
                    intent.putExtra("alamat", student.getAlamat());
                    intent.putExtra("jurusan", student.getJurusan());
                    context.startActivity(intent);
                }
            });
        }

        void bindTo(Student student) {
            this.student = student;
        }
    }
}
