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
    private ArrayList<Account> listAcc = loginService.listAcc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/account");
        String userName=req.getParameter("username");
        String passWord=req.getParameter("password");
        boolean check=false;

        for(Account account: listAcc) {
            if(userName.equals(account.getUserName())&& passWord.equals(account.getPassWord())){
                check=true;
                break;
            }
        }

        if(check==true){
                //Hỏi lại các câu lệnh resp.sendRedirect,requestDispatcher.forward(req,resp)
                // đều vào doGet ?
                resp.sendRedirect("/account");
                return;
        }else {
                //PrintWriter writer= resp.getWriter();
                //writer.println("Đăng Nhập Fail");
                //Hỏi lại các câu lệnh resp.sendRedirect,requestDispatcher.forward(req,resp)
                // đều vào doGet?
                resp.sendRedirect("views/loginpage.jsp");
                return;
        }

    }
}
