package com.sambesnier.db.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the steps database table.
 * 
 */
@Entity
@Table(name="steps")
@NamedQuery(name="Step.findAll", query="SELECT s FROM Step s")
public class Step implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String description;

	private int step_numb;

	//bi-directional many-to-one association to Recipe
	@ManyToOne
	@JoinColumn(name="id_recipe")
	private Recipe recipe;

	public Step() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the step_numb
	 */
	public int getStep_numb() {
		return this.step_numb;
	}

	/**
	 * @param step_numb the step_numb to set
	 */
	public void setStep_numb(int step_numb) {
		this.step_numb = step_numb;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}