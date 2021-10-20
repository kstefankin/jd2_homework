package web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servtwo", urlPatterns = "/sserv")
public class SecondServ extends HttpServlet{

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        HttpSession session = request.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);

        out.println("<html><head><title>Second Servlet </title></head>");
        out.println("<body><h1>This is Servlet # 2 </h1>");
        out.println("<h1> number of sessions - " + visitCounter+ "  </h1>");
        out.println("</body></html>");

        ServletConfig config=getServletConfig();
        String par = config.getInitParameter("filename");
        //"D:/java/apache-tomcat-10.0.11/webapps/servtwo/WEB-INF/classes/counter.txt"
        File file = new File(par);
        FileWriter fileWriter = new FileWriter( file,false);
        String text = visitCounter.toString();
        fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }




}
