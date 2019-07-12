package com.supermarket.kata.code_supermarket_pricing.service;

import com.supermarket.kata.code_supermarket_pricing.Discount;
import com.supermarket.kata.code_supermarket_pricing.UnitPrice;

public class Pricing {

	/** Calcul prix unitaire **/

	public static float getPrice(UnitPrice price, Integer qte) {
		return price.getAmout() * qte;
	}

}
