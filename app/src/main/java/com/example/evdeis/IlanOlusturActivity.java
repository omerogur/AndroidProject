package com.example.evdeis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IlanOlusturActivity extends AppCompatActivity {
    private EditText editTextTextMultiLine2, editTextTextMultiLine3,ilanbasligi;
    private IlanDao v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_olustur);
        v1 = new IlanDao(this);
        TextView textView = findViewById(R.id.textView);
        EditText ilanbasligi = findViewById(R.id.ilanbasligi);
        editTextTextMultiLine2 = findViewById(R.id.editTextTextMultiLine2);
        editTextTextMultiLine3 = findViewById(R.id.editTextTextMultiLine3);
        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View tasarımtakım = findViewById(R.id.takimtasarimi);
                AlertDialog.Builder alert = new AlertDialog.Builder(IlanOlusturActivity.this);
                if (editTextTextMultiLine2.getText().toString().trim().length() == 0) {
                    alert.setMessage("İLAN AÇIKLAMASI BOŞ BIRAKILAMAZ");
                    alert.setTitle("HATA");
                    alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alert.show();

                } else if (editTextTextMultiLine3.getText().toString().trim().length() == 0) {
                    alert.setTitle("HATA");
                    alert.setMessage("TELEFON ALANI BOŞ BIRAKILAMAZ");
                    alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alert.show();
                } else {
                    try {
                        ekleme(ilanbasligi.getText().toString(),editTextTextMultiLine2.getText().toString(), editTextTextMultiLine3.getText().toString());
                    } finally {
                        v1.close();
                    }
                    alert.setTitle("TEBRİKLER");
                    alert.setMessage("TEBRİKLER İLANINIZ OLUŞTURULDU");
                    alert.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.show();
                    finish();
                    Intent yeniIntent = new Intent(IlanOlusturActivity.this, SecimActivity.class);
                    startActivity(yeniIntent);
                }
            }
        });
    }
    private void ekleme(String ilanbasligi, String editTextTextMultiLine2, String editTextTextMultiLine3) {
        SQLiteDatabase db = v1.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put("baslik", ilanbasligi);
        cv1.put("aciklama", editTextTextMultiLine2);
        cv1.put("ucret", editTextTextMultiLine3);
        db.insertOrThrow("ilan", null, cv1);
    }
    }
