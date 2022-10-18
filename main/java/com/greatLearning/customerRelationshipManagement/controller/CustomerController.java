package com.greatLearning.customerRelationshipManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.customerRelationshipManagement.entity.Customer;
import com.greatLearning.customerRelationshipManagement.service.CustomerService;




@Controller
@RequestMapping("/customer")
public class CustomerController {
	

		@Autowired
		private CustomerService customerService;
		
		//add mapping("/list)
		@RequestMapping("/list")
		public String listBooks(Model theModel) {
			System.out.println("request Recieved");
			
			//get students from database
			List<Customer>theCustomers=customerService.findAll();
			
			//add to the spring model
			theModel.addAttribute("Customers",theCustomers);
			
			return "list-customer";
		}
		@RequestMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			//create model attribute to bind form data
			
			Customer theCustomers=new Customer();
			
			theModel.addAttribute("Customers",theCustomers);
			 return "customer-form";
		}
		@RequestMapping("/showFormForUpdate")
		public String showFormFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
			
			//get the customer service
			Customer theCustomers= customerService.findById(theId);
			 
			 //set Book as a model attribute to pre-populate the form
			 theModel.addAttribute("Customers",theCustomers);
			 //send over to our form
			 return "customer-form";
		}
		
		@PostMapping("/save")
		public String saveStudent(@RequestParam("id") int id,@RequestParam("first_name") String firstName
				,@RequestParam("last_name") String lastName,
				@RequestParam("email") String eMail){
			System.out.println(id);
			Customer theCustomer;
			if(id!=0) {
				theCustomer=customerService.findById(id);
				theCustomer.setFirstName(firstName);
				theCustomer.setLastName(lastName);
				theCustomer.seteMail(eMail);
			}else {
				theCustomer=new Customer(firstName,lastName,eMail);
				//save the book
				customerService.save(theCustomer);
				
				//use a redirect to prevent duplicate submission
			}
				return "redirect:/customer/list";
			
			
		}
		@RequestMapping("/delete")
		public String delete(@RequestParam("customerId") int theId) {
			
			//delete the book
			customerService.deleteById(theId);
			
			//redirect to books/list
			return "redirect:/customer/list";
			
		}
		


}

