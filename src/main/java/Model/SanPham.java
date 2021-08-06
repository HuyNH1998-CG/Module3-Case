package Model;

public class SanPham {
    private int id;
    private String ten;
    private float gia;
    private String mota;
    private String hinhanh;
    private String phanloai;
    private String trongKho;
    private String status;

    public SanPham() {
    }

    public SanPham(int id, String ten, float gia, String mota, String hinhanh, String phanloai, String trongKho, String status) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
        this.hinhanh = hinhanh;
        this.phanloai = phanloai;
        this.trongKho = trongKho;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public String getTrongKho() {
        return trongKho;
    }

    public void setTrongKho(String trongKho) {
        this.trongKho = trongKho;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
