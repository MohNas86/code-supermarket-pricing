package com.supermarket.kata.code_supermarket_pricing;

public class Price {

	private final Float amout;

	public Price(Float amout) {
		super();
		this.amout = amout;
	}

	public Float getAmout() {
		return amout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amout == null) ? 0 : amout.hashCode());
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
		Price other = (Price) obj;
		if (amout == null) {
			if (other.amout != null)
				return false;
		} else if (!amout.equals(other.amout))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Price [amout=" + amout + "]";
	}

}
