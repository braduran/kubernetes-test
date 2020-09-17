package carga.test.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
	
	@GetMapping("process/{key}") 
	public String test(@PathVariable("key") int loop) { 
		for(int i = 0; i <= loop; i++) {
			System.out.println(i + " sqrt: " + Math.sqrt(i));
		}
		return "Terminado";
	} 

}
