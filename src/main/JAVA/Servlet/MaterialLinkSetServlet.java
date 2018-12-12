package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;

@WebServlet(name = "MaterialLinkSetServlet",urlPatterns = "/setLink.do")
public class MaterialLinkSetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mlink=request.getParameter("mlink");
        HttpSession session=request.getSession();
        session.setAttribute("mlink",mlink);
        //System.out.println("MaterialLinkSetServlet mlink="+mlink);
        PrintWriter out=response.getWriter();
        out.println("ok");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
