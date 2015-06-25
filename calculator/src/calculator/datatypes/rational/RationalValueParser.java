package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class RationalValueParser implements AbstractValueParser {

	public AbstractValue parse(String value) throws ParseValueException {
		try {
			String str_chisl = "";
			String str_znam = "";
			for(int i = 0; i < value.length(); i++)
			{
				if (value.charAt(i) != '/')
				{
					str_znam += value.charAt(i);
				}
				else
				{
					str_chisl = str_znam;
					str_znam = "";
				}
			}
			int chisl = Integer.parseInt(str_chisl);
			int znam = Integer.parseInt(str_znam);
			return new RationalValue(chisl, znam);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "рациональные числа";
	}



}