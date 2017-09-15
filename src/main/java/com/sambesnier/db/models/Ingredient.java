package com.sambesnier.db.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ingredients database table.
 * 
 */
@Entity
@Table(name="ingredients")
@NamedQuery(name="Ingredient.findAll", query="SELECT i FROM Ingredient i")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String value;

	//bi-directional many-to-one association to Recipe
	@ManyToOne
	@JoinColumn(name="id_recipe")
	private Recipe recipe;

	public Ingredient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}