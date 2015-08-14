package assignment;

import java.util.Arrays;
import java.util.function.Predicate;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

@Service
public class HugeIntegerOperationsImpl implements HugeIntegerOperations {

	private static final String IS_LESS_THAN_OR_EQUAL_TO = "isLessThanOrEqualTo";
	private static final String IS_GREATER_THAN_OR_EQUAL_TO = "isGreaterThanOrEqualTo";
	private static final String IS_LESS_THAN = "isLessThan";
	private static final String IS_GREATER_THAN = "isGreaterThan";
	private static final String IS_NOT_EQUAL_TO = "isNotEqualTo";
	private static final String IS_EQUAL_TO = "isEqualTo";

	public HugeIntegerOperationsImpl() {
	}

	@Override
	public String add(String first, String second) {
		HugeInteger firstNumber = new HugeInteger(first);
		HugeInteger secondNumber = new HugeInteger(second);

		ArrayUtils.reverse(firstNumber.getNumber());
		ArrayUtils.reverse(secondNumber.getNumber());

		for (int i = 0; i < findMaximum(firstNumber.getLength(), secondNumber.getLength()); i++) {
			firstNumber.getNumber()[i] += secondNumber.getNumber()[i];
		}
		ArrayUtils.reverse(firstNumber.getNumber());
		return firstNumber.toString();
	}

	@Override
	public String subtract(String first, String second) {
		HugeInteger firstNumber = new HugeInteger(first);
		HugeInteger secondNumber = new HugeInteger(second);

		ArrayUtils.reverse(firstNumber.getNumber());
		ArrayUtils.reverse(secondNumber.getNumber());

		for (int i = 0; i < findMaximum(firstNumber.getLength(), secondNumber.getLength()); i++) {
			firstNumber.getNumber()[i] -= secondNumber.getNumber()[i];
		}
		ArrayUtils.reverse(firstNumber.getNumber());

		return firstNumber.toString();
	}

	@Override
	public boolean isZero(String first) {
		HugeInteger number = new HugeInteger(first);
		return Arrays.asList(ArrayUtils.toObject(number.getNumber())).stream().map(digit -> digit == 0).reduce(true,
				(a, b) -> a && b);

	}

	@Override
	public boolean operations(String first, String second, String operator) {

		HugeInteger firstNumber = new HugeInteger(first);
		HugeInteger secondNumber = new HugeInteger(second);

		Predicate<HugeInteger> isEqualTo = b -> {
			return firstNumber.isEqualTo(b);
		};
		Predicate<HugeInteger> isNotEqualTo = b -> {
			return firstNumber.isNotEqualTo(b);
		};
		Predicate<HugeInteger> isGreaterThan = b -> {
			return firstNumber.isGreaterThan(b);
		};
		Predicate<HugeInteger> isLessThan = b -> {
			return firstNumber.isLessThan(b);
		};
		Predicate<HugeInteger> isGreaterThanOrEqualTo = b -> {
			return firstNumber.isGreaterThanOrEqualTo(b);
		};
		Predicate<HugeInteger> isLessThanOrEqualTo = b -> {
			return firstNumber.isLessThanOrEqualTo(b);
		};

		switch (operator) {

		case IS_EQUAL_TO:
			return isEqualTo.test(secondNumber);
		case IS_NOT_EQUAL_TO:
			return isNotEqualTo.test(secondNumber);
		case IS_GREATER_THAN:
			return isGreaterThan.test(secondNumber);
		case IS_LESS_THAN:
			return isLessThan.test(secondNumber);
		case IS_GREATER_THAN_OR_EQUAL_TO:
			return isGreaterThanOrEqualTo.test(secondNumber);
		case IS_LESS_THAN_OR_EQUAL_TO:
			return isLessThanOrEqualTo.test(secondNumber);
		}
		return true;
	}

	private int findMaximum(Integer a, Integer b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
}
