package com.example.evdeis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText editEmail,editSifre;
    private Button girisyap,kayitol;
    private String txtemail,txtsifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    public void init(){
        editEmail = findViewById(R.id.giris_editEmail);
        editSifre = findViewById(R.id.giris_editsifre);
        girisyap  = findViewById(R.id.buton_giris);
        kayitol   = findViewById(R.id.buton_kayitol);
        mAuth =FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtemail = editEmail.getText().toString();
                txtsifre = editSifre.getText().toString();

                if(!TextUtils.isEmpty(txtemail) && !TextUtils.isEmpty(txtsifre)){
                    mAuth.signInWithEmailAndPassword(txtemail,txtsifre)
                            .addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    mUser = mAuth.getCurrentUser();
                                    System.out.println("Kullanıcının Adı :" +mUser.getDisplayName());
                                    System.out.println("Kullanıcının Emaili :" +mUser.getEmail());
                                    System.out.println("Kullanıcının Uid :" +mUser.getUid());
                                    Intent i = new Intent(MainActivity.this,SecimActivity.class);
                                    startActivity(i);
                                }
                            }).addOnFailureListener(MainActivity.this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                    }else
                    Toast.makeText(MainActivity.this,"Email ve Şifre Boş Olamaz",Toast.LENGTH_SHORT).show();

            }
        });
        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent = new Intent(MainActivity.this,KayitActivity.class);
                startActivity(ıntent);

            }
        });
    }
}