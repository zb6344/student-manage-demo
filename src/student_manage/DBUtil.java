package student_manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.AutoCloseable;

    public class DBUtil {
        private static final String URL = "jdbc:mysql://localhost:3306/student_manage?useSSL=false&serverTimezone=Asia/Shanghai";
        private static final String USER = "root";

        private static final String PWD = "Zhu81126732@";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PWD);
        }

        public static void close(AutoCloseable... res) {
            for (AutoCloseable r : res) {
                try {
                    if (r != null) r.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }