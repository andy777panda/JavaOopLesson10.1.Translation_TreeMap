package net.ukr.andy777;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Vocabular implements Serializable {
	private static final long serialVersionUID = 1L;
	private TreeMap<String, String> vocab = new TreeMap<String, String>(); // map of words

	public Vocabular() {
		super();
	}

	
	public Vocabular(TreeMap<String, String> vocab) {
		super();
		this.vocab = vocab;
	}


	public TreeMap<String, String> getVocab() {
		return vocab;
	}

	// метод додавання іншомовних слів + перекладу до словника
	public Vocabular addVocabular() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Add words to vocabular");
		for (int i = 1; i == 1;) {

			System.out.print("EN-word: ");
			String wordEn=sc.next();

			System.out.print("\t" + "UA-translate: ");
			String wordUa=sc.next();

			vocab.put(wordEn, wordUa);

			System.out.print("another word?   0.no   1.yes ...");
			i=sc.nextInt();

		}
		sc.close();
		return this;
	}

	// метод читання словника з файлу методами серіалізації
	public Vocabular readVocabular(String fileName) {
		Vocabular res = null;
		try {
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(fileName));
			res = (Vocabular) OIS.readObject();
		} catch (IOException e) {
			System.out.println("ERROR load Vocabular - IOException!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR load Vocabular - ClassNotFoundException!!!");
		}
		return res;
	}

	// метод запису словника до файлу методами серіалізації
	public void saveVocabular(String fileName) {
		try {
			ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(fileName));
			OOS.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR save group !!!");
		}
	}
}