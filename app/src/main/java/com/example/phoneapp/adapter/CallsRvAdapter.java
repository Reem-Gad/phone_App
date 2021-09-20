package com.example.phoneapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoneapp.R;
import com.example.phoneapp.models.ModelCalls;

import java.util.List;

public class CallsRvAdapter extends RecyclerView.Adapter<CallsRvAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private Context nContext;
    private List<ModelCalls>nListCalls;
    public  CallsRvAdapter(Context context,List<ModelCalls>listCalls){
        nContext=context;
        nListCalls=listCalls;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater=LayoutInflater.from(nContext);
        View view=layoutInflater.inflate(R.layout.item_calls,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          TextView name,duration,data;
          name=holder.name;
          duration=holder.duration;
          data=holder.data;

          name.setText(nListCalls.get(position).getName());
        duration.setText(nListCalls.get(position).getDuration());
        data.setText(nListCalls.get(position).getData());




    }

    @Override
    public int getItemCount() {
        return nListCalls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
          TextView name,duration,data;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.contact_name);
            duration=itemView.findViewById(R.id.call_duration);
            data=itemView.findViewById(R.id.call_data);

        }
    }
}
