package frige;

import java.util.List;

public interface FrigeService {
	List<FrigeVO> frige_list(long user_id);	//재료 리스트 정보 가져오기(유통기한순)
	FrigeVO frige_detail(int content_list_id);	//재료정보 상세페이지 호출
	int frige_update(FrigeVO vo);	//재료정보 수정하기
		//재료정보 삭제
}
