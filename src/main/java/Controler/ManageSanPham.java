package Controler;

import Dao.ManageMySQL;
import Model.GioHang;
import Model.KhachHang;
import Model.PhanLoai;
import Model.SanPham;
//import Service.PhanLoaiService;
import Service.SanPhamService;
import models.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class ManageSanPham extends HttpServlet {
    ManageMySQL manageMySQL = new ManageMySQL();
    SanPhamService sanPhamService = new SanPhamService();

    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String actionSp = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (actionSp == null) {
            actionSp = "";
        }
        HttpSession session = req.getSession();
        Account user = (Account) session.getAttribute("user");
        switch (actionSp) {
            case "create":
                resp.sendRedirect("/views/CreateSanPham.jsp");
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                try {
                    manageMySQL.deletePrd(id);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                resp.sendRedirect("/");
                break;
            case "edit":
                int editid = Integer.parseInt(req.getParameter("id"));
                SanPham edit = null;
                try {
                    edit = manageMySQL.getSanPhamById(editid);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                req.setAttribute("edit", edit);
                requestDispatcher = req.getRequestDispatcher("/views/EditSp.jsp");
                requestDispatcher.forward(req, resp);
                break;
            default:
                Default(req, resp, user);
        }

    }

    private void Default(HttpServletRequest req, HttpServletResponse resp, Account user) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            list = (ArrayList<SanPham>) manageMySQL.Select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("listSp", list);
        if (user != null) {
            if (user.getRole().equals("admin")) {
                requestDispatcher = req.getRequestDispatcher("views/HomeAdmin.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                requestDispatcher = req.getRequestDispatcher("views/Home.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            requestDispatcher = req.getRequestDispatcher("views/Home.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<SanPham> list = null;
        String actionSp = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (actionSp == null) {
            actionSp = "";
        }
        switch (actionSp) {
            case "create":
                String ten = req.getParameter("name");
                float gia = Float.parseFloat(req.getParameter("price"));
                String moTa = req.getParameter("desc");
                String hinhAnh = req.getParameter("image");
                int phanloai = Integer.parseInt(req.getParameter("category"));
                int trongKho = Integer.parseInt(req.getParameter("amount"));
                sanPhamService.saveSp(ten, gia, moTa, hinhAnh, phanloai, trongKho);
                resp.sendRedirect("/");
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                String tenEdit = req.getParameter("ten");
                float giaEdit = Float.parseFloat(req.getParameter("gia"));
                String moTaEdit = req.getParameter("mota");
                String hinhAnhEdit = req.getParameter("hinhanh");
                int phanloaiedit = Integer.parseInt(req.getParameter("phanloai"));
                int trongKhoedit = Integer.parseInt(req.getParameter("trongKho"));
                try {
                    manageMySQL.edit(idEdit, tenEdit, giaEdit, moTaEdit, hinhAnhEdit, phanloaiedit, trongKhoedit);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                resp.sendRedirect("/");
                break;
            case "FindByLoai":
                try {
                    searchProduct2(req, resp);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                break;
            default:
                req.setAttribute("ListSp", SanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("views/HomeAdmin.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    private void searchProduct2(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        List<SanPham> list = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        if (id > 0) {
            list = manageMySQL.getSanPhamByCatName(id, name);
        } else {
            list = manageMySQL.getSanPhamByName(name);
        }
        ArrayList<GioHang> gioHangs = (ArrayList<GioHang>) request.getSession().getAttribute("cart");
        if (gioHangs != null) {
            request.setAttribute("cart", gioHangs);
        }
        request.setAttribute("listSp", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Home.jsp");
        dispatcher.forward(request, response);
    }
}
