
public class Test {
	public static void main(String[] args)
	{
		Vector vect1 = new Vector(3, 4, 0);
		Vector vect2 = new Vector(3, 8, 0);
		Vector2D vect3 = new Vector2D(0, 0);
		Vector2D vect4 = new Vector2D(0, 10);
		Vector2D point = new Vector2D(-3, -4);
		AbstractVector avect1 = vect1;
		AbstractVector avect2 = vect2;
		AbstractVector avect3 = vect3;
		AbstractVector avect4 = vect4;
		Segment segm = new Segment(avect1, avect2);
		Segment segm1 = new Segment(avect3, avect4);
		System.out.println(segm1.distanceTo(point));
	}
}
