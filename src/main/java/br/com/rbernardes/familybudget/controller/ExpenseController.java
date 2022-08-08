package br.com.rbernardes.familybudget.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rbernardes.familybudget.controller.dto.ExpenseDTO;
import br.com.rbernardes.familybudget.controller.form.ExpenseForm;
import br.com.rbernardes.familybudget.model.Expense;
import br.com.rbernardes.familybudget.repository.ExpenseRepository;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@GetMapping
	public List<ExpenseDTO> expenseList(){
		List<Expense> expenses = expenseRepository.findAll();
		return ExpenseDTO.convertToDto(expenses);
	}
	
	@PostMapping
	public ResponseEntity<ExpenseDTO> addExpense(@RequestBody @Valid ExpenseForm expenseForm, UriComponentsBuilder uriBuilder) {
		Expense expense = expenseForm.converToExpense();
		expenseRepository.save(expense);
		
		URI uri = uriBuilder.path("expenses/{id}").buildAndExpand(expense.getId()).toUri();
		return ResponseEntity.created(uri).body(new ExpenseDTO(expense));
	}
}
