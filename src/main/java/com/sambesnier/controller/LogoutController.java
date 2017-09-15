package com.sambesnier.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sambesnier.beans.MyContext;


@ManagedBean(name = "logoutController", eager = true)
@SessionScoped
public class LogoutController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	public LogoutController() {
		// TODO Auto-generated constructor stub
	}
	
	public void logout() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	session.removeAttribute("user");
    	
    	
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (IOException e) {
			
		}
		
		
	}
	
public void logoutOut() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	session.removeAttribute("user");
    	
    	
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			
		}
		
		
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
