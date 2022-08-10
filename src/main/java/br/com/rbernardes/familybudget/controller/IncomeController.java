package br.com.rbernardes.familybudget.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<IncomeDTO> incomeById(@PathVariable @Valid Long id) {
		Optional<Income> income = incomeRepository.findById(id);
		if(income.isPresent()) {
			return ResponseEntity.ok(new IncomeDTO(income.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<IncomeDTO> addIncome(@RequestBody @Valid IncomeForm incomeForm, UriComponentsBuilder uriBuilder) {
		Income income = incomeForm.convertToIncome();
		List<Income> incomesList = new ArrayList<>();
		incomesList = incomeRepository.findAll();
		for(int i = 0; i < incomesList.size(); i++) {
			if(incomesList.get(i).getDescription() == income.getDescription() && incomesList.get(i).getDate() == income.getDate()) {
			return ResponseEntity.ok(new IncomeDTO(income));
			}
		}
		incomeRepository.save(income);
		
		URI uri = uriBuilder.path("/incomes/{id}").buildAndExpand(income.getId()).toUri();
		return ResponseEntity.created(uri).body(new IncomeDTO(income));
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<IncomeDTO> incomeUpdate(@PathVariable @Valid Long id, @RequestBody @Valid UpdateIncomeForm updateIncomeForm) {
		Optional<Income> income = incomeRepository.findById(id);
		if(income.isPresent()) {
			income = Optional.of(updateIncomeForm.update(id, incomeRepository));
			return ResponseEntity.ok(new IncomeDTO(income.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> incomeDelete(@PathVariable @Valid Long id) {
		Optional<Income> income = incomeRepository.findById(id);
		if(income.isPresent()) {
			incomeRepository.deleteById(id);		
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
