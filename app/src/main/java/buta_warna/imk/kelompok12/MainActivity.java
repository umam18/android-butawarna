package buta_warna.imk.kelompok12;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTes(View view){
        Intent tentangIntent = new Intent(this, TestActivity.class);
        tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tentangIntent);
    }

    public void onClickBuku(View view){
        Intent tentangIntent = new Intent(this, ArticleActivity.class);
        tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tentangIntent);
    }

    public void onClickTentang(View view){
        Intent tentangIntent = new Intent(this, AboutActivity.class);
        tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(tentangIntent);
    }

    public void onClickExit(View view){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        MainActivity.this.finish();
    }

    public String getStringFromR(int id){
        return getResources().getString(id);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce){
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getStringFromR(R.string.exitToast), Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }

}
