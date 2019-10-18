package kr.co.itcen.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@RequestMapping 단독 mapping*/

@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestBookController:list()";
	}
}
