package web;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "tten", urlPatterns = "/ten")
public class TaskTen extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            String name = req.getParameter("name");
            String phnum = req.getParameter("phnum");
            String email = req.getParameter("email");


            if ((name=="")||(phnum=="" & email=="")) {

                writer.println("Soory! Try one more time!");

            } else {

                writer.println(name);
                writer.println(phnum);
                writer.println(email);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }




}
