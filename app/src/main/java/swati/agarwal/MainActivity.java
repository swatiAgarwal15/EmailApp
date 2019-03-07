package swati.agarwal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText email, subject, message;

        email = findViewById(R.id.editTextEmail);
        subject = findViewById(R.id.editTextSubject);
        message = findViewById(R.id.editTextMessage);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = email.getText().toString().trim();
                String s2 = subject.getText().toString().trim();
                String s3 = message.getText().toString().trim();
                if (s1.equals("") || s2.equals("")||s3.equals("")) {
                    Toast.makeText(MainActivity.this, "enter all values", Toast.LENGTH_SHORT).show();
                } else {
                   String mailAddress = String.format("mailno:%s",s1,null);
                   Intent emailIntenet = new Intent(Intent.ACTION_SEND, Uri.fromParts("mailto",s1,null));
                   emailIntenet.putExtra(Intent.EXTRA_SUBJECT,s2);
                   emailIntenet.putExtra(Intent.EXTRA_TEXT,s3);
                   startActivity(emailIntenet);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
