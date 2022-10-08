package com.example.thutonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends  AppCompatActivity {
   TextView txtvDangnhap;
   Button btnfrofile;
    EditText edtUserName, edtpassWord;
    CheckBox cbreMember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
        //lay gia tri
       edtUserName.setText(sharedPreferences.getString("taikhoan",""));
       edtpassWord.setText(sharedPreferences.getString("matkhau",""));
       cbreMember.setChecked(sharedPreferences.getBoolean("checked",false));

        txtvDangnhap=(TextView) findViewById(R.id.textView8);
        txtvDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhdangnhap=new Intent(MainActivity.this,TrangDangki.class);
                startActivity(mhdangnhap);
            }
        });

        btnfrofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtUserName.getText().toString().trim();
                String password=edtpassWord.getText().toString().trim();
                if(username.equals("TranHuong")&& password.equals("2050531200202")){
                    Toast.makeText(MainActivity.this,"Dang Nhap Thanh Cong",Toast.LENGTH_SHORT).show();
                    Intent mhdangnhap1=new Intent(MainActivity.this,TrangChu.class);
                    startActivity(mhdangnhap1);
                    //Neu co check
                    if(cbreMember.isChecked()){
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else{
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();

                    }
                }else {
                    Toast.makeText(MainActivity.this,"Loi Dang Nhap",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa(){
        btnfrofile=(Button) findViewById(R.id.button_dangnhap);
        edtpassWord=(EditText) findViewById(R.id.IputPassword);
        edtUserName=(EditText) findViewById((R.id.editTextTextPersonName2));
        cbreMember=(CheckBox) findViewById(R.id.checkBox);

    }
}