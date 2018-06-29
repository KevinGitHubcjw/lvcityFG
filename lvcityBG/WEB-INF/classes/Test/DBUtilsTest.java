package Test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.neuedu.lvcity.common.DBUtils;

public class DBUtilsTest {

	@Test
	public void test() {
		Connection conn=DBUtils.getConnection();
		System.err.println("conn");
	}

}
