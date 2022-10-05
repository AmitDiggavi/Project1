public class ISBNValidator implements IISBNValidator {
    /**
     * Checks is the given ISBN number is a valid ISBN13 number.
     * @param isbn13 the ISBN number to validate
     * @return true is the number if a valid ISBN number, false otherwise
     */
    public boolean validate(String isbn13) {
        String[] intsAsStrings = isbn13
            .replaceAll("\\D+", "")
            .split("");
        Integer[] digits = new Integer[intsAsStrings.length];
        for (int i = 0; i < intsAsStrings.length; i++) {
            try {
                digits[i] = Integer.parseInt(intsAsStrings[i]);
            } catch (NumberFormatException ignored) {
                return false;
            }
        }
        if (digits.length != 13) return false;

        Integer checkDigit = digits[digits.length - 1];
        if (checkDigit < 0 || checkDigit > 9) return false;

        int sum = 0;
        for (int i = 0; i < digits.length - 1; i++) {
            int multiplier = i % 2 == 0 ? 1 : 3;
            sum += multiplier * digits[i];
        }

        int calculatedCheckDigit = 10 - (sum % 10);
        calculatedCheckDigit = calculatedCheckDigit == 10 ? 0 : calculatedCheckDigit;
        return checkDigit == calculatedCheckDigit;
    }
}
