package Library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userModel extends Model{
    /*显示数据库所有内容*/
    public boolean retrieveDB() {
        try {
            //创建连接实例
            this.stmt = this.conn.createStatement();

            //构造sql查询语句
            String sql = "select * from users";
            ResultSet rs = this.stmt.executeQuery(sql);

            String titleFormat = "%-10s %20s %20s \n";
            System.out.printf(titleFormat,"USERNAME","PASS","EMAIL");
            System.out.println("------------------------------------------------");

            while (rs.next()) {

                String username = rs.getString("username");
                String pass = rs.getString("pass");
                String email = rs.getString("email");

                String format = "%-10s %20s %20s\n";
                System.out.printf(format, username, pass, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*根据用户名更新密码*/
    public boolean updateDB(String username, String newPass) {
        try {
            this.stmt = this.conn.createStatement();
            //用户验证当前密码正确后，可以修改密码
            //预编译的sql语句
            String sql2 = "UPDATE `Library`.`users` " +
                    "SET `pass` = ? WHERE (`username` = ?);\n";
            PreparedStatement prep = conn.prepareStatement(sql2);

            //为预编译的占位符赋值
            prep.setString(1,newPass);
            prep.setString(2,username);

            //执行sql语句
            prep.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*登陆账号*/
    public boolean signIn(String username, String pass) {
        try {
            this.stmt = this.conn.createStatement();
            //用户验证当前密码正确后，可以修改密码

            String sql = "select pass from users where username = ?";
            //预编译的sql语句
            PreparedStatement prep = conn.prepareStatement(sql);

            //为预编译的占位符赋值
            prep.setString(1,username);

            //执行sql语句
            ResultSet rs = prep.executeQuery();
            String storedPass = null;
            while (rs.next()) {
                storedPass = rs.getString("pass");
            }
            if (pass.equals(storedPass)) {
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /*注册新账号*/
    public boolean signUP(String username, String pass, String email) {
        try {
            this.stmt = conn.createStatement();
            //预编译sql语句
            String sql = "INSERT INTO `Library`.`users` (`username`, `pass`, `email`) " +
                    "VALUES (?, ?, ?);";
            PreparedStatement prep = conn.prepareStatement(sql);
            //赋值
            prep.setString(1,username);
            prep.setString(2,pass);
            prep.setString(3,email);
            //执行
            prep.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
