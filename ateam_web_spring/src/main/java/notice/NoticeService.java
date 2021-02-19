package notice;

import java.util.List;

import common.CommuVO;

public interface NoticeService {
	
	void notice_insert(CommuVO vo);	//공지글 저장
	List<CommuVO> notice_list();	//공지글 조회
	NoticePage notice_list(NoticePage page);//페이지단위로 공지글목록조회
	List<CommuVO> notice_view(int id);	//공지글 상세보기
	void notice_update(CommuVO vo);	//공지글 변경저장
	void notice_delete(int id);	//공지글 삭제

}
