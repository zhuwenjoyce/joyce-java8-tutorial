package com.joyce.java8.Demo9_PredicateFilter;

public class Employee {
    public Employee(Integer id, Integer age, String gender, String fName, String lName){
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    public Employee(){

	}

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    public Integer getId() {
		return id;
	}
	public Employee setId(Integer id) {
		this.id = id;
		return this;
	}
	public Integer getAge() {
		return age;
	}
	public Employee setAge(Integer age) {
		this.age = age;
		return this;
	}
	public String getGender() {
		return gender;
	}
	public Employee setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//To change body of generated methods, choose Tools | Templates.
    @Override
    public String toString() {
        return "id="+this.id.toString()+" - age="+this.age.toString();
    }
}
