package task_1.com.gmx.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task_1.com.gmx.utilities.Driver;

@Getter
public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='text'])[2]")
    private WebElement personalDataLink;

    @FindBy(tagName = "h1")
    private WebElement fullName;
}
