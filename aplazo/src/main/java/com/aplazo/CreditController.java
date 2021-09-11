package com.aplazo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplazo.entity.Credit;
import com.aplazo.entity.Plazo;

@RestController
@RequestMapping (value="payments")
public class CreditController {
	
	@Autowired
	private ITaskService taskService;
	
	@GetMapping("/getPayments")
	public List<Plazo>  getTasks(@RequestBody Credit credit) {
		
		return taskService.getTask(credit);
	}
	
	
	
}
