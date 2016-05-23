package org.wikidreams.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WDFile {

	/**
	 * @param file
	 * @param lines
	 * @throws IOException
	 */
	public static void writeTextFile(File file, ArrayList<String> lines) throws IOException  {
		Path path = Paths.get(file.getAbsolutePath());  
		final Charset ENCODING = StandardCharsets.UTF_8;
		BufferedWriter writer = Files.newBufferedWriter(path, ENCODING);
		for(String line : lines){
			writer.write(line);
		}
		writer.close();
	}



	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> readTextFile(File file) throws IOException {
		final Charset ENCODING = StandardCharsets.UTF_8;  
		Path path = Paths.get(file.getAbsolutePath());
		BufferedReader reader = Files.newBufferedReader(path, ENCODING);
		ArrayList<String> lines = new ArrayList<>();
		String line = null;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}



	/**
	 * Returns the number of lines of a text file.
	 * @param file
	 * @return
	 */
	public static int getNumLines(File file) {
		int numLines = 0;
		try {
			LineNumberReader reader  = new LineNumberReader(new FileReader(file));
			String lineRead = "";
			while ((lineRead = reader.readLine()) != null) {}
			numLines = reader.getLineNumber(); 
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numLines;
	}

}
