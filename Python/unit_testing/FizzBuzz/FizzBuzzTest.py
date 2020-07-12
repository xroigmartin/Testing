import unittest

from FizzBuzz import FizzBuzz

class FizzBuzzTest(unittest.TestCase):
    
    def test_returnItselfNumber(self):
        self.assertEqual(FizzBuzz.fizzBuzz(self, 1), 1)
        self.assertEqual(FizzBuzz.fizzBuzz(self, 2), 2)
        self.assertEqual(FizzBuzz.fizzBuzz(self, 4), 4)

    def test_returnFizzIfDivisibleByThree(self):
        self.assertEqual(FizzBuzz.fizzBuzz(self, 3), "Fizz")
        self.assertEqual(FizzBuzz.fizzBuzz(self, 6), "Fizz")
        self.assertEqual(FizzBuzz.fizzBuzz(self, 9), "Fizz")
	
    def test_returnBuzzIfDivisibleByFive(self):
        self.assertEqual(FizzBuzz.fizzBuzz(self, 5), "Buzz")
        self.assertEqual(FizzBuzz.fizzBuzz(self, 10), "Buzz")
        self.assertEqual(FizzBuzz.fizzBuzz(self, 20), "Buzz")
	
    def test_returnFizzBuzzIfDivisibleByThreeAndFive(self):
        self.assertEqual(FizzBuzz.fizzBuzz(self, 15), "FizzBuzz")
        self.assertEqual(FizzBuzz.fizzBuzz(self, 30), "FizzBuzz")
        self.assertEqual(FizzBuzz.fizzBuzz(self, 60), "FizzBuzz")

if __name__ == "__main__":
    unittest.main()