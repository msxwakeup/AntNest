package Servlet;

import DAO.IMaterialDAO;
import DAOImpl.MaterialDAOImpl;
import Mo.Material;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "pdfServlet",urlPatterns = "/pdfStreamHandeler.do")
public class pdfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //String fileLink=request.getParameter("link");
        HttpSession session=request.getSession();
        String filelink=(String)session.getAttribute("mlink");
        //System.out.println("link="+filelink);
        //  IMaterialDAO materialDAO=new MaterialDAOImpl();
//        try {
//            material=materialDAO.getMaterials(fileName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        flink=material.getLink();
//        System.out.println(flink);
        //"C:/material/[数据结构(C语言版)].严蔚敏_吴伟民.扫描版.pdf";
//服务端把response的header头中设置Access-Control-Allow-Origin为制定可请求当前域名下数据的域名
        // response.setHeader("Access-Control-Allow-Origin", "*"); // 解决请求头跨域问题

        response.setContentType("application/pdf");
        //   filelink="C:/material/[数据结构(C语言版)].严蔚敏_吴伟民.扫描版.pdf";
        File f1 = new File(filelink);

        FileInputStream reader= new FileInputStream(f1);

        BufferedInputStream BufferReader = new BufferedInputStream(reader);

        // 创建servlet 输出流对象

        ServletOutputStream sos = response.getOutputStream();





        int b;

        while ((b = BufferReader.read())!= -1){

            sos.write(b);

        }

        sos.close(); // 这里有点和c语言里的读取文件有点像

        reader.close();


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }


}

