package padilah.farid.sqlite.sqlitewithactive.transaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.sqlite.sqlitewithactive.R;
import padilah.farid.sqlite.sqlitewithactive.database.DbHelper;

public class UpdateActivity extends AppCompatActivity {

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
    DbHelper dbHelper;

    String nama = "", nim = "", alamat = "", jurusan = "", id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
        dbHelper = new DbHelper(this);
        setData();
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
    }

    public void setData() {
        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        nim = getIntent().getStringExtra("nim");
        jurusan = getIntent().getStringExtra("jurusan");
        txtName.setText(nama);
        txtNim.setText(nim);
        txtJurusan.setText(jurusan);
        txtAlamat.setText(alamat);
    }

    public void update() {
        if (!txtName.getText().toString().equals("")) {
            nama = txtName.getText().toString();
        } else {
            Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        if (!txtNim.getText().toString().equals("")) {
            nim = txtNim.getText().toString();
        } else {
            Toast.makeText(this, "Nim Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        if (!txtAlamat.getText().toString().equals("")) {
            alamat = txtAlamat.getText().toString();
        } else {
            Toast.makeText(this, "Alamat Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        if (!txtJurusan.getText().toString().equals("")) {
            jurusan = txtJurusan.getText().toString();
        } else {
            Toast.makeText(this, "Jurusan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }

        dbHelper.EditData(id, nama, nim, jurusan, alamat);
        Toast.makeText(this, "Sukses Update", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UpdateActivity.this, ShowActivity.class));

    }
}
