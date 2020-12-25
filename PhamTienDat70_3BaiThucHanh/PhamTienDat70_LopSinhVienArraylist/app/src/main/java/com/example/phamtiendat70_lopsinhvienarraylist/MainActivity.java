package com.example.phamtiendat70_lopsinhvienarraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtTen,edtDiem,edtMSV,edtNS,edtLop,edtXL,edtCV;
    TextView txtSTT;
    Button btnLui,btnTien,btnLuu,btnXoa,btnThem;
    ArrayList LopSV,B;
    SinhVien A;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(" Quản Lý Sinh Viên");
        edtTen= findViewById(R.id.edtTen);
        edtMSV= findViewById(R.id.edtMSV);
        edtLop= findViewById(R.id.edtLop);
        edtNS= findViewById(R.id.edtNS);
        edtDiem= findViewById(R.id.edtDiem);
        edtXL= findViewById(R.id.edtXL);
        edtCV= findViewById(R.id.edtCV);
        txtSTT = findViewById(R.id.txtSTT);
        btnTien =(Button) findViewById(R.id.btnTien);
        btnLui =(Button) findViewById(R.id.btnLui);
        btnLuu =(Button) findViewById(R.id.btnLuu);
        btnXoa =(Button) findViewById(R.id.btnXoa);
        btnThem =(Button) findViewById(R.id.btnThem);
        final List <SinhVien> LopSV = new ArrayList();
        A = new SinhVien("Pham Tien Dat",0001,1998,"KTDT$THCN",6.0,"không");
        LopSV.add(A);
        edtTen.setText(LopSV.get(0).getHoTen());
        edtMSV.setText(LopSV.get(0).getMaSV()+"");
        edtLop.setText(LopSV.get(0).Lop);
        edtNS.setText(LopSV.get(0).getNamSinh()+"");
        edtDiem.setText(LopSV.get(0).getDiem()+"");
        edtCV.setText(LopSV.get(0).getChucVu());
        edtXL.setText(LopSV.get(0).DanhGiaSinhVien());
        txtSTT.setText(pos+1+"");
        LopSV.add(new SinhVien("Nguyen Van A",0001,1996,"KTDT$THCN",8.0,"lop truong"));
        LopSV.add(new SinhVien("Nguyen Van B",0002,1997,"KTDT$THCN",7.0,"lop pho"));
        LopSV.add(new SinhVien("Nguyen Van C",0003,1998,"KTDT$THCN",6.0,"bi thu"));
        LopSV.add(new SinhVien("Nguyen Van D",0004,1999,"KTDT$THCN",5.0,"không"));

        btnTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos+=1;
                if (pos>(LopSV.size()-1)) pos-=1;
                txtSTT.setText(pos+1+"");

                edtTen.setText(LopSV.get(pos).getHoTen());
                edtMSV.setText(LopSV.get(pos).getMaSV()+"");
                edtLop.setText(LopSV.get(pos).Lop);
                edtNS.setText(LopSV.get(pos).getNamSinh()+"");
                edtDiem.setText(LopSV.get(pos).getDiem()+"");
                edtCV.setText(LopSV.get(pos).getChucVu());
                edtXL.setText(LopSV.get(pos).DanhGiaSinhVien());

            }
        });
        btnLui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos-=1;
                if (pos<0) pos+=1;
                txtSTT.setText(pos+1+"");
                edtTen.setText(LopSV.get(pos).getHoTen());
                edtMSV.setText(LopSV.get(pos).getMaSV()+"");
                edtLop.setText(LopSV.get(pos).Lop);
                edtNS.setText(LopSV.get(pos).getNamSinh()+"");
                edtDiem.setText(LopSV.get(pos).getDiem()+"");
                edtCV.setText(LopSV.get(pos).getChucVu());
                edtXL.setText(LopSV.get(pos).DanhGiaSinhVien());

            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTen.getText().toString().equals("")||edtMSV.getText().toString().equals("")||
                        edtLop.getText().toString().equals("")||edtNS.getText().toString().equals("")||
                        edtDiem.getText().toString().equals("")||edtCV.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this,"chưa nhập đủ thông tin",Toast.LENGTH_LONG).show();
                else {
                    LopSV.get(pos).setHoTen(edtTen.getText() + "");
                    LopSV.get(pos).setLop(edtLop.getText() + "");
                    LopSV.get(pos).setNamSinh(Integer.parseInt(edtNS.getText().toString()));
                    LopSV.get(pos).setDiem(Double.parseDouble(edtDiem.getText().toString()));
                    LopSV.get(pos).setChucVu(edtCV.getText() + "");
                    LopSV.get(pos).setMaSV(Integer.parseInt(edtMSV.getText().toString()));

                    edtXL.setText(LopSV.get(pos).DanhGiaSinhVien());

                }

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hiển thị sinh viên phía sau lên trước khi xóa sinh viên hiện tại

                edtTen.setText(LopSV.get(pos+1).getHoTen());
                edtMSV.setText(LopSV.get(pos+1).getMaSV()+"");
                edtLop.setText(LopSV.get(pos+1).Lop);
                edtNS.setText(LopSV.get(pos+1).getNamSinh()+"");
                edtDiem.setText(LopSV.get(pos+1).getDiem()+"");
                edtCV.setText(LopSV.get(pos+1).getChucVu());
                edtXL.setText(LopSV.get(pos+1).DanhGiaSinhVien());

                LopSV.remove(pos);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=0;
                txtSTT.setText(pos+1+"");
                SinhVien O = new SinhVien();
                LopSV.add(0,O);

                edtTen.setText("");
                edtMSV.setText("");
                edtLop.setText("");
                edtNS.setText("");
                edtDiem.setText("");
                edtCV.setText("");
                edtXL.setText("");
            }
        });


    }
}



