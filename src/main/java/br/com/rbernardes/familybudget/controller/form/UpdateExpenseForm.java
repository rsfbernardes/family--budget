package br.com.rbernardes.familybudget.controller.form;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rbernardes.familybudget.model.Expense;
import br.com.rbernardes.familybudget.repository.ExpenseRepository;

public class UpdateExpenseForm {

	@NotNull @NotEmpty
	private String description;
	
	@NotNull
	private Double value_expense;
	
	@NotNull @DateTimeFormat
	private LocalDate date_expense;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue_expense() {
		return value_expense;
	}
	
	public void setValue_expense(Double value_expense) {
		this.value_expense = value_expense;
	}
	
	public LocalDate getDate_expense() {
		return date_expense;
	}
	
	public void setDate_expense(LocalDate date_expense) {
		this.date_expense = date_expense;
	}
	
	public Expense converToExpense() {
		return new Expense(description, value_expense, date_expense);
	}

	public Expense update(@Valid Long id, ExpenseRepository expenseRepository) {
		Expense expense = expenseRepository.getReferenceById(id);
		expense.setDescription(this.description);
		expense.setValue(this.value_expense);
		expense.setDate(this.date_expense);
		return expense;
	}
}
