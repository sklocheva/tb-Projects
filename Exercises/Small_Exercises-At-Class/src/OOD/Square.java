package OOD;

public class Square implements Shape {

	final private Shape s;
//	public void SetHeight(int h){
//		_h=_w=h;
//	}
//	
//	public void SetWidth(int w){
//		_h=_w=w;
//	}
	
	public Square(int size){
		this.s= new Rectangle(size, size);
	}
	@Override
	public double Area(){ 
		return 1.0;
	}
	
}
