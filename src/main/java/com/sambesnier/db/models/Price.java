package com.sambesnier.db.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prices database table.
 * 
 */
@Entity
@Table(name="prices")
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String price;

	//bi-directional many-to-many association to Recipe
	@ManyToMany(mappedBy="prices", cascade = CascadeType.ALL)
	private List<Recipe> recipes1;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="priceBean", cascade = CascadeType.ALL)
	private List<Recipe> recipes2;

	public Price() {
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Recipe> getRecipes1() {
		return this.recipes1;
	}

	public void setRecipes1(List<Recipe> recipes1) {
		this.recipes1 = recipes1;
	}

	public List<Recipe> getRecipes2() {
		return this.recipes2;
	}

	public void setRecipes2(List<Recipe> recipes2) {
		this.recipes2 = recipes2;
	}

	public Recipe addRecipes2(Recipe recipes2) {
		getRecipes2().add(recipes2);
		recipes2.setPriceBean(this);

		return recipes2;
	}

	public Recipe removeRecipes2(Recipe recipes2) {
		getRecipes2().remove(recipes2);
		recipes2.setPriceBean(null);

		return recipes2;
	}

}