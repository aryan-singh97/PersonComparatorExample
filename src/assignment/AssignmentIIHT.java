package assignment;

import java.util.Scanner;

public class AssignmentIIHT {


        public static void main(String[] args) {

            java.util.ArrayList <Person>list = new java.util.ArrayList<>();

            Scanner sc = new Scanner(System.in);
            System.out.println("Add more items to the list (y/n) ?");
            char response = sc.nextLine().charAt(0);

            while(response == 'y'){

                System.out.println("Enter the following");
                System.out.println("Full Name (First Name + Last Name): ");

                String fullName = sc.nextLine();
                System.out.println("City: ");
                String city = sc.nextLine();
                System.out.println("Age: ");
                int age = sc.nextInt();
                list.add(new Person(fullName,city,age));

                System.out.println("Add more items to the list (y/n) ?");
                response = sc.next().charAt(0);
                sc.nextLine();
            }

            System.out.println("Okay, how would you like to sort the list ?");
            System.out.println("Enter '1' for By Age,\n '2' By City, \n '3' By FirstName,\n '4' By LastName]");
            int sortingResponse = sc.nextInt();

            switch(sortingResponse)
            {
                case 1:
                    java.util.Collections.sort(list, new SortByAge());
                case 2:
                    java.util.Collections.sort(list, new SortByCity());
                case 3:
                    java.util.Collections.sort(list, new SortByFirstName());
                case 4:
                    java.util.Collections.sort(list, new SortByLastName());
                default:
                    java.util.Collections.sort(list, new SortByAge());
            }


            System.out.println("After Sorting list: ");

            for(Person person : list){
                System.out.println(person);
            }


        }
    }


    class Person {
        String name, city;
        int age;

        Person(String name, String city, int age){
            this.name = name;
            this.city = city;
            this.age = age;
        }

        String getName(){
            return this.name;
        }

        String getFirstName(){
            String firstName = this.name.substring(0, this.name.indexOf(' '));
            return firstName;
        }

        String getLastName(){
            String lastName = this.name.substring(this.name.indexOf(' ') + 1);
            return lastName;
        }

        String getCity(){
            return this.city;
        }

        Integer getAge(){
            return this.age;
        }


        @Override
        public String toString(){
            return "Person : "  + this.getName() + ", " + this.getCity() + ", " + this.getAge();
        }
    }

    // Separate class for sorting using : Comparator
    class SortByFirstName implements java.util.Comparator<Person>{
        @Override
        public int compare(Person first, Person second){
            return first.getFirstName().compareTo(second.getFirstName());
        }
    }

    class SortByLastName implements java.util.Comparator<Person>{
        @Override
        public int compare(Person first, Person second){
            return first.getLastName().compareTo(second.getLastName());
        }
    }


    class SortByAge implements java.util.Comparator<Person>{
        @Override
        public int compare(Person first, Person second){
            return first.getAge().compareTo(second.getAge());
        }
    }

    class SortByCity implements java.util.Comparator<Person>{
        @Override
        public int compare(Person first, Person second){
            return first.getCity().compareTo(second.getCity());
        }
    }
