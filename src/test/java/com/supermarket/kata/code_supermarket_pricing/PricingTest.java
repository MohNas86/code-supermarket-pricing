package com.supermarket.kata.code_supermarket_pricing;

import java.math.BigDecimal;
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
	private UnitPrice unitPrice_1 = new UnitPrice(new BigDecimal(0.5));

	@Before
	public void init() throws Exception {

		unitPrice = new UnitPrice(new BigDecimal(0.65));
		threeForOne = new Discount(new BigDecimal(1.0), 3f);
		fiveForOneAndHalf = new Discount(new BigDecimal(1.5), 5f);
		discounts = asList(threeForOne, fiveForOneAndHalf);
	}

	@Test
	public void getPriceTest() throws Exception {

		assertEquals("a product costs 0.65$", new BigDecimal(0.65), Pricing.getPrice(unitPrice, 1));

	}

	//
	@Test
	public void getReductionPriceTest() throws Exception {

		assertEquals("Five units costs 2 Dollars: 1 Dollar (threeForOnediscount) + 1 Dollar ( 2 units) ", 2.0,
				Pricing.getReductionPrice(unitPrice_1, 5, threeForOne));
		assertEquals("Three units costs 1 Dollar: threeForOne discount selected", 1.0,
				Pricing.getReductionPrice(unitPrice_1, 3, threeForOne));
		assertEquals("Five units costs 1.5 Dollars: fiveForOneAndHalf discount selected", new BigDecimal(1.5),
				Pricing.getReductionPrice(unitPrice_1, 5, fiveForOneAndHalf));

	}

	@Test
	public void getReductionsPriceTest() throws Exception {

		assertEquals("Five units costs 2 Dollars: 1 Dollar (threeForOne discount) + 1 Dollar ( 2 units) ",
				new BigDecimal(3.5), Pricing.getReductionsPrice(unitPrice_1, 5, discounts));
		assertEquals("Three units costs 1 Dollar: threeForOne discount selected", new BigDecimal(2.5),
				Pricing.getReductionsPrice(unitPrice_1, 3, discounts));
		assertEquals("Five units costs 1.5 Dollars: fiveForOneAndHalf discount selected", new BigDecimal(3.5),
				Pricing.getReductionsPrice(unitPrice_1, 5, discounts));
	}

}
