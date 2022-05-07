package Main;

public class KhachHang {
    private String HoTenKhachHang;
    private String CCCD;
    private String GT;
    private String SDT;
    private String QueQuan;
    private String NgayBatDauO;
    private String MaPhongTro;

    public String getHoTenKhachHang() {
        return HoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        HoTenKhachHang = hoTenKhachHang;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getNgayBatDauO() {
        return NgayBatDauO;
    }

    public void setNgayBatDauO(String ngayBatDauO) {
        NgayBatDauO = ngayBatDauO;
    }

    public String getMaPhongTro() {
        return MaPhongTro;
    }

    public void setMaPhongTro(String maPhongTro) {
        MaPhongTro = maPhongTro;
    }

    public KhachHang(String hoTenKhachHang, String CCCD, String GT, String SDT, String queQuan, String ngayBatDauO, String maPhongTro) {
        HoTenKhachHang = hoTenKhachHang;
        this.CCCD = CCCD;
        this.GT = GT;
        this.SDT = SDT;
        QueQuan = queQuan;
        NgayBatDauO = ngayBatDauO;
        MaPhongTro = maPhongTro;
    }
}
