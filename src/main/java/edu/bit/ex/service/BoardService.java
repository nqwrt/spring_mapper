package edu.bit.ex.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
import edu.bit.mapper.BoardMapper;

@Service
public class BoardService {

	@Inject
	BoardMapper boardMapper;
	
    public List<BoardVO> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
    }
    
	//@Transactional(propagation=Propagation.REQUIRES_NEW)  
	//@Transactional()  
    public void insertBoard(BoardVO boardVO) throws Exception {
    	boardMapper.insertBoard(boardVO);
    	
    	System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
    }

    public BoardVO selectBoardOne(String bId) throws Exception {
		return boardMapper.selectBoardOne(bId);
    }
    
    public List<BoardVO> selectBoardListPage(Criteria criteria) throws Exception {
		return boardMapper.selectBoardListPage(criteria);
    }
    
    public int selectAllBoard() throws Exception {
		return boardMapper.selectAllBoard();
    }
    
    public void updateShape(BoardVO param) throws Exception {
    	boardMapper.updateShape(param);
    }
    
    public void insertReply(BoardVO param) throws Exception {
    	boardMapper.insertReply(param);
    }
    
    //@Transactional()
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void tranTest() 
	{
		
		System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
/*		
		try {*/
			
			BoardVO bo = new BoardVO();
			bo.setbName("¿Ã∏ß");
			bo.setbContent("ƒ¡≈Ÿ√˜");
			bo.setbTitle("¡¶∏Ò");	
			
			boardMapper.insertBoard(bo);
			bo=null;
			boardMapper.insertBoard(bo);	
			
/*		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/

	}
    
    /*
    public List<BoardVO> selectBoardListPage(Criteria criteria)  {
		return sqlSession.selectList("selectBoardListPage",criteria);
    }
    
    public int selectTotal() throws Exception {
		return sqlSession.selectOne("selectTotal");
    }
    
    public void updateShape(BoardVO param) throws Exception {
		sqlSession.insert("updateShape", param);
    }
    
    public void insertReply(BoardVO param) throws Exception {
		sqlSession.insert("insertReply", param);
    }
    
    public void updateBoard(BoardVO param) throws Exception {
		sqlSession.insert("updateBoard1", param);
    }
     
    public BoardVO selectBoardOne(String bId) throws Exception {
		return sqlSession.selectOne("selectBoardOne", bId);
    }

    public void deleteBoardOne(String bId) throws Exception {
		sqlSession.delete("deleteBoardOne", bId);
    }
    */


    
}
