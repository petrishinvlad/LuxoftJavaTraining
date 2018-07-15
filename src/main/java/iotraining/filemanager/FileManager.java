package iotraining.filemanager;


import java.io.*;

public class FileManager {
    public static int calculateFiles(String path) {
        return calcFiles(path, FileType.FILE);
    }
    Object

    public static int calculateDirs(String path) {
        return calcFiles(path, FileType.DIRECTORY);
    }

    public static int calcFiles(String path, FileType fileType) {
        int count = 0;

        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(ExceptionStatus
                                                .DIRECTORY_DOES_NOT_EXIST
                                                .getMessage());
        }

        if (file.isDirectory()) {
            for (File innerFile : file.listFiles()) {
                int directoryIncrement = fileType == FileType.DIRECTORY ? 1 : 0;
                count += calcFiles(innerFile.getPath(), fileType) + directoryIncrement;
            }
        } else {
            int fileIncrement = fileType == FileType.FILE ? 1 : 0;
            count += fileIncrement;
        }

        return count;
    }
}
