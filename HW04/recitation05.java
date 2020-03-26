public class recitation05 {
	/*

	**null
	//special value that redefernce tyoe can have
	ex: String, Scanner
	String str = null;
	Scanner sc = null;

	//Primitive type can not point to null
	ex: int x = null does not compile!!!

	//....Using reference type: .equals to check if the two things are equal
	BUT if you are checking null: use ==
	*/

	/*
	**Static variable
	- belongs to the class itself not a specific object
	- can be access from both instance methods and static methods
	
	ex: public class Foo {
		static int counter = 4;
		}

		main(){
		System.out.println(Foo.counter())  //Valid
		Foo object = new Foo();
		object.counter();  //Valid
		}

	- All counstant should be static and final in Java
	- Static variables are useful for constants
	public class Human{
		private static final int x = 9;
	}

	*/

	/*
	**Copy Constructor:
	
	1. What do you mean:
		Car is a reference.
		-> reference is like an arrow that point to the reference memory

	2. 
	//Shallow copy
	public class Car{
		private String[] upgrades;
		private String model;

		public Car(Car c) {
			this.upgrade = c.upgrades;
			this.model = c.model;
		}
	}

	3. Types of copies:
	a) Shallow copy:
		- The new object is pointing to the original one
		- The two object have the same property
		!! Problem: a change to the original copy you change the both object (Since they are pointing to the same position)
		!! Copy the reference only

	b) Deep copy(the good reference):
		- extracting information rather than pointing object(saving reference)
		- If you change the one, it will not affect the other one
		- it is like making a clone of the original thing. 
		  You are not pointing to the priginal thing. You are pointing to the clone. 
		  So if the original thing changes, you will not be affected. 



	*/

	/*
	**Wrapper classes:
	Most primitive have a wrapper class:
	ex: Integer, Double, Character

	ex autoboxing:
	int val = 42;
	Integer intObj = val; //boxing
	int val2 intObj; //unboxing

	*/  

	/*

	***Class Design
	>>Core method in Java
	1. String toSting() method
		a) NEED! to be in class
		b) allow us to print objects' data without getting the memory reference
		c) if trying to print an object without using toString() -> Car@2g34jhgj
		d) public String toString{
			return "Model " + this.model + "\nYear: " + this.year + "\nColor: " + this.color;
		}

	2. equals() method

	3. All instance variables should be private:
		Do not want anyone to change the value

	4. 


	*/
}

//Static method example
ex:
public class Dog{
	public String name;
	public static int numDogs;
	private static numCat;//can appear in instance method
	public Dog(){
		numDogs++;
		numCat++;
	}

	public static int getNmDogs(){
		return numDogs;
	}

	/* 
	Make no sence since you are accessing instance data
	public static int tosting(){
		this.name;

	}*/



//???????????It will be on the slide
//Shallow copy/ deep copy example:

public static void main(String[] args) {
	//Shallow copy: assigning(pointint) to the new thing
	public shallowmeth(){
		this.model = other.model;
		this.year = other.year;
	}

	//Deep copy: print out the value to a new thing
	this.upgrades = new String[c.upgrades.length]; //creating a new array
	for (int i = 0; i < this.upgrades.length; i++) {
		this.upgrade[i] = c.upgrade[i];
	}
}


















public String method(){
	return "Hi";
}

public void method1(){
	System.out.println("Hi");
}