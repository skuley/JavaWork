package com.lec.sts19_rest.ajax.command;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.beans.BWriteDTO;

public interface Command {
	void execute(Model model);

}
