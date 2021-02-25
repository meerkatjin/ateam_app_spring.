package frige;

import java.util.List;

public interface FrigeService {
	List<FrigeVO> frige_list(long user_id);	//재료 리스트 정보 가져오기(유통기한순)
	List<FrigeVO> frige_list_name(long user_id);	//재료 리스트 정보 가져오기(이름순)
	List<FrigeVO> frige_list_meat(long user_id);	//재료 리스트 정보 가져오기(고기)
	List<FrigeVO> frige_list_fish(long user_id);	//재료 리스트 정보 가져오기(수산물)
	List<FrigeVO> frige_list_vege(long user_id);	//재료 리스트 정보 가져오기(채소)
	List<FrigeVO> frige_list_fruit(long user_id);	//재료 리스트 정보 가져오기(과일)
	List<FrigeVO> frige_list_dairy(long user_id);	//재료 리스트 정보 가져오기(유제품)
	List<FrigeVO> frige_list_grain(long user_id);	//재료 리스트 정보 가져오기(곡류)
	List<FrigeVO> frige_list_season(long user_id);	//재료 리스트 정보 가져오기(조미료/주류)
	List<FrigeVO> frige_list_etc(long user_id);	//재료 리스트 정보 가져오기(음료/기타)
	
		//재료정보 수정하기
		//재료정보 삭제
}
