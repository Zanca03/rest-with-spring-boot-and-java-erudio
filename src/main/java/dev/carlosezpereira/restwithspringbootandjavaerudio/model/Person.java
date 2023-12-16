package dev.carlosezpereira.restwithspringbootandjavaerudio.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity //Declara que é uma classe relacionada a uma tabela no DB
@Table(name = "person") //Define o nome da tabela no DB ao qual a classe irá representar
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id //Define como primary key da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false,length = 80) //Define a tabela que irá representar.
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 80)
    private String lastName;
    @Column(nullable = false,length = 100)//Caso não seja definido o "name", assume-se que o nome da tabela é o mesmo do atributo
    private String address;
    @Column(nullable = false,length = 6)
    private String gender;

    public Person(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(id, person.id)) return false;
        if (!Objects.equals(firstName, person.firstName)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        if (!Objects.equals(address, person.address)) return false;
        return Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
