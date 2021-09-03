package option;

/**
 * Класс Options - хранит все аргументы для выполнения программы
 * String outputFile  - имя выходного файла
 * String sortingMode - режим сортировки (-a -d)(по умолчанию -a)
 * String dataType    - тип данных (-i -s)(по умолчанию -i)
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
