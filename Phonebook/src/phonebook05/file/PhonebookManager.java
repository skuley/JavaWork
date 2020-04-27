package phonebook05.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb, Closeable {
	
	public static final String PB_DATA_DIR = "data";
	public static final String PB_DATA_FILE = "phonebook.dat";
	private File pbDir;
	private File pbFile;
	
	
	private ArrayList<PhonebookModel> list = new ArrayList<PhonebookModel>();

	// singleton 적용
	// 기본 생성자 생성 방지
	private PhonebookManager() {
		
		// FileNotFoundException 여부로 확인
		// 파일이 존재하면 파일 읽어 들이기 --> pbList;
		// TODO
		
		pbDir = new File(PB_DATA_DIR);
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else {
			System.out.println("폴더 존재 : " + pbDir.getAbsolutePath());
		} // pbDir 폴더 제어
		
		pbFile = new File(pbDir, PB_DATA_FILE);
		if(pbFile.exists()) {
			System.out.println("파일에서 데이터 읽습니다...");
			try(
					ObjectInputStream oin = new ObjectInputStream(new FileInputStream(pbFile));
					){
				list = null; // 가져오려는 데이터를 정화하게 받으려고 초기화 시켜줌
				list = (ArrayList<PhonebookModel>)oin.readObject();
				System.out.println(list.size() + " 개의 데이터를 읽었습니다");
			} catch(FileNotFoundException e) {
				System.out.println("저장된 파일이 없습니다.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// pbFile.exist()
		} else {
			System.out.println("읽어올 파일이 없습니다");
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

	@Override
	public void close() throws IOException {
		// TODO 
		// 데이터 저장
		// pbList -> 파일로 저장
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(pbFile));
		oout.writeObject(list);
		System.out.println("파일 저장 완료");
		oout.close();
		
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
