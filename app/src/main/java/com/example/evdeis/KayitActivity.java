package com.example.evdeis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class KayitActivity extends AppCompatActivity {
    private ConstraintLayout conslayout;
    private EditText kayit_email,kayit_sifre,kullanici_isim;
    private String txtemail,txtsifre,txtisim;
    private Button kaydol;
    private FirebaseAuth mAuht;
    private FirebaseUser mUser;
    private DatabaseReference mReferance;
    private HashMap<String,Object> mData;

    private void init(){
        kaydol = findViewById(R.id.buton_kaydet);
        conslayout =findViewById(R.id.conslayout);
        kayit_email = findViewById(R.id.giris_editEmail);
        kayit_sifre = findViewById(R.id.giris_editsifre);
        kullanici_isim = findViewById(R.id.kullanici_isim);
        mAuht = FirebaseAuth.getInstance();  //kayıt ve giriş için
        mReferance = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        init();

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtemail=kayit_email.getText().toString();
                txtsifre=kayit_sifre.getText().toString();
                txtisim = kullanici_isim.getText().toString();
                 //id şifre boşmu kontrol
                if(!TextUtils.isEmpty(txtisim) && !TextUtils.isEmpty(txtemail) && !TextUtils.isEmpty(txtsifre))  {
                    mAuht.createUserWithEmailAndPassword(txtemail,txtsifre) // kullanıcıyı mail ve sifre ile kayıt ediyoruz.
                    .addOnCompleteListener(KayitActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                mUser = mAuht.getCurrentUser();
                                mData = new HashMap<>();
                                mData.put("Kullanici Adı : ", txtisim);                         //firebase referans gösterek child altına kullancılar olusturuyoruz  tekrar altına uid olusturuyoruz onun altınada set data diyerek bilgileri getirdik
                                mData.put("Kullanıcı Email : ", txtemail);                     //uid göre kullanıcı bilgilerini databasede gösteriyoruz ve realtime Database kayıt ediyoruz.
                                mData.put("Kullanici Sifre :", txtsifre);
                                mData.put("Kullanici Uid : ",mUser.getUid());
                                mReferance.child("Kullanıcılar").child(mUser.getUid())
                                        .setValue(mData)
                                        .addOnCompleteListener(KayitActivity.this, new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()) {
                                                    Toast.makeText(KayitActivity.this, "Kayıt İşlemi Başarılı", Toast.LENGTH_SHORT).show();
                                                    finish(); // aktivite bitir
                                                    startActivity(new Intent(KayitActivity.this, MainActivity.class));
                                                }
                                                  else
                                                      Toast.makeText(KayitActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                                            }
                                        });
                            }else
                                Snackbar.make(conslayout,task.getException().getMessage(),Snackbar.LENGTH_SHORT).show(); // hata varsa gösterecek

                        }
                    });
                }else
                   // Toast.makeText(KayitActivity.this,"Email ve Şifre Boş Olamaz",Toast.LENGTH_SHORT).show();
                    Snackbar.make(conslayout,"Email ve Şifre Boş Olamaz",Snackbar.LENGTH_SHORT).show();

            }
        });
    }
}