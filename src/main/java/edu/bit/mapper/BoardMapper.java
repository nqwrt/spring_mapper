package edu.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardMapper {

	@Select("select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc")
	public List<BoardVO> selectBoardList();
	
	@Insert("insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, #{bName}, #{bTitle}, #{bContent}, 0, mvc_board_seq.currval, 0, 0 )")
	public void insertBoard(BoardVO param);
	
	@Select("select * from mvc_board where bId = #{bId}")
	public BoardVO selectBoardOne(String bId);
	
	@Select("select count(*) from mvc_board")
	public int selectAllBoard();
	
	@Update("update mvc_board set bStep = bStep + 1 where bGroup = #{bGroup} and bStep > #{bStep}")
	public void updateShape(BoardVO boardVO);
	
	@Insert("insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, #{bName}, #{bTitle},#{bContent}, #{bGroup}, #{bStep}+1, #{bIndent}+1)")
	public void insertReply(BoardVO boardVO);
	
/*	 <update id="updateShape" parameterType="edu.bit.ex.vo.BoardVO" >
 	update mvc_board set bStep = bStep + 1 where bGroup = #{bGroup} and bStep > #{bStep}
	</update>
	
	<insert id="insertReply" parameterType="edu.bit.ex.vo.BoardVO" >
 	insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, #{bName}, #{bTitle},#{bContent}, #{bGroup}, #{bStep}+1, #{bIndent}+1)
	</insert>*/
	
    public List<BoardVO> selectBoardListPage(Criteria criteria); 
    
    
 
}
