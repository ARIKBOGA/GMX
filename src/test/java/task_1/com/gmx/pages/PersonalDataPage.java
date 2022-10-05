package task_1.com.gmx.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task_1.com.gmx.utilities.Driver;

@Getter
public class PersonalDataPage {

    public PersonalDataPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='links-menu__link'])[1]")
    private WebElement profileInfoLink;

    @FindBy(xpath = "//label[text()='First name (s)']/..//input")
    private WebElement firstnameInput;

    @FindBy(xpath = "//label[text()='Last name']/..//input")
    private WebElement lastnameInput;

    @FindBy(xpath = "//label[text()='Password']/..//input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Changes')]")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//ul/li[1]//a")
    private WebElement myAccountPageLink;

}
