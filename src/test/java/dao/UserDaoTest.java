package dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void selectAdminInfo() {
    }

    @Test
    public void userSelect() {
    }

    @Test
    public void deleteUserById() {
        UserDao userDao=new UserDao();
        userDao.deleteUserById("44");
    }
}