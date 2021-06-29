package com.example.evdeis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Sayfais extends AppCompatActivity {
    private IsDao v1;
    private ListView mListView;
    private Intent i;

    private ArrayAdapter<String>adapter;
    private String[] ilanlar ={"ÖRNEK İŞ1","ÖRNEK İŞ2","ÖRNEK İŞ3","ÖRNEK İŞ4","ÖRNEK İŞ5",
            "ÖRNEK İŞ6","ÖRNEK İŞ7","ÖRNEK İŞ8","ÖRNEK İŞ9","ÖRNEK İŞ10","ÖRNEK İŞ11","ÖRNEK İŞ12","ÖRNEK İŞ13","ÖRNEK İŞ14","ÖRNEK İŞ15",};
    private String[] aciklama={"Türkiye'nin en güvenilir araştırma şirketlerinden biri olan ailemiz bünyesinde çağrı merkezi departmanında çalışmak isteyen, genç, dinamik, araştırma meraklısı çalışma arkadaşları aranmaktadır.\n" +
            "\n" +
            "Genel Nitelikler\n" +
            "\n" +
            "o    ÇATI(TELEFON DESTEKLİ ANKET) Ve Saha Araştırmacısı Olarak Çalışabilecek,\n" +
            "\n" +
            "o    Tecrübeli Veya Tecrübesiz\n" +
            "\n" +
            "o    Diksiyonu Düzgün\n" +
            "\n" +
            "o    Araştırmaya Meraklı Çalışma Arkadaşları Aranmaktadır."
          ,"ÖRNEK ACIKLAMA2","ÖRNEK ACIKLAMA3","ÖRNEK ACIKLAMA4","ÖRNEK ACIKLAMA5","ÖRNEK ACIKLAMA6","ÖRNEK ACIKLAMA7","ÖRNEK ACIKLAMA8","ÖRNEK ACIKLAMA9","ÖRNEK ACIKLAMA10","ÖRNEK ACIKLAMA11","ÖRNEK ACIKLAMA2"
            ,"ÖRNEK ACIKLAMA13","ÖRNEK ACIKLAMA14","ÖRNEK ACIKLAMA15",};
    private String[] ücret={"2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL","2000 TL",};
    private String telefon[] = {"053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx",
            "053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx","053x xxx xx xx",};
    private int [] ilanResim=   {R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,
            R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath,R.drawable.argonath};
   private Bitmap secilenResim;
   static public İlan ilan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfais);
        v1 = new IsDao(this);
        mListView = findViewById(R.id.main_activity_listView);
        adapter = new ArrayAdapter<>(Sayfais.this, android.R.layout.simple_list_item_1,ilanlar);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i = new Intent(Sayfais.this,ilandetay.class);
                secilenResim= BitmapFactory.decodeResource(getApplicationContext().getResources(),ilanResim[position]);
                ilan = new İlan(ilanlar[position],aciklama[position],ücret[position],telefon[position],secilenResim);
                startActivity(i);
            }
        });
        /* listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent git = new Intent(Sayfais.this,ilandetay.class);
                git.putExtra("DETAY",landetay.get(i));
                git.putExtra("ücret",ucret.get(i));
                git.putExtra("telefon",telefon.get(i));
                startActivity(git);
            }
        });
    }
    private String [] sutunlar = {"baslik","aciklama","ucret"};
    private void bilgilerigoster() {

        SQLiteDatabase db = v1.getReadableDatabase();
        Cursor okunanlar = db.query("ilan", sutunlar, null, null, null, null, null);
        while (okunanlar.moveToNext()) {
            ArrayList<String>gilan = new ArrayList<>();
            ArrayList<String>gcret = new ArrayList<>();

            ArrayList<String>gilandetay = new ArrayList<>();
            String baslik = okunanlar.getString(okunanlar.getColumnIndex("baslik"));
            String aciklama = okunanlar.getString(okunanlar.getColumnIndex("aciklama"));
            String ucret = okunanlar.getString(okunanlar.getColumnIndex("ucret"));

            gilan.add(baslik);
            gcret.add(ucret);
            gilandetay.add(aciklama);
            ArrayAdapter<String> sqladapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,gilan);
            listView1.setAdapter(sqladapter);
        }
    }*/
    }
}