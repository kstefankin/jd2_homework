package web;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "telev", urlPatterns = "/telev")
public class ServletUsAgent extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String useragent = request.getHeader("User-Agent");


        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();

        String browserName = browser.getName();

        Version browserVersion = userAgent.getBrowserVersion();

        if (useragent == null) {
            out.println("<html><head><title>task 11 </title></head>");
            out.print("<body><h1>Приветствую неопознанного </h1>");
            out.println("<h1> пользователя  </h1>");
            out.println("</body></html>");

        } else {
            out.println("<html><head><title>task 11 </title></head>");
            out.print("<body><h1>Приветствую  </h1>");
            out.println("<h1> пользователя - " + browserName +"  "+ browserVersion + "  </h1>");
            out.println("</body></html>");
        }






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }



}
