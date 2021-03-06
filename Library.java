public class Library {
    public static int[] extractValuesAfterFour(int[] digits) {
        if (digits == null || digits.length == 0) {
            throw new RuntimeException("Inbound array cannot be null nor empty.");
        }

        int index = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 4) index = i;
        }
        if (index == -1) {
            throw new RuntimeException("Inbound array must contain one 4-digit at least.");
        }
        int[] newDigits = new int[digits.length - index - 1];
        System.arraycopy(digits, index + 1, newDigits, 0, newDigits.length);

        return newDigits;
    }
    public static boolean checkOneOrFourDigitPresenceFoul(int[] digits) {
        return true;
    }
    public static boolean checkOneOrFourDigitPresenceTry(int[] digits) {
        return false;
    }
}
