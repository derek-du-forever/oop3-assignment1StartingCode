package appDomain;

public class MainInput {
    private String fileName;
    private String sortingAlgorithmType;
    private String sortingProperty;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        this.fileName = fileName;
    }

    public String getSortingAlgorithmType() {
        return sortingAlgorithmType;
    }

    public String getSortingAlgorithmName() {
        switch (sortingAlgorithmType) {
            case "b":
                return "Bubble Sort";
            case "s":
                return "Selection Sort";
            case "i":
                return "Insertion Sort";
            case "m":
                return "Merge Sort";
            case "q":
                return "Quick Sort";
            case "z":
                return "Heap Sort";
            default:
                throw new IllegalArgumentException("Unknown sorting algorithm type: " + sortingAlgorithmType);
        }
    }

    public void setSortingAlgorithmType(String sortingType) {
        if (sortingType == null || sortingType.trim().isEmpty()) {
            throw new IllegalArgumentException("Sorting algorithm type cannot be null or empty");
        }
        this.sortingAlgorithmType = sortingType;
    }

    public String getSortingProperty() {
        return sortingProperty;
    }

    public void setSortingProperty(String sortingProperty) {
        if (sortingProperty == null || sortingProperty.trim().isEmpty()) {
            throw new IllegalArgumentException("Sorting property cannot be null or empty");
        }
        this.sortingProperty = sortingProperty;
    }

}
