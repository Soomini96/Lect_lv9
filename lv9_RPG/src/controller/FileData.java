package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileData {
	String fileName1 = "guildData.txt";
	File guildFile = new File(fileName1);
	String fileName2 = ".txt";
	File UserFile = new File(fileName2);
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;

	public void save() {
//		String data 
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
