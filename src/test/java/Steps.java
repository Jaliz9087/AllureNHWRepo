import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {


    @Step ("Open main page")
    public void openMainPage (){
        open("https://github.com");
    }
    @Step("Search our repository")
    public void searchOurRepository(){
        
        $(".search-input").click();
        $("#query-builder-test").sendKeys("Jaliz9087/AllureNHWRepo");
        $("#query-builder-test").submit();
    }
    @Step("Found our repo")
    public void foundOurRepo(){
        $(By.linkText("Jaliz9087/AllureNHWRepo")).click();
        $("#issues-tab").click();
    }
    @Step("Cheking header" )
    public void checkingHeader(){
            $(withText("ForTestIssue")).should(Condition.exist);
        }
}
