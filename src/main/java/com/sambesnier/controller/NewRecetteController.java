package com.sambesnier.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sambesnier.beans.MyContext;
import com.sambesnier.db.models.Category;
import com.sambesnier.db.models.Ingredient;
import com.sambesnier.db.models.Price;
import com.sambesnier.db.models.Recipe;
import com.sambesnier.db.models.Step;
import com.sambesnier.db.models.User;



@ManagedBean(name = "newrecette", eager = true)
@ViewScoped
public class NewRecetteController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String title;
	
	List<Category> categories;
	
	String category;
	
	List<Price> prices;
	
	String price;
	
	int baking;
	
	int preparation;
	
	int portions;
	
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	List<Step> steps = new ArrayList<Step>();
	
	public NewRecetteController() {
	}
	
	public void submit() {
		Recipe recipe = new Recipe();
		recipe.setTitle(title);
		Category cat = new Category();
		cat.setCategory(category);
		recipe.setCategoryBean(cat);
		Price pri = new Price();
		pri.setPrice(price);
		recipe.setPriceBean(pri);
		recipe.setPreparation(preparation);
		recipe.setBaking(baking);
		recipe.setPortions(portions);
		
		for(int i = 0; i < ingredients.size(); i++) {
			ingredients.get(i).setRecipe(recipe);
		}
		
		for(int i = 0; i < steps.size(); i++) {
			steps.get(i).setRecipe(recipe);
		}
		
		recipe.setIngredients(ingredients);
		recipe.setSteps(steps);
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	
    	User user = (User) session.getAttribute("user");
    	recipe.setUser(user);
		
		Recipe rc = (Recipe)myContext.getRepository().create(recipe);
		
		if (rc != null) {
			
			System.out.println("Recette crée");
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("../recettes.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addIngredient() {
		ingredients.add(new Ingredient());
	}
	
	public void addStep() {
		steps.add(new Step());
	}
	
	public void delIngredient() {
		ingredients.remove(ingredients.size()-1);
	}
	
	public void delStep() {
		steps.remove(steps.size()-1);
	}
	
	/**
	 * @return the myContext
	 */
	public MyContext getMyContext() {
		return myContext;
	}
	/**
	 * @param myContext the myContext to set
	 */
	public void setMyContext(MyContext myContext) {
		this.myContext = myContext;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		
		categories = (List<Category>) myContext.getRepository().queryList("Category.findAll", null);
		
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the prices
	 */
	public List<Price> getPrices() {
		
		prices = (List<Price>)myContext.getRepository().queryList("Price.findAll", null);
		
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the baking
	 */
	public int getBaking() {
		return baking;
	}

	/**
	 * @param baking the baking to set
	 */
	public void setBaking(int baking) {
		this.baking = baking;
	}

	/**
	 * @return the preparation
	 */
	public int getPreparation() {
		return preparation;
	}

	/**
	 * @param preparation the preparation to set
	 */
	public void setPreparation(int preparation) {
		this.preparation = preparation;
	}

	/**
	 * @return the portions
	 */
	public int getPortions() {
		return portions;
	}

	/**
	 * @param portions the portions to set
	 */
	public void setPortions(int portions) {
		this.portions = portions;
	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		if(ingredients.size() == 0) {
			ingredients.add(new Ingredient());
		}
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		if(steps.size() == 0) {
			steps.add(new Step());
		}
		return steps;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	
	
}
