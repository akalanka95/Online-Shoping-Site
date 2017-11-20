package com.akalanka.shopingbackend.dao;

import java.util.List;

import com.akalanka.shopingbackend.dto.Cart;
import com.akalanka.shopingbackend.dto.CartLine;

public interface CartLineDao {

	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartandProduct(int cartId, int productId);
	boolean updateCart(Cart cart);

}
