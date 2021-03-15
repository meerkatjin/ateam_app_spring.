package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.dto.BoardDTO;

@Service
public class BoardService implements BoardInterface {
	@Autowired private BoardDAO dao;

	@Override
	public List<BoardDTO> notice_list() {
		return dao.notice_list();
	}
}
