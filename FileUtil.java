package actiongenerator;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import actiongenerator.obj.Item;

public class FileUtil {

	// "#"が�?ぞいて
	public static List<Item> readFile(String filename) {
		List<Item> items = new ArrayList<Item>();

		System.out.println("定義ファイル:"+ filename);
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "utf-8");
			BufferedReader br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null) {
				if (line != null && line.trim().length() != 0 && !line.trim().startsWith("#")) {

					String[] data = line.split("\t");
					if (data.length > 4) {
						Item item = new Item();
						item.actionName = data[0];
						item.inout = data[1] ;
						item.fieldname = data[2];
						item.type = data[3];
						item.comment = data[4];
						items.add(item);
						System.out.println("     " + item);
					} else {
						System.out.println("【不正定義 length:" + data.length + "]" + line);

					}

				}

			}
			br.close();
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return items;
	}

	public static void writeFile(String filename, String contents) throws Exception {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
			pw.println(contents);
			pw.close();
		} catch (IOException e) {
			throw e;
		}
	}

}
