package br.com.rbernardes.familybudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbernardes.familybudget.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{

	
}
