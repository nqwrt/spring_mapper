package edu.bit.ex.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.PageMaker;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BController {

	
	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		System.out.println("list()");
		model.addAttribute("list", boardService.selectBoardList());
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception {
		System.out.println("write()");

		boardService.insertBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) throws Exception{
		System.out.println("content_view()");

		String bId = request.getParameter("bId");		
		model.addAttribute("content_view", boardService.selectBoardOne(bId));
		
		return "content_view";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST )
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) throws Exception{
		System.out.println("reply_view()");

		String bId = request.getParameter("bId");		
		model.addAttribute("reply_view", boardService.selectBoardOne(bId));
		return "reply_view";
	}
	
	@Transactional(rollbackFor=Exception.class)
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO,HttpServletRequest request, Model model) throws Exception {
		System.out.println("reply()");

		//트랜잭션을 위한 예제.
		
		boardService.updateShape(boardVO);
		
		//에러를 내기 위한 일부러 null을 만들어 버림
		boardVO.setbName(null);
		boardService.insertReply(boardVO);	
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) throws Exception {
		System.out.println("delete()");

		//String bId = request.getParameter("bId");
		//boardService.deleteBoardOne(bId); 
		
		return "redirect:list";
	}
	
	@RequestMapping("/list2")
	public void list3(Criteria criteria, Model model) throws Exception {
		System.out.println("list2()");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		System.out.println(criteria.getPerPageNum());
		System.out.println(criteria.getPage());
		
   
	    int totalCount = boardService.selectAllBoard();
	    System.out.println(totalCount);
	    System.out.println("전체 게시물 수를 구함:" + totalCount);
		pageMaker.setTotalCount(totalCount);
       
		List<BoardVO> boardList = boardService.selectBoardListPage(criteria); 
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageMaker", pageMaker);

		//return "redirect:list";
	}
	
}
