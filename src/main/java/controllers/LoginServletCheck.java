package controllers;

import down.CRUDAccount;
import models.Account;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/accountcheck"})
public class LoginServletCheck extends HttpServlet {
    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/account");
        req.setCharacterEncoding("utf-8");
        ArrayList<Account> listAcc = null;
        try {
            listAcc = CRUDAccount.showAccount();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        String userName=req.getParameter("username");
        String passWord=req.getParameter("password");
        boolean check=false;
        HttpSession session = req.getSession();
        assert listAcc != null;
        for(Account account: listAcc) {
            if(userName.equals(account.getUserName())&& passWord.equals(account.getPassWord())){
                session.setAttribute("user",account);
                check=true;
                break;
            }
        }

        if(check){
                resp.sendRedirect("/");
        }else {
                resp.sendRedirect("views/loginpage.jsp");
        }

    }
}
