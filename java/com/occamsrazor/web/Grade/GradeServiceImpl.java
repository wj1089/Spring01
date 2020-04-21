package com.occamsrazor.web.Grade;

import com.occamsrazor.web.util.Credit;

public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;
	
	public GradeServiceImpl() {
		grades = new Grade[5];
		count=0;
	}
	
	@Override
	public Grade[] list() {
		return grades;
	}

	@Override
	public Grade detail(String userid) {
		Grade returnGrade = null;
		for(int i =0;i<count;i++) {
			if(userid.equals(grades[i].getUserid())) {
			}
		}
		return returnGrade;
	}

	@Override
	public void add(Grade grade) {
		grade = grades[count];
		count++;
		
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public void update(Grade grade) {
		for(int i=0;i<count;i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i].setKorean(grade.getKorean());
				grades[i].setEnglish(grade.getEnglish());
				grades[i].setMeth(grade.getMeth());
				grades[i].setJava(grade.getJava());
				break;
			}
		}
	}

	@Override
	public void delete(Grade grade) {
		for(int i=0; i<count;i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i] = grades[count-1];
				grades[count-1] = null;
				count--;
			}
		}
		
	}

	@Override
	public int total(Grade grade) {
		int total = 0;
		for(int i=0;i<count;i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				total = Integer.parseInt(grades[i].getKorean())
					  + Integer.parseInt(grades[i].getEnglish())
					  + Integer.parseInt(grades[i].getMeth())
					  + Integer.parseInt(grades[i].getJava());
					  break;
			}
		}
		return total;
	}

	@Override
	public int average(Grade grade) {
		return total(grade)/4;
	}

	@Override
	public Credit record(Grade grade) {
		Credit record =  Credit.F;
		for(int i=0; i<count;i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				switch(average(grade)/10) {
				case 10: case 9: record = Credit.A;
				break;
			case 8: record = Credit.B;
				break;
			case 7: record = Credit.C;
				break;
			case 6: record = Credit.D;
				break;
			case 5: record = Credit.E;
				break;
				}
			}
		}
		return record;
	}
}
