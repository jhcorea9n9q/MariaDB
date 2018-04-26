import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TEST2 extends DBConnection {
	
	static Connection CON;
	static List<HashMap<String, Object>> LIST;
	static String SQL;

	public static void main(String[] args) throws Exception {
		CON = openDB();
		
//		ArrayList<String> JobName = new ArrayList<String>();
//		ArrayList<String> WhatToDo = new ArrayList<String>();
//		
//		JobName.add("모바일 UI/UX 웹디자인");
//		JobName.add("실내건축설계(캐드,레빗,3D맥스)");
//		JobName.add("ICT 융합 SW보안전문가");
//		JobName.add("응용SW 개발자(정보처리산업기사)");
//		
//		WhatToDo.add("기업체에서 스마트기기에 적용 가능한 사용자 경험 디자인을 개발하기 위한 디자인 제작 능력을 요구함에 따라, 스마트문화앱콘텐츠제작 직종의 NCS능력단위(UI/UX 전략수립, UI디자인, GUI디자인) 및 UIUX엔지니어링 직종의 NCS능력단위(UIUX가이드 제작)와 융합하여 교과편성 하였음");
//		WhatToDo.add("1. 최신버전의 소프트웨어로 현장에 실무업무 즉시 가능한 훈련구성 \n2. 산업체 요구조건에 맞춘 커리큘럼과 인력양성 능력 함양");
//		WhatToDo.add("본 과정은 ICT플랫폼 구축 전반에 대한 구축 및 개발능력과 보안 프로세스 구축 능력을 습득할 수 있는 과정으로, 실제 ICT환경구축을 통해 이에 대한 보안 프로세스를 구축 할 수 있게 하여 실무 활용 지식 가능 \n- 실무 경험이 풍부한 강사진을 통해 실무에서 활용할 수 있는 지식 습득 \n- IoT, 빅데이터, 모바일 등 ICT 융합 응용 프로그램 개발 전문지식 습득 \n- ICT 환경 전반에 걸친 보안 프로세스 구현 지식 습득");
//		WhatToDo.add("응용 소프트웨어 개발자를 양성함과 동시에 정보처리산업기사 취득을 병행 할 수 있으므로 학생들의 수업참여도를 고취 시킬 수 있음. \n광주 전남의 증가되는 SW 에니지니어의 수요에 부응하여 현장에서 강점을 드러낼 수 있는 인재개발.");
//
//		입력(JobName.get(0), WhatToDo.get(0), "홍길동", "20180426");
//		입력(JobName.get(1), WhatToDo.get(1), "유관순", "20180426");
//		입력(JobName.get(2), WhatToDo.get(2), "이철수", "20180426");
//		입력(JobName.get(3), WhatToDo.get(3), "박순", "20180426");
//		
//		삭제();
		입력("새로운 직업", "끝내주는 일을 하죠", "조한서", "20180427");
		
		확인();
		
		CON.close();
	}
	
	public static void 테이블생성() throws Exception {
		System.out.println("데이터베이스_생성중");
		SQL = "CREATE TABLE `ExcelData` ("
				+ "번호 INT NOT NULL,"
				+ "제목 VARCHAR(50) NULL,"
				+ "내용 VARCHAR(500) NULL,"
				+ "작성자 VARCHAR(20) NOT NULL,"
				+ "삭제여부 VARCHAR(1) NOT NULL DEFAULT 'N',"
				+ "작성일자 VARCHAR(8) NOT NULL)";
		
		List DATALIST = new ArrayList();
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);	
	}

	public static void 입력(String 제목, String 내용, String 작성자, String 작성일자) throws Exception {
		System.out.println("데이터_생성중");
		SQL = "insert into ExcelData(제목, 내용, 작성자, 작성일자) values (?, ?, ?, ?)";
		
		List DATALIST = new ArrayList();
		DATALIST.add(제목);
		DATALIST.add(내용);
		DATALIST.add(작성자);
		DATALIST.add(작성일자);
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);
	}
	
	public static void 확인() throws Exception {
		System.out.println("확인()");
		SQL = "select * from ExcelData where 삭제여부 = 'N'";
		LIST = select(CON, SQL);
		for(int i = 0; i <LIST.size(); i++) {
			System.out.println(LIST.get(i));
		}
	}
	
	public static void 수정() throws Exception  {
		System.out.println("수정()");
		SQL = "UPDATE `ExcelData` SET `제목`=?, 내용=?, WHERE `번호`=?";
		List DATALIST = new ArrayList();
		DATALIST.add("제목수정");
		DATALIST.add("내용수정");			
		DATALIST.add(1);		
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);
		
	}
	
	public static void 삭제() throws Exception  {
		System.out.println("삭제()");
		SQL = "UPDATE `ExcelData` SET `삭제여부`='Y' WHERE `번호`=?";
		List DATALIST = new ArrayList();
		DATALIST.add("1");			
		int RESULT = edit(CON, SQL, DATALIST);
		System.out.println(RESULT);		
		
	}
	
}
