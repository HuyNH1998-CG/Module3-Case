package Controler;

import Dao.ManageMySQL;
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
            case "edit":
            case "FindByLoai":
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
                sanPhamService.saveSp(ten,gia,moTa,hinhAnh,phanloai,trongKho);
                resp.sendRedirect("/");
                break;
            case "edit":
            default:
                req.setAttribute("ListSp", SanPhamService.list);
                requestDispatcher = req.getRequestDispatcher("views/HomeAdmin.jsp");
                requestDispatcher.forward(req, resp);
        }
    }
}
