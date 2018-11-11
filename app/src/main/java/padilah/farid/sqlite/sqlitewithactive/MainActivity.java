package padilah.farid.sqlite.sqlitewithactive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import padilah.farid.sqlite.sqlitewithactive.auth.LoginActivity;
import padilah.farid.sqlite.sqlitewithactive.sharedpreferences.Preferences;
import padilah.farid.sqlite.sqlitewithactive.transaction.AddActivity;
import padilah.farid.sqlite.sqlitewithactive.transaction.ShowActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.add)
    LinearLayout add;
    @BindView(R.id.show)
    LinearLayout show;
    Preferences prev = new Preferences();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddActivity.class));
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                prev.clearLoggedInUser(MainActivity.this);
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
