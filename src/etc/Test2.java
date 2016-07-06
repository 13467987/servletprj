package etc;

public class Test2 {

	public static void main(String[] args) {
		//Test ts = new Test();
		//static꺼가 실햄됨
		
		
		try {
			Class.forName("command.Test");
			//로드 똑같이 실행됨
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
