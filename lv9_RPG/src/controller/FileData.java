package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.Item;
import models.Unit;

public class FileData {
	Shop shop = new Shop();
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
	public void load() {
		
		Player.inventory.resetInventory();
		Player.guild.resetGuild();
		
		try { // inventory
			fr = new FileReader(fileName1);
			br = new BufferedReader(fr);
			
			String str = br.readLine();
			fr.close();
			br.close();
			String temp[] = str.split("/");
			for(int i=0; i<temp.length; i++) {
				Item item = this.shop.findItem(temp[i]);
				Player.inventory.addInventory(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try { // guild
			fr = new FileReader(fileName2);
			br = new BufferedReader(fr);
			
			String str = br.readLine();
			Player.money = Integer.parseInt(str);
			str = br.readLine();
			while(str!=null) {
				String temp[] = str.split("/");
				String name = temp[0];
				int level = Integer.parseInt(temp[1]);
				int maxHp = Integer.parseInt(temp[2]);
				int att = Integer.parseInt(temp[3]);
				int def = Integer.parseInt(temp[4]);
				int exp = Integer.parseInt(temp[5]);
				boolean party = Boolean.parseBoolean(temp[6]);
				Player.guild.addUnit(name, level, maxHp, att, def, exp, party);
				str = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
