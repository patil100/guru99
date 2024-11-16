package Read_Write_File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCSV {

    private List<String> StringArrayList = new ArrayList<>();

	
	public ReadFromCSV (String path) throws IOException {
		List<String> credentials= Files.readAllLines(Paths.get(path));
		for(String s:credentials) {
			StringArrayList.add(s);
			
		}	
	} public String[] ReadLineNumber(int line) throws Exception {
        String login = StringArrayList.get(line);
        String[] StringArray = login.split(",");
        return StringArray;
    }
}
