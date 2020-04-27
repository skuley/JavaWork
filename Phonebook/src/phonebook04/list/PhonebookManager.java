package phonebook04.list;

import java.util.ArrayList;
import java.util.Arrays;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> list = new ArrayList<PhonebookModel>();

	// singleton 적용
	// 기본 생성자 생성 방지
	private PhonebookManager() {
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

		// ArrayList<PhonebookModel> list = new ArrayList<PhonebookModel>(insert(name,
		// phoneNum, memo));

		PhonebookModel pbmodel = new PhonebookModel(name, phoneNum, memo);

		pbmodel.setUid(getMaxUid() + 1);

		list.add(pbmodel);
		//list.add(new PhonebookModel( name, phoneNum, memo));

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		// 배열의 특정 부분만 가지고 온다
		/*PhonebookModel[] pba = new PhonebookModel[list.size()];
		for (int i = 0; i < list.size(); i++) {
			pba[i] = list.get(i);
		}*/
		
		
		return list.toArray(new PhonebookModel[list.size()]);
	}

	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUid() == uid) {
				return list.get(i);
			}
		}
		return null; // 못 찾으면 null 리턴
	} // selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류 : ", Pb.ERR_UID);
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름 입력 오류 : ", Pb.ERR_EMPTY_STRING);

		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0) {
			throw new PhonebookException("update() 없는 uid : ", Pb.ERR_UID);
		} // if (index)

		list.get(index).setName(name);
		list.get(index).setPhoneNum(phoneNum);
		list.get(index).setMemo(memo);

		return 1;
	} // updateByUid

	@Override
	public int deleteByUid(int uid) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("delete() uid 오류 : ", Pb.ERR_UID);
		int index = findIndexByUid(uid);
		if (index < 0)
			throw new PhonebookException("delete() 없는 uid : ", Pb.ERR_UID);

		list.remove(index);

		return 1;
	} // deleteByUid()

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		for (int i = 0; i < list.size(); i++) {
			if (maxUid < list.get(i).getUid()) {
				maxUid = list.get(i).getUid();
			}
		}

		return maxUid;
	} // getMaxUid()

	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	private int findIndexByUid(int uid) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUid() == uid) {
				return i;
			}
		}

		return -1;
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
