package com.BlockV2;

public class BlockV2 {
	public double x;
	public double y;
	public double d;
	// public boolean bool;

	public BlockV2(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
		// this.bool = false;
	}

	public BlockV2() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = (int)prime * result + d;
		result = (int) (prime * result + x);
		result = (int) (prime * result + y);
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
		BlockV2 other = (BlockV2) obj;
		// if (d != other.d)
		// return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlockV2 [x=" + x + ", y=" + y + ", d=" + d + "]";
	}

}
