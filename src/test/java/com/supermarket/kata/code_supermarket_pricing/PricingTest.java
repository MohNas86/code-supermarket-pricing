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
	public void getPriceTest() throws Exception {
		assertEquals("a product costs 0.65$", 0.65f, Pricing.getPrice(unitPrice, 1), Double.MIN_VALUE);

	}

	@Test
	public void getReductionPriceTest() throws Exception {

		assertEquals("Five units costs 2 Dollars: 1 Dollar (threeForOne discount) + 1 Dollar ( 2 units) ", 2f,
				Pricing.getReductionPrice(new UnitPrice(0.5f), 5, threeForOne), Double.MIN_VALUE);
		assertEquals("Three units costs 1 Dollar: threeForOne discount selected", 1f,
				Pricing.getReductionPrice(new UnitPrice(0.5f), 3, threeForOne), Double.MIN_VALUE);
		assertEquals("Five units costs 1.5 Dollars: fiveForOneAndHalf discount selected", 1.5f,
				Pricing.getReductionPrice(new UnitPrice(0.5f), 5, fiveForOneAndHalf), Double.MIN_VALUE);

	}

	@Test
	public void getReductionsPriceTest() throws Exception {

		assertEquals("Five units costs 2 Dollars: 1 Dollar (threeForOne discount) + 1 Dollar ( 2 units) ", 3.5f,
				Pricing.getReductionsPrice(new UnitPrice(0.5f), 5, discounts), Double.MIN_VALUE);
		assertEquals("Three units costs 1 Dollar: threeForOne discount selected", 2.5f,
				Pricing.getReductionsPrice(new UnitPrice(0.5f), 3, discounts), Double.MIN_VALUE);
		assertEquals("Five units costs 1.5 Dollars: fiveForOneAndHalf discount selected", 3.5f,
				Pricing.getReductionsPrice(new UnitPrice(0.5f), 5, discounts), Double.MIN_VALUE);

	}

}
