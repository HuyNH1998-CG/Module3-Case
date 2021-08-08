package Controler;

import Dao.ManageMySQL;
import Model.PhanLoai;
import Model.SanPham;
//import Service.PhanLoaiService;
import Service.PhanLoaiService;
import Service.SanPhamService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class ManageSanPham extends HttpServlet {
    ManageMySQL manageMySQL = new ManageMySQL();
    SanPhamService sanPhamService = new SanPhamService();
    PhanLoaiService phanLoaiService =new PhanLoaiService();

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
                int indexDelete = Integer.parseInt(req.getParameter("index"));
                try {
                    sanPhamService.deleteSp(indexDelete);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/");
                break;
            case "edit":
                int indexEdit=Integer.parseInt(req.getParameter("index"));
                req.setAttribute("IndexEdit",sanPhamService.list.get(indexEdit));
                requestDispatcher=req.getRequestDispatcher("Views/EditSp.jsp");
                requestDispatcher.forward(req, resp);
            case "FindByLoai":
                String loai = req.getParameter("findLoai");
                try {
                    req.setAttribute("listSp", SanPhamService.FindByLoai(loai));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                requestDispatcher = req.getRequestDispatcher("Views/HomeAdmin.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case "Show":
                int cateID=Integer.parseInt(req.getParameter("id"));
                ManageMySQL manageMySQL = new ManageMySQL();
                try {
                    SanPham Sp=manageMySQL.ShowSp(cateID);
                    req.setAttribute("Sp",Sp);
                    requestDispatcher = req.getRequestDispatcher("Views/ShowSp.jsp");
                    requestDispatcher.forward(req, resp);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                req.setAttribute("listSp", SanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("Views/Home.jsp");
                requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String actionSp = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (actionSp == null) {
            actionSp = "";
        }
        switch (actionSp) {
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String ten = req.getParameter("ten");
                float gia = Float.parseFloat(req.getParameter("gia"));
                String moTa = req.getParameter("mota");
                String hinhAnh = req.getParameter("hinhanh");
                String phanloai = req.getParameter("phanloai");
                String trongKho = req.getParameter("trongKho");
                String status = req.getParameter("status");
                SanPham sanPham = new SanPham(id, ten, gia, moTa, hinhAnh, phanloai, trongKho, status);

                try {
                    sanPhamService.saveSp(sanPham);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/");
                break;

            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                String tenEdit = req.getParameter("ten");
                float giaEdit = Float.parseFloat(req.getParameter("gia"));
                String moTaEdit = req.getParameter("mota");
                String hinhAnhEdit = req.getParameter("hinhanh");
                String phanloaiEdit = req.getParameter("phanloai");
                String trongKhoEdit = req.getParameter("trongKho");
                String statusEdit = req.getParameter("status");
                SanPham sanPhamEdit = new SanPham(idEdit, tenEdit, giaEdit, moTaEdit, hinhAnhEdit, phanloaiEdit, trongKhoEdit, statusEdit);

                try {
                    sanPhamService.editSp(idEdit,sanPhamEdit);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                resp.sendRedirect("/");
                break;

            default:
                req.setAttribute("ListPl", PhanLoaiService.listpl);
                req.setAttribute("ListSp", SanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("Views/Home.jsp");
                requestDispatcher.forward(req, resp);
        }
    }
}
