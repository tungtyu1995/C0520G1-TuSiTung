package bai_thi;

// Giá xuất khẩu, Quốc gia nhập sản phẩm.
public class SanPhamXuatKhau extends SanPham {
    double giaXuatKhau;
    String quocGiaNhapSanPham;

    public SanPhamXuatKhau() {
        super();
    }

    public SanPhamXuatKhau(double giaXuatKhau, String quocGiaNhapSanPham) {
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public SanPhamXuatKhau( String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaXuatKhau, String quocGiaNhapSanPham) {
        super( maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return "SanPhamXuatKhau{" +
                ", id ='" + id + '\'' +
                ", maSanPham ='" + maSanPham + '\'' +
                ", tenSanPham ='" + tenSanPham + '\'' +
                ", giaBan =" + giaBan +
                ", soLuong =" + soLuong +
                ", nhaSanXuat ='" + nhaSanXuat + '\'' +
                "giaXuatKhau =" + giaXuatKhau +
                ", quocGiaNhapSanPham ='" + quocGiaNhapSanPham + '\'' +
                '}';
    }
}
