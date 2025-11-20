package com.example.project;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		double temp; // unused
		return a - b;
	}

	public int multiply(int a, int b) {
		int Result = a * b; // bad naming + temporary variable
		return Result;
	}
}
