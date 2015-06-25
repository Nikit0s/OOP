package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.datatypes.complex.ComplexValue;
import calculator.datatypes.complex.ComplexValueParser;

public class ComplexTest {

	@Test
	public void testAdd() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkAdd("-3.0i", "1.0+2.0i", "1.0-1.0i");
		checkAdd("1.0-3.0i", "1.0+2.0i", "2.0-1.0i");
	}
	@Test
	public void testSub() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkSub("-3.0i", "1.0+2.0i", "-1.0-5.0i");
	}
	@Test
	public void testMul() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkMul("1.0+2.0i", "1.0+2.0i", "-3.0+4.0i");
	}
	@Test
	public void testDiv() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkDiv("2.0+2.0i", "1.0+1.0i", "2.0");
	}
	private void checkAdd(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		ComplexValueParser P = new ComplexValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		ComplexValue sum = (ComplexValue) f_op.add(s_op);
		assertTrue("Error in add()", res.equals(sum.toString()));
	}
	private void checkSub(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		ComplexValueParser P = new ComplexValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		ComplexValue sum = (ComplexValue) f_op.sub(s_op);
		assertTrue("Error in add()", res.equals(sum.toString()));
	}
	private void checkMul(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		ComplexValueParser P = new ComplexValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		ComplexValue sum = (ComplexValue) f_op.mul(s_op);
		assertTrue("Error in add()", res.equals(sum.toString()));
	}
	private void checkDiv(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		ComplexValueParser P = new ComplexValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		ComplexValue sum = (ComplexValue) f_op.div(s_op);
		assertTrue("Error in add()", res.equals(sum.toString()));
	}
}
