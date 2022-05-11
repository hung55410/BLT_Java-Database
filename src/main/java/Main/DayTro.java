package Main;

public class DayTro{
    private String MaDayTro;
    private String TenDayTro;
    private Integer SLphong;
    private String DiaChi;
    private String madinhdanh;

    public DayTro(String maDayTro, String tenDayTro, Integer SLphong, String diaChi, String madinhdanh) {
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

    public Integer getSLphong() {
        return SLphong;
    }

    public void setSLphong(Integer SLphong) {
        this.SLphong = SLphong;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getMadinhdanh() {
        return madinhdanh;
    }

    public void setMadinhdanh(String madinhdanh) {
        this.madinhdanh = madinhdanh;
    }
}
