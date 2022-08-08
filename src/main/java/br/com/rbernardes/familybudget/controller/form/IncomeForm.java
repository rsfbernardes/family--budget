package br.com.rbernardes.familybudget.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rbernardes.familybudget.model.Income;

public class IncomeForm {

	@NotNull @NotEmpty
	private String description;
	@NotNull @NotEmpty
	private Double value_incomeForm;
	@NotNull @NotEmpty
	private LocalDate date_incomeForm;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue_incomeForm() {
		return value_incomeForm;
	}
	
	public void setValue_incomeForm(Double value_incomeForm) {
		this.value_incomeForm = value_incomeForm;
	}
	
	public LocalDate getDate_incomeForm() {
		return date_incomeForm;
	}
	
	public void setDate_incomeForm(LocalDate date_incomeForm) {
		this.date_incomeForm = date_incomeForm;
	}

	public Income convertToIncome() {
		return new Income(description, value_incomeForm, date_incomeForm);
	}
}
