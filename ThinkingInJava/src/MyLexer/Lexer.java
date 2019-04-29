package MyLexer;

import java.io.*;

public class Lexer {

    private static String readFile(String filePath) {
        String outputPath = "/Users/mohaitao/Desktop/lexerOutput.txt";
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(filePath));
            BufferedReader d  = new BufferedReader(new InputStreamReader(in));
            StringBuffer buffer = new StringBuffer();

            String count;
            while((count = d.readLine()) != null){
                buffer.append(count+"\n");
            }
            d.close();

            return buffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        String filePath = "/Users/mohaitao/Desktop/exampleProgram.txt";
        String result = Lexer.readFile(filePath);
        System.out.println(result);

    }
}
