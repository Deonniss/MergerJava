package parser;

/**
 * ����� ParserInt - ������ String � Integer, ���������� ����������
 * ��� ������������� ��������� ��������
 */

public class ParserInt {

    /**
     * ����� parseInteger - ������ String � Integer
     * @param value - String ��������, ������� ����� ������������� � Integer
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
     * ����� isDigit - ��������� ������ �� �����
     * @param s - String ��������, ������� �������� �������� �� �����
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
