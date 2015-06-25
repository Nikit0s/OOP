package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.datatypes.rational.RationalValue;
import calculator.datatypes.rational.RationalValueParser;

public class RationalTest {

	@Test
	public void testAdd() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkAdd("1/2", "3/4", "5/4");
	}
	@Test
	public void testSub() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkSub("7/6", "3/6", "2/3");
	}
	@Test
	public void testMul() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkMul("3/-2", "2/3", "-1/1");
	}
	@Test
	public void testDiv() throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		checkDiv("3/2", "3/2", "1/1");
	}
	private void checkAdd(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		RationalValueParser P = new RationalValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		RationalValue sum = (RationalValue) f_op.add(s_op);
		assertTrue("Error in add()", res.equals(sum.toString()));
	}
	private void checkSub(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		RationalValueParser P = new RationalValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		RationalValue sub = (RationalValue) f_op.sub(s_op);
		assertTrue("Error in add()", res.equals(sub.toString()));
	}
	private void checkMul(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		RationalValueParser P = new RationalValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		RationalValue sub = (RationalValue) f_op.mul(s_op);
		assertTrue("Error in add()", res.equals(sub.toString()));
	}
	private void checkDiv(String first, String second, String res) throws ParseValueException, OperationNotSupportedException, DivisionByZeroException
	{
		RationalValueParser P = new RationalValueParser();
		AbstractValue f_op = P.parse(first);
		AbstractValue s_op = P.parse(second);
		RationalValue sub = (RationalValue) f_op.div(s_op);
		assertTrue("Error in add()", res.equals(sub.toString()));
	}

}
