package com.occamsrazor.wed.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;
import com.occamsrazor.web.util.Rank;

@RestController
@RequestMapping("/lotto")
public class LottoController {
		@Autowired LottoService lottoService;
		
		@PostMapping("/buy")
		public Messenger register(@RequestBody Lotto lotto) {
			System.out.println("로또 데이터 넘어옴");
			int current  = lottoService.count();
			lottoService.add(lotto);
			return (lottoService.count() == current+1)? Messenger.SUCCESS:Messenger.FAIL;
		}
		@GetMapping("/lottoNumber")
		public String lottoNumber() {
			return lottoService.lottoNum();
		}
		
		@GetMapping("/user/lotto")
		public String myNumber(@PathVariable String userid) {
			Lotto result = lottoService.detail(userid);
			return result.getLotto();
		}
		@GetMapping("/rank/{userid}")
		public Rank checkRank(@PathVariable String userid) {
			return lottoService.checkRank(userid);
		}
}
