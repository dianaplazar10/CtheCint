package com.hashmaps;

import java.util.HashMap;

/*
 * This class compares the purpose of implemeneting Hashcode and Equals method to a object.
 * 
 * All the Wrapper classes do have the Hashcode and Equals method implemenetation. 
 * This enables to restrict a duplication of values when these elements are added to a collection.
 * The same applies even to HashMap, if the keys are of Wrapper classes type, such as Integer/String, etc.
 * 
 * However, if we implement a custom type as Key, and if the customer Type 
 * does not implement Hashcode and Equals method, then . the map will allow adding duplicates of the same type.
 */

public class DemoHashcodeEqualsForHashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> wrapperKeyMap = new HashMap<Integer,String>();
		wrapperKeyMap.put(1, "one");
		wrapperKeyMap.put(1, "one");
		System.out.println("Size of map with Integer key :::::: " + wrapperKeyMap.size());
		
		
		HashMap<Student, String> noHashEqElementMap = new HashMap<Student,String>();
		Student student1 = new Student(1);
		Student student2 = new Student(2); // student created with same Id. Note that Hashcode is validated baswd on ID for Student_withImpl
		noHashEqElementMap.put(student1, "Student1");
		noHashEqElementMap.put(student2, "Student1");
		System.out.println("Size of map where Element key WITHOUT HashEquals methodImpl :::::: " + noHashEqElementMap.size());
		

		HashMap<Student_withImpl, String> withHashEqElementMap = new HashMap<Student_withImpl,String>();
		Student_withImpl studentWith1 = new Student_withImpl(1);
		Student_withImpl studentWith2 = new Student_withImpl(1); // student created with same Id. Note that Hashcode is validated only based on ID for Student_withImpl
		withHashEqElementMap.put(studentWith1, "Student2");
		withHashEqElementMap.put(studentWith2, "Student1");
		System.out.println("Size of map where Element key WITH HashEquals methodImpl :::::: " + withHashEqElementMap.size());

	}

}

/*
 * Output:
 * 
Size of map with Integer key :::::: 1
Size of map where Element key WITHOUT HashEquals methodImpl :::::: 2
Size of map where Element key WITH HashEquals methodImpl :::::: 1
 */



class Student{
	private int id;
	public Student(int id) {
		this.id = id;
	}
}

class Student_withImpl{
	private int id;
	public Student_withImpl(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student_withImpl other = (Student_withImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
}