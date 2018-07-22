package buta_warna.imk.kelompok12;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class TestActivity extends AppCompatActivity {

    int[] ishiharaArr;
    int currentIshihara = 2;
    int currentAnswer = 2;
    int scoreBenar = 0;
    int scoreSalah = 0;
    int gambar = 0;
    int userAnswer = 0;

    ImageView ishiharaImg;
    EditText answerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle(getStringFromR(R.string.tesButaWarna));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView t = (TextView) findViewById(R.id.tes);
        t.setText("1 / 10");
        ishiharaArr = new int[] {2, 3, 5, 6, 7, 8, 12, 15, 16, 26, 29, 35, 42, 45, 73, 74, 96, 97}; //7,12
        ishiharaImg = (ImageView) findViewById(R.id.mImageTest);
        answerEditText = (EditText) findViewById(R.id.mAnswer);
    }

    private void btnNext(){
        currentIshihara = getRandomIshihara(ishiharaArr);
        currentAnswer = currentIshihara;
        int newImg = getIsharaDrawable(currentIshihara);
        ishiharaImg.setImageResource(newImg);
        answerEditText.setText("");
    }

    public void onClickAnswer(View v){
        String result;
        String strUserAnswer = answerEditText.getText().toString();
        try {
            userAnswer = Integer.parseInt(strUserAnswer);
        } catch (NumberFormatException e){

        }
                if (strUserAnswer.equals("")) {
                    Toast.makeText(this, getStringFromR(R.string.emptyAnswerToast), Toast.LENGTH_SHORT).show();
                } else {
                    gambar = gambar +1;
                    if (userAnswer == currentAnswer) {
                        result = getStringFromR(R.string.correctAnswer);
                        scoreBenar = scoreBenar + 1;
                    } else {
                        result = getStringFromR(R.string.wrongAnswer);
                        scoreSalah = scoreSalah + 1;

                    }

//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setCancelable(false);
//                builder.setTitle(getStringFromR(R.string.resultAnswer));
//                builder.setMessage(getStringFromR(R.string.userAnswer) + "Benar : " + scoreBenar + "Salah : " + scoreSalah + "Gambar Ke- : " + gambar);
//                builder.setPositiveButton(getStringFromR(R.string.testNext), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        btnNext();
//                    }
//                });
//
//                AlertDialog hasil = builder.create();
//                hasil.show();
                    if (gambar < 10) {
                        TextView t = (TextView) findViewById(R.id.tes);
                        t.setText(String.valueOf(gambar + 1)+" / 10");
                        btnNext();
                    }else {
                        Intent kesimpulanIntent = new Intent(this, Kesimpulan.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("benar", Integer.parseInt("" + scoreBenar));
                        bundle.putInt("salah", Integer.parseInt("" + scoreSalah));
                        kesimpulanIntent.putExtras(bundle);
                        kesimpulanIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(kesimpulanIntent);
                    }
                }

    }

    /**
     * get Random number of ishihara test;
     * @param array -> ishiharaArr
     * @return random number from array
     */
    public int getRandomIshihara(int[] array){
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    /**
     * get Ishihara Drawable Image
     * @param ishihara -> ishihara number
     * @return R.id.DrawableImage
     */
    public int getIsharaDrawable(int ishihara){
        String name = "ishihara_" + String.valueOf(ishihara);
        int img = getResources().getIdentifier(name, "drawable", getPackageName());
        return img;
    }

    public String getStringFromR(int id){
        return getResources().getString(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case DialogInterface.BUTTON_POSITIVE:
                                Intent tentangIntent = new Intent(getApplicationContext(), MainActivity.class);
                                tentangIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(tentangIntent);
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Apakah ingin keluar dari Tes?").setPositiveButton("Ya", dialogClickListener).setNegativeButton("Tidak", dialogClickListener);
            AlertDialog hasil = builder.create();
            hasil.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
