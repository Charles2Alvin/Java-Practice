package interview;
import java.io.File;
public class listAllFiles {
    public static void list(File dir) {
        if (dir == null || !dir.exists())
            return;
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles())
            list(file);
    }
    public static void main(String[] args) {
        listAllFiles.list(new File("/Users/mohaitao/Desktop/JavaCode" +
                "/ThinkingInJava/src/offer"));
    }
}
