package kr.or.kosta.springmvc.board.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.springmvc.board.domain.Board;
import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.PageMaker;
import kr.or.kosta.springmvc.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = Logger.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public void createGET(Board board, Model model) {
		logger.info("create get...........");
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createPOST(Board board, RedirectAttributes rttr) throws Exception {
		logger.info("create post.............");
		logger.info(board);
		
		service.create(board);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
//		model.addAttribute("result", "success");
		
//		return "/board/success";
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list...........................");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listCri(Criteria cri, Model model) throws Exception {
		logger.info("show list Page with Criteria..............");
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(131);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,
			         @ModelAttribute("cri") Criteria cri,
			         Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("bno")int bno, RedirectAttributes rttr) throws Exception {
		
		service.delete(bno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/deletePage", method=RequestMethod.POST)
	public String deletePOST(@RequestParam("bno")int bno, Criteria cri, RedirectAttributes rttr) throws Exception{
		
		service.delete(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void updateGET(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePOST(Board board, RedirectAttributes rttr) throws Exception{
		
		logger.info("update post................");
		service.update(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return  "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public void updatePagingGET(@RequestParam("bno") int bno,
			                    @ModelAttribute("cri") Criteria cri,
			                    Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value="/updatePage", method=RequestMethod.POST)
	public String updatePagingPOST(Board board,
			@ModelAttribute("cri")Criteria cri,
			RedirectAttributes rttr) throws Exception {
		service.update(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
}
