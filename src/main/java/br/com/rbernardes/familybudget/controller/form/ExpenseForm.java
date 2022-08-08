package br.com.rbernardes.familybudget.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rbernardes.familybudget.model.Expense;

public class ExpenseForm {

	@NotNull @NotEmpty
	private String description;
	@NotNull @NotEmpty
	private Double value_expenseForm;
	@NotNull @NotEmpty
	private LocalDate date_expenseForm;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue_expenseForm() {
		return value_expenseForm;
	}
	
	public void setValue_expenseForm(Double value_expenseForm) {
		this.value_expenseForm = value_expenseForm;
	}
	
	public LocalDate getDate_expenseForm() {
		return date_expenseForm;
	}
	
	public void setDate_expenseForm(LocalDate date_expenseForm) {
		this.date_expenseForm = date_expenseForm;
	}

	public Expense converToExpense() {
		return new Expense(description, value_expenseForm, date_expenseForm);
	}
}
