package com.occamsrazor.web.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Credit;
import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;
	
	@PostMapping("/add")
	public Messenger add(@RequestBody Grade grade) {
		int current = gradeService.count();
		gradeService.add(grade);
		return (gradeService.count() == (current+1))?Messenger.SUCCESS : Messenger.FAIL;
		
	}
	@PostMapping("/record")
	public Credit record(@RequestBody Grade grade) {
			Credit record = gradeService.record(grade);
			return record;
	}
	
}
