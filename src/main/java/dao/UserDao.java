package dao;

import pojo.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //封装一个方法 根据管理员的名字查询管理员的信息
    public User selectAdminInfo(String name) {
        User user = null;
        Connection connection = DBUtil.getConn();
        String sql = "select * from tb_user where user_name=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                //取出数据的每个字段值
                Integer id = r.getInt("ID");
                String userName = r.getString("USER_NAME");
                String pwd = r.getString("USER_PASSWORD");
                Integer userType = r.getInt("USER_TYPE");
                Integer userState = r.getInt("USER_STATE");
//将取出的数据封装到对象
                user = new User();
                user.setId(id);
                user.setUserName(userName);
                user.setUserPassword(pwd);
                user.setUserType(userType);
                user.setUserState(userState);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }


    //查询用户信息
    public List<User> userSelect(String id) throws SQLException {
        User user = null;
        List<User> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        String sql = "";

        if (id == null || id.equals("")) {
            sql = "select * from tb_user";
        } else {
            sql = "select * from tb_user where id=" + id;
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet r = ps.executeQuery();
        while (r.next()) {
            //取出数据的每个字段值
            Integer id1 = r.getInt("ID");
            String userName = r.getString("USER_NAME");
            String pwd = r.getString("USER_PASSWORD");
            Integer userType = r.getInt("USER_TYPE");
            Integer userState = r.getInt("USER_STATE");
            //将取出的数据封装到对象
            user = new User();
            user.setId(id1);
            user.setUserName(userName);
            user.setUserPassword(pwd);
            user.setUserType(userType);
            user.setUserState(userState);
            list.add(user);
        }

        return list;
    }

    //根据id删除数据
    public int deleteUserById(String id) {
        int row = 0;
        //获取数据库连接
        Connection conn = DBUtil.getConn();
        //编写sql
        String sql = "delete from tb_user where id=?";
        try {
            //创建 PreparedStatement对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //给?赋值
            ps.setInt(1, Integer.parseInt(id));

            //执行
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }


    //根据id查询当前用户
    public User selectUserInfoById(String id) {
        int row = 0;
        //获取连接对象
        Connection conn = DBUtil.getConn();
        User user = null;
        //编写sql
        String sql = "select * from tb_user where id=?";
        //得到PreparedStatement对象
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //给？赋值

            ps.setInt(1, Integer.parseInt(id));
            //执行
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                //取出数据的每个字段值
                Integer id1 = r.getInt("ID");
                String userName = r.getString("USER_NAME");
                String pwd = r.getString("USER_PASSWORD");
                Integer userType = r.getInt("USER_TYPE");
                Integer userState = r.getInt("USER_STATE");
                //将取出的数据封装到对象
                user = new User();
                user.setId(id1);
                user.setUserName(userName);
                user.setUserPassword(pwd);
                user.setUserType(userType);
                user.setUserState(userState);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return user;
    }

    public int updateUserInfoById(User user){
        Connection conn = DBUtil.getConn();
        int row=0;
        String sql="update tb_user set user_password=?where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,user.getUserPassword());
            ps.setInt(2,user.getId());
             row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }
}
