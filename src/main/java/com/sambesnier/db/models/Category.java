package com.sambesnier.db.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String category;

	//bi-directional many-to-many association to Recipe
	@ManyToMany(mappedBy="categories", cascade = CascadeType.ALL)
	private List<Recipe> recipes1;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="categoryBean", cascade = CascadeType.ALL)
	private List<Recipe> recipes2;

	public Category() {
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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
		recipes2.setCategoryBean(this);

		return recipes2;
	}

	public Recipe removeRecipes2(Recipe recipes2) {
		getRecipes2().remove(recipes2);
		recipes2.setCategoryBean(null);

		return recipes2;
	}

}