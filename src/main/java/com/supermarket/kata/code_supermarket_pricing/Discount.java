package com.supermarket.kata.code_supermarket_pricing;

public class Discount {

	private final Float price;
	private final Float Qte;

	public Discount(Float price, Float qte) {
		super();
		this.price = price;
		Qte = qte;
	}

	public Float getPrice() {
		return price;
	}

	public Float getQte() {
		return Qte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Qte == null) ? 0 : Qte.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		if (Qte == null) {
			if (other.Qte != null)
				return false;
		} else if (!Qte.equals(other.Qte))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discount [price=" + price + ", Qte=" + Qte + "]";
	}

}
