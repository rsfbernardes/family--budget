package br.com.rbernardes.familybudget.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rbernardes.familybudget.controller.dto.ExpenseDTO;
import br.com.rbernardes.familybudget.controller.form.ExpenseForm;
import br.com.rbernardes.familybudget.controller.form.UpdateExpenseForm;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExpenseDTO> expenseById(@PathVariable @Valid Long id) {
		Optional<Expense> expense = expenseRepository.findById(id);
		if(expense.isPresent()) {
			return ResponseEntity.ok(new ExpenseDTO(expense.get()));			
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ExpenseDTO> addExpense(@RequestBody @Valid ExpenseForm expenseForm, UriComponentsBuilder uriBuilder) {
		Expense expense = expenseForm.converToExpense();
		expenseRepository.save(expense);
		
		URI uri = uriBuilder.path("expenses/{id}").buildAndExpand(expense.getId()).toUri();
		return ResponseEntity.created(uri).body(new ExpenseDTO(expense));
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ExpenseDTO> expenseUpdate(@PathVariable @Valid Long id, @RequestBody @Valid UpdateExpenseForm updateExpenseForm) {
		Optional<Expense> optional = expenseRepository.findById(id);
		if(optional.isPresent()) {
			Expense expense = updateExpenseForm.update(id, expenseRepository);
			return ResponseEntity.ok(new ExpenseDTO(expense));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> expenseDelete(@PathVariable @Valid Long id){
		Optional<Expense> optional = expenseRepository.findById(id);
		if(optional.isPresent()) {
			expenseRepository.deleteById(id);
			return ResponseEntity.ok().build();			
		}
		
		return ResponseEntity.notFound().build();
	}
}
