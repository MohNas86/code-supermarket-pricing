package com.supermarket.kata.code_supermarket_pricing;

import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.supermarket.kata.code_supermarket_pricing.service.Pricing;

public class PricingTest {

	private UnitPrice unitPrice;
	private Discount threeForOne, fiveForOneAndHalf;
	private List<Discount> discounts;

	@Before
	public void init() throws Exception {
		unitPrice = new UnitPrice(0.65f);
		threeForOne = new Discount(1.0f, 3f);
		fiveForOneAndHalf = new Discount(1.5f, 5f);
		discounts = asList(threeForOne, fiveForOneAndHalf);
	}

	@Test
	public void getPrice() throws Exception {
		assertEquals("a product costs 0.65$", 0.65f, Pricing.getPrice(unitPrice, 1), Double.MIN_VALUE);

	}

	

}
