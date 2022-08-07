package br.com.rbernardes.familybudget.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rbernardes.familybudget.model.Expense;

public class ExpenseDTO {

	private Long id;
	private String description;
	private Double value_expense;
	private LocalDate date_expense;
	
	public ExpenseDTO(Expense expense) {
		this.id = expense.getId();
		this.description = expense.getDescription();
		this.value_expense = expense.getValue();
		this.date_expense = expense.getDate();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Double getValue() {
		return value_expense;
	}

	public LocalDate getDate() {
		return date_expense;
	}

	public static List<ExpenseDTO> convertToDto(List<Expense> expenses) {
		return expenses.stream().map(ExpenseDTO::new).collect(Collectors.toList());
	}
}
