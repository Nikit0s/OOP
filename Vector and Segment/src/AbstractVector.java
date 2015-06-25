
public interface AbstractVector {
	double scalar(AbstractVector v);
	double len();
	AbstractVector multiply(double factor);
	AbstractVector add(AbstractVector v);
	AbstractVector sub(AbstractVector v);
}
