package com.unac.pages;

import com.unac.actions.Action;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ServicesPage extends PageObject {

    //<a href="openaccount.htm">Open New Account</a>
    By aOpenNewAccount = By.xpath("//a[text()='Open New Account']");
    By savings = By.xpath("//*[@id='type']/option[2]");

    //<input type="button" class="button" value="Open New Account">
    By btnOpenNewAccount = By.xpath("//input[@type='button' and @class='button' and @value='Open New Account']");
    //*[@id="openAccountForm"]/form/div/input

    By account = By.xpath("//*[@id=\"newAccountId\"]");
    String newAccount;
    By aAccountsOverview = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");

    By pathRelativeListAccount = By.xpath("//*[@id=\"accountTable\"]/tbody/tr");

    List<WebElement> listAccount;



    public void waitOneSecond() {
        try {
            Thread.sleep(1000); // wait for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void selectSavings(){
        Action.clickElement(getDriver(), aOpenNewAccount);
        Action.clickElement(getDriver(), savings);
        waitOneSecond();
        Action.clickElement(getDriver(), btnOpenNewAccount);
        waitOneSecond();
        newAccount = Action.getElementText(getDriver(),account);

    }
    String accountRef;
    public void validateAccount(){
        Action.clickElement(getDriver(),aAccountsOverview);
        listAccount =Action.getListElementText(getDriver(),pathRelativeListAccount);
        boolean accountFound = false;

        for (WebElement row : listAccount) {
            WebElement firstColumn = row.findElement(By.xpath("./td[1]/a"));
            String accountValue = firstColumn.getText();
            accountRef = accountValue;
            if (accountValue.equals(newAccount)) {
                accountFound = true;
                break;
            }
        }

        if (accountFound) {
            System.out.println("El valor " + newAccount + " está presente en la primera columna.");
            assertEquals("El valor esperado es: "+ newAccount + "es igual a "+accountRef, newAccount,accountRef);
        } else {
            System.out.println("El valor " + newAccount + " no está presente en la primera columna.");
            //assertNotEquals("El valor esperado es: " + newAccount + " y no debe ser igual a " + accountRef, newAccount, accountRef);
        }

    }
}
