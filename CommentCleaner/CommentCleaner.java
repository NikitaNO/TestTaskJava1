import java.util.Scanner;

public class CommentCleaner {
    private Scanner scanner;

    public CommentCleaner(String filename) {
        scanner = new Scanner(getClass().getResourceAsStream(filename));
    }

    public CommentCleaner() {
    }

    public String result() {
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()){
            builder.append(scanner.nextLine()).append(scanner.hasNext() ? "\n" : "");
        }
        String collect = builder.toString();
        return collect.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)", "");
    }

    private static void testCommentCleaner() {
        CommentCleaner commentCleaner = new CommentCleaner("test.txt");
        System.out.println(commentCleaner.result());
    }

    public static void main(String[] args) {
        testCommentCleaner();
    }
}
