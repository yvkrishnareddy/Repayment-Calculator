package pages;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class KeyValuesFromFile {
	final static String filePath = "./Files/TestData.txt";
	public static void main(String[] args)
	{
		//List<ListOfPairs<String,String>> pairList = new ArrayList<ListOfPairs<String,String>>();
		// read text file to HashMap
		Map<String, String> mapFromFile = HashMapFromTextFile();

		// iterate over HashMap entries
		for (Map.Entry<String, String> entry : mapFromFile.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public static Map<String, String> HashMapFromTextFile()
	{

		Map<String, String> map = new HashMap<String, String>();
		BufferedReader br = null;

		try {
			// create file object
			File file = new File(filePath);

			// create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));

			String line = null;
			int lineCount = 0;
			// read file line by line
			while ((line = br.readLine()) != null) {

				//   line.replace("\"","dq");
				String keyWord = "[record";
				String[] parts = new String[0];

				if(line.contains(keyWord) && line.contains("\"")) {
					parts = line.split("\"" );
					String key = parts[0].trim();
					Pattern p = Pattern.compile(".*\" *(.*) *\"].*");
					Matcher m = p.matcher(line);
					m.find();
					String value = m.group(1);

					//    String value = line.substring(line.indexOf('\"') + 1, line.indexOf(']'));

					if (!key.equals(""))
						map.put(key, value);
				}
				else if(!line.contains(keyWord) && line.contains("[")) {
					parts = line.split("\\[" );
					String key = parts[0].trim();
					String value = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
					if (!key.equals(""))
						map.put(key, value);
				} else if (!line.contains(keyWord)) {
					parts = line.split("\"" );
					String key = parts[0].trim();
					String value = parts[1].trim();
					if (!key.equals(""))
						map.put(key, value);
				}
				lineCount++;
			}
			System.out.println("Total Lines inthe File: "+lineCount);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (Exception e) {
				}
            }
		}

		return map;
	}
}
