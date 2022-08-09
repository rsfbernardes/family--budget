package br.com.rbernardes.familybudget.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rbernardes.familybudget.model.Income;

public class IncomeDTO {

	private String description;
	private Double value;
	
	private LocalDate date;
	
	public IncomeDTO(Income income) {
		this.description = income.getDescription();
		this.value = income.getValue();
		this.date = income.getDate();
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

	public static List<IncomeDTO> convertToDto(List<Income> incomes) {
		return incomes.stream().map(IncomeDTO::new).collect(Collectors.toList());
	}
}
