package com.occamsrazor.web.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Credit;
import com.occamsrazor.web.util.Messenger;

	@RestController
	@RequestMapping("/grade")
	public class GradeController{
		@Autowired GradeService gradeService;
		@PostMapping("/register")
		public Messenger register(@RequestBody Grade grade) {
			int current = gradeService.count();
			gradeService.add(grade);
			return (gradeService.count() == current+1)?Messenger.SUCCESS:Messenger.FAIL;
		}
	
		@GetMapping("/report/{userid}")//{필드}d안 값이 밑에 path v String userid로 들어온다.
		public Credit report(@PathVariable String userid) {
			System.out.println("report 성공!!");
			return gradeService.detail(userid);
		}
}
	














//@RestController
//@RequestMapping("/grade")
//public class GradeController {
//	@Autowired GradeService gradeService;
//
//	@PostMapping("/add")
//	public Messenger add(@RequestBody Grade grade) {
//		int current = gradeService.count();
//		gradeService.add(grade);
//		return (gradeService.count() == (current+1))?Messenger.SUCCESS : Messenger.FAIL;
//
//	}
//	@PostMapping("/record")
//	public int record(@RequestBody Grade grade) {
//			int record = gradeService.record(grade);
//			return record;
//	}

	

