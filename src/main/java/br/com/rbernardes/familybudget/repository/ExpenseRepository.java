package br.com.rbernardes.familybudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbernardes.familybudget.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
