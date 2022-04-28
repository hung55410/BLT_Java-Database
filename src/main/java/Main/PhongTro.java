package Main;

public class PhongTro {
    private String MaPhongTro;
    private String TenPhongTro;
    private Integer SoNguoiTro;
    private String GiaPhongTro;

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
