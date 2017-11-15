package com.akalanka.shopingbackend.daoim;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akalanka.shopingbackend.dao.ProductsDao;
import com.akalanka.shopingbackend.dto.Category;
import com.akalanka.shopingbackend.dto.Products;


@Repository("productsDao")
@Transactional
public class ProductsDaoIm implements ProductsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Products get(int id) {
		
		return sessionFactory.getCurrentSession().get(Products.class, Integer.valueOf(id));
	}

	@Override
	public List<Products> list() {
		String selectProductsList = "FROM Products "; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectProductsList);
		return query.getResultList();
	}

	@Override
	public boolean add(Products products) {
		try {
			sessionFactory.getCurrentSession().persist(products);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Products products) {
		try {
			sessionFactory.getCurrentSession().update(products);;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Products products) {
		products.setIs_active(false);
		try {
			sessionFactory.getCurrentSession().update(products);;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Products> listActiveProducts() {
		String activeProductsList = "FROM Products WHERE is_active= :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(activeProductsList);
		query.setParameter("active",true);
		return query.getResultList();
	}

	@Override
	public List<Products> listActiveProductsByCategory(int category_id) {
		String activeProductsListByCategory = "FROM Products WHERE is_active= :active AND category_id= :category_id"; 
		Query query = sessionFactory.getCurrentSession().createQuery(activeProductsListByCategory);
		query.setParameter("active",true);
		query.setParameter("category_id",category_id);
		return query.getResultList();
		
	}

	@Override
	public List<Products> listLatestActiveProducts(int count) {
		String activeProductsListByCategory = "FROM Products WHERE is_active= :active ORDERED BY id"; 
		Query query = sessionFactory.getCurrentSession().createQuery(activeProductsListByCategory);
		query.setParameter("active",true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
		
	}

}
