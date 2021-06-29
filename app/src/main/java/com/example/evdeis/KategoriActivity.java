package com.example.evdeis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class KategoriActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView kategoriRV;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        toolbar = findViewById(R.id.toolbar);
        kategoriRV = findViewById(R.id.kategoriRV);
        toolbar.setTitle("kategoriler"); //isim
        setSupportActionBar(toolbar);  //ekle

        kategoriRV.setHasFixedSize(true); // tasarım sabitle
        kategoriRV.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new ArrayList<>();
        Kategoriler k1= new Kategoriler(1,"PAKETLEME");
        Kategoriler k2= new Kategoriler(2,"BİRLEŞTİRME");
        Kategoriler k3= new Kategoriler(3,"DÜZENLEME");
        Kategoriler k4= new Kategoriler(4,"KATLAMA");
        Kategoriler k5= new Kategoriler(5,"TASARLAMA");



        kategorilerArrayList.add(k1);
        kategorilerArrayList.add(k2);
        kategorilerArrayList.add(k3);
        kategorilerArrayList.add(k4);
        kategorilerArrayList.add(k5);

        adapter = new KategoriAdapter(this,kategorilerArrayList);
        kategoriRV.setAdapter(adapter);

    }
}