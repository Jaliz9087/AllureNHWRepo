import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.withText;



public class SimpleTest {
    @Test
    public void simpleGHTest(){
        //SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("Jaliz9087/AllureNHWRepo");
        $("#query-builder-test").submit();

        $(By.linkText("Jaliz9087/AllureNHWRepo")).click();
        $("#issues-tab").click();
        $(withText("ForTestIssue")).should(Condition.exist);
    }
}
