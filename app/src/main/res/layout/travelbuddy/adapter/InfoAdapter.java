package com.continental.travelbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.continental.travelbuddy.R;
import com.continental.travelbuddy.model.Info;
import com.continental.travelbuddy.model.Video;

import java.util.List;
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoHolder> {
    List<Info> listaInfo;
    TextView url;
    public InfoAdapter(List<Info> listaInfo){
        this.listaInfo=listaInfo;
    }
    @NonNull
    @Override
    public InfoAdapter.InfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_usuarios,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);

        url=(TextView)vista.findViewById(R.id.txtUrl);

        return new InfoAdapter.InfoHolder(vista);
    }

    @Override
    public  void onBindViewHolder(@NonNull InfoAdapter.InfoHolder holder, int position){
        holder.txt_lugar.setText(listaInfo.get(position).getLT_Nombre().toString());
    }
    @Override
    public int getItemCount(){
        return listaInfo.size();
    }
    public class InfoHolder extends RecyclerView.ViewHolder{
        TextView txt_lugar;
        public InfoHolder(View itemView){

            super(itemView);
            txt_lugar=(TextView)itemView.findViewById(R.id.tctNombreLugar);
        }
    }


}

