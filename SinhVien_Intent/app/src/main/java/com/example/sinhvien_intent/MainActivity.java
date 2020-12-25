package com.example.sinhvien_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnTien,btnXem,btnThem,btnLui;
    TextView txtHT1,txtMSV1,txtXL1,txtSTT;
    ArrayList<SinhVien> mangSinhVien;
    int pos = 0,mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          txtHT1 = findViewById(R.id.txtHT1);
          txtMSV1 =  findViewById(R.id.txtMSV1);
          txtXL1 = findViewById(R.id.txtXL1);
          txtSTT = findViewById(R.id.txtSTT);
          btnTien = findViewById(R.id.btnTien);
          btnLui = findViewById(R.id.btnLui);
          btnXem = findViewById(R.id.btnXem);
          btnThem = findViewById(R.id.btnThem);
        mangSinhVien = new ArrayList<SinhVien>();
        mangSinhVien.add(new SinhVien("Pham Tien Dat",1,1998,"KTDT$THCN",8.5,"lop truong"));
        mangSinhVien.add(new SinhVien("Nguyen Thi A",2,1998,"KTDT$THCN",8.8,"lop pho"));
        mangSinhVien.add(new SinhVien("Nguyen Thi B",3,1997,"KTDT$THCN",8.7,"bi thu"));
        mangSinhVien.add(new SinhVien("Nguyen Thi C",4,1999,"KTDT$THCN",9.0,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi D",5,1998,"KTDT$THCN",8.0,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi E",6,1997,"KTDT$THCN",7.0,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi F",7,1999,"KTDT$THCN",6.0,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi G",8,1999,"KTDT$THCN",5.0,"không"));

        txtHT1.setText(mangSinhVien.get(pos).getHoTen());
        txtMSV1.setText(mangSinhVien.get(pos).getMaSV()+"");
        txtXL1.setText(mangSinhVien.get(pos).getChucVu());
        txtSTT.setText(pos+1+"");
        btnTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos+=1;
                if (pos>(mangSinhVien.size()-1)) pos-=1;
                txtSTT.setText(pos+1+"");
                // edtTen.setText(A.getHoTen());
                txtHT1.setText(mangSinhVien.get(pos).getHoTen());
                txtMSV1.setText(mangSinhVien.get(pos).getMaSV()+"");
                txtXL1.setText(mangSinhVien.get(pos).getChucVu());

            }
        });
        btnLui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos-=1;
                if (pos<0) pos+=1;
                txtSTT.setText(pos+1+"");
                txtHT1.setText(mangSinhVien.get(pos).getHoTen());
                txtMSV1.setText(mangSinhVien.get(pos).getMaSV()+"");
                txtXL1.setText(mangSinhVien.get(pos).getChucVu());

            }
        });
        btnXem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mode=0;
                Intent My_Intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("mode",mode);
                bundle.putString("Ho Ten",mangSinhVien.get(pos).getHoTen());
                bundle.putInt("Ma Sinh Vien",mangSinhVien.get(pos).getMaSV());
                bundle.putInt("Nam Sinh",mangSinhVien.get(pos).getNamSinh());
                bundle.putString("Lop",mangSinhVien.get(pos).getLop());
                bundle.putDouble("Diem",mangSinhVien.get(pos).getDiem());
                bundle.putString("Chuc Vu",mangSinhVien.get(pos).getChucVu());
                bundle.putInt("postition",pos);
                My_Intent.putExtra("du lieu",bundle);
                startActivityForResult(My_Intent,1);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode =1;
                Intent My_Intent = new Intent(MainActivity.this, Main2Activity.class);
                int position = 0;
                SinhVien sinhvienTG =  new SinhVien();
                mangSinhVien.add(0,sinhvienTG);
                Bundle bundle = new Bundle();
                bundle.putInt("mode",mode);
                bundle.putString("Ho Ten","");
                bundle.putInt("Ma Sinh Vien",position);
                bundle.putInt("Nam Sinh",position);
                bundle.putString("Lop","");
                bundle.putDouble("Diem",position);
                bundle.putInt("Hinh",position);
                bundle.putString("Chuc Vu","không");
                bundle.putInt("postition",position);
                My_Intent.putExtra("du lieu",bundle);
                startActivityForResult(My_Intent,1);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Bundle bundle2 = data.getBundleExtra("BundleRespond");
                int ViTri = bundle2.getInt("ViTri");
                mangSinhVien.get(ViTri).setHoTen(bundle2.getString("Ho Ten"));
                mangSinhVien.get(ViTri).setMaSV(bundle2.getInt("Ma Sinh Vien"));
                mangSinhVien.get(ViTri).setNamSinh(bundle2.getInt("Nam Sinh"));
                mangSinhVien.get(ViTri).setLop(bundle2.getString("Lop"));
                mangSinhVien.get(ViTri).setDiem(bundle2.getDouble("Diem"));
                mangSinhVien.get(ViTri).setChucVu(bundle2.getString("Chuc Vu"));
            }
            if (resultCode == 2) {
                Bundle bundle2 = data.getBundleExtra("BundleRespond1");
                int ViTri = bundle2.getInt("ViTri");
                Toast.makeText(MainActivity.this," đã xóa Sinh Viên"+mangSinhVien.get(ViTri).getHoTen(),Toast.LENGTH_SHORT).show();
                mangSinhVien.remove(ViTri);
            }
        }

    }
}
