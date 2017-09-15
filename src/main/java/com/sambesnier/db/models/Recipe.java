package com.sambesnier.db.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recipes database table.
 * 
 */
@Entity
@Table(name="recipes")
@NamedQueries({ 
	@NamedQuery(name="Recipe.findAll", query="SELECT r FROM Recipe r"),
	@NamedQuery(name="Recipe.findById", query="SELECT r FROM Recipe r WHERE r.id = :id")})
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int baking;

	private int portions;

	private int preparation;

	private String title;

	//bi-directional many-to-one association to Ingredient
	@OneToMany(mappedBy="recipe", cascade = CascadeType.ALL)
	private List<Ingredient> ingredients;

	//bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(
		name="recipe_category"
		, joinColumns={
			@JoinColumn(name="id_recipe")
			}
		, inverseJoinColumns={
			@JoinColumn(name="category")
			}
		)
	private List<Category> categories;

	//bi-directional many-to-many association to Price
	@ManyToMany
	@JoinTable(
		name="recipe_price"
		, joinColumns={
			@JoinColumn(name="id_recipe")
			}
		, inverseJoinColumns={
			@JoinColumn(name="price")
			}
		)
	private List<Price> prices;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category")
	private Category categoryBean;

	//bi-directional many-to-one association to Price
	@ManyToOne
	@JoinColumn(name="price")
	private Price priceBean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Step
	@OneToMany(mappedBy="recipe", cascade = CascadeType.ALL)
	private List<Step> steps;

	public Recipe() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaking() {
		return this.baking;
	}

	public void setBaking(int baking) {
		this.baking = baking;
	}

	public int getPortions() {
		return this.portions;
	}

	public void setPortions(int portions) {
		this.portions = portions;
	}

	public int getPreparation() {
		return this.preparation;
	}

	public void setPreparation(int preparation) {
		this.preparation = preparation;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Ingredient addIngredient(Ingredient ingredient) {
		getIngredients().add(ingredient);
		ingredient.setRecipe(this);

		return ingredient;
	}

	public Ingredient removeIngredient(Ingredient ingredient) {
		getIngredients().remove(ingredient);
		ingredient.setRecipe(null);

		return ingredient;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public Category getCategoryBean() {
		return this.categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	public Price getPriceBean() {
		return this.priceBean;
	}

	public void setPriceBean(Price priceBean) {
		this.priceBean = priceBean;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Step> getSteps() {
		return this.steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public Step addStep(Step step) {
		getSteps().add(step);
		step.setRecipe(this);

		return step;
	}

	public Step removeStep(Step step) {
		getSteps().remove(step);
		step.setRecipe(null);

		return step;
	}

}