package Servlet;

import DAO.IMaterialDAO;
import DAOImpl.MaterialDAOImpl;
import Mo.Material;
import Utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MateialPageServlet",urlPatterns = "/materialpage.do")
public class MaterialPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String currentPage=request.getParameter("currentPage");
        String key=request.getParameter("names");
        //String dict=request.getParameter("choose");

        if (key==null){
            key="";
        }
/*       if(dict==null){
            dict="filename";
        }*/
        int cpage=0;
        try {
            cpage=Integer.parseInt(currentPage);
        }catch (Exception e){
            cpage=1;
        }
        IMaterialDAO materialDAO=new MaterialDAOImpl();
        PageBean<Material> pageBean=new PageBean<>();
        List<Material> list=null;
        int totalRows=0;

//        if(dict.equals("filename")){
//        try {
//            totalRows=materialDAO.getMaterial(key).size();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         pageBean.setPagesize(3);
//        pageBean.setTotalRows(totalRows);
//        pageBean.setCurrentPage(cpage);
//        try {
//            list=materialDAO.getshow(key,pageBean.getRowStart(),pageBean.getPagesize());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }}
//        else{
            try {
                totalRows=materialDAO.getMaterial(key).size();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pageBean.setPagesize(4);
            pageBean.setTotalRows(totalRows);
            pageBean.setCurrentPage(cpage);
            try {
                list=materialDAO.getSeries(key,pageBean.getRowStart(),pageBean.getPagesize());
            } catch (SQLException e) {
                e.printStackTrace();
            }
//        }
        pageBean.setPageList(list);
        request.setAttribute("key",key);
        //request.setAttribute("dict",dict);
        request.setAttribute("pagebean",pageBean);
        //request.getRequestDispatcher("materialShow.jsp").forward(request,response);

        request.getRequestDispatcher("resource.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
