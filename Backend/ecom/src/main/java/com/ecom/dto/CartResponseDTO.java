package com.ecom.dto;

import java.util.List;

import com.ecom.entity.CartEntity;
import com.ecom.entity.CategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDTO {
	
private List<CartEntity> carts;
	
	private CartEntity cart;

}
