import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Entry {
    public static void main(String[] args) throws IOException {
        // Get the email id
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an email id: ");
        String emailId = br.readLine();
        System.out.println();
        br.close();

        // Create url and open connection
        URL url = new URL("http://www.ecs.soton.ac.uk/people/" + emailId);
        URLConnection conn = url.openConnection();

        // Url buffer reader
        BufferedReader webBr = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        // Regex to match the name holder
        String pattern = "property=\"name\">(.*)</h1>";
        Pattern regex = Pattern.compile(pattern);

        // Go through each line until printing the name, after that stop looking
        Matcher matcher;
        String inputLine;
        while ((inputLine = webBr.readLine()) != null) {
            matcher = regex.matcher(inputLine);
            if (matcher.find()) {
                System.out.println("Name: " + matcher.group(1));
                break;
            }
        }

        webBr.close();
    }
}
