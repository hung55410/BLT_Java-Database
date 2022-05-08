package Main;

public class PhongTro {
    private String MaPhongTro;
    private String TenPhongTro;
    private Integer SoNguoiTro;
    private String GiaPhongTro;
    private String MaDayTro;

    public PhongTro(String maPhongTro, String tenPhongTro, Integer soNguoiTro, String giaPhongTro, String maDayTro) {
        MaPhongTro = maPhongTro;
        TenPhongTro = tenPhongTro;
        SoNguoiTro = soNguoiTro;
        GiaPhongTro = giaPhongTro;
        MaDayTro = maDayTro;
    }

    public String getMaDayTro() {
        return MaDayTro;
    }

    public void setMaDayTro(String maDayTro) {
        MaDayTro = maDayTro;
    }

    public PhongTro(String maPhongTro, String tenPhongTro, Integer soNguoiTro, String giaPhongTro) {
        MaPhongTro = maPhongTro;
        TenPhongTro = tenPhongTro;
        SoNguoiTro = soNguoiTro;
        GiaPhongTro = giaPhongTro;
    }

    public String getMaPhongTro() {
        return MaPhongTro;
    }

    public void setMaPhongTro(String maPhongTro) {
        MaPhongTro = maPhongTro;
    }

    public String getTenPhongTro() {
        return TenPhongTro;
    }

    public void setTenPhongTro(String tenPhongTro) {
        TenPhongTro = tenPhongTro;
    }

    public Integer getSoNguoiTro() {
        return SoNguoiTro;
    }

    public void setSoNguoiTro(Integer soNguoiTro) {
        SoNguoiTro = soNguoiTro;
    }

    public String getGiaPhongTro() {
        return GiaPhongTro;
    }

    public void setGiaPhongTro(String giaPhongTro) {
        GiaPhongTro = giaPhongTro;
    }
}
