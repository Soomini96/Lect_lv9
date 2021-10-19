package units;

import controller.Unit;

public class UnitWolf extends Unit {
	public UnitWolf() {
		setName("늑대");
	}

	@Override
	public void skill(Unit target) {
		System.out.println("적 전체에게 공격력의 절반 데미지");
		// TODO Auto-generated method stub

	}
}
