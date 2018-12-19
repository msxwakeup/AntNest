package Servlet;

import DAO.IMaterialDAO;
import DAOImpl.MaterialDAOImpl;
import Mo.Material;
import Utils.UploadUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MaterialUploadServlet",urlPatterns = "/materialUpload.do")
public class MaterialUploadServlet extends HttpServlet {
    IMaterialDAO iMaterialDAO;

    public void init() throws ServletException {
        iMaterialDAO=new MaterialDAOImpl();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String name=req.getParameter("name");
        String knowledge=req.getParameter("knowledge");
        UploadUtil uploadUtil=new UploadUtil(this,req);
        String newname="";
        System.out.println("1111:"+this.getServletConfig().getServletContext().getContextPath());
        try {
            newname=uploadUtil.processUploadedFile("material","materials");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(newname);
        Material material=new Material();
        material.setName(name);
        material.setLink("materials/"+newname);
        material.setKnowledge(knowledge);
        boolean flag=false;
        try {
            flag=iMaterialDAO.uploadMaterial(material);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(flag)
            System.out.println("成功");
        else
            System.out.println("失败");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
