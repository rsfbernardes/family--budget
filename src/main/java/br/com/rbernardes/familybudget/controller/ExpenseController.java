package br.com.rbernardes.familybudget.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbernardes.familybudget.model.Expense;

@RestController
public class ExpenseController {

	@GetMapping("/expenses")
	public List<Expense> expenseList(){
		Expense expense = new Expense(1l, "gas", 100.00d, LocalDate.now());
		return Arrays.asList(expense, expense, expense);
	}

}
