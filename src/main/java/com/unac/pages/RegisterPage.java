package com.unac.pages;

import com.unac.actions.Action;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://parabank.parasoft.com")

public class RegisterPage extends PageObject {
    By btnGoRegister = By.xpath("//a[text()='Register']");
    By firstName = By.name("customer.firstName");
    By lastName = By.name("customer.lastName");
    By address = By.name("customer.address.street");
    By city = By.name("customer.address.city");
    By state = By.name("customer.address.state");
    By zipCode = By.name("customer.address.zipCode");
    By phone = By.name("customer.phoneNumber");
    By ssn = By.name("customer.ssn");
    By username = By.name("customer.username");
    By password = By.name("customer.password");
    By confirmPassword = By.name("repeatedPassword");
    By btnRegister = By.xpath("//input[@type='submit' and @class='button' and @value='Register']");
    //By btnGoRegister = By.name("//a[text()='Register']");
    //By getUsername = By.xpath("//input[@name='uid']");
    // En chrome = //*[text()="algo"]

    public void navegateTo(String url){
        Action.navegateUrl(getDriver(),url);
        Action.clickElement(getDriver(), btnGoRegister);
    }
    public void registerNames(String strFirstName, String strLastName){
        Action.sendData(getDriver(),firstName, strFirstName);
        Action.sendData(getDriver(),lastName,strLastName);
    }
    public void registerCity(String strAddress, String strCity){
        Action.sendData(getDriver(),address, strAddress);
        Action.sendData(getDriver(),city,strCity);
    }
    public void registerState(String strState, String strZipCode){
        Action.sendData(getDriver(),state, strState);
        Action.sendData(getDriver(),zipCode,strZipCode);
    }
    public void registerNums(String strPhone, String strSsn){
        Action.sendData(getDriver(),phone, strPhone);
        Action.sendData(getDriver(),ssn,strSsn);
    }
    public void registerUsernames(String strUsername, String strPassword){
        Action.sendData(getDriver(),username, strUsername);
        Action.sendData(getDriver(),password,strPassword);
        Action.sendData(getDriver(),confirmPassword,strPassword);
        Action.clickElement(getDriver(), btnRegister);
    }


}
