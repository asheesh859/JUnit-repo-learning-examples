package com.unittest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.unittest1.model.Calculator;

@SpringBootTest
public class CalculatorTest {
	
	@Test
	public void testAdd() {
		int ExpectedValue = 50;
		Calculator c = new Calculator();
		int ActualValue = c.add(10,40);
		Assertions.assertEquals(ExpectedValue , ActualValue);
		
	}
	
	@Test
	public void testMul() {
		int ExpectedValue = 50;
		Calculator c = new Calculator();
		int ActualReslt = c.mul(10,5);
		Assertions.assertEquals(ExpectedValue ,ActualReslt);
		}

}
