package units;

import controller.Unit;

public class UnitOrc extends Unit {
	public UnitOrc() {
		setName("오크");
	}

	@Override
	public void skill(Unit target) {
		System.out.println("한명에게 2배의 데미지 + 기절");
		// TODO Auto-generated method stub

	}
}
