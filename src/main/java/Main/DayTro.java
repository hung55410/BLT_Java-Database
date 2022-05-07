package Main;

public class DayTro{
    private String MaDayTro;
    private String TenDayTro;
    private int SLphong;
    private String DiaChi;
    private String madinhdanh;
    public String getMadinhdanh() {
        return madinhdanh;
    }

    public void setMadinhdanh(String madinhdanh) {
        this.madinhdanh = madinhdanh;
    }

    public DayTro(String maDayTro, String tenDayTro, int SLphong, String diaChi) {
        MaDayTro = maDayTro;
        TenDayTro = tenDayTro;
        this.SLphong = SLphong;
        DiaChi = diaChi;
    }
    public DayTro(String maDayTro, String tenDayTro, int SLphong, String diaChi, String madinhdanh) {
        MaDayTro = maDayTro;
        TenDayTro = tenDayTro;
        this.SLphong = SLphong;
        DiaChi = diaChi;
        this.madinhdanh = madinhdanh;
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
