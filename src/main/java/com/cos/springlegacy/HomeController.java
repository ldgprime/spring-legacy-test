package com.cos.springlegacy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.springlegacy.dto.RequestInfoDto;

//http://localhost:8080/springlegacy/
//Controller 어노테이션은 페이지를 리턴하는 어노테이션이다.
@Controller
public class HomeController {
	
//	1. 데이터 전달 - 쿼리스트링, Form데이터, JSON
//	2. 데이터 받기 - 쿼리스트링, Form데이터, JSON
//	3. Pathvariable 사용해보기
	
	//톰켓이 제공하는 모든 객체는 매개변수자리에 적기만 하면  DI 함 필요할 때 적기만 함
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//Controller 어노테이션이 있는 클래스에서 함수가 return하는 순간
		//ViewResolver가 관여하여 prefix와 suffix를 만들어서
		//페이지를 return해준다.
		//requsetdispather는 controller,RestController를 찾는다.
		
		//request 에 담기 => modelandview  model은 request+requestdispather model은 request
		
		String username = "ssar";
		model.addAttribute("username", username);//Object타입
		

		
		return "home";
	}	
		
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(@RequestParam("id")String id, @RequestParam("pw")String pw,Model model) {//RequestParam 생략가능  QueryString,x-www-formurlencoded 방식만
		
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		
		
		model.addAttribute("id", id); model.addAttribute("pw", pw);
		 
		
		return "hello";
	}
	
	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String goodbye(RequestInfoDto requestInfoDto) {
		//매개변수에 클래스를 적으면 객체를 생성하고 매개변수로 addr,hobby를 넣어준다. 변수명은 중요하지 않고 getter,setter명으로 호출 스프링 private 접근 x
		
		System.out.println("addr: "+requestInfoDto.getAddr());
		System.out.println("addr: "+requestInfoDto.getHobby());
		
		return "goodbye";
	}
	
	
}
