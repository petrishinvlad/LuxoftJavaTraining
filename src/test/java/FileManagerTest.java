import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileManagerTest {
    private static final String TESTING_DIR_PATH = "./testDir/";
    private static final String FILENAME_EXTENSION = ".txt";

    @BeforeClass
    public static void createFilesForTesting() {
        File file  = new File(TESTING_DIR_PATH);
        file.mkdir();

        for (int i = 0; i < 5; i++) {
            File dir = new File(file, String.valueOf(i+1));
            dir.mkdir();
            for (int j = 0; j < 5; j++) {
                File insideDir = new File(dir, String.valueOf(j+1));
                insideDir.mkdir();
                for (int k = 0; k < 5; k++) {
                    try {
                        new File(insideDir, String.valueOf(3*k+1) + FILENAME_EXTENSION).createNewFile();
                        new File(insideDir, String.valueOf(3*k+2) + FILENAME_EXTENSION).createNewFile();
                        new File(insideDir, String.valueOf(3*k+3) + FILENAME_EXTENSION).createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @AfterClass
    public static void deleteTestedFiles() {
        deleteDir(new File(TESTING_DIR_PATH));
    }

    private static void deleteDir(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                deleteDir(file);
            }
            file.delete();
        }
        dir.delete();
    }

    @Test
    public void testFileCalculation() {

    }

    @Test
    public void testDirCalculation() {

    }

    @Test/*(expected = IllegalArgumentException.class)*/
    public void testNotExistingDir() {

    }
}
