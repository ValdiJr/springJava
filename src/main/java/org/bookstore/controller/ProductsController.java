package org.bookstore.controller;

import javax.validation.Valid;

import org.bookstore.dao.ProductDAO;
import org.bookstore.models.Price.BookType;
import org.bookstore.models.Product;
import org.bookstore.utils.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
@RequestMapping("/produtos")

public class ProductsController {
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	binder.setValidator(new ProductValidator());
	}
	@Autowired
	private ProductDAO productDAO;

	
	@RequestMapping("/form")
	public ModelAndView form(){
	ModelAndView modelAndView =
	new ModelAndView("products/form");
	modelAndView.addObject("types", BookType.values());
	return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(@Valid Product product,
			RedirectAttributes redirectAttributes, BindingResult bindingResult
			) {
		
		if(bindingResult.hasErrors()){
			System.out.println("ERRRRRRROUUUUUUU");
			return "redirect:produtos/form";
			
			}else{
				System.out.println("PASSSSOUUUUU");		
		System.out.println("Cadastrando o produto " + product);
		redirectAttributes.addFlashAttribute("sucesso",
				"Produto cadastrado com sucesso");
		productDAO.save(product);
		return "redirect:produtos";}
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
	ModelAndView modelAndView =
	new ModelAndView("products/list");
	modelAndView.addObject("products", productDAO.list());
	return modelAndView;
	}


}
