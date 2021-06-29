package com.example.evdeis;

import android.graphics.Bitmap;

public class İlan {
    public İlan(String baslik, String aciklama, String ucret, String telefon, Bitmap resim) {
        this.baslik = baslik;
        this.aciklama = aciklama;
        this.ucret = ucret;
        this.telefon = telefon;
        this.resim = resim;
    }

    private String baslik, aciklama, ucret, telefon;
    private Bitmap resim;

    public İlan() {
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getUcret() {
        return ucret;
    }

    public void setUcret(String ucret) {
        this.ucret = ucret;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Bitmap getResim() {
        return resim;
    }

    public void setResim(Bitmap resim) {
        this.resim = resim;
    }
}


