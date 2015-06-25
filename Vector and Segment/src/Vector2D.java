public final class Vector2D implements AbstractVector
{
	private final double x;
    private final double y;
    double getX()
    {
    	return x;
    }
    double getY()
    {
    	return y;
    }
    public Vector2D(double a, double b){
        x = a;
        y = b;
    }
    public AbstractVector add(AbstractVector other){
    	Vector2D vect = ((Vector2D)other);
        Vector2D result = new Vector2D(vect.x + x, vect.y + y);
        return result;
    }
    public AbstractVector sub(AbstractVector other){
    	Vector2D vect = ((Vector2D)other);
        Vector2D result = new Vector2D(x - vect.x, y - vect.y);
        return result;
    }
    public AbstractVector multiply(double alpha){
        Vector2D result = new Vector2D(x * alpha, y * alpha);
        return result;
    }
    public double scalar(AbstractVector other){
        double result = 0;
        Vector2D vect = ((Vector2D)other);
        result += x*vect.x + y*vect.y;
        return result;
    }
    public double len(){
        double result = Math.sqrt(x * x + y * y);
        return result;
    }
}