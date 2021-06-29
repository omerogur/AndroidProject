package com.example.evdeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ilandetay extends AppCompatActivity {
    private TextView baslik,detay,ücret,telefon;
    private Intent get_Intent;
    private ImageView resim;
    private String sBaslik,sAciklama,sUcret,sTelefon;
    private Bitmap secilenResim;

    public void init(){
        baslik = findViewById(R.id.ilanbasliktext);
        detay = findViewById(R.id.aciklamatext);
        resim = findViewById(R.id.ilanresmi);
        ücret = findViewById(R.id.ucret_ilan);
        telefon = findViewById(R.id.telefon_ilan);
        get_Intent = getIntent();
        sAciklama =Sayfais.ilan.getAciklama();
        sBaslik = Sayfais.ilan.getBaslik();
        secilenResim = Sayfais.ilan.getResim();
        sUcret = Sayfais.ilan.getUcret();
        sTelefon = Sayfais.ilan.getTelefon();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilandetay);
        init();


        if(!TextUtils.isEmpty(sBaslik)&& !TextUtils.isEmpty(sAciklama)){
            baslik.setText(sBaslik);
            detay.setText(sAciklama);
            ücret.setText(sUcret);
            telefon.setText(sTelefon);
            resim.setImageBitmap(secilenResim);

        }

    }
}