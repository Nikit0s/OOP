
public final class Vector implements AbstractVector
{
	private final double x;
    private final double y;
    private final double z;
    double getX()
    {
    	return x;
    }
    double getY()
    {
    	return y;
    }
    double getZ()
    {
    	return z;
    }
    public Vector(double a, double b, double c){
        x = a;
        y = b;
        z = c;
    }
    public AbstractVector add(AbstractVector other){
    	Vector vect = ((Vector)other);
        Vector result = new Vector(vect.x + x, vect.y + y, vect.z + z);
        return result;
    }
    public AbstractVector sub(AbstractVector other){
    	Vector vect = ((Vector)other);
        Vector result = new Vector(x - vect.x, y - vect.y, z - vect.z);
        return result;
    }
    public AbstractVector multiply(double alpha){
        Vector result = new Vector(x * alpha, y * alpha, z * alpha);
        return result;
    }
    public double scalar(AbstractVector other){
        double result = 0;
        Vector vect = ((Vector)other);
        result += x*vect.x + y*vect.y + z*vect.z;
        return result;
    }
    public double len(){
        double result = Math.sqrt(x * x + y * y + z * z);
        return result;
    }
}
