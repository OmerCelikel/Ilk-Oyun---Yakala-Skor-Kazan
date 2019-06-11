package myfirstapplication.omeroguzcelikel.com.oyundeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OyunGiris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_giris);
    }


    public void oyunBasla (View view){
        Intent intent = new Intent(OyunGiris.this , MainActivity.class);
        startActivity(intent);
    }
}
