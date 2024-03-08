package com.borani.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CompanyStreamQuestions {

    public static void main(String[] args) {
        List<Company> cList = generateDummyCompanies();
        //System.out.println(cityWiseListOfCompanies(cList));
        printCityName(cList);
    }

    private static List<Company> generateDummyCompanies() {
        List<Company> companies = new ArrayList<>();
        // Generating dummy data for 10 companies
        for (int i = 1; i <= 10; i++) {
            String companyName = "Company " + i;
            Address companyAddress = new Address("Street " + i, new City("City " + i, new State("State " + i)));
            List<Person> employees = generateDummyEmployees(i);
            companies.add(new Company(companyName, companyAddress, employees));
        }
        return companies;
    }

    private static List<Person> generateDummyEmployees(int companyId) {
        List<Person> employees = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Long id = (long) (companyId * 100 + i);
            String name = "Employee " + i;
            employees.add(new Person(id, name));
        }
        return employees;
    }

    public static List<String> getCityNameFromCompaniesAddress(List<Company> cList) {
        return cList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                .collect(toList());
    }

    public static List<String> getCityNameWithNullChecks(List<Company> cList) {
        return cList.stream()
                .map(Company::getAddress)
                .filter(Objects::nonNull)
                .map(Address::getCity)
                .filter(Objects::nonNull)
                .map(City::getName)
                .filter(Objects::nonNull)
                .collect(toList());
    }

    public static List<String> getPersonListForAllCompanies(List<Company> cList) {
        return cList.stream()
                .map(Company::getPersonList)
                .flatMap(List::stream)
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<Company>> cityWiseListOfCompanies(List<Company> cList) {
        return cList.stream()
                .collect(Collectors.groupingBy(c -> c.getAddress().getCity().getName()));
    }

    public static boolean companyInSomeCity(List<Company> cList, String cityName) {
        return cList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .anyMatch(cityName::equals);
    }

    public static boolean noComanyInCity(List<Company> cList, String cityName) {
        return cList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .noneMatch(cityName::equals);
    }

    public static List<String> printCityName(List<Company> cList) {
        return cList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                .peek(city -> System.out.println("city name :" + city))
                .collect(Collectors.toList());
    }

    public static List<String> uniqueCityName(List<Company> cList) {
        return cList.stream()
                .map(Company::getAddress)
                .map(Address::getCity)
                .map(City::getName)
                .distinct()
                .toList();
    }
}
