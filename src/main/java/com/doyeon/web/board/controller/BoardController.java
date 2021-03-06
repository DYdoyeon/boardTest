package com.doyeon.web.board.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doyeon.web.board.model.BoardVO;

import com.doyeon.web.board.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getBoardList.do", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {

		model.addAttribute("boardList", boardService.getBoardList());

		return "board/index";

	}

	@RequestMapping("/boardForm")

	public String boardForm() {

		return "board/boardForm";

	}

	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {

		boardService.insertBoard(boardVO);

		return "redirect:/board/getBoardList";

	}

}
