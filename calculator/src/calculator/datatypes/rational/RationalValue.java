package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class RationalValue extends AbstractValue {
	private final int chisl;
	private final int znam;
	
	public RationalValue(int chisl, int znam) {
		super();
		if ((chisl < 0) & (znam < 0))
		{
			chisl = -chisl;
			znam = -znam;
		}
		if ((chisl > 0) & (znam < 0))
		{
			chisl = -chisl;
			znam = -znam;
		}
		int min = Math.abs(znam);
		if (Math.abs(chisl) < Math.abs(znam))
		{
			min = Math.abs(chisl);
		}
		int i = 2;
		while (i <= min)
		{
			if (chisl % i == 0 && znam % i == 0)
			{
				chisl /= i;
				znam /= i;
				min /= i;
			}
			else
			{
				i++;
			}
		}
		this.chisl = chisl;
		this.znam = znam;
	}

	public String toString() {
		String result = Integer.toString(chisl) + "/" + Integer.toString(znam);
		return result;
	}

	public AbstractValue add(AbstractValue operand) {
		int res_chisl = 0;
		int res_znam = znam;
		int op_chisl = ((RationalValue) operand).chisl;
		int op_znam = ((RationalValue) operand).znam;
		while ((res_znam % op_znam) != 0)
		{
			res_znam += znam;
		}
		res_chisl = (res_znam / znam) * chisl + (res_znam / op_znam) * op_chisl;
		return new RationalValue(res_chisl, res_znam);
	}

	public AbstractValue sub(AbstractValue operand) {
		int res_chisl = 0;
		int res_znam = znam;
		int op_chisl = ((RationalValue) operand).chisl;
		int op_znam = ((RationalValue) operand).znam;
		while ((res_znam % op_znam) != 0)
		{
			res_znam += znam;
		}
		res_chisl = (res_znam / znam) * chisl - (res_znam / op_znam) * op_chisl;
		return new RationalValue(res_chisl, res_znam);
	}

	public AbstractValue mul(AbstractValue operand) {
		int res_chisl = chisl * ((RationalValue) operand).chisl;
		int res_znam = znam * ((RationalValue) operand).znam;
		return new RationalValue(res_chisl, res_znam);
	}

	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException {
		if (((RationalValue) operand).znam == 0)
			throw new DivisionByZeroException();
		RationalValue new_operand = new RationalValue(((RationalValue) operand).znam, ((RationalValue) operand).chisl);
		return mul(new_operand);
	}

}
