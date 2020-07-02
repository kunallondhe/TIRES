package com.tires.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.tires.web.model.*;

public class ProductDao {
	public int SaveProduct(Product p) {
		int i = 0;
		try {
			Configuration conf = new Configuration().configure().addAnnotatedClass(Product.class);
			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

			SessionFactory sf = conf.buildSessionFactory(reg);

			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();

			session.save(p);

			tx.commit();

			i = 1;

		} catch (Exception e) {
			System.out.println(e);
		}

		return i;
	}

	public List<Product> GetProducts(Search s) {
		List<Product> products = new ArrayList<Product>();

		try {
			Configuration conf = new Configuration().configure().addAnnotatedClass(Product.class);
			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			SessionFactory sf = conf.buildSessionFactory(reg);

			Session session = sf.openSession();
			
			Query query = session.createQuery("from Product where width = :width and profile = :profile and rimsize = :rimsize");
			query.setParameter("width", Integer.parseInt(s.getWidth()));
			query.setParameter("profile", Integer.parseInt(s.getProfile()));
			query.setParameter("rimsize", Integer.parseInt(s.getRimsize()));
			
			products = (List<Product>)query.getResultList();
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return products;
	}

}
