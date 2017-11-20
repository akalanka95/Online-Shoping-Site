package com.akalanka.shopingbackend.daoim;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akalanka.shopingbackend.dao.CartLineDao;
import com.akalanka.shopingbackend.dto.Cart;
import com.akalanka.shopingbackend.dto.CartLine;
import com.akalanka.shopingbackend.dto.Category;


@Repository("cartLineDao")
@Transactional
public class CartLineDaoIm implements CartLineDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartLine) {
		cartLine.setAvailable(false);
		try {
			sessionFactory.getCurrentSession().update(cartLine);;
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
	

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

	@Override
	public List<CartLine> list(int cartId) {
		String query = "from CartLine WHERE cartId = :cartId ";
		return sessionFactory.getCurrentSession()
								.createQuery(query,CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "from CartLine WHERE cartId = :cartId and isAvailable = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query,CartLine.class)
									.setParameter("cartId", cartId)
										.setParameter("available", true)
										.getResultList();
	}

	@Override
	public CartLine getByCartandProduct(int cartId, int productId) {
		String query = "from CartLine WHERE cartId = :cartId and product.id = :productId";
		try{
			return sessionFactory.getCurrentSession()
								.createQuery(query,CartLine.class)
									.setParameter("cartId", cartId)
										.setParameter("productId", productId)
										.getSingleResult();
	}catch(Exception ex) {
		return null;
	}
	}

}
