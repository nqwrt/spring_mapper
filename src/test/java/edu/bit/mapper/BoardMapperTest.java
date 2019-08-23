package edu.bit.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Insert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.ex.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardMapperTest {

	@Inject 
	private BoardMapper boardMapper;
	
	
	@Test
	public void test1SelectBoardList() {
		BoardVO boardVO = boardMapper.selectBoardOne("1000");
		System.out.println(boardVO.getbHit());
	}

	@Test
	public void test2InsertBoard() {
		//insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, #{bName}, #{bTitle}, #{bContent}, 0, mvc_board_seq.currval, 0, 0 )")
		BoardVO boardVO = new BoardVO();
		boardVO.setbName("TooMuchTalker");
		boardVO.setbTitle("구구단을 외자");
		boardVO.setbContent("구구단을 외자");
		boardMapper.insertBoard(boardVO);
		System.out.println(boardVO);		
	}
	
	//public List<BoardVO> selectBoardList();
	@Test
	public void test3SelectAllBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boardMapper.selectBoardList();
		
		System.out.println(list.size());
	}
}
