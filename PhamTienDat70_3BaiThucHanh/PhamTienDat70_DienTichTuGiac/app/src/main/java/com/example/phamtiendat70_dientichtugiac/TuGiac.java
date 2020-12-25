package com.example.phamtiendat70_dientichtugiac;



public class TuGiac {
    private  Diem A,B,C,D;

    public TuGiac(Diem a, Diem b, Diem c, Diem d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public TuGiac() {
    }

    public Diem getA() {
        return A;
    }

    public void setA(Diem a) {
        A = a;
    }

    public Diem getB() {
        return B;
    }

    public void setB(Diem b) {
        B = b;
    }

    public Diem getC() {
        return C;
    }

    public void setC(Diem c) {
        C = c;
    }

    public Diem getD() {
        return D;
    }

    public void setD(Diem d) {
        D = d;
    }
    double chieudaidoanthang (Diem a, Diem b)
    {
        double chieudai;
        chieudai = Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));
        return  chieudai;
    }
//  public double chieudaidoanthang (Diem a, Diem b)
//  {
//    double chieu_dai;
//    chieu_dai= Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));
//    return chieu_dai;
//  }

    public  double kiem_tra_tu_giac ()
    {
        double KQ1,KQ2,KQ3,KQ4;
        KQ1 = ( D.getX()-A.getX())/(C.getX()-A.getX())-( D.getY()-A.getY())/(C.getY()-A.getY());
        KQ2 = ( B.getX()-A.getX())/(C.getX()-A.getX())-(  B.getY()-A.getY())/(C.getY()-A.getY());
        KQ3 = (  A.getX()-B.getX())/(D.getX()-B.getX())-( A.getY()-B.getY())/(D.getY()-B.getY());
        KQ4 = (  C.getX()-B.getX())/(D.getX()-B.getX())-( C.getY()-B.getY())/(D.getY()-B.getY());
        if (KQ1*KQ2<0&&KQ3*KQ4<0)
        {
            double NCV1 = ((chieudaidoanthang(A, B) + chieudaidoanthang(A, C) + chieudaidoanthang(B, C))) / 2;
            double NCV2 = (chieudaidoanthang(A, C) + chieudaidoanthang(A, D) + chieudaidoanthang(C, D)) / 2;
            return Math.sqrt(NCV1 * (NCV1 - chieudaidoanthang(A, B)) * (NCV1 - chieudaidoanthang(A, C)) * (NCV1 - chieudaidoanthang(B, C)))
                    +Math.sqrt(NCV2 * (NCV2 - chieudaidoanthang(A, D)) * (NCV1 - chieudaidoanthang(A, C)) * (NCV1 - chieudaidoanthang(D, C)));
        }
        else if (KQ1*KQ2>0&&KQ3*KQ4>0)
        {
            double  NCV1 = ((chieudaidoanthang(A,C) +chieudaidoanthang(C,D)+chieudaidoanthang(D,A)))/2;
            double  NCV2= (chieudaidoanthang(C,D) +chieudaidoanthang(D,B)+chieudaidoanthang(B,C))/2;
            return Math.sqrt(NCV1*(NCV1-chieudaidoanthang(A,C))*(NCV1-chieudaidoanthang(C,D))*(NCV1-chieudaidoanthang(D,A)))
                    + Math.sqrt(NCV2*(NCV2-chieudaidoanthang(C,D))*(NCV2-chieudaidoanthang(D,B))*(NCV2-chieudaidoanthang(B,C)));
        }
        else return 0;

    }

}
