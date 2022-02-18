package com.ian.handesignpattern.principle.ocp.impove;

public class Ocp {
	
	public static void main(String[] args) {
		//使用看看存在的問題
		GraphicEditor graphicEditor = new GraphicEditor();
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
		graphicEditor.drawShape(new OtherGraphic());
	}

}

//這是一個用於繪製的類
class GraphicEditor{
	//接收Shape對象, 調用draw方法
	public void drawShape(Shape s) {
		s.draw();
	}
}

//Shape類, 基類
abstract class Shape{
	int m_type;
	public abstract void draw();
}

class Rectangle extends Shape {
	Rectangle(){
		super.m_type = 1;
	}

	@Override
	public void draw() {
		System.out.println(" 繪製矩形 ");
	}
}

class Circle extends Shape{
	Circle(){
		super.m_type = 2;
	}
	
	@Override
	public void draw() {
		System.out.println(" 繪製圓形 ");
	}
}

//新增畫三角形
class Triangle extends Shape{
	Triangle(){
		super.m_type = 3;
	}
	
	@Override
	public void draw() {
		System.out.println(" 繪製三角形 ");
	}
}

//新增一個圖形
class OtherGraphic extends Shape{
	OtherGraphic(){
		super.m_type = 4;
	}
	
	@Override
	public void draw() {
		System.out.println(" 繪製其他圖形 ");
	}
}