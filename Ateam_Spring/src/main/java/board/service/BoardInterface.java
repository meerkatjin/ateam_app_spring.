package board.service;

import java.util.List;

import board.dto.BoardDTO;

public interface BoardInterface {
	List<BoardDTO> notice_list();	//공지글 조회
}
