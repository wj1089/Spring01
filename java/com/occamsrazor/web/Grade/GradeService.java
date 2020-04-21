package com.occamsrazor.web.Grade;

import com.occamsrazor.web.util.Credit;

public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public Grade detail(String userid);
	public int count();
	public void update(Grade grade);
	public void delete(Grade grade);
	public int total(Grade grade);
	public int average(Grade grade);
	public Credit record(Grade grade);
}
