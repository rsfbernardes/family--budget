package br.com.rbernardes.familybudget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbernardes.familybudget.controller.dto.IncomeDTO;
import br.com.rbernardes.familybudget.model.Income;
import br.com.rbernardes.familybudget.repository.IncomeRepository;

@RestController
public class IncomeController {
	
	@Autowired
	private IncomeRepository incomeRepository;

	@GetMapping("/incomes")
	public List<IncomeDTO> incomeList(){
		
		List<Income> incomes = incomeRepository.findAll();	
		return IncomeDTO.convertToDto(incomes);
	}
}
