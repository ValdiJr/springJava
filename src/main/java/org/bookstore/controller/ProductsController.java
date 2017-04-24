package org.bookstore.controller;

import org.bookstore.dao.ProductDAO;
import org.bookstore.models.Price.BookType;
import org.bookstore.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

	
	@RequestMapping("/form")
	public ModelAndView form(){
	ModelAndView modelAndView =
	new ModelAndView("products/form");
	modelAndView.addObject("types", BookType.values());
	return modelAndView;
	}
	@RequestMapping("/produtos")
	public String save(Product product) {
		System.out.println("Cadastrando o produto " + product);
		productDAO.save(product);
		return "products/ok";
	}

}
