package aht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {
	
	@GetMapping("/trang-user")
	public String trangChu() {
		return "trang-user";
	}
}
