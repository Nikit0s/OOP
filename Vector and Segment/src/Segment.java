
public class Segment {
	private AbstractVector start;
	private AbstractVector end;
	public Segment(AbstractVector a, AbstractVector b)
	{
		start = a;
		end = b;
	}
	public AbstractVector getStart()
	{
		return start;
	}
	public AbstractVector getEnd()
	{
		return end;
	}
	public double len(){
		AbstractVector result = end.sub(start);
        return result.len();
    }
	public double distanceTo(AbstractVector point)
	{
		AbstractVector v = end.sub(start);
		AbstractVector w = point.sub(start);
		double sc1 = w.scalar(v);
		double sc2 = v.scalar(v);
		if (sc1 <= 0)
		{
			return w.len();
		}
		if (sc2 <= sc1)
		{
			Segment seg = new Segment(point, end);
			return seg.len();
		}
		double b = sc1 / sc2;
		AbstractVector pb = start.add(v.multiply(b));
		Segment seg = new Segment(point, pb);
		return seg.len();
	}
}
