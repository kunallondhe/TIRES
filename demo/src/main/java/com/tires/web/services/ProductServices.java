package com.tires.web.services;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.tires.web.dao.ProductDao;
import com.tires.web.model.Product;
import com.tires.web.model.Search;

public class ProductServices {

	public List<Product> GetProducts(Search s) {

		List<Product> products = new ArrayList<Product>();

		try {
			ProductDao obj = new ProductDao();

			products = obj.GetProducts(s);

		} catch (Exception e) {
			System.out.println(e);
		}

		return products;
	}

	public Boolean SaveProduct(Product p) {

		Boolean sucess = false;
		try {

			ProductDao obj = new ProductDao();

			if (p == null) {
				p = new Product();

				p.setItemNumber(ThreadLocalRandom.current().nextInt(555555, 999999));
				p.setWidth(ThreadLocalRandom.current().nextInt(210, 325));
				p.setProfile(ThreadLocalRandom.current().nextInt(35, 60));
				p.setRimsize(ThreadLocalRandom.current().nextInt(15, 22));
				p.setLocalisedName("Michelin " + p.getWidth() + "/" + p.getProfile() + " R" + p.getRimsize()
						+ " 92 (V) PILOT ALPIN 4 XL N0 Porsche");
				p.setDescription(
						"he Michelin Pilot Alpin PA4 has been designed as a high performance winter tyre that delivers greater safety, greater mobility and greater control for high performance cars in cold weather conditions.\r\n"
								+ "\r\n"
								+ "The Michelin Pilot Alpin PA4 brakes 3 metres shorter than its predecessor on wet roads, and offers better traction and braking on snow and ice thanks to a heavily grooved tread pattern with increased ridges and sipes.\r\n"
								+ "\r\n"
								+ "The Michelin Pilot Alpin PA4 incorporates Michelin Total Performance technology for improved grip and driving precision in cold weather conditions, thanks to increased rigidity and a third generation Helio Compound rubber mixture. Stabiligrip technology allows the tyre to break through standing water and make contact with the road surface.");
				p.setImage(
						"https://preprodstatictires.azureedge.net/kentico10/mediastorage/app_themes/cwc/tireimages/usa/868984/michelin_premier_as_rt1q_2020617734.jpg");
				p.setSpeedRating("V");

			}

			obj.SaveProduct(p);

			sucess = true;

		} catch (Exception e) {
			System.out.println(e);
		}

		return sucess;

	}

	// Avoid duplicate while saving using hashtable
	public Hashtable<Integer, Boolean> SaveProducts(List<Product> products) {

		Hashtable<Integer, Boolean> hm = new Hashtable<Integer, Boolean>();

		try {

			ProductDao obj = new ProductDao();

			for (Product p : products) {
				obj.SaveProduct(p);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return hm;
	}
}
