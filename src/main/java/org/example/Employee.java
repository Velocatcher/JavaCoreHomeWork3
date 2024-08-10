package org.example;

import java.util.Comparator;

public class Employee {
    private static final int CURRENT_YEAR = 2024;
    String name;
    String midName;
    String surName;
    String position;
    String phone;
    int salary;
    static int birth;
    static int bMonth;
    static int bDay;

    public Employee(String name, String midName, String surName, String phone, String position, int salary
            , int birth) {
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getMidName() {
        return midName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return CURRENT_YEAR - birth;
}

    @Override
    public String toString() {
         return "Employee{" +
                 "name='" + name + '\'' +
                 ", midName='" + midName + '\'' +
                 ", surName='" + surName + '\'' +
                 ", position='" + position + '\'' +
                 ", phone='" + phone + '\'' +
                 ", salary=" + salary +
                 ", age=" + getAge() +
                 '}';
         }


    /**
     * returns
     * negative integer if this object birthdate is less (earlier), than given (older)
     * positive integer if this object birthdate is more (later), than given (younger)
     * zero if this object is the same as given
     * */

    public static int compare(int dd, int mm, int yyyy) {
         //day = 0..30, 31 is binary 11111, ok to left shift month by 6
         //month = 0..11, 15 is binary 1111, ok to left shift year by 5 more
         int empl = bDay + (bMonth << 6) + (birth << 11);
         int income = dd + (mm << 6) + (yyyy << 11);
         return empl - income;
         }



    public void increaseSalary(int amount){
        this.salary += amount;
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("Иван", "Иванович", "Иванов", "+79189998877", "Сантехник"
                , 100000, 1980);
        Employee emp2 = new Employee("Петр", "Петрович", "Сидоров", "+79189998866", "Инженер"
                , 150000, 1990);
        Employee manager = new Manager("Арнольд", "Адольфович", "Шварцнегеров", "+791899988555", "Менеджер"
                , 250000, 1890);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(manager);
        Employee[] company = new Employee[]{emp1, emp2, manager};


        Manager.increaser(company, 10000);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(manager);
        System.out.println();
        System.out.println(compare(24,8,1967));


    }

}




