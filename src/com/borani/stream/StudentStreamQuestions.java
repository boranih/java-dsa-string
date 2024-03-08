package com.borani.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StudentStreamQuestions {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
//        System.out.println("Student start with first name with A -> " + findTheListOfStudentStartWithA(list));
//        System.out.println("Group The Student By Department Names -> " + groupByDepartmentName(list));
//        System.out.println("Count -> " + totalCountOfTheStudent(list));
//        System.out.println("Max Age of the student -> " + maxAgeOfTheStudent(list));
//        System.out.println("List Of all Departments -> " + findAllDepartmentsName(list));
//        System.out.println("Find the count of student in each department -> " + countStudentInEachDepartment(list));
//        System.out.println("Avg age of the student -> " + avgAgeOfMaleAndFemaleStudent(list));
//        System.out.println("Find the department with maximum no of student -> " + findTheDepartmentWithMaxStudent(list));
//        System.out.println("Find the sorted students who lives in Delhi -> " + findTheStudentLiveInDelhiAndSortDesc(list));
//        System.out.println("Avg rank in each department -> " + avgRankInEachDepartment(list));
//        System.out.println("Highest rank in each department -> " + highestRankInEachDepartment(list));
        System.out.println("Student With Sorted with Rank -> " + sortedStudentWithRank(list));
        System.out.println("Student With Sorted with Rank -> " + findNthRank(list,2));
    }

    public static List<Student> findTheListOfStudentStartWithA(List<Student> studentList) {
        return studentList.stream()
                .filter(s -> s.getFirstName().startsWith("A"))
                .collect(toList());
    }

    public static Map<String, List<Student>> groupByDepartmentName(List<Student> studentList) {
        return studentList.stream()
                .collect(groupingBy(Student::getDepartmantName));
    }

    public static long totalCountOfTheStudent(List<Student> studentList) {
        return studentList.size();
    }

    public static int maxAgeOfTheStudent(List<Student> studentList) {
        return studentList.stream()
                .mapToInt(Student::getAge)
                .max()
                .stream().findFirst().orElse(0);
    }

    public static Set<String> findAllDepartmentsName(List<Student> studentList) {
        // return studentList.stream().map(st -> st.getDepartmantName()).distinct().collect(Collectors.toList());
        return studentList.stream()
                .map(Student::getDepartmantName)
                .collect(toSet());
    }

    public static Map<String, Long> countStudentInEachDepartment(List<Student> studentList) {
        return studentList.stream()
                .collect(groupingBy(Student::getDepartmantName, counting()));
        // return null;
    }

    public static Map<String, Double> avgAgeOfMaleAndFemaleStudent(List<Student> studentList) {
        return studentList.stream()
                .collect(groupingBy(Student::getGender, averagingInt(Student::getAge)));
    }

    public static String findTheDepartmentWithMaxStudent(List<Student> studentList) {
        return studentList.stream()
                .collect(groupingBy(Student::getDepartmantName, counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public static List<String> findTheStudentLiveInDelhiAndSortDesc(List<Student> studentList) {
        Predicate<Student> CITY_PREDICATE = student -> student.getCity().equals("Karnataka");
        List<String> delhi = studentList.stream()
                .filter(CITY_PREDICATE)
                .sorted(Comparator.comparing(Student::getFirstName))
                .map(Student::getFirstName)
                .collect(toList());
        return delhi;
    }

    public static Map<String, Double> avgRankInEachDepartment(List<Student> studentList) {
        return studentList.stream()
                .collect(groupingBy(Student::getDepartmantName, averagingDouble(Student::getRank)));
    }

    public static Map<String, Optional<Student>> highestRankInEachDepartment(List<Student> studentList) {
        return studentList.stream()
                .collect(groupingBy(Student::getDepartmantName, minBy(Comparator.comparing(Student::getRank))));
    }

    public static Map<String, Integer> sortedStudentWithRank(List<Student> studentList) {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .collect(toList())
                .stream()
                .collect(Collectors.toMap(st -> st.getFirstName() + " " + st.getLastName(), Student::getRank, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public static Student findNthRank(List<Student> studentList, int rank) {
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .skip(rank-1)
                .findFirst()
                .get();
    }
}