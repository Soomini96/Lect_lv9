package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.Unit;

public class FileData {
	String fileName1 = "inventory.txt";
	File inventoryFile = new File(fileName1);
	
	String fileName2 = "guildData.txt";
	File guildFile = new File(fileName2);
	
	FileWriter fw = null;
	FileReader fr = null;
	BufferedReader br = null;

	public void save() {
		String invenData = Player.inventory.getInvenData();
		System.out.println(invenData);
		try {
			fw = new FileWriter(inventoryFile);
			fw.write(invenData);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String guildData = Player.money + "\n";
//		data += Player.guild.getUnitSize() + "\n";
		guildData += Player.guild.writeData();
		System.out.println(guildData);
		try {
			fw = new FileWriter(guildFile);
			fw.write(guildData);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//	public void load() {
//		try {
//			fr = new FileReader(fileName1)
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
