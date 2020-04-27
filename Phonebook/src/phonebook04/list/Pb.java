package phonebook04.list;

// CONTROLLER Interface
// 동작을 정의하기 전에 "동작 설계"
public interface Pb {

	public static final String VERSION = "전화번호부 4.0";

	// 1. 생성
	public abstract int insert(String name, String phoneNum, String memo); /* 1 */
	// 2. 배열에 저장
	public abstract PhonebookModel[] selectAll(); /* 2 */
	// 3. 검색 / 조회
	public abstract PhonebookModel selectByUid(int uid); /* 3 */
	// 4. 수정
	public abstract int updateByUid(int uid, String name, String phoneNum, String memo); /* 4 */
	// 5. 삭제
	public abstract int deleteByUid(int uid); /* 5 */

	// 에러가 발생한 상황들
	// 1. index 범위 벗어남
	// 2. 입력문자열이 empty (혹은 null)일 경우
	// 3. uid가 없는 경우

	// 에러코드 상수
	public static final int ERR_GENERIC = 0; // 일반 오류
	public static final int ERR_INDEXOUTOFRANGE = 1; // index 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2; // 입력문자열이 empty (혹은 null)일 경우
	public static final int ERR_UID = 3; // uid가 없는 경우

	// 에러 문자열
	public static final String[] ERR_STR = { "일반 오류", // 0
			"인덱스 오류", // 1
			"문자열 오류", // 2
			"UID 오류" // 3
	};

}
