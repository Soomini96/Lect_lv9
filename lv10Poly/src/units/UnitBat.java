package units;

import controller.Unit;

public class UnitBat extends Unit {
	public UnitBat() {
		setName("박쥐");
	}

	@Override
	public void skill(Unit target) {
		
		System.out.println("적 한명에게 침묵 시전.");
		target.setFrozen(true);
		System.out.printf("[%s]가 침묵의 늪에 갇혔다. [1회 턴 동안 공격 불가]\n",target.getName());
	}
}
