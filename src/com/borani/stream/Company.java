package com.borani.stream;

import java.util.List;

public class Company {

    private String name;
    private Address address;
    private List<Person> personList;

    public Company(String companyName, Address companyAddress, List<Person> employees) {
        this.name = companyName;
        this.address = companyAddress;
        this.personList = employees;
    }

    public String getName() {
        return name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", personList=" + personList +
                '}';
    }
}

class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Address {
    private String street;
    private City city;

    public Address(String s, City city) {
        this.street = s;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city=" + city +
                '}';
    }
}

class City {
    private String name;
    private State state;

    public City(String s, State state) {
        this.name = s;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}

class State {
    private String name;

    public State(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
