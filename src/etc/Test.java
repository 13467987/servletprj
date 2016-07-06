package etc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import vo.BoardVo;

public class Test {
	
	static ArrayList<String> a;
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		
		
		System.out.println("hello");
		
		BoardVo boardVo = new BoardVo();
		Class clazz = boardVo.getClass();
		Method[] methods =clazz.getMethods();
		
		for(int i = 0; i<methods.length;i++){
			System.out.println(methods[i].getName());
			if(methods[i].getName().equals("getTitle")){
				System.out.println(methods[i].invoke(boardVo));				
			}
		}
		
	}
	static {
		System.out.println("aa");
		//class가 로드될때 먼저 실행
		a= new ArrayList<>();
		//로드 전 초기화
		a.add("d");
	}
}
