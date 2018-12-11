package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC连接类
public class JDBCUtil {
    //连接数据库四要素
    private static String driverClassName="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql:///ant?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String username="root";
    private static String password="123456";
    static {      //当jdbc字节码被加载进JVM就立刻执行
			   //加载注册驱动
			try {
		Class.forName(driverClassName);
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			   }
           }
    //创建并返回一个Connection对象
    public static Connection getConn() {

       try {
            //获取连接对象
            return DriverManager.getConnection(url,username,password);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if(rs!=null)
                rs.close();
        }catch(Exception e) {

        }finally {
            try {
                if(st!=null)
                    st.close();
            }catch(Exception e){

            }finally {
                try {
                    if(conn!=null)
                        conn.close();

                }
                catch(Exception e){

                }

            }
        }
    }

}
