package option;

/**
 * ����� Options - ������ ��� ��������� ��� ���������� ���������
 * String outputFile  - ��� ��������� �����
 * String sortingMode - ����� ���������� (-a -d)(�� ��������� -a)
 * String dataType    - ��� ������ (-i -s)(�� ��������� -i)
 */
public class Options {

    private String outputFile;
    private String sortingMode = "-a";
    private String dataType = "-i";

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getSortingMode() {
        return sortingMode;
    }

    public void setSortingMode(String sortingMode) {
        this.sortingMode = sortingMode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
