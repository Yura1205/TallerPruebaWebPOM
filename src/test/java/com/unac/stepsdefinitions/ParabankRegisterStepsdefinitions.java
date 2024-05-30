package com.unac.stepsdefinitions;

import com.unac.pages.ServicesPage;
import com.unac.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParabankRegisterStepsdefinitions {

    RegisterPage registerPage;
    ServicesPage servicesPage;

    @Given("Deseo abrir la pagina parabank {string}")
    public void deseo_abrir_la_pagina_parabank(String url) {
        registerPage.navegateTo(url);
    }
    @When("ingreso el First Name {string} y el Last Name {string}")
    public void ingreso_el_first_name_y_el_last_name(String firstName, String lastName) {
        registerPage.registerNames(firstName, lastName);
    }
    @When("ingreso el Address {string} y la City {string}")
    public void ingreso_el_address_y_la_city(String address, String city) {
        registerPage.registerCity(address, city);
    }
    @When("ingreso el State {string} y el Zip Code {string}")
    public void ingreso_el_state_y_el_zip_code(String state, String zipCode) {
        registerPage.registerState(state, zipCode);
    }
    @When("ingreso Phone {string} y el SSN {string}")
    public void ingreso_phone_y_el_ssn(String phone, String ssn) {
        registerPage.registerNums(phone, ssn);
    }
    @When("ingreso el Username {string} y el password {string} y valido")
    public void ingreso_el_username_y_el_password_y_valido(String userName, String password) {
        registerPage.registerUsernames(userName, password);
    }
    @When("Selecciono Open New Account y type of Account Savings")
    public void selecciono_open_new_account_y_type_of_account() {
        servicesPage.selectSavings();
    }

    @Then("valido que el numero de cuenta exista")
    public void valido_que_el_titulo_sea() {
        servicesPage.validateAccount();
    }
}
