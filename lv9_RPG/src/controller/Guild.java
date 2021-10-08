package controller;

import java.util.ArrayList;

import models.Unit;

public class Guild {
	private final int PARTYSIZE = 4; // 파티원 디폴트 4
	private ArrayList<Unit> units = new ArrayList<>();
	private Unit partyUnit[] = new Unit[this.PARTYSIZE];

	public Guild() {
		// 길드원 추가하기
		for (int i = 0; i < 10; i++) {
			this.units.add(addUnit());
		}
		// 파티원 4명 임의로 골라 넣기
		for (int i = 0; i < this.PARTYSIZE; i++) {
			int idx = Player.ran.nextInt(this.units.size());
			if (this.units.get(idx).getParty()) {
				i--;
			} else {
				this.units.get(idx).turnOnParty();
			}
		}
		this.partyUnitCheck(); // partyUnit에 넣어주기
	}

	private Unit addUnit() {
		String name1[] = { "이", "김", "구", "박", "한", "전", "최", "나", "허" };
		String name2[] = { "수", "두", "슬", "상", "세", "효", "유", "은", "승" };
		String name3[] = { "민", "호", "비", "윤", "영", "주", "정", "선", "혁" };
		String name = name1[Player.ran.nextInt(name1.length)];
		name += name2[Player.ran.nextInt(name2.length)];
		name += name3[Player.ran.nextInt(name3.length)];

		int num = Player.ran.nextInt(name1.length) + 1;
		int hp = num * 10;
		int att = num + 5;
		int def = num + 3;

		Unit newUnit = new Unit(name, hp, att, def);
		return newUnit;
	}

	private void partyUnitCheck() {
		this.partyUnit = new Unit[this.PARTYSIZE];
		int idx = 0;
		for (int i = 0; i < this.units.size(); i++) {
			if (this.units.get(i).getParty()) {
				this.partyUnit[idx] = this.units.get(i);
				idx++;
			}
		}
	}

	public void printAllGuild() {
		System.out.println("------- 길드원 리스트 -------");
		for (int i = 0; i < this.units.size(); i++) {
			this.units.get(i).printUnit(i + 1);
		}
		System.out.println("--------------------------");
		System.out.println("Money: " + Player.money + "원");
		System.out.println("--------------------------");
	}

	public void printAllGuildWithInventory() {
		System.out.println("------- 길드원 리스트 -------");
		for (int i = 0; i < this.units.size(); i++) {
			this.units.get(i).printUnitWithInventory(i + 1);
		}
		System.out.println("--------------------------");
		System.out.println("Money: " + Player.money + "원");
		System.out.println("--------------------------");
	}

	public void addGuild() {
		System.out.println("길드원을 추가하시겠습니까? [비용:5000원]");
		System.out.print("[1]Yes [2]No: ");
		String input = Player.scan.next();
		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				if (Player.money >= 5000) {

					Unit newUnit = this.addUnit();
					this.units.add(newUnit);

					newUnit.printUnit();
					System.out.println("길드원을 추가합니다.");
					Player.money -= 5000;
				} else {
					System.out.println("돈이 부족합니다.");
				}
			}
		} catch (Exception e) {
		}
	}

	public void deleteGuild() {
		System.out.print("삭제할 길드원의 번호를 입력하세요[0.취소]_");
		String input = Player.scan.next();
		try {
			int sel = Integer.parseInt(input) - 1;
			if (sel >= 0 && sel < this.units.size()) {
				this.units.get(sel).delAllItem();
				this.units.remove(sel);
				this.partyUnitCheck();
			}
		} catch (Exception e) {
		}
	}

	public void printAllParty() {
		System.out.println("------- 파티원 리스트 -------");
		for (int i = 0; i < this.PARTYSIZE; i++) {
			this.partyUnit[i].printUnit(i + 1);
		}
		System.out.println("--------------------------");
	}

	public void changeParty() {
		this.printAllParty();
		System.out.print("교체를 원하는 파티원의 번호를 입력하세요_");
		String input = Player.scan.next();
		try {
			int sel = Integer.parseInt(input) - 1;
			if (sel >= 0 && sel < this.partyUnit.length) {
				this.printAllGuild();
				System.out.print("길드원의 번호를 입력하세요_");
				int guildIdx = Player.scan.nextInt() - 1;
				if (guildIdx >= 0 && guildIdx < this.units.size() && !this.units.get(guildIdx).getParty()) {
					this.partyUnit[sel].turnOffParty();
					this.units.get(guildIdx).turnOnParty();
					this.partyUnitCheck();
				} else {
					System.out.println("추가할 수 없는 길드원입니다.");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Unit getUnit(int idx) {
		return this.units.get(idx);
	}

	public int getUnitSize() {
		return this.units.size();
	}

	public void sortGuild() {
		System.out.println("[1.이름 순 정렬]");
		System.out.println("[2.공격력 순 정렬]");
		String input = Player.scan.next();
		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				for (int i = 0; i < this.units.size(); i++) {
					for (int j = i; j < this.units.size(); j++) {
						if (this.units.get(i).getName().compareTo(this.units.get(j).getName()) > 0) {
							Unit temp = this.units.get(i);
							this.units.set(i, this.units.get(j));
							this.units.set(j, temp);
						}
					}
				}
			} else if (sel == 2) {
				for (int i = 0; i < this.units.size(); i++) {
					for (int j = i; j < this.units.size(); j++) {
						if (this.units.get(i).getAttack() < this.units.get(j).getAttack()) {
							Unit temp = this.units.get(i);
							this.units.set(i, this.units.get(j));
							this.units.set(j, temp);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
