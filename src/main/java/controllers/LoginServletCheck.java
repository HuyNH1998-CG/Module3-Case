package controllers;

import models.Account;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/accountcheck"})
public class LoginServletCheck extends HttpServlet {
    LoginService loginService = new LoginService();
    ArrayList<Account> listAcc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/account");
        listAcc = loginService.listAcc;
        String userName=req.getParameter("username");
        String passWord=req.getParameter("password");
        boolean check=false;
        boolean check2=false;
//        Account acc;
//        for(Account account: listAcc) {
//            if(userName.equals(account.getUserName())&& passWord.equals(account.getPassWord())){
//                acc=account;
//                break;
//            }
//        }


        for(Account account: listAcc) {
            if(userName.equals(account.getUserName())&& passWord.equals(account.getPassWord())&&account.getRole().equals("admin")){
                check=true;
                break;
            }else if(userName.equals(account.getUserName())&& passWord.equals(account.getPassWord())&&account.getRole().equals("khachhang")){
                check2=true;
                break;
            }
        }

        if(check==true) {
            //Hỏi lại các câu lệnh resp.sendRedirect,requestDispatcher.forward(req,resp)
            // đều vào doGet ?
            resp.sendRedirect("/account");
            return;
        }else if(check2==true){
            resp.sendRedirect("/views/homepage.jsp");
        }else {
                //PrintWriter writer= resp.getWriter();
                //writer.println("Đăng Nhập Fail");
                //Hỏi lại các câu lệnh resp.sendRedirect,requestDispatcher.forward(req,resp)
                // đều vào doGet?
                resp.sendRedirect("views/loginpage.jsp");
                return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
