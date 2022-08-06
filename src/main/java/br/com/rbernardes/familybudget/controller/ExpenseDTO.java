package br.com.rbernardes.familybudget.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rbernardes.familybudget.model.Expense;

public class ExpenseDTO {

	private Long id;
	private String description;
	private Double value;
	private LocalDate date;
	
	public ExpenseDTO(Expense expense) {
		this.id = expense.getId();
		this.description = expense.getDescription();
		this.value = expense.getValue();
		this.date = expense.getDate();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Double getValue() {
		return value;
	}

	public LocalDate getDate() {
		return date;
	}

	public static List<ExpenseDTO> convertToDto(List<Expense> expenses) {
		return expenses.stream().map(ExpenseDTO::new).collect(Collectors.toList());
	}
}
