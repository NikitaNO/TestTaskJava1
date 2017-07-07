import java.util.HashMap;
import java.util.Map;

public class MIMETypeChecker {

    private Map<String, String> knownTypes;

    public MIMETypeChecker() {
        knownTypes = new HashMap<>();
        knownTypes.put("htm", "text/html");
        knownTypes.put("html", "text/html");
        knownTypes.put("htmls", "text/html");
        knownTypes.put("png", 	"image/png");
    }

    public String checkMimeType(String filename) {
        String[] parsed = filename.split("[.]");
        if(parsed.length == 1) {
            return "Incorrect filename format!";
        }
        String ext = parsed[parsed.length - 1].toLowerCase();
        String mimeType = knownTypes.get(ext);
        if(mimeType == null) {
            return "Unknown type. You can modify it by using method addMimeType(String ext, String type)";
        } else {
            return mimeType;
        }
    }

    public void addMimeType(String ext, String type) {
        knownTypes.put(ext.toLowerCase(), type);
    }
    private void testMimeChecker() {
        System.out.println(checkMimeType("image1.png"));
        System.out.println(checkMimeType("/var/www/index.htm"));
        System.out.println(checkMimeType("image.txt.png"));
        System.out.println(checkMimeType("image"));
        System.out.println(checkMimeType("image.txt"));
        addMimeType("txt", "text/plain");
        System.out.println(checkMimeType("image.txt"));
        System.out.println(checkMimeType("image.TXT"));
    }

    public static void main(String[] args) {
        new MIMETypeChecker().testMimeChecker();
    }
}
