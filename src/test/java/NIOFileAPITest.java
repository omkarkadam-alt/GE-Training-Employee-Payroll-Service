import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathCheckIfFileExists() throws IOException {
        // Check File Exists
        Path homePath = Paths.get(HOME);
        System.out.println(HOME);
        assertTrue(Files.exists(homePath));
    }

    @Test
    public void givenPathDeleteTheDirectory() throws IOException {
        // Delete File and Check If File Exists or not
        Path tmpPath = Paths.get(HOME + '/' + PLAY_WITH_NIO);
        if(Files.exists(tmpPath)){
            FileUtils.deleteDirectory(tmpPath.toFile());
        }
        assertTrue(Files.notExists(tmpPath));
    }

    @Test
    public void givenPathCreateDirectory() throws IOException {
        //Create Directory
        Path tmpPath = Paths.get(HOME + '/' + PLAY_WITH_NIO);
        Files.createDirectory(tmpPath);
        assertTrue(Files.exists(tmpPath));
    }

    @Test
    public void givenPathCreateRandomFiles() throws IOException {

        Path tmpPath = Paths.get(HOME + '/' + PLAY_WITH_NIO);
        IntStream.range(1, 10).forEach(cntr -> {
            Path tmpFile = Paths.get(tmpPath + "/temp" + cntr);
            assertTrue(Files.notExists(tmpFile));
            try{ Files.createFile(tmpFile); }
            catch(IOException e) { }
            assertTrue(Files.exists(tmpFile));
        });
    }

    @Test
    public void givenPathListAllDirectories() throws IOException {
        Path tmpPath = Paths.get(HOME + '/' + PLAY_WITH_NIO);
        Files.list(tmpPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(tmpPath).forEach(System.out::println);
        Files.newDirectoryStream(tmpPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
