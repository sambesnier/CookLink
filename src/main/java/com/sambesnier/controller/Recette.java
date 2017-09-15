package com.sambesnier.controller;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.sambesnier.beans.MyContext;
import com.sambesnier.db.models.Recipe;



@ManagedBean(name = "recette", eager = true)
@SessionScoped
public class Recette {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	Recipe recipe;
	
	String id;
	
	public Recette() {
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
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		
		Map<String, Object> prop = new HashMap<String, Object>();
		prop.put("id", Integer.parseInt(id));
		
		recipe = (Recipe) myContext.getRepository().queryObject("Recipe.findById", prop);
		
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
