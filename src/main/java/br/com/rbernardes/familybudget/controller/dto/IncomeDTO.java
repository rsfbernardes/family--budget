package br.com.rbernardes.familybudget.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rbernardes.familybudget.model.Income;

public class IncomeDTO {

	private Long id;
	private String description;
	private Double value_income;
	private LocalDate date_income;
	
	public IncomeDTO(Income income) {
		this.id = income.getId();
		this.description = income.getDescription();
		this.value_income = income.getValue();
		this.date_income = income.getDate();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Double getValue() {
		return value_income;
	}

	public LocalDate getDate() {
		return date_income;
	}

	public static List<IncomeDTO> convertToDto(List<Income> incomes) {
		return incomes.stream().map(IncomeDTO::new).collect(Collectors.toList());
	}
}
