package com.example.phamtiendat70_intent2chieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText edtDiem;
    TextView txtLayCV;
    Button btnXXL;
    Intent Intent_Nhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtDiem = findViewById(R.id.edtDiem);
        txtLayCV = findViewById(R.id.txtLayCV);
        //  edtCV = findViewById(R.id.edtCV);
        btnXXL = findViewById(R.id.btnXXL);
        Intent intent = getIntent();
        final String ChucVu = intent.getStringExtra("ChucVu");
        txtLayCV.setText(ChucVu);
        btnXXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Diem = Double.parseDouble(edtDiem.getText().toString());
                if (ChucVu.equals("lop truong")) Diem = Diem+0.5;
                else if (ChucVu.equals("lop pho")) Diem += 0.3;
                else if (ChucVu.equals("bi thu"))  Diem+= 0.2;
                Intent_Nhan = new Intent();
                Intent_Nhan.putExtra("Diem",Diem);
                Intent_Nhan.putExtra("ChuVu",ChucVu);
                setResult(RESULT_OK,Intent_Nhan);
                finish();

            }
        });
    }
}
