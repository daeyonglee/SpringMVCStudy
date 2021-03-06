package kr.or.kosta.springmvc.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.springmvc.board.domain.Criteria;
import kr.or.kosta.springmvc.board.domain.PageMaker;
import kr.or.kosta.springmvc.board.domain.Reply;
import kr.or.kosta.springmvc.board.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Reply reply) throws Exception {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.addReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<Reply>> list(@PathVariable("bno") int bno) {
		
		ResponseEntity<List<Reply>> entity = null;
		
		try {
			entity = new ResponseEntity<List<Reply>>(service.listReply(bno), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<Reply>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{rno}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	  public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody Reply vo) {

	    ResponseEntity<String> entity = null;
	    try {
	      vo.setRno(rno);
	      service.updateReply(vo);

	      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    return entity;
	  }
	@RequestMapping(value="/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") int rno){
		
		ResponseEntity<String> entity = null;
		
		try {
			service.deleteReply(rno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno") int bno
			                                          , @PathVariable("page") int page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<Reply> list = service.listReplyPage(bno, cri);
			
			map.put("list", list);
			
			int replyCount = service.count(bno);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
}
