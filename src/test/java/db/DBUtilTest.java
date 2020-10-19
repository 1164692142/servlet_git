package db;

import org.junit.Test;
import util.DBUtil;

import static org.junit.Assert.*;

public class DBUtilTest {

    @Test
    public void getConn() {
        System.out.println(DBUtil.getConn());
    }
}