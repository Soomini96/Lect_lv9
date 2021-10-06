package controller;

import models.Shop;
import models.User;

public class ShopManager {

	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;
	String shopName;

	public ShopManager(String name) {
		this.shopName = name;
	}

	public void run() {
		boolean isRun = true;
		while (isRun) {
			if (Shop.log == null) {
				isRun = userMenu();
			} else {
				shoppingMenu(Shop.log);
			}
		}
	}

	public boolean userMenu() {
		System.out.println("[[" + this.shopName + "]]");
		if (this.um.getUsers().size() > 0) {
			System.out.println("------------");
			for (User user : this.um.getUsers()) {
				System.out.printf("ID: %s / PW: %s\n", user.getId(), user.getPw());
			}
		}
		System.out.println("------------");
		System.out.println("[1]로그인");
		System.out.println("[2]회원가입");
		System.out.println("------------");
		System.out.println("[0]종료");
		System.out.println("[100]관리자");
		System.out.println("------------");
		System.out.print(": ");
		String input = Shop.sc.next();

		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				this.um.logIn();
			} else if (sel == 2) {
				this.um.signIn();
			} else if (sel == 100) {
				boolean isRun = true;
				while (isRun) {
					isRun = managerMode();
				}

			} else if (sel == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return true;
	}

	public void shoppingMenu(String log) {
		System.out.println("------------");
		System.out.println(Shop.log + " is log in _");
		System.out.println("------------");
		System.out.println("[1]쇼핑하기");
		System.out.println("[2]장바구니");
		System.out.println("------------");
		System.out.println("[0]로그아웃");
		System.out.println("------------");
		System.out.print(": ");
		String input = Shop.sc.next();

		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				this.im.shopping(log); // 카테고리 보여줌 -> 고르기
			} else if (sel == 2) {
				boolean isRun = true;
				while (isRun) {
					isRun = jang(log);
				}
			} else if (sel == 0) {
				Shop.log = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean jang(String log) {
		System.out.println("------------");
		System.out.println("[1]전체 장바구니");
		System.out.println("[2]장바구니 삭제");
		System.out.println("[3]장바구니 결제");
		System.out.println("------------");
		System.out.println("[0]뒤로가기");
		System.out.println("------------");
		System.out.print(": ");
		String input = Shop.sc.next();

		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				System.out.println("------------");
				um.userJangList(log);
				System.out.println("------------");
			} else if (sel == 2) {
				im.deleteJang(log);
			} else if (sel == 3) {
				im.payJang(log);
			} else if (sel == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	public boolean managerMode() {
		System.out.println("------------");
		System.out.println("[1]아이템 관리");
		System.out.println("[2]카테고리 관리");
		System.out.println("[3]장바구니 관리");
		System.out.println("[4]유저 관리");
		System.out.println("------------");
		System.out.println("[0]뒤로가기");
		System.out.println("------------");
		System.out.print(": ");
		String input = Shop.sc.next();

		try {
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				managerOfItem();
			} else if (sel == 2) {
				managerOfCategory();
			} else if (sel == 3) {
				managerOfJang();
			} else if (sel == 4) {
				managerOfUser();
			} else if (sel == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return true;
	}

	private void managerOfItem() {
		while (true) {
			System.out.println("[1.전체아이템] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			String input = Shop.sc.next();

			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					im.showAllItem();
				} else if (sel == 2) {
					im.addItem();
				} else if (sel == 3) {
					im.delItem();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void managerOfCategory() {
		while (true) {
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
			String input = Shop.sc.next();

			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					im.showAllCategory();
				} else if (sel == 2) {
					im.addCategory();
				} else if (sel == 3) {
					im.delCategory();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void managerOfJang() {
		while (true) {
			System.out.println("[1.전체장바구니] [2.장바구니삭제] [0.뒤로가기]");
			String input = Shop.sc.next();

			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					im.showAllJang();
				} else if (sel == 2) {
					im.delJang();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void managerOfUser() {
		while (true) {
			System.out.println("[1.전체사용자] [2.사용자추가] [3.사용자삭제] [0.뒤로가기]");
			String input = Shop.sc.next();

			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					um.showAllUser();
				} else if (sel == 2) {
					um.addUser();
				} else if (sel == 3) {
					um.delUser();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
