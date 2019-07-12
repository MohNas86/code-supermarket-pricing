package com.supermarket.kata.code_supermarket_pricing.service;

import java.util.Collection;

import com.supermarket.kata.code_supermarket_pricing.Discount;
import com.supermarket.kata.code_supermarket_pricing.UnitPrice;

public class Pricing {

	/** Calcul prix unitaire **/

	public static float getPrice(UnitPrice price, Integer qte) {
		return price.getAmout() * qte;
	}

	/** Calcul prix unitaire en appliquant la réduction **/

	public static float getReductionPrice(UnitPrice price, Integer qte, Discount discount) {
		if (qte < discount.getQte()) {
			return getPrice(price, qte);
		}
		int div = (int) (qte / discount.getQte());
		int rest = (int) (qte % discount.getQte());
		return div * discount.getPrice() + rest * price.getAmout();

	}

	/** Calcul des prix en appliquant la liste des réductions **/

	public static float getReductionsPrice(UnitPrice price, Integer qte, Collection<Discount> discounts) {

		Float sum = 0f;
		for (Discount discount : discounts) {
			sum = sum + getReductionPrice(price, qte, discount);
		}

		return sum;
	}

}
