package com.occamsrazor.web.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	public MemberService memberService;
	
	@PostMapping("/join")
	public Member add(@RequestBody Member member) {//internet server에 연결하는부분
		System.out.println(">>>>>");
		System.out.println(member.toString());
		memberService = new MemberServiceImpl();
		memberService.add(member);
		return member;
	}//Service안 배열로 들어간다.
}