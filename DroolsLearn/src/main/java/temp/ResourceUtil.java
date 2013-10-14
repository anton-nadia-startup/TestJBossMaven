package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Anton Krupnov
 * Date: 26.09.13
 * Time: 22:21
 */
public class ResourceUtil {

    public static List<String> getResources(String directory, String extension) {
        List<String> resources = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.class.getResourceAsStream(directory)));
        String fileName;
        try {
            while ((fileName = reader.readLine()) != null)
                if (fileName.endsWith(extension)){
                    String fullName = directory + "/" + fileName;
                    resources.add(fullName);
                    System.out.println(fullName); // todo
            }
        } catch (IOException ignored) {

        }
        return resources;
    }
}
