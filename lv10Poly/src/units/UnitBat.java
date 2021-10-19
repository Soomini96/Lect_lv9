package units;

import controller.Unit;

public class UnitBat extends Unit {
	public UnitBat() {
		setName("박쥐");
	}

	@Override
	public void skill() {
		System.out.println("적 한명에게 침묵 시전.");
	}
}
