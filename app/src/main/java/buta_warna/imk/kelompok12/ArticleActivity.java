package buta_warna.imk.kelompok12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClickPengertian(View view) {
        Fragment myfragment;
        myfragment = new FragmentPengertian();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_change, myfragment);
        fragmentTransaction.commit();
    }
    public void onClickPenyebab(View view) {
        Fragment myfragment;
        myfragment = new FragmentPenyebab();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_change, myfragment);
        fragmentTransaction.commit();
    }

    public void onClickJenis(View view) {
        Fragment myfragment;
        myfragment = new FragmentJenis();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_change, myfragment);
        fragmentTransaction.commit();
    }
    public void onClickPengobatan(View view) {
        Fragment myfragment;
        myfragment = new FragmentPengobatan();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_change, myfragment);
        fragmentTransaction.commit();
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            if (item.getItemId() == android.R.id.home) {
                Intent tentangIntent = new Intent(this, MainActivity.class);
                tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(tentangIntent);
            }
            return super.onOptionsItemSelected(item);
        }
}
