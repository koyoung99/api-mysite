package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.BoardService;
import com.javaex.util.JsonResult;
import com.javaex.vo.BoardVo;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 리스트
	@GetMapping(value = "/api/board")
	public JsonResult list(Model model) {
		System.out.println("BoardController.list()");

		List<BoardVo> bList = boardService.exeList();

		return JsonResult.success(bList);
	}

	// 읽기
	@GetMapping(value = "/api/board/read/{no}")
	public JsonResult read(@PathVariable(value = "no") int no) {
		System.out.println("BoardController.read()");

		BoardVo boardVo = boardService.exeSelectOne(no);

		return JsonResult.success(boardVo);
	}

	// 삭제
	@DeleteMapping(value = "/api/board/delete/{no}")
	public JsonResult delete(@PathVariable(value = "no") int no) {
		System.out.println("BoardController.delete()");

		int count=boardService.exeDelete(no);

		return JsonResult.success(count);
	}

	
	// 등록
	@PostMapping(value = "/api/board/add")
	public JsonResult write(@RequestBody BoardVo boardVo) {
		System.out.println("BoardController.write()");

		int count=boardService.exeInsert(boardVo);

		return JsonResult.success(count);
	}

	// 수정폼
	@GetMapping(value = "/api/board/modify/{no}")
	public JsonResult modifyForm(@PathVariable(value = "no") int no) {
		System.out.println("BoardController.modifyForm()");

		BoardVo boardVo = boardService.exeSelectOne(no);
		System.out.println(boardVo);
		return JsonResult.success(boardVo);
	}

	// 수정
	@PutMapping(value = "/api/board/modify")
	public JsonResult modify(@RequestBody BoardVo boardVo) {
		System.out.println("BoardController.modify()");

		int count=boardService.exeModify(boardVo);

		return JsonResult.success(count);
	}

}
