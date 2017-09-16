package com.sambesnier.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sambesnier.beans.MyContext;
import com.sambesnier.db.models.User;


@ManagedBean(name = "inscription", eager = true)
@SessionScoped
public class InscriptionController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String username;
	String mail;
	String password;
	String password2;

	public InscriptionController() {

	}

	public void submit() {
		
		User user = new User();
		user.setEmail(mail);
		user.setPassword(password);
		user.setUsername(username);
		
		User sessionUser = (User)myContext.getRepository().create(user);
		
		if (sessionUser != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			
			session.setAttribute("user", sessionUser);
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("recettes.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		clear();
	}

	private void clear() {
		setUsername(null);
		setMail(null);
		setPassword(null);
		setPassword2(null);
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	
	

}
