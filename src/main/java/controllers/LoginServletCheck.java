package controllers;

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
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/accountcheck"})
public class LoginServletCheck extends HttpServlet {
    LoginService loginService = new LoginService();
    ArrayList<Account> listAcc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/account");
        //tại sao Toàn sửa lissAcc=loginService.listAcc cho vào đây thì ko lỗi nữa, create acc ko
        //phải reset lại serve tomcat
        listAcc= loginService.listAcc;
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
                HttpSession session= req.getSession();
                session.setAttribute("id",account.getId());
                session.setAttribute("username",account.getUserName());
                session.setAttribute("password",account.getPassWord());
                session.setAttribute("ten",account.getTen());
                session.setAttribute("ngaysinh",account.getNgaySinh());
                session.setAttribute("sdt",account.getSoDT());
                session.setAttribute("email",account.getEmail());
                session.setAttribute("diachi",account.getDiaChi());
                session.setAttribute("role",account.getRole());
                break;
            }else if(userName.equals(account.getUserName())&& passWord.equals(account.getPassWord())&&account.getRole().equals("khachhang")){
                HttpSession session= req.getSession();
                session.setAttribute("id",account.getId());
                session.setAttribute("username",account.getUserName());
                session.setAttribute("password",account.getPassWord());
                session.setAttribute("ten",account.getTen());
                session.setAttribute("ngaysinh",account.getNgaySinh());
                session.setAttribute("sdt",account.getSoDT());
                session.setAttribute("email",account.getEmail());
                session.setAttribute("diachi",account.getDiaChi());
                session.setAttribute("role",account.getRole());
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
