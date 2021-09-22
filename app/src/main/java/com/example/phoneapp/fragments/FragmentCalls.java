package com.example.phoneapp.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoneapp.R;
import com.example.phoneapp.adapter.CallsRvAdapter;
import com.example.phoneapp.models.ModelCalls;

import java.util.ArrayList;
import java.util.List;

public class FragmentCalls extends Fragment {
    private View v;
    private RecyclerView recyclerView;



    public FragmentCalls(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frag_calls,container,false);
        recyclerView=v.findViewById(R.id.rv_calls);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager= linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        CallsRvAdapter adapter=new CallsRvAdapter(getContext(), getCallsLogs());
        recyclerView.setAdapter(adapter);


        return v;


    }
    private List<ModelCalls> getCallsLogs(){
        List<ModelCalls>list=new ArrayList<>();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED){
                   ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CALL_LOG},1);
        }
        Cursor cursor=getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI,null,
                null,null,CallLog.Calls.DATE + " ASC");
       int number=cursor.getColumnIndex(CallLog.Calls.NUMBER);
       int duration=cursor.getColumnIndex(CallLog.Calls.DURATION);
       int date=cursor.getColumnIndex(CallLog.Calls.DATE);
       cursor.moveToFirst();
       while (cursor.moveToNext()){
           list.add(new ModelCalls(cursor.getString(number),cursor.getString(duration),cursor.getString(date)));

       }
        return list;
    }
    





}
