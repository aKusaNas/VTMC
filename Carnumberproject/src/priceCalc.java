import java.util.Arrays;

public class priceCalc {

	public static Object calculatePrice(String plateNumber) {

		double plateNumberPrice = 0.0;

		if (isNamePlateHasCorrectCharacters(plateNumber)) {
			if (plateNumber.length() > 0 && plateNumber.length() < 7) {
				plateNumberPrice = 10000.0;
			}

			if (plateNumber.length() == 6) {
				if (hasIncreasingDigits(plateNumber)) {
					plateNumberPrice = 1000.0;
				}

				if (hasThreeSameLetters(plateNumber) || hasThreeSameDigits(plateNumber)) {
					plateNumberPrice = 1000.0;
				}

				if (hasThreeSameLetters(plateNumber) && hasThreeSameDigits(plateNumber)) {
					plateNumberPrice = 5000.0;
				}
				if (hasOneOfThree(plateNumber)) {
					plateNumberPrice = 2000.0;
				}
				if (oneOfThreeWithSameDigits(plateNumber)) {
					plateNumberPrice = 7000.0;
				}
			}
		} else {
			throw new IllegalArgumentException("\r\n" + "	* Incorrect plate number format.\r\n"
					+ "	* Must be 1-6 symbols\r\n" + "	 * latin letters and number combination");
		}

		return plateNumberPrice;
	}

	private static boolean hasThreeSameDigits(String plateNumber) {
		// CHECKS SAME DIGITS
		if (plateNumber.charAt(3) == plateNumber.charAt(4) && plateNumber.charAt(3) == plateNumber.charAt(5)) {
			return true;
		}
		return false;
	}

	private static boolean hasIncreasingDigits(String plateNumber) {
		// CHECKS INCREASING DIGITS
		String[] zeroToNine = { "001", "002", "003", "004", "005", "006", "007", "008", "009" };
		String cathnumber = "";
		for (int i = 3; i < 6; i++) {
			cathnumber += plateNumber.charAt(i);
		}
		boolean containszeroToNine = Arrays.stream(zeroToNine).anyMatch(cathnumber::equals);
		boolean sameLetters = hasThreeSameLetters(plateNumber);

		if (containszeroToNine && sameLetters) {
			return true;
		}
		return false;

	}

	private static boolean hasThreeSameLetters(String plateNumber) {
		// CHECKS SAME LETTERS
		if (plateNumber.charAt(0) == plateNumber.charAt(1) && plateNumber.charAt(0) == plateNumber.charAt(2)) {
			return true;
		}
		return false;

	}

	private static boolean hasOneOfThree(String plateNumber) {
		// CHECKS EXCLUSIVE LETTERS
		String[] oneOfThree = { "GOD", "KLR", "BOS" };
		String check = "";
		for (int i = 0; i < 3; i++) {
			check += plateNumber.charAt(i);
		}
		for (String string : oneOfThree) {
			if (string.contains(check)) {
				return true;
			}
		}
		return false;
	}

	private static boolean oneOfThreeWithSameDigits(String plateNumber) {
		// CHECKS EXCLUSIVE LETTERS WITH SAME DIGITS
		boolean hasOneOfThreeLetters = hasOneOfThree(plateNumber);

		if ((plateNumber.charAt(3) == plateNumber.charAt(4) && plateNumber.charAt(3) == plateNumber.charAt(5))
				&& hasOneOfThreeLetters) {
			return true;
		}

		return false;
	}

	public static boolean isNamePlateHasCorrectCharacters(String plateNumber) {
		// CHECKS CORRECT CHARACTERS IN PLATE
		for (int i = 0; i < plateNumber.length(); i++) {
			if (Character.isLowerCase(plateNumber.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
