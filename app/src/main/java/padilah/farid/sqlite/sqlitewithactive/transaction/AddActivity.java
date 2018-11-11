package padilah.farid.sqlite.sqlitewithactive.transaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.sqlite.sqlitewithactive.R;
import padilah.farid.sqlite.sqlitewithactive.database.DbHelper;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.txt_name)
    EditText txtName;
    @BindView(R.id.txt_nim)
    EditText txtNim;
    @BindView(R.id.txt_jurusan)
    EditText txtJurusan;
    @BindView(R.id.txt_alamat)
    EditText txtAlamat;
    @BindView(R.id.insert)
    Button insert;
    String nama = "", nim = "", alamat = "", jurusan = "";
    DbHelper dbHelper;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        dbHelper = new DbHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    public void save() {
        if (!txtName.getText().toString().equals("") && !txtAlamat.getText().toString().equals("") && !txtJurusan.getText().toString().equals("") && !txtNim.getText().toString().equals("")) {
            nama = txtName.getText().toString();
            nim = txtNim.getText().toString();
            alamat = txtAlamat.getText().toString();
            jurusan = txtJurusan.getText().toString();
            status = dbHelper.MasukanData(nama, nim, alamat, jurusan);

            if (status) {
                Toast.makeText(this, "Berhasil Mengubah data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Gagal masukan data", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Maaf Form Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
