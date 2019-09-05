package edu.bit.mapper;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardMapperTest {

	@Inject 
	public BoardMapper boardMapper;
	
	//@Inject 
	//public BoardService boardService;
	
	@Ignore
	@Test
	public void testSelectBoardList() {
		BoardVO boardVO = boardMapper.selectBoardOne("522");
		System.out.println(boardVO.getbHit());
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Test
	public void testTransaction()  {
		
		try {
			BoardVO boardVO = boardMapper.selectBoardOne("6665");
			
			boardMapper.insertBoard(boardVO);
			
			
			//에러를 내기 위한 일부러 null을 만들어 버림
			boardVO.setbName(null);
			boardMapper.insertBoard(boardVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	

}
