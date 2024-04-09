package com.borani.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StudentStreamQuestions {

    static List<Student> list = List.of(
            new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122, List.of(
                    "computer", "board games")),
            new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67, List.of(
                    "computer", "guiter")),
            new Student(2, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164, List.of(
                    "shopping")),
            new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26, List.of(
                    "reading")),
            new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12, List.of(
                    "computer", "cooking")),
            new Student(5, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90,
                    List.of()),
            new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324, List.of(
                    "computer", "gym")),
            new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433, List.of(
                    "gym", "board games")),
            new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7, List.of(
                    "guiter", "board games")),
            new Student(9, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98,
                    List.of(
                            "dance")));

    public static void main(String[] args) {
        StudentStreamQuestions s = new StudentStreamQuestions();
        System.out.println(s.findStudentByIdIfExist(list, List.of(2,9,5)));
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
                .skip(rank - 1)
                .findFirst()
                .get();
    }

    public List<String> sortBasedOnTheName(List<Student> sList) {
        return sList.stream()
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.nullsFirst(String::compareTo)))
                .map(this::createFullName)
                .collect(Collectors.toList());
    }

    public Set<String> sortBasedOnTheName(Set<Student> sList) {
        return sList.stream()
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.nullsLast(String::compareTo)))
                .map(this::createFullName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private String createFullName(Student student) {
        return "%s %s".formatted(student.getFirstName(), student.getLastName());
    }

    public Long countStudentInterest(List<Student> sList, String interest) {
        return sList.stream()
                .map(Student::getInterest)
                .flatMap(Collection::stream)
                .filter(s -> s.equals(interest))
                .collect(Collectors.counting());
    }

    public Set<String> extractAllInterests(List<Student> sList) {
        return sList.stream()
                .map(Student::getInterest)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public List<Student> findStudentByIdIfExist(List<Student> sList, List<Integer> sIds) {
        return sIds.stream()
                .map(this::findById)
                .flatMap(Optional::stream)
                .toList();
    }

    private Optional<Student> findById(Integer id) {
        return list.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }
}