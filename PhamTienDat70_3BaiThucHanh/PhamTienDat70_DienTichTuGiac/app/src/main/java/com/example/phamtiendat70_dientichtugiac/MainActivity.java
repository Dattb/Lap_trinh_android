package com.example.phamtiendat70_dientichtugiac;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXoa, btnTinh;
    TextView txtKT, txtS;
    EditText edtXA, edtXB, edtXC, edtYA, edtYB, edtYC, edtXD, edtYD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(" tính Diện tích tứ giác ");
        btnXoa = findViewById(R.id.btnXoa);
        btnTinh = findViewById(R.id.btnTinh);
        txtKT = findViewById(R.id.txtKT);
        txtS = findViewById(R.id.txtS);
        edtXA = findViewById(R.id.edtXA);
        edtXB = findViewById(R.id.edtXB);
        edtXC = findViewById(R.id.edtXC);
        edtYA = findViewById(R.id.edtYA);
        edtYB = findViewById(R.id.edtYB);
        edtYC = findViewById(R.id.edtYC);
        edtXD = findViewById(R.id.edtXD);
        edtYD = findViewById(R.id.edtYD);


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Thực hiện xóa", Toast.LENGTH_LONG).show();
                txtKT.setText(" chu vi");
                txtS.setText("dien tich");
                edtXA.setText("");
                edtXA.setHint(" Toa DO XA");
                edtXB.setText("");
                edtXB.setHint(" Toa DO XB");
                edtXC.setText("");
                edtXC.setHint(" Toa DO XC");
                edtYA.setText("");
                edtYA.setHint(" Toa DO YA");
                edtYB.setText("");
                edtYB.setHint(" Toa DO YB");
                edtYC.setText("");
                edtYC.setHint(" Toa DO YC");
                edtXD.setText("");
                edtXD.setHint(" Toa DO XD");
                edtYD.setText("");
                edtYD.setHint(" Toa DO YD");
            }
        });
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtXA.getText().toString().equals("") || edtYA.getText().toString().equals("") ||
                        edtXB.getText().toString().equals("") || edtYB.getText().toString().equals("") ||
                        edtXC.getText().toString().equals("") || edtYC.getText().toString().equals("") ||
                        edtXD.getText().toString().equals("") || edtYD.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "chưa nhập đủ dữ liệu", Toast.LENGTH_LONG).show();
                else
                {
                    Diem A = new Diem(Double.parseDouble(edtXA.getText().toString()), Double.parseDouble(edtYA.getText().toString()));
                Diem B = new Diem(Double.parseDouble(edtXB.getText().toString()), Double.parseDouble(edtYB.getText().toString()));
                Diem C = new Diem(Double.parseDouble(edtXC.getText().toString()), Double.parseDouble(edtYC.getText().toString()));
                Diem D = new Diem(Double.parseDouble(edtXD.getText().toString()), Double.parseDouble(edtYD.getText().toString()));
                TuGiac ABCD = new TuGiac(A, B, C, D);
                double KiemTra;
                double DTich;
                if (ABCD.kiem_tra_tu_giac() != 0)
                   {
                    txtKT.setText("đúng");
                    DTich = ABCD.kiem_tra_tu_giac();
                    txtS.setText(String.format("%.2f", DTich));
                    //txtS.setText(DTich+"");
                   } else {
                      txtKT.setText("sai");
                    //Toast.makeText(this, "tọa độ 4 điểm không tạo thành tứ giác", Toast.LENGTH_LONG).show();
                     txtS.setText("dien tich");
                       }
                }
            }
        });
    }

//    public void tinhtoan(View view) {
//        Toast.makeText(this, " Thực hiện tính toán CV và DT", Toast.LENGTH_LONG).show();
//        Diem A = new Diem();
//        Diem B = new Diem();
//        Diem C = new Diem();
//        Diem D = new Diem();
//
////        try {
////            Diem A1 = new Diem(Double.parseDouble(edtXA.getText().toString()), Double.parseDouble(edtYA.getText().toString()));
////            A = A1;
////        } catch (NumberFormatException e) {
////            Toast.makeText(this, "Nhập Lại Tọa Độ A", Toast.LENGTH_LONG).show();
////        }
////        try {
////            Diem B1 = new Diem(Double.parseDouble(edtXB.getText().toString()), Double.parseDouble(edtYB.getText().toString()));
////            B = B1;
////        } catch (NumberFormatException e) {
////            Toast.makeText(this, "Nhập Lại Tọa Độ B", Toast.LENGTH_LONG).show();
////        }
////        try {
////            Diem C1 = new Diem(Double.parseDouble(edtXC.getText().toString()), Double.parseDouble(edtYC.getText().toString()));
////
////        } catch (NumberFormatException e) {
////            Toast.makeText(this, "Nhập Lại Tọa Độ C", Toast.LENGTH_LONG).show();
////
////        }
////        try {
////            Diem D1 = new Diem(Double.parseDouble(edtXA.getText().toString()), Double.parseDouble(edtYA.getText().toString()));
////            A = D1;
////        } catch (NumberFormatException e) {
////            Toast.makeText(this, "Nhập Lại Tọa Độ D", Toast.LENGTH_LONG).show();
////
////        }
//        btnTinh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Diem A = new Diem(Double.parseDouble(edtXA.getText().toString()), Double.parseDouble(edtYA.getText().toString()));
//                Diem B = new Diem(Double.parseDouble(edtXB.getText().toString()), Double.parseDouble(edtYB.getText().toString()));
//                Diem C = new Diem(Double.parseDouble(edtXC.getText().toString()), Double.parseDouble(edtYC.getText().toString()));
//                Diem D = new Diem(Double.parseDouble(edtXD.getText().toString()), Double.parseDouble(edtYD.getText().toString()));
//                HCN ABCD = new HCN(A, B, C, D);
//                double ChuVi;
//                double DTich;
//                ChuVi = ABCD.chieudaidoanthang(C,D);
//                DTich = ABCD.kiem_tra_tu_giac();
//                txtP.setText(String.format("%.2f",ChuVi ));
//                txtS.setText(String.format("%.2f", DTich));
//
//            }
//        });
//
//
//
//
//    }

}


