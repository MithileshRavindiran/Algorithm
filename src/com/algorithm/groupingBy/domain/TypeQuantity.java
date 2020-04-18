package com.algorithm.groupingBy.domain;

public class TypeQuantity {

	private FruitType type;
	private int quantity;

	public TypeQuantity() {
		super();
	}

	public TypeQuantity(FruitType type, int quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}

	public FruitType getType() {
		return type;
	}

	public void setType(FruitType type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TypeQuantity other = (TypeQuantity) obj;
		if (quantity != other.quantity)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeQuantity [type=" + type + ", quantity=" + quantity + "]";
	}

}
