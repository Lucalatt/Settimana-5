package i.lucal.epicode.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "home page";
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	public String login_success() {
		return "login success";
	}

}
