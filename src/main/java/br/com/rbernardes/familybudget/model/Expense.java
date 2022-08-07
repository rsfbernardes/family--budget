package br.com.rbernardes.familybudget.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double value_expense;
	private LocalDate date_expense;

	public Expense() {
		
	}
	
	public Expense(String description, Double value_expense, LocalDate date_expense) {
		super();
		this.description = description;
		this.value_expense = value_expense;
		this.date_expense = date_expense;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value_expense;
	}
	
	public void setValue(Double value_expense) {
		this.value_expense = value_expense;
	}

	public LocalDate getDate() {
		return date_expense;
	}
	
	public void setDate(LocalDate date_expense) {
		this.date_expense = date_expense;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date_expense, description, id, value_expense);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return Objects.equals(date_expense, other.date_expense) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(value_expense, other.value_expense);
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", description=" + description + ", value=" + value_expense + ", date_expense=" + date_expense + "]";
	}
}
