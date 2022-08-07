package br.com.rbernardes.familybudget.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Income {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double value_income;
	private LocalDate date_income;
	
	public Income() {
		
	}
	
	public Income(String description, Double value_income, LocalDate date_income) {
		super();
		this.description = description;
		this.value_income = value_income;
		this.date_income = date_income;
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
		return value_income;
	}
	
	public void setValue(Double value_income) {
		this.value_income = value_income;
	}

	public LocalDate getDate() {
		return date_income;
	}
	
	public void setDate(LocalDate date_income) {
		this.date_income = date_income;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date_income, description, id, value_income);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Income other = (Income) obj;
		return Objects.equals(date_income, other.date_income) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(value_income, other.value_income);
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", description=" + description + ", value=" + value_income + ", date_income=" + date_income + "]";
	}
}
