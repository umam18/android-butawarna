package buta_warna.imk.kelompok12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent tentangIntent = new Intent(this, MainActivity.class);
            tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(tentangIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
