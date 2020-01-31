package com.cos.springlegacy;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springlegacy.dto.RequestJsonDto;

@Controller
public class JsonController {
	
	//스프링은 form의 name값과 혹은 쿼리스트링만 오브젝트로 자동변환!! Map 사용x  getreader()로 데이터를 받아야함.
	//@RequestBody 역할 bufferdreader 통신
	//@ResponseBody 역할 bufferdwriter 통신
	@RequestMapping(value = "/jsonTest", method = RequestMethod.POST)
	public @ResponseBody RequestJsonDto jsonHome(@RequestBody RequestJsonDto requestJsonDto) {//{제이슨데이터} @RequestBody가 없다면 requset.getParamter로 받는다.
													  //
													  //관점지향프로그램	
		
		System.out.println(requestJsonDto.getId());
		
		return requestJsonDto;//viewResolver가 관여 오류가 남
	}
	
	//http://localhost:8080/springlegacy/jsonHome/1
	@RequestMapping (value = "/jsonHome/{num}",method = RequestMethod.GET)
	public String jsonHome(@PathVariable("num") int num) {// 생략 불가
		
		System.out.println("num: "+num);
		
		return "jsonHome";
	}
	
	
	
}
