package buta_warna.imk.kelompok12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Kesimpulan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesimpulan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        int benar = bundle.getInt("benar");
        int salah = bundle.getInt("salah");

        if(benar > 0 && benar < 10) {
            TextView correct = (TextView) findViewById(R.id.hasil);
            correct.setText("Benar : "+String.valueOf(benar)+"     Salah : "+String.valueOf(salah));
            TextView result = (TextView) findViewById(R.id.conclusion);
            result.setText("Buta Warna Parsial");
        }
        else if(benar > 9){
            TextView correct = (TextView) findViewById(R.id.hasil);
            correct.setText("Benar : "+String.valueOf(benar)+"     Salah : "+String.valueOf(salah));
            TextView result = (TextView) findViewById(R.id.conclusion);
            result.setText("Normal");
        }
        else{
            TextView correct = (TextView) findViewById(R.id.hasil);
            correct.setText("Benar : "+String.valueOf(benar)+"     Salah : "+String.valueOf(salah));
            TextView result = (TextView) findViewById(R.id.conclusion);
            result.setText("Buta Warna Total");
        }
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

    public void ya(View view){
        Intent tesIntent = new Intent(this, TestActivity.class);
        tesIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tesIntent);
    }

    public void tidak(View view){
        Intent tentangIntent = new Intent(this, MainActivity.class);
        tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tentangIntent);
    }
}
