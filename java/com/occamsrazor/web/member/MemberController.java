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
		//@service와 연결을위해 new대신에서  @Autowired를 쓰인다
		@PostMapping("/join")
		public Messenger add(@RequestBody Member member) {
			int current = memberService.count();
			String s = "";
			memberService.add(member);
			return (memberService.count()==(current+1))?Messenger.SUCCESS:Messenger.FAIL;
		}
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		return (memberService.login(member))?Messenger.SUCCESS:Messenger.FAIL;
	}
	@GetMapping("/list")
	public Member[] list(@RequestBody String name) {
		Member[] returMember = new Member[5];
		return returMember;
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
