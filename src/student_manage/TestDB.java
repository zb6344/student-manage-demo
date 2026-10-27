package student_manage;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
        public static void main(String[] args) {
            Connection conn = null;
            try {
                conn = DBUtil.getConnection();
                System.out.println("✅数据库连接成功！");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("❌数据库连接失败！");
            }finally {
                DBUtil.close(conn);
            }
        }
    }
