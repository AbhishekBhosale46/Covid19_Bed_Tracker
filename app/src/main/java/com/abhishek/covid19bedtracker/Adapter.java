package com.abhishek.covid19bedtracker;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Hospitals> hospitals;

    public Adapter (Context ctx, List<Hospitals> hospitals) {
        this.inflater = LayoutInflater.from(ctx);
        this.hospitals = hospitals;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
//        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AssetManager am = inflater.getContext().getApplicationContext().getAssets();
        //Typeface typeface1 = Typeface.createFromAsset(am, "fonts/baloo.ttf");
        Typeface typeface = Typeface.createFromAsset(am, "fonts/VisbyRoundCFBold.otf");

        holder.aventi.setTypeface(typeface,Typeface.BOLD);
        holder.abeds.setTypeface(typeface,Typeface.BOLD);
        holder.aoxi.setTypeface(typeface,Typeface.BOLD);
        holder.totaloxi.setTypeface(typeface,Typeface.BOLD);
        holder.totalbeds.setTypeface(typeface,Typeface.BOLD);
        holder.totalventi.setTypeface(typeface,Typeface.BOLD);
        holder.hospname.setTypeface(typeface);

        holder.vaccant.setTypeface(typeface, Typeface.BOLD);
        holder.total.setTypeface(typeface, Typeface.BOLD);
        holder.oxi.setTypeface(typeface);
        holder.beds.setTypeface(typeface);
        holder.venti.setTypeface(typeface);
        holder.adress.setTypeface(typeface);
        holder.contact.setTypeface(typeface);
        holder.lastupdate.setTypeface(typeface);
        holder.contactno.setTypeface(typeface);

        holder.aventi.setText(hospitals.get(position).getAvailventi());
        holder.abeds.setText(hospitals.get(position).getAvailbeds());
        holder.aoxi.setText(hospitals.get(position).getAvailoxi());
        holder.totalbeds.setText(hospitals.get(position).getTotalbeds());
        holder.totalventi.setText(hospitals.get(position).getTotalventi());
        holder.totaloxi.setText(hospitals.get(position).getTotaloxi());
        holder.hospname.setText(hospitals.get(position).getHospname());
        holder.contactno.setText(hospitals.get(position).getContactno());
        holder.adress.append(" " + (hospitals.get(position).getAddress()));

    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView abeds,aventi,aoxi,totalbeds,totalventi,totaloxi,hospname;
        TextView vaccant,total,beds,oxi,venti,adress,contact,lastupdate,contactno;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            abeds = itemView.findViewById(R.id.vaccantbeds);
            aventi = itemView.findViewById(R.id.vaccantventi);
            aoxi = itemView.findViewById(R.id.vaccantoxi);
            totalbeds = itemView.findViewById(R.id.totalbeds);
            totalventi = itemView.findViewById(R.id.totalventi);
            totaloxi = itemView.findViewById(R.id.totaloxi);
            hospname = itemView.findViewById(R.id.hospital_name);

            vaccant = itemView.findViewById(R.id.vaccant);
            total = itemView.findViewById(R.id.total);
            beds = itemView.findViewById(R.id.beds);
            oxi = itemView.findViewById(R.id.oxygen);
            venti = itemView.findViewById(R.id.venti);
            adress = itemView.findViewById(R.id.address);
            adress.setSelected(true);
            contact = itemView.findViewById(R.id.contact);
            lastupdate = itemView.findViewById(R.id.last_update);
            lastupdate.setSelected(true);
            contactno = itemView.findViewById(R.id.contactno);

        }
    }
}
