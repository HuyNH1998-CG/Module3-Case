package Controler;

import Dao.ManageMySQL;
import Model.PhanLoai;
import Model.SanPham;
//import Service.PhanLoaiService;
import Service.SanPhamService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class ManageSanPham extends HttpServlet {
    ManageMySQL manageMySQL=new ManageMySQL();
    SanPhamService sanPhamService=new SanPhamService();



    @Override
    public void init(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionSp = req.getParameter("action");
        RequestDispatcher requestDispatcher;


        if (actionSp == null) {
            actionSp = "";
        }
        switch (actionSp) {
            case "create":
                resp.sendRedirect("/Views/CreateSanPham.jsp");
                break;
            case "delete":
            case "edit":
            case "FindByLoai":
            default:ArrayList<SanPham> list=new ArrayList<>();
                try {
                    list= (ArrayList<SanPham>) manageMySQL.Select();
                } catch (Exception e) {
                    e.printStackTrace();
                } req.setAttribute("listSp", list);
                requestDispatcher = req.getRequestDispatcher("Views/HomeAdmin.jsp");
                requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<SanPham> list = null;


        String actionSp = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (actionSp == null) {
            actionSp = "";
        }
        switch (actionSp) {
            case "create":
                int id=Integer.parseInt(req.getParameter("id"));
                String ten=req.getParameter("ten");
                float gia=Float.parseFloat("gia");
                String moTa=req.getParameter("mota");
                String hinhAnh=req.getParameter("hinhanh");
                String phanloai=req.getParameter("phanloai");
                String trongKho=req.getParameter("trongKho");
                String status=req.getParameter("status");
                SanPham sanPham=new SanPham(id,ten,gia,moTa,hinhAnh,phanloai,trongKho,status);

                sanPhamService.saveSp(sanPham);
                resp.sendRedirect("/");
                break;

            case "edit":
            default:
//                req.setAttribute("ListPl", PhanLoaiService.listpl);
                req.setAttribute("ListSp", SanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("Views/HomeAdmin.jsp");
                requestDispatcher.forward(req, resp);
        }
    }
}
