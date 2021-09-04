package parser;

/**
 * Класс ParserInt - парсит String в Integer, выбрасывая исключение
 * при невозможности выполнить операцию
 */

public class ParserInt {

    /**
     * parseInteger method - parses a String into an Integer
     * @param value - String value that needs to be converted to an Integer
     * @return Integer
     */
    public static Integer parseInteger(String value) {
        if (isDigit(value)) {
            return Integer.parseInt(value);
        } else {
            throw new NumberFormatException();
        }
    }

    /**
     * isDigit method - checks the string for a number
     * @param s - String value that passes the number check
     * @return boolean
     */
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
