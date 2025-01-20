import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.withText;
import static io.qameta.allure.Allure.step;


public class SimpleTest extends TestBase {
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
    @Test
    public void lambdaTest(){
        step("Open main page", () ->{
            open("https://github.com");
        });
        step("Search our repository" +" "+ REPOSITORY, () ->{
            $(".search-input").click();
            $("#query-builder-test").sendKeys("Jaliz9087/AllureNHWRepo");
            $("#query-builder-test").submit();
        });
        step("Found our repo", () ->{
            $(By.linkText("Jaliz9087/AllureNHWRepo")).click();
            $("#issues-tab").click();
        });
        step("Checking the header"+" " + TITLE, () ->{
            $(withText("ForTestIssue")).should(Condition.exist);
        });

    }
}

