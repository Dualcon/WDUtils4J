package com.wikidreams.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class WDFile {

	public static ArrayList<String> readTXTFile(File file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String sCurrentLine;
		ArrayList<String> lines = new ArrayList<>();
		while ((sCurrentLine = br.readLine()) != null) {
			lines.add(sCurrentLine);
		}
		if (br != null)br.close();		return lines;
	}



	public static void writeTextToFile(File file, StringBuilder sb) throws Exception {
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(sb.toString());
		bufferedWriter.close();
	}

}
