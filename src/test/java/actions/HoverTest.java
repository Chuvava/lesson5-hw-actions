package actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    //Task 1
    @Test
    void openEnterpriseByHoveringSolutions() {

        open("https://github.com/");
        $(".header-menu-wrapper").$(Selectors.byText("Solutions")).hover();
        $(Selectors.byText("Enterprise")).click();
        $(".eyebrow-banner").sibling(0).shouldHave(Condition.text("GitHub for enterprises"));
        $(".eyebrow-banner").sibling(1).shouldHave(Condition.text("Build like the best"));
    }
}
