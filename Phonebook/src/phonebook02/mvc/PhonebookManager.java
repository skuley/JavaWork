package phonebook02.mvc;

import java.util.Arrays;

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements PbController {

	// 최대 데이터 개수 
	public static final int MAX_DATA = 3;
	
	// 배열로 구현
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];
	
	// 몇개의 데이터가 저장되었는지 확인 및 관리
	private int count = 0;
	
	
	// 어플리케이션을 제어하는 controller는 하나 만든다
	// 앱을 통제하는 지휘 통제소가 하나 이상이면 좀 그렇다
	// 고로 
	// singleton 적용
	
	// 기본 생성자 생성 방지
	private PhonebookManager() {
		// TODO Auto-generated constructor stub
	}
	
	private static PhonebookManager instance = null;
	
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
			return instance;
	} // getInstance()
	
	
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// 이름은 필수 (매개변수 검증)
		
		int result = PbController.QUERY_FAIL;
		if(name == null || name.trim().length() == 0) {
			return result;
		}
		
		
		// 배열 공간 확인
		// 만약 배열이 다 찼으면, MAX_DATA 만큼 추가된 새 배열 작성
		if(count == pbList.length) {
			// Arrays.copyOf 로 배열에 있는 데이터를 새로운 pbList를 만들어 넣어준다. MAX_DATA 만큼은 null으로 추가하낟.
			pbList = Arrays.copyOf(pbList, pbList.length + MAX_DATA);
		}
		
		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count].setUid(getMaxUid() + 1); // 기존의 최대 uid 값보다 1증가한 값. (unique 한 값 보장)
		// pbList[count] = selectByUid(count + 1);
		
		// uid와 배열 index는 다르다!!
		
		count++;
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		// 배열의 특정 부분만 가지고 온다
		return Arrays.copyOfRange(pbList, 0, count);
	}

	
	// 특정 uid의 데이터 검색 리턴
	// 못 찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {

		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return pbList[index]; // uid 발견하면 리턴
			} // if
		} // for
		
		return null; // 못 찾으면 null 리턴
	} //selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		int result = PbController.QUERY_FAIL;
		
		//매개변수 검증
		if(uid < 1) return result;
		if(name == null || name.trim().length() == 0) return result;
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index < 0) {
			return result;
		} // if (index)
		
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);
		result = 1;
		
		return result;
	} // updateByUid
	

	@Override
	public int deleteByUid(int uid) {
		int result = PhonebookManager.QUERY_FAIL;
		
		// 매개변수 검증
		if(uid < 1) return result;
		int index = findIndexByUid(uid);
		if(index < 0)
			return result;
		
		// 배열 뒤의 운소들을 앒으로 이동
		for(int i = index, j = index + 1; j < count; i++, j++) {
			pbList[i] = pbList[j];
		}
		
		// count 감소
		count--;
		result = 1;
		
		return result;
	} // deleteByUid()
	
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		for(int index = 0; index < count; index++) {
			if(maxUid < pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}
		
		return maxUid;
	} // getMaxUid()
	
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	private int findIndexByUid(int uid) {
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return index;
			} // if
		} // for
		return -1;
	}

}
