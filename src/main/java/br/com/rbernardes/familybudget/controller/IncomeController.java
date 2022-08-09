package br.com.rbernardes.familybudget.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rbernardes.familybudget.controller.dto.IncomeDTO;
import br.com.rbernardes.familybudget.controller.form.IncomeForm;
import br.com.rbernardes.familybudget.controller.form.UpdateIncomeForm;
import br.com.rbernardes.familybudget.model.Income;
import br.com.rbernardes.familybudget.repository.IncomeRepository;

@RestController
@RequestMapping("/incomes")
public class IncomeController {
	
	@Autowired
	private IncomeRepository incomeRepository;

	@GetMapping
	public List<IncomeDTO> incomeList(){
		List<Income> incomes = incomeRepository.findAll();	
		return IncomeDTO.convertToDto(incomes);
	}
	
	@GetMapping(value = "/{id}")
	public IncomeDTO expenseById(@PathVariable @Valid Long id) {
		Income income = incomeRepository.getReferenceById(id);		
		return new IncomeDTO(income);
	}
	
	@PostMapping
	public ResponseEntity<IncomeDTO> addIncome(@RequestBody @Valid IncomeForm incomeForm, UriComponentsBuilder uriBuilder) {
		Income income = incomeForm.convertToIncome();
		incomeRepository.save(income);
		
		URI uri = uriBuilder.path("/incomes/{id}").buildAndExpand(income.getId()).toUri();
		return ResponseEntity.created(uri).body(new IncomeDTO(income));
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<IncomeDTO> incomeUpdate(@PathVariable @Valid Long id, @RequestBody @Valid UpdateIncomeForm updateIncomeForm) {
		Income income = updateIncomeForm.update(id, incomeRepository);
		return ResponseEntity.ok(new IncomeDTO(income));
	}
}
