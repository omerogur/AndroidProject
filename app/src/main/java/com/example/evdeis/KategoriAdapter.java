package com.example.evdeis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>{
    private Context mContext; //android özelliklerini kullanmak icin
    private List<Kategoriler> kategorilerliste;

    public KategoriAdapter(Context mContext, List<Kategoriler> kategorilerliste) {
        this.mContext = mContext;
        this.kategorilerliste = kategorilerliste;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView kategori_card;
        private TextView textViewKategoriAd;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            kategori_card = itemView.findViewById(R.id.kategori_card);
            textViewKategoriAd = itemView.findViewById(R.id.textViewKategoriAd);
        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_card_tasarim,parent,false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kategoriler kategori = kategorilerliste.get(position);
        holder.textViewKategoriAd.setText(kategori.getKategori_ad());
        holder.kategori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i = new Intent(mContext,Sayfais.class);
              mContext.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {

        return kategorilerliste.size();
    }


}
