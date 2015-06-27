package com.mycompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.domain.Contact;
import com.mycompany.service.ContactService;

@Controller("/")
public class ContactController {

	
	@Autowired
	private ContactService contactService;
	
//	@RequestMapping()
//	public void list(Model model)
//	{
//		List<Contact> contacts = contactService.getAll();
//		model.addAttribute(contacts);
//	}

	
     
	@RequestMapping(value="/list")
	public ModelAndView list(Model model)
	{
		ModelAndView mv = new ModelAndView("list");
		List<Contact> contacts = contactService.getAll();
		mv.addObject("e", contacts.size());
		//Contact contact = contacts.get(0);
		
		mv.addObject("contacts", contacts);
		
		return mv;
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add()
	{
		ModelAndView mv = new ModelAndView("contactForm");
		mv.addObject("contact", new Contact());
		
		List<String> gen = new ArrayList<String>();
		gen.add("man");
		gen.add("woman");
		gen.add("gay");
		
		
		List<String> country = new ArrayList<String>();
		country.add("America");
		country.add("Aruba");
		country.add("Cuba");
		country.add("Domenica");
		country.add("Germany");
		country.add("Japan");
		country.add("Netherlands");

		mv.addObject("gen",gen);
		mv.addObject("country",country);
		
		
		return mv;
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public String save(@ModelAttribute Contact contact,BindingResult result)
	{
		if(!result.hasErrors())
			{
			contactService.save(contact);
			
			}
		
		return "redirect:list.htm";
		
		
	}
	
	@RequestMapping("/remov/{cid}")
	public String remov(@PathVariable Integer cid)
	{
		contactService.delete(cid);

		
		return "redirect:/list.htm";
	}
	
	@RequestMapping(value="/edita",method = RequestMethod.GET)
	public ModelAndView edita(@RequestParam("id") Integer id)
	{
		Contact contact = contactService.findbyId(id);
		
		ModelAndView mv = new ModelAndView("edit");
		
		mv.addObject("contact", contact);
		
		List<String> gen = new ArrayList<String>();
		gen.add("man");
		gen.add("woman");
		gen.add("gay");
		
		
		List<String> country = new ArrayList<String>();
		country.add("America");
		country.add("Aruba");
		country.add("Cuba");
		country.add("Domenica");
		country.add("Germany");
		country.add("Japan");
		country.add("Netherlands");

		mv.addObject("gen",gen);
		mv.addObject("country",country);
		return mv;
	}
	
	@RequestMapping(value="/edit",method= RequestMethod.POST)
	public String edit(@ModelAttribute("contact") Contact contact,BindingResult result)
	{
		
		if(!result.hasErrors())
			{
	
			contactService.update(contact);
			
			}
		
		return "redirect:/list.htm";
		
		
	}
	

	
}
