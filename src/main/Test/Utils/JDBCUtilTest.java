package Utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class JDBCUtilTest {

    @Test
    public void getConn() {
        JDBCUtil jdbc = new JDBCUtil();
        Connection conn = jdbc.getConn();

        assertNotNull(conn);
        System.out.println(conn);
        if (conn != null) {
            System.out.println("成功连接");
        }
    }
}