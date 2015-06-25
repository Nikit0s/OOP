package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class ComplexValue extends AbstractValue {
	private final double real;
	private final double image;
	
	public ComplexValue(double real, double image) {
		super();
		this.real = real;
		this.image = image;
	}

	public String toString() {
		String sign = "";
		if (image > 0.001)
		{
			sign = "+";
		}
		if (image == 0.0)
		{
			String result = Double.toString(real);
			return result;
		}
		else
		{
			String result = Double.toString(real) + sign + Double.toString(image) + "i";
			return result;
		}
	}

	public AbstractValue add(AbstractValue operand) {
		double res_real = 0;
		double res_image = 0;
		double op_real = ((ComplexValue) operand).real;
		double op_image = ((ComplexValue) operand).image;
		res_real = real + op_real;
		res_image = image + op_image;
		return new ComplexValue(res_real, res_image);
	}

	public AbstractValue sub(AbstractValue operand) {
		double res_real = real;
		double res_image = image;
		double op_real = ((ComplexValue) operand).real;
		double op_image = ((ComplexValue) operand).image;
		res_real -= op_real;
		res_image -= + op_image;
		return new ComplexValue(res_real, res_image);
	}

	public AbstractValue mul(AbstractValue operand) {
		double res_real = 0;
		double res_image = 0;
		double op_real = ((ComplexValue) operand).real;
		double op_image = ((ComplexValue) operand).image;
		res_real += real * op_real - image * op_image;
		res_image += real * op_image + image * op_real;
		return new ComplexValue(res_real, res_image);
	}

	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException {
		if ((((ComplexValue) operand).real == 0) & ((ComplexValue) operand).image == 0)
			throw new DivisionByZeroException();
		double res_real = 0;
		double res_image = 0;
		double op_real = ((ComplexValue) operand).real;
		double op_image = ((ComplexValue) operand).image;
		res_real += (real * op_real + image * op_image) / (Math.pow(op_real, 2) + (Math.pow(op_image, 2)));
		res_image += (op_real * image - op_image * real) / (Math.pow(op_real, 2) + (Math.pow(op_image, 2)));
		return new ComplexValue(res_real, res_image);
	}

}
