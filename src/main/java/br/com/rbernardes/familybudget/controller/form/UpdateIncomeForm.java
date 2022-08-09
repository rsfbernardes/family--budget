package br.com.rbernardes.familybudget.controller.form;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rbernardes.familybudget.model.Income;
import br.com.rbernardes.familybudget.repository.IncomeRepository;

public class UpdateIncomeForm {

	@NotNull @NotEmpty
	private String description;
	
	@NotNull
	private Double value_income;
	
	@NotNull @DateTimeFormat
	private LocalDate date_income;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue_income() {
		return value_income;
	}
	
	public void setValue_income(Double value_income) {
		this.value_income = value_income;
	}
	
	public LocalDate getDate_income() {
		return date_income;
	}
	
	public void setDate_income(LocalDate date_income) {
		this.date_income = date_income;
	}
	
	public Income converToIncome() {
		return new Income(description, value_income, date_income);
	}

	public Income update(@Valid Long id, IncomeRepository incomeRepository) {
		Income income = incomeRepository.getReferenceById(id);
		income.setDescription(this.description);
		income.setDate(this.date_income);
		income.setValue(this.value_income);
		return income;
	}
}
