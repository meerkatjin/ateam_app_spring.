package notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.CommuVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired private NoticeDAO dao;

	@Override
	public void notice_insert(CommuVO vo) {
		dao.notice_insert(vo);
		
	}

	@Override
	public List<CommuVO> notice_list() {
		// TODO Auto-generated method stub
		return dao.notice_list();
	}

	@Override
	public List<CommuVO> notice_view(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notice_update(CommuVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notice_delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NoticePage notice_list(NoticePage page) {
		return dao.notice_list(page);
	}

}
