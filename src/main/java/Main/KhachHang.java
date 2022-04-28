package Main;

public class KhachHang {
    private String HoTenKhachHang;
    private String CCCD;
    private boolean GT;
    private String SDT;
    private String QueQuan;
    private String NgayBatDauO;

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

    public boolean isGT() {
        return GT;
    }

    public void setGT(boolean GT) {
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

    public KhachHang(String hoTenKhachHang, String CCCD, boolean GT, String SDT, String queQuan, String ngayBatDauO) {
        HoTenKhachHang = hoTenKhachHang;
        this.CCCD = CCCD;
        this.GT = GT;
        this.SDT = SDT;
        QueQuan = queQuan;
        NgayBatDauO = ngayBatDauO;
    }
}
