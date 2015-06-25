package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser {

	public AbstractValue parse(String value) throws ParseValueException {
		try {
			String str_real = "";
			String str_image = "";
			boolean have_image = true;
			int start = 0;
			int end = value.length() - 1;
			if (value.charAt(end) != 'i')
			{
				have_image = false;
			}
			if (value.charAt(0) == '-')
			{
				start++;
			}
			if (!have_image)
			{
				str_real = value;
				str_image = "0";
			}
			else{
				for (int i = start; i < end; i++)
				{
					if ((value.charAt(i) != '+') & (value.charAt(i) != '-'))
					{
						str_image += value.charAt(i);
					}
					else
					{
						str_real = str_image;
						if (value.charAt(i) == '-')
						{
							str_image = "-";
						}
						else
						{
							str_image = "";
						}
					}
				}
			}
			if (start > 0 & (str_real.length() != 0))
			{
				str_real = "-" + str_real;
			}
			if (start > 0 & (str_real.length() == 0))
			{
				str_real = "0";
				str_image = "-" + str_image;
			}
			double real = Double.parseDouble(str_real);
			double image = Double.parseDouble(str_image);
			return new ComplexValue(real, image);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "комплексные числа";
	}



}
