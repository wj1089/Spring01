package com.occamsrazor.web.Grade;

import com.occamsrazor.web.util.Credit;

public interface GradeService {
	
	public void add(Grade grade);
	public int count();
	public Credit detail(String userid);
}
