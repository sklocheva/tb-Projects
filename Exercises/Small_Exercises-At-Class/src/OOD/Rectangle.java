package OOD;

public final class Rectangle implements Shape {

//	protected int _h;
//	protected int _w;
//	public void SetHeight(int h){
//		_h=h;
//	}
//	
//	public void SetWidth(int w){
//		_w=w;
//	}
	
	private final int _h, _w;
	
	public Rectangle(int h, int w){
		this._h=h;
		this._w=w;
	}
	@Override
	public double Area(){ 
		return _w*_h;
	}
	
}
