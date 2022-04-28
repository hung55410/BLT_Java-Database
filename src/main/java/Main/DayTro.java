package Main;

public class DayTro{
    private String MaDayTro;
    private String TenDayTro;
    private int SLphong;
    private String DiaChi;

    public DayTro(String maDayTro, String tenDayTro, int SLphong, String diaChi) {
        MaDayTro = maDayTro;
        TenDayTro = tenDayTro;
        this.SLphong = SLphong;
        DiaChi = diaChi;
    }

    public String getMaDayTro() {
        return MaDayTro;
    }

    public void setMaDayTro(String maDayTro) {
        MaDayTro = maDayTro;
    }

    public String getTenDayTro() {
        return TenDayTro;
    }

    public void setTenDayTro(String tenDayTro) {
        TenDayTro = tenDayTro;
    }

    public int getSLphong() {
        return SLphong;
    }

    public void setSLphong(int SLphong) {
        this.SLphong = SLphong;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
