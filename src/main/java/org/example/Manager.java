package org.example;


import java.util.Objects;

public class Manager extends Employee {


        public Manager(String name, String midName, String surName, String phone, String position, int salary, int birth, Genders gender) {
            super(name, midName, surName, phone, position, salary,birth, gender );
        }

    public static void increaser(Employee[] emp, int increment) {
        for (int i = 0; i < emp.length; i++) {
             if (!(emp[i] instanceof Manager)){
               emp[i].increaseSalary(increment);
            }
        }

//        static void increaser(Employee[] emp) {
//             for (int i = 0; i < emp.length; i++) {
//                 if (!Objects.equals(emp[i].position, "Менеджер")) {
//                     emp[i].increaseSalary(5000);
//                     }
//                 }
             }
 }


