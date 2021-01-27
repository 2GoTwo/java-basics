package read_file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




public class Main {

	public static void main(String[] args) throws IOException {
		//From FileReader
		System.out.println(readFromFile("resources/input.txt"));
		
		//From InputStreamReader
		Class<?> clazz = Main.class;
		InputStream is = clazz.getResourceAsStream("/input.txt"); //absolute path
		System.out.println(readFromInputStream(is));
		
		//Using InputStreamReader and classLoader
		ClassLoader cl = Main.class.getClassLoader();
		InputStream iscl = cl.getResourceAsStream("input.txt"); //relative path
		System.out.println(readFromInputStream(iscl));
		
		//small file
		System.out.println(readSmallFile("resources/input.txt"));
		
		//read with tokenizer
		readWithTokenizer(new FileReader("resources/input.txt"));
		
	}

	static String readFromFile(String path) {
		StringBuilder strb = new StringBuilder();

		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
			br.lines().forEach(str -> strb.append(str).append("\n"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strb.toString();
	}
	
	static String readFromInputStream(InputStream inputStream) {
		StringBuilder strb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			br.lines().forEach(str -> strb.append(str).append("\n"));
		} catch (IOException e) {
			System.out.println("file not found ...");
		}
		return strb.toString();
	}
	
	static String readSmallFile(String pathos) {
		StringBuilder strb = new StringBuilder();
		Path path = Paths.get(pathos);
		try {
			Files.readAllLines(path).forEach(str -> strb.append(str).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strb.toString();
	}
	
	static String readLargeFile(String pathos) {
		StringBuilder strb = new StringBuilder();
		Path path = Paths.get(pathos);
		try {
			BufferedReader br = Files.newBufferedReader(path);
			br.lines().forEach(str -> strb.append(str).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strb.toString();
	}
	
	
	static void readWithTokenizer(Reader reader) {
		StreamTokenizer stok = new StreamTokenizer(reader);
		try {
			while((stok.nextToken()) != StreamTokenizer.TT_EOF) {
				if(stok.ttype == StreamTokenizer.TT_WORD) {
					System.out.println(stok.sval);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
