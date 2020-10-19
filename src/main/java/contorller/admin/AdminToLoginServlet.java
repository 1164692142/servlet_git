package contorller.admin;

import dao.UserDao;
import pojo.User;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminToLoginServlet",urlPatterns = "/loginServlet")
public class AdminToLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //接收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //根据管理员的账号，查询管理员信息
        UserDao userDao=new UserDao();
        User user = userDao.selectAdminInfo(username);
        //对管理员登陆，我们只需要判断密码和账号即可
        if(user.getUserName().equals(username)&&user.getUserPassword().equals(password)){
            //成功，去首页  同时绑定用户名到session
            HttpSession session = req.getSession();//默认时长30min
            session.setAttribute("loginName",username);
            //将session绑定到
            req.getRequestDispatcher("/resources/admin/AdminTemp.jsp").forward(req,resp);

        }else{
            //用户名或密码错误，将错误信息显示在登录界面
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
