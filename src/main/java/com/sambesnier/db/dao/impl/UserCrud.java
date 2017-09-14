package com.sambesnier.db.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sambesnier.db.dao.IUserCrud;
import com.sambesnier.db.models.User;


public class UserCrud implements IUserCrud {

	public void createUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentLink");
		EntityManager em = emf.createEntityManager();

		// 2 : Ouverture transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		user.setRole("user");
		// 4 : Persistance Objet/Relationnel : création d'un enregistrement en
		// base
		em.persist(user);

		// 5 : Fermeture transaction
		tx.commit();

		// 6 : Fermeture unité de travail JPA
		em.close();
		emf.close();
		
	}

	public void getUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void upduateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
