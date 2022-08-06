package br.com.rbernardes.familybudget.model;

import java.time.LocalDate;
import java.util.Objects;

public class Expense {

	private Long id;
	private String description;
	private Double value;
	private LocalDate date;
	
	public Expense(Long id, String description, Double value, LocalDate date) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.date = date;
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
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, id, value);
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
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", description=" + description + ", value=" + value + ", date=" + date + "]";
	}
}
