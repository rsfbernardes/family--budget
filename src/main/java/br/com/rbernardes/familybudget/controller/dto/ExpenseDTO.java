package br.com.rbernardes.familybudget.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rbernardes.familybudget.model.Expense;

public class ExpenseDTO {

	private String description;
	private Double value;
	private LocalDate date;
	
	public ExpenseDTO(Expense expense) {
		this.description = expense.getDescription();
		this.value = expense.getValue();
		this.date = expense.getDate();
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
