package com.example.evdeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecimActivity extends AppCompatActivity {
    private Button buton_ilan,buton_is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secim);

        buton_ilan = findViewById(R.id.buton_ilan);
        buton_is = findViewById(R.id.buton_is);



        buton_is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecimActivity.this,KategoriActivity.class);
                startActivity(i);

            }
        });


        buton_ilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecimActivity.this,IlanOlusturActivity.class);
                startActivity(i);
            }
        });
    }
}