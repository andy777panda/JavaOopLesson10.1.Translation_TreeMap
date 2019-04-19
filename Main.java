package net.ukr.andy777;

/*
 Lesson10
 1. Написать программу - переводчик, которая будет переводить текст в файле English.in, написанный на английском языке, 
 на украинский язык, согласно заранее составленному словарю. Результат сохранить в файл Ukrainian.out.
 2. Сделать ф-ю ручного наполнения словаря и возможность его сохранения на диск.*/

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> wordsEn = FileOperation.readFile("English.in"); // читання іншомовного тексту
		List<String> wordsUa = new ArrayList<String>(); // ініцілізація списку для україномовного перекладу
		// System.out.print(words);

		// Map<String, String> vocab = FileOperation.readVocabular("Vocabular.csv"); // читання словника з файлу
		// Vocabular vcb = new Vocabular((TreeMap<String, String>) vocab); // допоміжний код для початкової серіалізації
		Vocabular vcb = new Vocabular().readVocabular("Vocabular.srl"); // читання словника з серіалізованого файлу

		int operation = AP.inputIntegerDialog(1, 2, "Chose operation:   1.translate;   2.addVocabular+translate ... ");
		if (operation == 2)
			vcb.addVocabular();

		// переклад по словам
		for (String word : wordsEn)
			if (vcb.getVocab().containsKey(word))
				wordsUa.add(vcb.getVocab().get(word));

		// запис перекладу до файлу
		FileOperation.saveFile("Ukrainian.out", wordsUa);
		// System.out.println(wordsUa);
		System.out.println("translated");

		FileOperation.saveVocabular("Vocabular.csv", vcb.getVocab()); // запис словника до табличного файлу
		vcb.saveVocabular("Vocabular.srl");// запис словника до серіалізованого файлу
	}
}
