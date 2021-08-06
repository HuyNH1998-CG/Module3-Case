package controllers;

import models.Account;
import services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/account"})
public class LoginServlet extends HttpServlet {
    LoginService loginService= new LoginService();
    //private ArrayList<Account> listAcc= loginService.listAcc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if(action==null){
            action="";
        }

        switch (action){
            case "create":
                requestDispatcher=req.getRequestDispatcher("/views/createAccount.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "edit":
                int indexEdit=Integer.parseInt(req.getParameter("index"));
                req.setAttribute("account",loginService.listAcc.get(indexEdit));
                requestDispatcher=req.getRequestDispatcher("views/editAccount.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "delete":
                int id=Integer.parseInt(req.getParameter("id"));
                loginService.delete(id);
                resp.sendRedirect("/account");
                break;
            default:
                req.setAttribute("listAcc", loginService.listAcc);
                requestDispatcher= req.getRequestDispatcher("views/showAccount.jsp");
                requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
//      RequestDispatcher requestDispatcher;
//      if(action==null){
//          action="";
//      }
        int id= Integer.parseInt(req.getParameter("id"));
        String userName=req.getParameter("username");
        String passWord=req.getParameter("password");
        String ten=req.getParameter("ten");
        String ngaySinh=req.getParameter("ngaysinh");
        String sDT= req.getParameter("sdt");
        String email=req.getParameter("email");
        String diaChi=req.getParameter("diachi");
        String role=req.getParameter("role");

        Account account=new Account(id,userName,passWord,ten,ngaySinh,sDT,email,diaChi,role);
        switch (action){
            case "create":
                loginService.save(account);

                resp.sendRedirect("/views/loginpage.jsp");
                break;
            case "edit":
                loginService.edit(account);
                resp.sendRedirect("/account");
                break;

            default:
                break;
        }
    }
}
