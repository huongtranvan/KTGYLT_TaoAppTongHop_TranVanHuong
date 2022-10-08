package com.example.thutonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrangDangki extends  AppCompatActivity {
    Button btnDangki;
    Button btnDangki1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_dangki);
        btnDangki=(Button) findViewById(R.id.button_Dangki);
        btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhdangki=new Intent(TrangDangki.this,TrangChu.class);
                startActivity(mhdangki);
            }
        });
        btnDangki1=(Button) findViewById(R.id.button_Huybo);
        btnDangki1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhdangki2=new Intent(TrangDangki.this,MainActivity.class);
                startActivity(mhdangki2);
            }
        });

    }

}