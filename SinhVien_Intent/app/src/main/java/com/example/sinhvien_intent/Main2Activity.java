package com.example.sinhvien_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText edtTen,edtDiem,edtMSV,edtNS,edtLop,edtXL,edtCV;
    Button btnLuu,btnTroVe,btnXoa;
    Bundle bundle,bundle1;
    SinhVien sinhVien;
    int ViTri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtTen= findViewById(R.id.edtTen);
        edtMSV= findViewById(R.id.edtMSV);
        edtLop= findViewById(R.id.edtLop);
        edtNS= findViewById(R.id.edtNS);
        edtDiem= findViewById(R.id.edtDiem);
        edtXL= findViewById(R.id.edtXL);
        edtCV= findViewById(R.id.edtCV);
        btnLuu = findViewById(R.id.btnLuu);
        btnTroVe = findViewById(R.id.btnTroVe);
        btnXoa = findViewById(R.id.btnXoa);
        Intent intent = getIntent();
        bundle = intent.getBundleExtra("du lieu");
        int CheDo = bundle.getInt("mode");
        sinhVien = new SinhVien();
        sinhVien.setHoTen(bundle.getString("Ho Ten"));
        sinhVien.setMaSV(bundle.getInt("Ma Sinh Vien"));
        sinhVien.setNamSinh(bundle.getInt("Nam Sinh"));
        sinhVien.setLop(bundle.getString("Lop"));
        sinhVien.setDiem(bundle.getDouble("Diem"));
        sinhVien.setChucVu(bundle.getString("Chuc Vu"));
        ViTri = bundle.getInt("postition");
        if (CheDo==0) {
            edtTen.setText(sinhVien.getHoTen());
            edtMSV.setText(sinhVien.getMaSV()+"");
            edtNS.setText(sinhVien.getNamSinh()+"");
            edtLop.setText(sinhVien.getLop());
            edtDiem.setText(sinhVien.getDiem()+"");
            edtCV.setText(sinhVien.getChucVu());
            edtXL.setText(sinhVien.DanhGiaSinhVien());
        }else if (CheDo==1)
        {
            edtTen.setText("");
            edtMSV.setText("");
            edtNS.setText("");
            edtLop.setText("");
            edtDiem.setText("");
            edtCV.setText("");
            edtXL.setText("");
        }
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTen.getText().toString().equals("")||edtMSV.getText().toString().equals("")||
                        edtNS.getText().toString().equals("")||edtLop.getText().toString().equals("")||
                        edtDiem.getText().toString().equals("")||edtCV.getText().toString().equals("")
                    //||imgHinh.getMatrix().equals(null)
                )
                {
                    Toast.makeText(Main2Activity.this,"chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {
                    sinhVien.setHoTen(edtTen.getText().toString());
                    sinhVien.setMaSV(Integer.parseInt(edtMSV.getText().toString()));
                    sinhVien.setNamSinh(Integer.parseInt(edtNS.getText().toString()));
                    sinhVien.setLop(edtLop.getText().toString());
                    sinhVien.setDiem(Double.parseDouble(edtDiem.getText().toString()));
                    sinhVien.setChucVu(edtCV.getText().toString());
                    edtXL.setText(sinhVien.DanhGiaSinhVien());
                }
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTen.getText().toString().equals("")||edtMSV.getText().toString().equals("")||
                        edtNS.getText().toString().equals("")||edtLop.getText().toString().equals("")||
                        edtDiem.getText().toString().equals("")||edtCV.getText().toString().equals("")
                    //||imgHinh.getMatrix().equals(null)
                )
                {
                    Toast.makeText(Main2Activity.this,"chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intentRespond = new Intent(Main2Activity.this, MainActivity.class);
                    bundle1 = new Bundle();
                    bundle1.putString("Ho Ten", sinhVien.getHoTen());
                    bundle1.putInt("Ma Sinh Vien", sinhVien.getMaSV());
                    bundle1.putInt("Nam Sinh", sinhVien.getNamSinh());
                    bundle1.putString("Lop", sinhVien.getLop());
                    bundle1.putDouble("Diem", sinhVien.getDiem());
                    bundle1.putString("Chuc Vu", sinhVien.getChucVu());
                    bundle1.putInt("ViTri", ViTri);
                    intentRespond.putExtra("BundleRespond", bundle1);
                    setResult(RESULT_OK, intentRespond);
                    finish();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRespond1 = new Intent(Main2Activity.this, MainActivity.class);
                Bundle bundle2 = new Bundle();
                //xoa= 1;
                bundle2.putInt("ViTri", ViTri);
                intentRespond1.putExtra("BundleRespond1", bundle2);
                setResult(2, intentRespond1);
                finish();

            }
        });
    }
}
