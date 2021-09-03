package parser;

/**
 * Класс ParserInt - парсит String в Integer, выбрасывая исключение
 * при невозможности выполнить операцию
 */

public class ParserInt {

    /**
     * Метод parseInteger - парсит String в Integer
     * @param value - String значение, которое нужно преобразовать в Integer
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
     * Метод isDigit - проверяет строку на число
     * @param s - String значение, которое проходит проверку на число
     * @return boolean
     * @throws NumberFormatException
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
