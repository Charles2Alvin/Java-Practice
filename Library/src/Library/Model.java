package Library;

import java.sql.*;
import java.util.Calendar;

public class Model {
    //表名
    private static final String tableName = "books";
    //jdbc驱动名以及url
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/Library?useSSL=false&serverTimezone=UTC";
    //数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "Qq123123";
    //数据库连接句柄
    static Connection conn = null;
    static Statement stmt = null;
    //---------------------------------------------------
    /*连接数据库*/
    public Connection connectDB() {
        Connection conn = null;
        Statement st = null;
        try {
            //注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //打开链接
            System.out.println("正在连接数据库……");
            this.conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("连接成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
    }
    /*断开连接*/
    public boolean closeConn() {
        try {
            if (this.conn != null) {
                this.conn.close();
                System.out.println("连接已关闭");
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }
    /*增加新的书籍到馆藏*/
    public boolean insertDB(String borrower) {
        try {
            this.stmt = this.conn.createStatement();
//            String sql = "INSERT INTO books VALUES()"
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*显示馆藏*/
    public boolean retrieveDB() {
        try {
            //创建连接实例
            this.stmt = this.conn.createStatement();

            //构造sql查询语句
            String sql = "select * from books";
            ResultSet rs = this.stmt.executeQuery(sql);

            String titleFormat = "%-45s %20s %20s %20s %20s %10s\n";
            System.out.printf(titleFormat,"TITLE","AUTHOR","STATE","BORROWER","BORROWED TIME","PRICE");
            System.out.print("-----------------------------------------------------------------");
            System.out.print("-----------------------------------------------------------------");
            System.out.println("-----------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String state = rs.getString("state");
                String borrower = rs.getString("borrower");
                Date borrowTime = rs.getDate("borrowTime");
                int price = rs.getInt("price");

                String format = "%-45s %20s %20s %20s %20s %10s\n";
                System.out.printf(format,title,author,state,borrower,borrowTime,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*更新书籍的借书状态*/
    public boolean updateDB(int id, String borrower) {
        try {
            //根据书籍的id，修改书籍的借出状态，以及对应的借书人，借书日期
            this.stmt = this.conn.createStatement();
            //获取当前时间
            java.util.Date t = Calendar.getInstance().getTime();
            java.sql.Date time = new java.sql.Date(t.getTime());

            //预编译的sql语句
            String sql = "UPDATE `Library`.`books` SET `borrowTime` = ?, " +
                    "`borrower` = ?, `state` = 'true' WHERE (`id` = ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //为预编译的占位符赋值
            pstmt.setDate(1, time);
            pstmt.setString(2, borrower);
            pstmt.setInt(3,id);

            //执行sql语句
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
