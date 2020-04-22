package com.occamsrazor.wed.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/")
public class LottoController {
		@Autowired LottoService lottoService;
		
		@PostMapping("/register")
		public Messenger register(@RequestBody Lotto lotto) {
			System.out.println("로또 데이터 넘어옴");
			int current  = lottoService.count();
			lottoService.add(lotto);
			
			return (lottoService.count() == current+1)? Messenger.SUCCESS:Messenger.FAIL;
		}
}
