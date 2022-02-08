package com.ian.handesignpattern.principle.inversion.improve;

public class DependencyInversion {

	public static void main(String[] args) {
		//客戶端無需改變
		Person person = new Person();
		person.reveive(new Email());
		person.reveive(new WeiXin());
	}

}

//定義介面
interface IReceiver{
	public String getInfo();
}

class Email implements IReceiver{
	public String getInfo() {
		return "電子郵件信息: hello, world";
	}
}

//增加微信
class WeiXin implements IReceiver{
	public String getInfo() {
		return "微信信息: hello, ok";
	}
}

//方式2
class Person{
	//這裡我們是對介面的依賴
	public void reveive(IReceiver receiver) {
		System.out.println(receiver.getInfo());
	}
}
