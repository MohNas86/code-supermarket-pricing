package com.supermarket.kata.code_supermarket_pricing.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.supermarket.kata.code_supermarket_pricing.Discount;
import com.supermarket.kata.code_supermarket_pricing.UnitPrice;

public class Pricing {

	/** Calcul prix unitaire **/

	public static BigDecimal getPrice(UnitPrice price, Integer qte) {

		return price.getAmout().multiply(new BigDecimal(qte));
	}

	/** Calcul prix unitaire en appliquant la rédu0ction **/

	public static BigDecimal getReductionPrice(UnitPrice price, Integer qte, Discount discount) {
		if (qte < discount.getQte()) {
			return getPrice(price, qte);
		}
		int div = (int) (qte / discount.getQte());
		int rest = (int) (qte % discount.getQte());
		return discount.getPrice().multiply(new BigDecimal(div)).add(price.getAmout().multiply(new BigDecimal(rest)));

	}

	/** Calcul des prix en appliquant la liste des réductions **/

	public static BigDecimal getReductionsPrice(UnitPrice price, Integer qte, Collection<Discount> discounts) {

		BigDecimal sum = BigDecimal.ZERO;

		sum = discounts.stream().map(discount -> getReductionPrice(price, qte, discount)).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		return sum;

	}

}
