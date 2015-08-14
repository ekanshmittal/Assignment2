# Assignment2
A service HugeInteger which uses a 40-element array of digits to
store integers as large as 40 digits each. Methods to parse, toString, add and subtract. Method
parse receives a String, extract each digit using method charAt and place the integer
equivalent of each digit into the integer array. For comparing HugeInteger objects, the following
methods: isEqualTo, isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo
and isLessThanOrEqualTo are provided. Each of these is a predicate method that returns true if the relationship
holds between the two HugeInteger objects and returns false if the relationship does not hold. Provided
a predicate method isZero. 

Following URI's
/add - for adding two numbers, params = first,second
/subtract - for finding difference between two numbers ,  params = first,second
/isZero - checks if the number is zero, params = first
/operation- returns result after applying the operation,  params = first,second,operation
