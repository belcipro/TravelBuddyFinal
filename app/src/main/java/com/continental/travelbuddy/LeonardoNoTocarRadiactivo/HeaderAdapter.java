package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.continental.travelbuddy.R;

import java.util.ArrayList;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.MyViewHolder>{
    private ArrayList<LugarModel> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView txtId;
        TextView txtNombre;
        TextView imageView;
        TextView inicio;
        TextView fin;
        Button btnDetail;

        Context context;

        MyViewHolder(View v) {
            super(v);
            context=v.getContext();

            txtId = (TextView) v.findViewById(R.id.txtId);
            txtNombre = (TextView) v.findViewById(R.id.txtNombre);
            imageView = (TextView) v.findViewById(R.id.imageView);
            btnDetail = (Button) v.findViewById(R.id.btnDetail);

        }

        void setOnClickListeners(){
            btnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetalleActivity.class);
            intent.putExtra("ID_Lugar_Turistico", txtId.getText());
            context.startActivity(intent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HeaderAdapter(ArrayList<LugarModel> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HeaderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item___lugar_turistico_listar, parent, false);

        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.txtId.setText(mDataset.get(position).getID_Lugar_Turistico());
        holder.txtNombre.setText(mDataset.get(position).getLT_Nombre());
        holder.imageView.setText(mDataset.get(position).getLT_Descripcion());

        //events
        holder.setOnClickListeners();
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
