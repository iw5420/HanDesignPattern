package com.ian.handesignpattern.principle.inversion.improve;

public class DependencyPass {

	public static void main(String[] args) {
		
		ChangHong changHong = new ChangHong();

		//ex1
		OpenAndClose openAndClose = new OpenAndClose();
		openAndClose.open(changHong);
		
//		//ex2
//		OpenAndClose openAndClose = new OpenAndClose(changHong);
//		openAndClose.open();
		
//		//ex3
//		OpenAndClose openAndClose = new OpenAndClose();
//		openAndClose.setTv(changHong);
//		openAndClose.open();
	}
}

//實例:
class ChangHong implements ITV{

	@Override
	public void play() {
		System.out.println("長虹電視機, 打開");		
	}
	
}

//方式1: 通過介面傳遞依賴
//開關的介面
interface IOpenAndClose{
	public void open(ITV tv); //抽象方法, 接收介面
}

interface ITV{
	public void play();
}
//實現介面
class OpenAndClose implements IOpenAndClose{
		public void open(ITV tv) {
			tv.play();
		}
}

////方式2: 通過構造方法依賴傳遞
//interface IOpenAndClose{
//	public void open(); //抽象方法
//}
//
//interface ITV{ //ITV介面
//	public void play();
//}
//
//class OpenAndClose implements IOpenAndClose{
//	public ITV tv; //成員
//	public OpenAndClose(ITV tv) { //構造器
//		this.tv = tv;
//	}
//	
//	public void open() {
//		this.tv.play();
//	}
//}

////方法3, 透過setter方法傳遞
//interface IOpenAndClose{
//	public void open(); // 抽象方法
//	public void setTv(ITV tv);
//}
//
//interface ITV{// ITV 介面
//	public void play();
//}
//
//class OpenAndClose implements IOpenAndClose{
//	private ITV tv;
//	
//	public void setTv(ITV tv) {
//		this.tv = tv;
//	}
//	
//	public void open() {
//		this.tv.play();
//	}
//	
//}