package bbcs.tangruri.bot.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	public static String readFile(String filename) {
		BufferedReader in = null;
		String content = "";
		try {
			in = new BufferedReader(new FileReader(filename));
			String buffer;
			while((buffer = in.readLine()) != null) {
				if(content.equals("") == false)
					content += System.getProperty("line.separator");
				content += buffer;
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}

		return content;
	}
}
