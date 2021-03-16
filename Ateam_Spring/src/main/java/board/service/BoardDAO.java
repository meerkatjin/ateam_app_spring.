package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.dto.BoardDTO;

@Repository
public class BoardDAO implements BoardInterface {
	@Autowired private SqlSession sql;

	@Override
	public List<BoardDTO> notice_list() {
		return sql.selectList("board.mapper.list");
	}

}
