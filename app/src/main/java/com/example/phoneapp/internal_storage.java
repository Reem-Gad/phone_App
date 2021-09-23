package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class internal_storage extends AppCompatActivity {


    SharedPreferences sp;
    SharedPreferences.Editor edit;


Button btn_save , btn_restore;
EditText txt_name , txt_phone;


public static final String File_name = "users" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        btn_save = findViewById(R.id.btn_save);
        btn_restore = findViewById(R.id.btn_restore);
        txt_name = findViewById(R.id.txt_name);
        txt_phone = findViewById(R.id.txt_phone);





        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt_name.getText().toString();
                String phone = txt_phone.getText().toString();

                try {
                    FileOutputStream fos =  openFileOutput(File_name , MODE_PRIVATE);
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println("user name : " + name + " \n phone : " + phone );
                    pw.close();
                    fos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            });




        btn_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    FileInputStream fis =  openFileInput(File_name );
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    String alltext = "";
                    String temp = "";
                    while ((temp=br.readLine())!=null){
                        alltext += temp ;
                    }
                    br.close();
                    isr.close();
                    fis.close();
                    Toast.makeText(internal_storage.this , alltext ,  Toast.LENGTH_SHORT).show();

                }catch (FileNotFoundException e)
                {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });



    }
}





















