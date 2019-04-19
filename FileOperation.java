package net.ukr.andy777;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FileOperation {
	private static String wordSplitter= " ";
	private static String vocabSplitter= ";";

	// читання слів з файлу до списку
	public static List<String> readFile(String fileName) {
		List<String> res = new ArrayList<String>();
		try {
			String str = null;
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((str = br.readLine()) != null) {
				String words[] = str.split(wordSplitter);
				for (String word : words) {
					word = word.replaceAll("\\W", "");// замінюємо не букви/цифри на пустий символ.
					res.add(word.replace("\t", ""));// доповнюємо список новим словом 
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error open file - " + fileName);
		}
		return res;
	}

	// запис до файлу списку слів
	public static void saveFile(String fileName, List<String> words) {
		String resStr = "";
		for (String word : words)
			resStr += word + wordSplitter;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName));
			pw.print(resStr);
		} catch (FileNotFoundException e) {
			System.out.println("Error found file" + fileName);
		} finally {
			pw.close();
		}
	}

	
	// читання словника з табличного формату
	public static Map<String, String> readVocabular(String fileName) {
		Map<String, String> res = new TreeMap<String, String>();
		try {
			String str = null;
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((str = br.readLine()) != null) {
				String words[] = str.split(vocabSplitter);
				res.put(words[0], words[1]);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error open file - " + fileName);
		}
		return res;
	}

	// запис словника до табличного формату
	public static void saveVocabular(String fileName, Map<String, String> vocab) {
		String resStr = "";
		Set<Map.Entry<String, String>> words = vocab.entrySet();
		for (Map.Entry<String, String> w : words)
			resStr += w.getKey() + vocabSplitter + w.getValue() + System.getProperty("line.separator");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName));
			pw.print(resStr);
		} catch (FileNotFoundException e) {
			System.out.println("Error found file" + fileName);
		} finally {
			pw.close();
		}
	}

}