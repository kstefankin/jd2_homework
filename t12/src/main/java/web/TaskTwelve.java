package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "twelve", urlPatterns = "/tw")
public class TaskTwelve extends HttpServlet{

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");

        HttpSession session = request.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        session.setAttribute("visitCounter", visitCounter);

        String num = visitCounter.toString();
        BufferedImage image = new BufferedImage(400,200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = image.createGraphics();
        graph.setFont(new Font("Serif", Font.ITALIC,60));
        graph.setColor(Color.yellow);
        graph.drawString(num,100,100);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpeg",out);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }




}
