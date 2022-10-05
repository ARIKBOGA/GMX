package task_1.com.gmx.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task_1.com.gmx.utilities.Driver;

@Getter
public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-item-name='logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//li/a[@title='My Account']")
    private WebElement myAccountLink;
}
