package etc;

import dao.BoardDao;
import jdbc.DBManager;

public class ServiceTest {

	public static void main(String[] args) {
		System.out.println(DBManager.getConnection());
	}

}
