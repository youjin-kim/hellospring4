package kr.co.itcen.hellospring.controller;

//import java.io.IOException;
//import java.io.Writer;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; // contextPath() : 기술이라서 spring에서 숨김
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		String data = "Hello World2";

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", data);
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}

	@RequestMapping("/hello3")
	public String hello3(Model model) { // 이 방법을 더 추천!!!!!
		String data = "Hello World3";
		model.addAttribute("data", data);

		return "hello";
	}

	@RequestMapping("/hello4")
	public String hello4(@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "age", required = true, defaultValue = "") int age, Model model) {

		model.addAttribute("email", email);
		model.addAttribute("age", age);

		return "hello";
	}

	@RequestMapping("/hello5")
	public String hello5(@ModelAttribute User user, Model model) {   //@ModelAttribute를 붙여주는게 좋다!!

		System.out.println(user);
		
		model.addAttribute("email", user.getEmail());
		model.addAttribute("age", user.getAge());

		return "hello";
	}
	
	@ResponseBody
	@RequestMapping("/hello7")
	public String hello7() {
		return "<h1>HelloWorld</h1>";
	}

}
