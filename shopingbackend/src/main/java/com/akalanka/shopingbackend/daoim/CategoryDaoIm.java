package com.akalanka.shopingbackend.daoim;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.dto.Category;

@Repository
@Transactional
public class CategoryDaoIm implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	/*static {
		Category category = new Category();
		category.setId(1);
		category.setName("Drums");
		category.setDescription("this is about drums");
		category.setImageUrl("drum.png");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(2);
		category.setName("Guitars");
		category.setDescription("this is about guitars");
		category.setImageUrl("guitar.png");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(3);
		category.setName("Pianos");
		category.setDescription("this is about pianos");
		category.setImageUrl("piano.png");
		
		categories.add(category);
		
	} */
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE is_active= :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		
		/*for(Category category :categories) {
			if(category.getId() == id)return category;
		}*/
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
