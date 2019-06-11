package myfirstapplication.omeroguzcelikel.com.oyundeneme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int skor;

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView [] imageArray;

    Handler handler;
    Runnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);


        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);


        imageArray = new ImageView[] {imageView, imageView2, imageView3 , imageView4 ,
                imageView5 , imageView6 , imageView7, imageView8 , imageView9 , imageView10 ,
                imageView11 , imageView12 , imageView13 , imageView14 , imageView15};

        resimSakla();
        skor = 0 ;



        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Kalan süre :  " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                textView.setText("SÜRE BİTTİ");
                handler.removeCallbacks(runnable);
                //oyun bitince hepsi görünmez olacak
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("OYUN BİTTİ");
                alert.setMessage("Yeniden Başlatmak İster Misin?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //tekrar başlat

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);


                    }
                });

                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //feyzoş a
                        Toast.makeText(MainActivity.this, "Bir Daha Bekleriz :)", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();

            }
        }.start();


    }


    public void skorArttır(View view){
        skor++;
            textView2.setText("Skor :  " + skor);
    }
            //SÜPER BURASI
    public void resimSakla(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(15);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,750);

            }
        };
        handler.post(runnable);

    }


}
