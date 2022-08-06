package br.com.rbernardes.familybudget.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbernardes.familybudget.controller.dto.IncomeDTO;
import br.com.rbernardes.familybudget.model.Income;

@RestController
public class IncomeController {

	@GetMapping("/incomes")
	public List<IncomeDTO> incomeList(){
		Income income = new Income(1l, "salary", 5000.00d, LocalDate.now());
		
		return IncomeDTO.convertToDto(Arrays.asList(income, income, income));
	}
}
