class FizzBuzz:

    def fizzBuzz(self, number):
        if number % 3 == 0 and number % 5 == 0:
            return "FizzBuzz"
        
        if number % 3 == 0:
            return "Fizz"

        if number % 5 == 0:
            return "Buzz"

        return number