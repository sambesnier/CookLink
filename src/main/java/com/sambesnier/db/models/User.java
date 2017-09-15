package com.sambesnier.db.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({ 
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByEmailOrUserName", query="SELECT u FROM User u WHERE u.email = :login or u.username = :login")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String email;

	private String password;

	private String username;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Recipe> recipes;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Recipe addRecipe(Recipe recipe) {
		getRecipes().add(recipe);
		recipe.setUser(this);

		return recipe;
	}

	public Recipe removeRecipe(Recipe recipe) {
		getRecipes().remove(recipe);
		recipe.setUser(null);

		return recipe;
	}

}