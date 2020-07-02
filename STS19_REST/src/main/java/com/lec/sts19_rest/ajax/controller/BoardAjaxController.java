package com.lec.sts19_rest.ajax.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.command.BListCommand;

@RestController
@RequestMapping("/rest")
public class BoardAjaxController {
	
	@RequestMapping("/")
	public void ajaxList(Model model) {
		new BListCommand().execute(model);
		
	}
}
