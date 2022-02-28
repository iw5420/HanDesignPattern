package com.ian.handesignpattern.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

//客戶端
public class Demeter1 {
	public static void main(String[] args) {
		System.out.println("~~~使用迪米特法則的改進~~~");
		//創建了一個SchoolManager 對象
		SchoolManager schoolManager = new SchoolManager();
		//輸出學校的員工id 和學校總部的員工信息
		schoolManager.printAllEmployee(new CollegeManager());
	}
}

//學校總部員工
class Employee{
	private String id;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
}

//學院的員工類
class CollegeEmployee{
	private String id;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}

//管理學院員工的管理類
class CollegeManager{
	//返回學院的所有員工
	public List<CollegeEmployee> getAllEmployee(){
		List<CollegeEmployee>list = new ArrayList<CollegeEmployee>();
		for(int i = 0; i<10; i++) { //這裡我們增加了10個員工到list
			CollegeEmployee emp = new CollegeEmployee();
			emp.setId("學校員工id =" + i);
			list.add(emp);
		}
		return list;
	}
	
	//輸出學校員工的信息
	public void printEmployee() {
	
		List<CollegeEmployee> list1 = this.getAllEmployee();
		System.out.println("--------學院員工--------");
		for(CollegeEmployee e : list1) {
			System.out.println(e.getId());
		}
	}
}

//學院管理類

//分析SchoolManager 類的直接朋友類有哪些 Emloyee, CollegeManager
//CokkegeEmploee 不是直接朋友 而是一個陌生類, 這樣違背了迪米特法則
class SchoolManager{
	
	//分析問題
	//1. 將輸出學院的員工的方法封裝到CollegeManager(你怎麼做的我不在乎, 你封裝到自己的類別自己做)
	//<=>你在別人的類裡面完成自己的方法, 是沒有意義的
	
	//返回學校總部的員工
	public List<Employee> getAllEmployee(){
		List<Employee>list = new ArrayList<Employee>();
		for(int i = 0; i<5; i++) { //這裡我們增加了5個員工到list
			Employee emp = new Employee();
			emp.setId("學校總部員工id =" + i);
			list.add(emp);
		}
		return list;
	}
	//該方法完成輸出學校總部和學校員工信息(id)
	void printAllEmployee(CollegeManager sub) {
		
		sub.printEmployee();
		
		//獲取到學校總部員工
		List<Employee> list2 = this.getAllEmployee();
		System.out.println("--------學校總部員工--------");
		for(Employee e : list2) {
			System.out.println(e.getId());
		}
		
	}
}
