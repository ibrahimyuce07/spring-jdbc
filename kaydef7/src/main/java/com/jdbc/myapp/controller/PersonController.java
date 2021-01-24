package com.jdbc.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdbc.myapp.dao.PersonDao;
import com.jdbc.myapp.model.Person;
import com.jdbc.myapp.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/list")
	public String getPersonList(Model model) {
		List<Person> personList = personService.getPersonList();
		model.addAttribute("personList", personList);
		return "list-person";
	}
	
	@GetMapping("/showFormForAdd")
	public String showCreateForm(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "save-form";
	}
	
	@PostMapping("/savePerson")
	public String createPerson(@ModelAttribute("person") Person person) {
		personService.createPerson(person);
		return "redirect:/person/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int theId, Model model) {
		Person person = personService.getPerson(theId);
		model.addAttribute("person", person);
		return "save-form";
		
	}
}
