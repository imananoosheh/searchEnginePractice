
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

/**
 * 
 * The Master class gives the word searched from 1000 files and its occurrence offsets
 *
 */

public class Master {

	public static void main(String[] args) throws IOException {

		Scanner scn = new Scanner(System.in); // taking input from user
		System.out.println("Enter keyword you wish to search");
		String st = scn.nextLine();
		String fileName = "C:\\Users\\user\\Desktop\\Files_Converted\\"; // location of text files converted from 1000 html web pages
		File f = new File(fileName); // creation of file object
		File[] allfiles = f.listFiles(); // To get files names from mentioned directory
		int k = 0;
		boolean check = false; // keyword occurrence check flag
		System.out.println("Searching for keyword " + st + " in 1000 files and below are the results:");
		System.out.println("\n====================================================");
		for (k = 0; k < allfiles.length; k++) {  //reading all the 100 files

			FileReader fr = new FileReader(allfiles[k]);       
			BufferedReader buffr = new BufferedReader(fr);
			int occurence = 0;
			String str = null;
			String word = "";
			while ((str = buffr.readLine()) != null) {  //reading each line from the files
				word = word + str;       
			}
			KMP kmp = new KMP(st);      //searching for string pattern using KMP algorithm
			int offsetnum = 0;          //initial offset set to zero
			String sub;
			int position = 0;           

			while (position <= word.length()) {

				sub = word.substring(position);

				offsetnum = kmp.search(st, sub); // using KMP algorithm for keyword search
				if (offsetnum == sub.length()) {
					break;
				}

				if ((offsetnum + position) < word.length()) { // checking offset
					occurence++;
					System.out.println("occurred at position " + (offsetnum + position)); // For offset of the searched keyword
																							
				}

				position = offsetnum + position + st.length();

			}

			if (occurence != 0) {

				System.out.println("\nkeyword searched occured in File: " + allfiles[k].getName()); // printing file names of keyword occurrence
																									
				System.out.println("***************************************************\n");
				check = true;

			}

		}

		if (!check) {
			System.out.println("No matches found for searched keyword in 1000 files"); // printing when keyword searched is not found
																						 

		}

	}

}
