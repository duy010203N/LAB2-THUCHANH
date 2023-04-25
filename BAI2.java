package BAI2;
import org.w3c.dom.ls.LSOutput;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
public class Album {
    //khai báo các thuộc tính
    private int maCD;
    private String tenCD;
    private String caSy;
    private int soBH;
    private float giaThanh;
    //khởi tạo constructor mặc định
    public Album() {
    }
    //khởi tạo constructor có tham số
    public Album(int cD, String tenCD, String caSy, int soBH, float giaThanh) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.caSy = caSy;
        this.soBH = soBH;
        this.giaThanh = giaThanh;
    }
    //------------begin getter and setter--------------
    public int getMaCD() {
        return maCD;
    }
 
    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }
 
    public String getTenCD() {
        return tenCD;
    }
 
    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }
 
    public String getCaSy() {
        return caSy;
    }
 
    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }
 
    public int getSoBH() {
        return soBH;
    }
 
    public void setSoBH(int soBH) {
        this.soBH = soBH;
    }
 
    public float getGiaThanh() {
        return giaThanh;
    }
 
    public void setGiaThanh(float giaThanh) {
        this.giaThanh = giaThanh;
    }
    //------------end getter and setter--------------
    @Override
    public String toString() {
        return "Album{" +
                "cD=" + maCD +
                ", tenCD='" + tenCD +  
                ", caSy='" + caSy + 
                ", soBH=" + soBH +
                ", giaThanh=" + giaThanh +
                '}';
    }
    //khởi tạo phương thức hiện thị theo format
    public void hienThiAlbum(){
        System.out.printf("%-10d %-20s %-20s %-10d %-20.1f \n",maCD,tenCD,caSy,soBH,giaThanh);
    }
 
}
 class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapAlbum(Album ab) {
        System.out.print("Nhập mã CD: ");
        ab.setMaCD(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập tên CD : ");
        ab.setTenCD(sc.nextLine());
        System.out.print("Nhập tên ca sĩ : ");
        ab.setCaSy(sc.nextLine());
        System.out.print("Nhập số lượng bài hát : ");
        ab.setSoBH(sc.nextInt());
        System.out.print("Nhập giá thành : ");
        ab.setGiaThanh(sc.nextFloat());
    }
    public static void main(String[] args) {
        Album alb[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("Bạn chọn làm gì?");
            System.out.println("1.Nhập thông tin CD \n" +
                    "2.Xuất danh sách Album.\n" + "3.Tính tổng giá thành \n" + "4.Tổng số lượng CD \n" +
                    "5.Sắp xếp giảm dần theo giá thành\n"+"6.Sắp xếp tăng dần theo tựa CD\n"+"Nhập số khác để thoát");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Nhập số lượng CD : ");
                    n = sc.nextInt();
                    alb = new Album[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("CD thứ " + (i + 1)+": ");
                        alb[i] = new Album();
                        nhapAlbum(alb[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s %-10s %-20s \n", "Mã CD", "Tên CD", "Tên ca sỹ", "Số bài hát", "Giá thành");
                    for (int i = 0; i < n; i++) {
                        alb[i].hienThiAlbum();
                    }
                    break;
                case 3:
                    int tong = 0;
                    for (int i = 0; i < n; i++) {
                        tong += alb[i].getGiaThanh();
                    }
                    System.out.println("" +
                            "Tổng giá thành là : " + tong);
                    break;
                case 4:
                    System.out.println("Tổng số lượng CD là : " + n);
                    break;
                case 5:
                    Album temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp thành công, Nhập số 2 để kiểm tra!");
                    break;
                case 6:
                    temp = alb[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (alb[i].getTenCD().compareTo(alb[j].getTenCD())>0) {
                                temp = alb[j];
                                alb[j] = alb[i];
                                alb[i] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp thành công, Nhập số 2 để kiểm tra!");
                    break;
                default:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
            }
        }while (flag) ;
    }
}
