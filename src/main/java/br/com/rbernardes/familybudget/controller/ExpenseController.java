package br.com.rbernardes.familybudget.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbernardes.familybudget.model.Expense;
import br.com.rbernardes.familybudget.repository.ExpenseRepository;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@GetMapping("/expenses")
	public List<ExpenseDTO> expenseList(){
		
		List<Expense> expenses = expenseRepository.findAll();
		return ExpenseDTO.convertToDto(expenses);
	}
}
