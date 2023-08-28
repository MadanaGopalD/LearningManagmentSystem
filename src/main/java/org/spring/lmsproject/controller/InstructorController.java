package org.spring.lmsproject.controller;

import java.util.List;

import org.spring.lmsproject.config.dto.SearchDto;
import org.spring.lmsproject.entity.Instructor;
import org.spring.lmsproject.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
//	private InstructorDao instructorDao;

	@GetMapping("/home")
	public String showInstructorHomePage(Model model) {
		List<Instructor> instructors = instructorService.findAllInstructor();
		System.out.println(instructors);
		model.addAttribute("instructors", instructors);
		model.addAttribute("search", new SearchDto());
		return "Home";
	}

	@RequestMapping("/user-reg")
	public String showAddInstructorPage(/* Model model */ @ModelAttribute("instructor") Instructor instructor) {

//		model.addAttribute("instructor", new Instructor());
		return "user-reg";
	}

	@PostMapping("/save-instructor")
	public String addNewInstructor(Instructor instructor) {
		instructorService.saveInstructor(instructor);
		return "redirect:/home";
	}

//	@RequestMapping("/search")
//	public String search(@RequestParam("id") int id,Model model)
//	{
//		Instructor instructor=instructorService.searchInstructor(id);
//		System.out.println(instructor);
//		ArrayList<Instructor> instructors=new ArrayList<>();
//		instructors.add(instructor);
//		model.addAttribute("instructors",instructors);
//		model.addAttribute("search", new SearchDto());
//		return "Home";
//	}

	@RequestMapping("/search")
	public String search(@RequestParam("name") String name, Model model) {
		List<Instructor> instructors = instructorService.searchInstructorByName(name);
		model.addAttribute("instructors", instructors);
		model.addAttribute("search", new SearchDto());
		return "Home";
	}

	@RequestMapping("/delete/{id}")
	public String deleteInstructor(@PathVariable("id") int id) {
		instructorService.deleteInstructor(id);
		return "redirect:/home";
	}
}
