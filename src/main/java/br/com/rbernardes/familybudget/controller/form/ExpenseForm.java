package br.com.rbernardes.familybudget.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rbernardes.familybudget.model.Expense;

public class ExpenseForm {

	@NotNull @NotEmpty
	private String description;
	
	@NotNull
	private Double value;
	
	@NotNull @DateTimeFormat
	private LocalDate date;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue_expenseForm() {
		return value;
	}
	
	public void setValue_expenseForm(Double value) {
		this.value = value;
	}
	
	public LocalDate getDate_expenseForm() {
		return date;
	}
	
	public void setDate_expenseForm(LocalDate date) {
		this.date = date;
	}

	public Expense converToExpense() {
		return new Expense(description, value, date);
	}
}
