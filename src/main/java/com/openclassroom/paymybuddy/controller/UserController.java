package com.openclassroom.paymybuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassroom.paymybuddy.model.User;
import com.openclassroom.paymybuddy.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	

	@GetMapping(value = {"/", "/home"})
	public String viewHomePage(Model model) {
		
		return findPaginated(1, model);
		
	}
	
	@GetMapping(value = "/signup")
	public String signup() {
		
		return "signup";
	}
	
	@PostMapping(value = "/signup")
	public ModelAndView signUp(User user) {
		
		ModelAndView mv = new ModelAndView("/home");
		userService.saveUser(user);
		mv.addObject("userList", userService.getUsers());
		
		return mv;
	}
	
	@GetMapping(value = "/showNewUserForm")
	public String showNewUserForm(Model model) {
		
		User user = new User();
		model.addAttribute("user",user);
		return "new_user";
	}
	
	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		
		userService.saveUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/deleteUser/{userId}")
	public String deleteUser(@PathVariable(value = "userId") long userId) {
		
		this.userService.deleteUser(userId);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/showUpdateForm/{userId}")
	public String showUpdateForm(@PathVariable(value = "userId") long userId, Model model) {
		
		User user = userService.getUserById(userId).get();
		
		//définit User comme attribut de modèle pour pré-remplir le formulaire
		
		model.addAttribute("user", user);
		
		return "/update_user";
	}
	
	// meme role que @PostMapping(value = "/saveUser")
	
	@PostMapping(value = "/updateUser")
	public String updateUser(@ModelAttribute("user") User user) {
		
		userService.updateUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping(value="/showUserListForm")
	public String showUserListForm(Model model) {
		
		model.addAttribute("userList", userService.getUsers());
		return "userList";
	}
	
	
	@GetMapping(value = "/showNewConnectionForm")
	public String showNewConnectionForm(Model model) {
		
		model.addAttribute("userList", userService.getUsers());
		return "addNewConnection";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		
		int pageSize = 5;
		
		Page<User> page = userService.findPaginated(pageNo, pageSize);
		List<User> userList = page.getContent();
		

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("userList",userList);
		
		return "home";
	}
	
	
	
	
	/*
	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
	public String addUser(@Validated User user, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "/addUser";
		}
		
		userservice.saveUser(user);
		return "redirect:/userList";
	}
	
	
	@GetMapping("/userList")
	public String showUserList(Model model) {
		
		model.addAttribute("users", userservice.getUsers());
		
		return "/userList";
	}
	
	*/

}
