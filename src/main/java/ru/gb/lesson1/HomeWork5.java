package ru.gb.lesson1;

public class HomeWork5 {
    public static void main(String[] args){
        Employee[] emplArr = new Employee[5];   // 4. массив из 5 сотрудников
        emplArr[0] = new Employee("John","owner","john@company.com",1234567,2000,45);
        emplArr[1] = new Employee("Peter","analyst","peter@company.com",7654321,1000,50);
        emplArr[2] = new Employee("David","developer","david@company.com",1357913,1500,30);
        emplArr[3] = new Employee("Mike","coach","mike@company.com",2468246,1800,35);
        emplArr[4] = new Employee("Marie","tester","marie@company.com",8642086,800,25);

        ageOver40(emplArr);
    }

    public static void ageOver40(Employee[] staff){    // 5. вывод информации
        System.out.println("Employees over 40: ");
        for (int i=0; i<staff.length; i++){
            if (staff[i].getAge() > 40) {
                staff[i].info();
            }
        }
    }


}
