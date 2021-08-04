package Model;

public class DonHang extends SanPham{
    private int orderID;
    private int userid;
    private int productid;
    private float total;

    public DonHang() {
    }

    public DonHang(int orderID, int userid, int productid, float total) {
        this.orderID = orderID;
        this.userid = userid;
        this.productid = productid;
        this.total = total;
    }

    public DonHang(int userid, int productid, float total) {
        this.userid = userid;
        this.productid = productid;
        this.total = total;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
