import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mein extends DBConnection {

	static Connection CON;
	static List<HashMap<String, Object>> LIST;
	static String SQL;
	
	public static void main(String[] args) throws Exception {
			System.out.println("연결-시작");
			CON = openDB();
			
			System.out.println("연결-중");
			
			////////////////////////////////////////////////
			
//         데이터 가져오기(SELECT)
//			SQL = "select * from 사용자";
//			LIST = select(CON, SQL);
//			for(int i = 0; i <LIST.size(); i++) {
//				System.out.println("아이디 : " + LIST.get(i));
//			}
			
            ////////////////////////////////////////////////
			
//        데이터 입력하기(INSERT)
			SQL = "insert into 사용자(아이디, 비밀번호) values (?, ?)";
			List DATALIST = new ArrayList();
			DATALIST.add("아이디");
			DATALIST.add("비밀번호");
			int RESULT = edit(CON, SQL, DATALIST);
			System.out.println(RESULT);
			
            ////////////////////////////////////////////////
			
//	        데이터 수정하기(UPDATE)
//			SQL = "UPDATE `사용자` SET `아이디`=? WHERE `아이디`=?";
//			List DATALIST = new ArrayList();
//			DATALIST.add("안녕");
//			DATALIST.add("Reset");			
//			int RESULT = edit(CON, SQL, DATALIST);
//			System.out.println(RESULT);
				
	         ////////////////////////////////////////////////
			
//	        데이터 삭제하기(DELETE)
//			SQL = "delete from 사용자 where 아이디 = ?";
//			List DATALIST = new ArrayList();
//			DATALIST.add("new");			
//			int RESULT = edit(CON, SQL, DATALIST);
//			System.out.println(RESULT);		
			
	         ////////////////////////////////////////////////
			
			
			
			CON.close();
			System.out.println("연결-종료");
	}

}
