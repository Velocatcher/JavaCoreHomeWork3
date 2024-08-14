package org.example;

import java.util.Comparator;

import static org.example.PartySelector.getPartyForToday;

public class Employee {
    private static final int CURRENT_YEAR = 2024;
    String name;
    String midName;
    String surName;
    String position;
    String phone;
    int salary;
    int birth;
    int bMonth;
    int bDay;

    enum Genders{MALE, FEMALE};
         Genders gender;


    public Employee(String name, String midName, String surName, String phone, String position, int salary
            , int birth, Genders gender) {
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birth = birth;
        this.gender = gender;
    }
    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
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
         return STR."Employee{name='\{name}\{'\''}, midName='\{midName}\{'\''}, surName='\{surName}\{'\''}, position='\{position}\{'\''}, phone='\{phone}\{'\''}, salary=\{salary}, age=\{getAge()}, gender=\{getGender()}\{'}'}";
         }


    /**
     * returns
     * negative integer if this object birthdate is less (earlier), than given (older)
     * positive integer if this object birthdate is more (later), than given (younger)
     * zero if this object is the same as given
     * */

    public  int compare(int dd, int mm, int yyyy) {
         //day = 0..30, 31 is binary 11111, ok to left shift month by 6
         //month = 0..11, 15 is binary 1111, ok to left shift year by 5 more
         int empl = bDay + (bMonth << 6) + (birth << 11);
         int income = dd + (mm << 6) + (yyyy << 11);
         return empl - income;
         }



    public void increaseSalary(int amount){
        this.salary += amount;
    }

//    enum Parties {NONE, NEW_YEAR, MARCH_8, FEB_23}

//    private static final PartySelector.Parties today = PartySelector.Parties.NONE;
//    private static  Parties today = Parties.MARCH_8;
    private static void celebrate(Employee[] emp) {

            PartySelector.Parties today = getPartyForToday();

        for (int i = 0; i < emp.length; i++) {
            switch (today) {
                case NEW_YEAR:
                    System.out.println(emp[i].name + ", happy New Year!");
                    break;
                case FEB_23:
                    if (emp[i].gender == Employee.Genders.MALE)
                        System.out.println(emp[i].name + ", happy February 23rd!");
                    break;
                case MARCH_8:
                    if (emp[i].gender == Employee.Genders.FEMALE)
                        System.out.println(emp[i].name + ", happy march 8th!");
                    break;
                default:
                    System.out.println(emp[i].name + ", celebrate this morning!");
            }
        }
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("Иван", "Иванович", "Иванов", "+79189998877", "Сантехник"
                , 100000, 1980, Genders.MALE);
        Employee emp2 = new Employee("Маша", "Петрович", "Сидорова", "+79189998866", "Инженер"
                , 150000, 1990, Genders.FEMALE);
        Employee manager = new Manager("Арнольд", "Адольфович", "Шварцнегеров", "+791899988555", "Менеджер"
                , 250000, 1890, Genders.MALE);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(manager);
        Employee[] company = new Employee[]{emp1, emp2, manager};


        Manager.increaser(company, 10000);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(manager);
        System.out.println();
//        System.out.println(compare(24,8,1967));
        celebrate(company);

    }

}




