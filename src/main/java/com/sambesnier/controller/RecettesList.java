package com.sambesnier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.sambesnier.beans.MyContext;
import com.sambesnier.db.models.Recipe;



@ManagedBean(name = "recettesList", eager = true)
@SessionScoped
public class RecettesList {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	List<Recipe> recipes = new ArrayList<Recipe>();
	
	
	public RecettesList() {
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
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		recipes =  (List<Recipe>) myContext.getRepository().queryList("Recipe.findAll", null);
		return recipes;
	}

	/**
	 * @param recipes the recipes to set
	 */
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}
