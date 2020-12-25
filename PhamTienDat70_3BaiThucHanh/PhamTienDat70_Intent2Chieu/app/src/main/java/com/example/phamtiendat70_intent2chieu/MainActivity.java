package com.example.phamtiendat70_intent2chieu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHT,edtNhapCV;
    TextView txtXL;
    Button btnND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHT = findViewById(R.id.edtHT);
        txtXL = findViewById(R.id.txtXL);
        edtNhapCV = findViewById(R.id.edtNhapCV);
        btnND = findViewById(R.id.btnND);

        btnND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  a  = edtNhapCV.getText().toString();
                //    int  b =Integer.parseInt(edtSo2.getText().toString());
                Intent My_Intent = new Intent(MainActivity.this, Main2Activity.class);
                My_Intent.putExtra("ChucVu",a);
                //  My_Intent.putExtra("b",b+"");
                startActivityForResult(My_Intent,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                double Diem = data.getDoubleExtra("Diem", 1);
                if (Diem >= 9) txtXL.setText("Xuất sắc");
                else if (Diem >= 8) txtXL.setText("giỏi");
                else if (Diem >= 7) txtXL.setText("khá");
                else if (Diem >= 5) txtXL.setText("trung bình");
                else txtXL.setText("Yếu");
                // edtXL.setText(Diem+"");
            }
            Toast.makeText(getApplicationContext(), "goi onActivityResult", Toast.LENGTH_LONG).show();

        }

    }
}
