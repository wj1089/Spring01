package com.occamsrazor.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {//internet server에 연결하는부분
		int current = memberService.count();
		String s="";
		memberService.add(member);//이걸 꼭 참고해야한다. 그래야 어떤걸가져올지 알음
		return(memberService.count()==(current+1))?Messenger.SUCCESS : Messenger.FAIL;

		
	}//페이지 그대로 남아있는다
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		return (memberService.login(member))? Messenger.SUCCESS:Messenger.FAIL;
	}
	@GetMapping("/list")
	public Member[] list(@RequestBody Member member) {
		Member[] members = new Member[5];
		return members;
	}
	@GetMapping("/detail")
	public Member detail(@RequestBody String name) {
		Member returnMember = new Member();
		return returnMember;
	}
	@GetMapping("/count")
	public int count(@RequestBody String name) {
		int count = 0;
		return count;
	}
	@GetMapping("/update")
	public Member update(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}
	@GetMapping("/delete")
	public Member delete(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}
}