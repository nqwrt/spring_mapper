package edu.bit.mapper;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.ex.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardMapperTest {

	@Inject 
	private BoardMapper boardMapper;
	
	
	@Test
	public void testSelectBoardList() {
		BoardVO boardVO = boardMapper.selectBoardOne("522");
		System.out.println(boardVO.getbHit());
	}


}
