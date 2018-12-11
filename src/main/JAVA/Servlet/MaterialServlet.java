package Servlet;

import DAO.IMaterialDAO;
import DAOImpl.MaterialDAOImpl;
import Mo.Material;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MaterialServlet",urlPatterns = "/material.do")
public class MaterialServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String l="算";
        IMaterialDAO materialDAO=new MaterialDAOImpl();
        List<Material> list=null;
        try {
            list=materialDAO.getMaterial(l);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        request.setAttribute("mlist",list);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
