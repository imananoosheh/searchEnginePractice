import java.io.*;
import org.jsoup.*;

/**
 * 
 * This class is used to convert HTML web pages to Text files
 *
 */

public class Conversion {

	public static void convert(String filename1) throws IOException {
		// Read htm file using jsoup
		File myfile = new File("C:\\Users\\user\\Desktop\\1000_web_htm_archive\\1000_web_htm_archive\\" + filename1); //location of html pages
		org.jsoup.nodes.Document doc = Jsoup.parse(myfile, "UTF-8");
		String text = doc.text();

		// Save the content of htm file into text(.txt) file 
		String modifiedfilename = filename1.replaceFirst("[.][^.]+$", "");
		PrintWriter out = new PrintWriter(
				"C:\\Users\\user\\Desktop\\Files_Converted\\" + modifiedfilename + ".txt"); 
		out.println(text);
		out.close();
	}

	public static void main(String[] args) throws IOException {
		// Track all the files inside folder
		File dir = new File("C:\\Users\\user\\Desktop\\1000_web_htm_archive\\1000_web_htm_archive\\");
		File[] filelist = dir.listFiles();
	
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isFile()) {
				convert(filelist[i].getName());
			}
		}
		System.out.println("Converted 1000 Html files to text files and stored them in a folder Files_Converted");
	}
}
