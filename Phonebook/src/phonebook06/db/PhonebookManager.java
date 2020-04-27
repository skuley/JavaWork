package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {

	// TODO : DB 를 위한 변수들 선언
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// singleton 적용
	// 기본 생성자 생성 방지
	private PhonebookManager() {

		// TODO
		// JDBC 프로그래밍
		// 클래스 로딩
		// 연결 Connection
		// Statement (필요하다면) 생성

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // getInstance()

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 이름은 필수 (매개변수 검증)
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);
		}

		int cnt = 0;
		// TODO
		// DML INSERT 부분
		// SQL_INSERT 사용하여 INSERT 하기
		// PreparedStatement
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {

		// TODO
		// SQL_SELECT_ALL 사용
		List<PhonebookModel> list = new ArrayList<PhonebookModel>();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date d = rs.getDate(COL_LABEL_REGDATE);
				Time t = rs.getTime(COL_LABEL_REGDATE);

				String date = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);

				java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
				list.add(new PhonebookModel(
						rs.getInt(COL_LABEL_UID), 
						rs.getString(COL_LABEL_NAME),
						rs.getString(COL_LABEL_PHONENUM), 
						rs.getString(COL_LABEL_MEMO), 
						date2));

			}

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 

		return list.toArray(new PhonebookModel[list.size()]);
	}

	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		// TODO

		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();

			if (rs.next())
				return new PhonebookModel();

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return null;

	} // selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류 : ", Pb.ERR_UID);
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);

		int cnt = 0;
		// TODO
		// SQL_UPDATE_BY_UID
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return cnt;
	} // updateByUid

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("delete() uid 오류 : ", Pb.ERR_UID);

		int cnt = 0;
		// TODO
		// SQL_DELETE_BY_UID
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return cnt;
	} // deleteByUid()

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	public int getMaxUid() {
		int maxUid = 0;

		// TODO : 옵션
		try {
			pstmt = conn.prepareStatement(SQL_COUNT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				maxUid = rs.getInt("cnt"); // 별칭으로 가져올 수 있음
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return maxUid;
	} // getMaxUid()

	@Override
	public void close() throws IOException {

		// TODO
		try {
			rs.close();
			stmt.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

} // PhonebookManager

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {

	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook error occured");

	} // PhonebookException()

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();

		return super.getMessage();
	}

} // PhonebookException
