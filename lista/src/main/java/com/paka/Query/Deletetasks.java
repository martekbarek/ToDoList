package com.paka.Query;

import java.util.Arrays;

public class Deletetasks {

	private int[] todel;
	
	public int[] getTodel() {
		return todel;
	}
	
	public void setTodel(int[] todel) {
		this.todel = todel;
	}

	@Override
	public String toString() {
		return "DeleteTasks [todel=" + Arrays.toString(todel) + "]";
	}
	
	
}
