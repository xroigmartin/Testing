package fizzBuzz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

	private FizzBuzz fizzBuzz = new FizzBuzz();
	
	@Test
	public void returnItselfNumber() {
		assertEquals(fizzBuzz.fizzBuzz(1), "1");
		assertEquals(fizzBuzz.fizzBuzz(2), "2");
		assertEquals(fizzBuzz.fizzBuzz(4), "4");
	}

	@Test
	public void returnFizzIfDivisibleByThree() {
		assertEquals(fizzBuzz.fizzBuzz(3), "Fizz");
		assertEquals(fizzBuzz.fizzBuzz(6), "Fizz");
		assertEquals(fizzBuzz.fizzBuzz(9), "Fizz");
	}
	
	@Test
	public void returnBuzzIfDivisibleByFive() {
		assertEquals(fizzBuzz.fizzBuzz(5), "Buzz");
		assertEquals(fizzBuzz.fizzBuzz(10), "Buzz");
		assertEquals(fizzBuzz.fizzBuzz(20), "Buzz");
	}
	
	@Test
	public void returnFizzBuzzIfDivisibleByThreeAndFive() {
		assertEquals(fizzBuzz.fizzBuzz(15), "FizzBuzz");
		assertEquals(fizzBuzz.fizzBuzz(30), "FizzBuzz");
		assertEquals(fizzBuzz.fizzBuzz(60), "FizzBuzz");
	}
}
