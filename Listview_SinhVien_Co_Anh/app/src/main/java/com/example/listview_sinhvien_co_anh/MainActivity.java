//デザイナー：Dat_Pham
// 完成時間：2:47 PM 24/5/2020
package com.example.listview_sinhvien_co_anh;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSV;
    Button btnAdd;
    ArrayList<SinhVien> mangSinhVien;
    SinhVienAdapter anAdapter;
    int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSV = findViewById(R.id.lvSV);
        btnAdd = findViewById(R.id.btnAdd);
        mangSinhVien = new ArrayList<SinhVien>();


        mangSinhVien.add(new SinhVien("Pham Tien Dat",1,1998,"KTDT$THCN",8.5,R.drawable.anh1,"lop truong"));
        mangSinhVien.add(new SinhVien("Nguyen Thi A",2,1998,"KTDT$THCN",8.8,R.drawable.anh2,"lop pho"));
        mangSinhVien.add(new SinhVien("Nguyen Thi B",3,1997,"KTDT$THCN",8.7,R.drawable.anh3,"bi thu"));
        mangSinhVien.add(new SinhVien("Nguyen Thi C",4,1999,"KTDT$THCN",9.0,R.drawable.anh4,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi D",5,1998,"KTDT$THCN",8.0,R.drawable.anh5,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi E",6,1997,"KTDT$THCN",7.0,R.drawable.anh6,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi F",7,1999,"KTDT$THCN",6.0,R.drawable.anh7,"không"));
        mangSinhVien.add(new SinhVien("Nguyen Thi G",8,1999,"KTDT$THCN",5.0,R.drawable.anh8,"không"));
         anAdapter = new SinhVienAdapter(
                MainActivity.this,
                R.layout.dong_sinh_vien,
                mangSinhVien
        );

        lvSV.setAdapter(anAdapter);

                lvSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mode=0;
                Toast.makeText(MainActivity.this,mangSinhVien.get(position).getHoTen(),Toast.LENGTH_SHORT).show();
                Intent My_Intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("mode",mode);
                bundle.putString("Ho Ten",mangSinhVien.get(position).getHoTen());
                bundle.putInt("Ma Sinh Vien",mangSinhVien.get(position).getMaSV());
                bundle.putInt("Nam Sinh",mangSinhVien.get(position).getNamSinh());
                bundle.putString("Lop",mangSinhVien.get(position).getLop());
                bundle.putDouble("Diem",mangSinhVien.get(position).getDiem());
                bundle.putInt("Hinh",mangSinhVien.get(position).getHinh());
                bundle.putString("Chuc Vu",mangSinhVien.get(position).getChucVu());
                bundle.putInt("postition",position);
               // bundle.putSerializable("xyz",mangSinhVien);
                My_Intent.putExtra("du lieu",bundle);
                startActivityForResult(My_Intent,1);
            }
        });
                lvSV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this," đã xóa Sinh Viên"+mangSinhVien.get(position).getHoTen(),Toast.LENGTH_SHORT).show();
                        mangSinhVien.remove(position);
                        anAdapter.notifyDataSetChanged();
                        return false;
                    }
                });

        btnAdd.setOnClickListener(new View.OnClickListener() {
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
                   mangSinhVien.get(ViTri).setHinh(bundle2.getInt("Hinh"));
                   mangSinhVien.get(ViTri).setChucVu(bundle2.getString("Chuc Vu"));
                   anAdapter.notifyDataSetChanged();
                   //Toast.makeText(getApplicationContext(), ViTri + "", Toast.LENGTH_LONG).show();

            }
            if (resultCode == 2) {
                Bundle bundle2 = data.getBundleExtra("BundleRespond1");
                int ViTri = bundle2.getInt("ViTri");
                Toast.makeText(MainActivity.this," đã xóa Sinh Viên"+mangSinhVien.get(ViTri).getHoTen(),Toast.LENGTH_SHORT).show();
                mangSinhVien.remove(ViTri);
                anAdapter.notifyDataSetChanged();
            }
            

        }

    }

}

