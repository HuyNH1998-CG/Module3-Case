package Model;

public class SanPham {
    private int id;
    private String ten;
    private float gia;
    private String mota;
    private String hinhanh;
    private String phanloai;

    public SanPham() {
    }

    public SanPham(String ten, float gia, String mota, String hinhanh, String phanloai) {
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
        this.hinhanh = hinhanh;
        this.phanloai = phanloai;
    }

    public SanPham(int id, String ten, float gia, String mota, String hinhanh, String phanloai) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.mota = mota;
        this.hinhanh = hinhanh;
        this.phanloai = phanloai;
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
}
