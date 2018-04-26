import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcon {

	public static void main(String[] args) {
		System.out.println("DBcon");
		String URL = "jdbc:mysql://MariaDB:3306/test";
		String USER = "root";
		String PWD = "1234";
		Connection con = null;
		//커넥트 해주기위한 클래스 변수화
		
		try {
				System.out.println("Driver 클래스 확인");
				Class.forName("org.mariadb.jdbc.Driver");
				// jar파일 안에 있는 패키지 안에, Driver 클래스가 있는지 확인한다.(연결할 수 있는 상태인가?)
			
				} catch (Exception e) {
					e.printStackTrace();
					// e 오류가 발생시 콘솔에 그대로 출력
				}
		
		try {
					con = DriverManager.getConnection(URL, USER, PWD);
					//DB에서 정보를 받아옴
					
					String SQL = "select 아이디 from 사용자";
					// MariaDB와의 커넥트를 위한 클래스.메소드
					// SQL 쿼리 명령문을 여기다 입력하자.
					
					PreparedStatement PS = con.prepareStatement(SQL);
					// 자바의 String SQL 내용을 MariaDB로 보내주기 위한 단계
					
					ResultSet RS = PS.executeQuery();
					//MariaDB가 SQL Query값을 받아 실행시킨 결과
					
					while(RS.next()) { 
								String 아이디 = RS.getString("아이디");
								System.out.println(아이디);
							   //next()를 쓰면 RS가 다 출력될 때까지 한 줄씩 돌아감
			  }
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
				try {
						con.close();
						//커넥트 종료시켜줌.
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		}		
		
		System.out.println("종료됨");
		
	}
	
}
