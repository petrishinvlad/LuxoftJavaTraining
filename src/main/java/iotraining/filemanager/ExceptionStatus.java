package iotraining.filemanager;

public enum ExceptionStatus {
    DIRECTORY_DOES_NOT_EXIST("Source directory does not exist");

    private String statusMessage;

    ExceptionStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMessage() {
        return statusMessage;
    }
}
