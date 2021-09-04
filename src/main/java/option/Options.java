package option;

/**
 * Options class - stores all arguments for executing the program
 * String outputFile    - the name of the output file
 * String sortingMode   - sorting mode (-a -d)(default -a)
 * String dataType      - data type (-i -s)(default is -i)
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
