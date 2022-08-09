package br.com.rbernardes.familybudget.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rbernardes.familybudget.model.Income;

public class IncomeForm {

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
	
	public Double getValue_incomeForm() {
		return value;
	}
	
	public void setValue_incomeForm(Double value) {
		this.value = value;
	}
	
	public LocalDate getDate_incomeForm() {
		return date;
	}
	
	public void setDate_incomeForm(LocalDate date) {
		this.date = date;
	}

	public Income convertToIncome() {
		return new Income(description, value, date);
	}
}
