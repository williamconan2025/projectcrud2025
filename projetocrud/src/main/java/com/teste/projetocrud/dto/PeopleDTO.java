package com.teste.projetocrud.dto;

import com.teste.projetocrud.model.PeopleModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PeopleDTO {

    @NotBlank
    @Size(max = 45)
    private String name;
    private String age;
    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotBlank
    @Size(max = 15)
    private String state;
    @NotBlank
    @Size(max = 40)
    private String city;
    @NotBlank
    @Size(max = 25)
    private String neighborhood;
    @NotBlank
    @Size(max = 100)
    private String address;
    @NotBlank
    @Size(max = 11)
    private String phone;
    private Integer score;

    public PeopleDTO(){

    }

    public PeopleDTO(String name, String age, String cep, String state, String city, String neighborhood, String address, String phone, Integer score) {
        this.name = name;
        this.age = age;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.address = address;
        this.phone = phone;
        this.score = score;
    }

    public PeopleDTO(PeopleModel peopleModel) {
        name = peopleModel.getName();
        age = peopleModel.getAge();
        cep = peopleModel.getCep();
        state = peopleModel.getState();
        city= peopleModel.getCity();
        neighborhood = peopleModel.getNeighborhood();
        address = peopleModel.getAddress();
        phone = peopleModel.getPhone();
        score = peopleModel.getScore();
    }

    public @NotBlank @Size(max = 45) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 45) String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public @NotBlank @Size(max = 8) String getCep() {
        return cep;
    }

    public void setCep(@NotBlank @Size(max = 8) String cep) {
        this.cep = cep;
    }

    public @NotBlank @Size(max = 15) String getState() {
        return state;
    }

    public void setState(@NotBlank @Size(max = 15) String state) {
        this.state = state;
    }

    public @NotBlank @Size(max = 40) String getCity() {
        return city;
    }

    public void setCity(@NotBlank @Size(max = 40) String city) {
        this.city = city;
    }

    public @NotBlank @Size(max = 25) String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(@NotBlank @Size(max = 25) String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public @NotBlank @Size(max = 100) String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank @Size(max = 100) String address) {
        this.address = address;
    }

    public @NotBlank @Size(max = 11) String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank @Size(max = 11) String phone) {
        this.phone = phone;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
