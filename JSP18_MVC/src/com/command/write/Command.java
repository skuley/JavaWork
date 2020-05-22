/**
 * 
 */
package com.command.write;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command 라는 interface
 *
 */
public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
