package br.com.rbernardes.familybudget.model;

import java.time.LocalDate;
import java.util.Objects;

public class Income {

	private Long id;
	private String description;
	private Double value;
	private LocalDate date;
	
	public Income(Long id, String description, Double value, LocalDate date) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.date = date;
	}

	public Long getId() {
		return id;
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
		Income other = (Income) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", description=" + description + ", value=" + value + ", date=" + date + "]";
	}
}
