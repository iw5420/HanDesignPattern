package com.ian.handesignpattern.principle.inversion;

public class DependencyInversion {

	public static void main(String[] args) {
		Person person = new Person();
		person.reveive(new Email());
	}

}

class Email{
	public String getInfo() {
		return "電子郵件信息: hello,world";
	}
}

//完成Person接收消息功能
//方式1分析
//1. 簡單, 比較容易想到
//2. 如果我們獲取的對象是微信, 短信等等, 則新增類, 同時Persons也要增加相對應的接收方法
//3. 解決思路: 引入一個抽象介面IReceiver, 表示接收者, 這樣Person類與介面IReceiver發生依賴
//   因為Email, 微信 等等屬於接收的範圍, 由他們各自實現IReceiver介面, 這樣我們就符合依賴倒轉原則
class Person{
	public void reveive(Email email) {
		System.out.println(email.getInfo());
	}
}
