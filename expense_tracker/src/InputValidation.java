public class InputValidation {

    public static boolean isValidAmount(double amount) {
        return amount > 0 && amount < 1000;
    }

    public static boolean isValidCategory(String category) {
        String[] validCategories = {"food", "travel", "bills", "entertainment", "other"};
        for (String validCategory : validCategories) {
            if (validCategory.equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}