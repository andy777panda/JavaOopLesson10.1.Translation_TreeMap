package net.ukr.andy777;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AP {

	public static int inputIntegerDialog(int a, int b, String msg) {
		int res;
		for (;;) {
			try {
				res = Integer.valueOf(JOptionPane.showInputDialog(msg));
				if ((res < a) || (res > b))
					JOptionPane.showMessageDialog(null, "number out of range");
				else
					break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			}
		}
		return res;
	}

}
