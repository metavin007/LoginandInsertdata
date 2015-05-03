
package com.mycompany.myspringtwo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Mycontroller 
{
   String userInDB = "jasin";
   String passwordInDB = "1234";

 @RequestMapping("/x.htm")
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       HttpServletRequest req = (HttpServletRequest) request;
        String ID = request.getParameter("id"); // รับค่าเข้ามา
        String Firstname = request.getParameter("firstname");
        String Lastname = request.getParameter("lastname");
        HttpSession session = request.getSession();
        session.setAttribute("id", ID);
        if (session.getAttribute("id") == null) {
            response.getWriter().print("NO have input");
    }
        else{
            File file = new File("C:\\temp\\mytext.txt"); 
       FileOutputStream fout = null;
       OutputStreamWriter w = null;
       try
       {   
           fout = new FileOutputStream(file);
           w = new OutputStreamWriter(fout,Charset.forName("UTF-8"));
           w.write("  รหัส :");
           w.write(ID);
           w.write("  ชื่อ :");
           w.write(Firstname);
           w.write(" นามสกุล :");
           w.write(Lastname);
       }
       finally
       {
       w.close();
       fout.close();
       }
            response.getWriter().print(ID);
            response.getWriter().print("\n"); 
            response.getWriter().print(Firstname);
            response.getWriter().print("\n"); 
            response.getWriter().print(Lastname);
        }
    
    }
  @RequestMapping("/y.htm")
    protected void doGet2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       HttpServletRequest req = (HttpServletRequest) request;
        String username = request.getParameter("username"); // รับค่าเข้ามา
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {

            if (userInDB.equals(username) && passwordInDB.equals(password)) {

                session.setAttribute("username", username);
                response.getWriter().print("login complete");
            } else {
                response.getWriter().print("You have Key is " + session.getAttribute("username"));
                response.getWriter().print("  ID is jasin and password is 1234 ");
            }

        } else {
            response.getWriter().print("login perfect");
        } 

    }
 
}
