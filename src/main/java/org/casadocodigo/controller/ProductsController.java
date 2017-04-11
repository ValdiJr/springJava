package org.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ProductsController {

	@RequestMapping("/produtos/form")
	public String form(){
	return "products/form";
	}
	


}
