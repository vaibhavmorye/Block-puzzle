package com.block;

public class Block {
	public int x;
	public int y;
	public int d;

	
	public Block() {
	}

	public Block(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Block other = (Block) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Block [x=" + x + ", y=" + y + ", d=" + d + "]";
	}
	
	

}