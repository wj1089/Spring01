package com.occamsrazor.wed.lotto;

import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements LottoService{

	private Lotto[] lottos;
	private int count;
	
	public LottoServiceImpl() {
		lottos =  new Lotto[5];
		count =0;
		
	}
	
	@Override
	public void add(Lotto lotto) {
		lottos[count] = lotto;
		count++;
		
	}

	@Override
	public int count() {
		return count;
	}

	private String lottoNumber(String lottoNumber) {
		
		for(int i=0; i<Math.random();i++) {
			if(lottoNumber.equals(lottos[i].getLottoNumber())) {
				
			}
		}
		return null;
	}
	
	
	
	
}
