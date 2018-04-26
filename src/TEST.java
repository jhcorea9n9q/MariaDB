import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TEST extends DBConnection {
	
	static Connection CON;
	static List<HashMap<String, Object>> LIST;
	static String SQL;

	public static void main(String[] args) throws Exception {
		CON = openDB();
		
		// 1) 값을 입력
		입력();
		// 2) 입력된 값을 확인
		확인();
		// 3) 입력된 값을 수정 한다. 
		수정();
		// 4) 수정한 값을 확인 한다.
		확인();
		// 5) 수정한 값을 삭제 한다.
		삭제();
		// 6) 삭제한 값을 확인 한다.
		확인();
		
		CON.close();
	}
	
	public static void 확인() throws Exception {
		System.out.println("확인()");
		SQL = "select 아이디, 비밀번호 from 사용자";
		LIST = select(CON, SQL);
		for(int i = 0; i <LIST.size(); i++) {
			System.out.println(LIST.get(i));
		}
	}
	
	public static void 입력() throws Exception {
		System.out.println("입력()");
		SQL = "insert into 사용자(아이디, 비밀번호) values (?, ?)";
		List DATALIST = new ArrayList();
		DATALIST.add("새 아이디");
		DATALIST.add("새 비밀번호");
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);
		
	}
	
	public static void 수정() throws Exception  {
		System.out.println("수정()");
		SQL = "UPDATE `사용자` SET `아이디`=? WHERE `아이디`=?";
		List DATALIST = new ArrayList();
		DATALIST.add("日本語");
		DATALIST.add("새 아이디");			
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);
		
	}
	
	public static void 삭제() throws Exception  {
		System.out.println("삭제()");
		SQL = "delete from 사용자 where 아이디 = ?";
		List DATALIST = new ArrayList();
		DATALIST.add("아이디");			
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);		
		
	}

}
