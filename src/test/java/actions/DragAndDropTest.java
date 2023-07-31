package actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    //Task 2
    @Test
    void dragAndDropOnHeroku() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement sourceEl = $("#column-a");
        SelenideElement targetEl = $("#column-b");

        //These commented two ways below of 'drag and drop' from actions() don't work
        //actions().clickAndHold(sourceEl).moveToElement(targetEl).release().build().perform();
        //actions().dragAndDrop(sourceEl, targetEl);

        //This way of 'drag and drop' works
        sourceEl.dragAndDropTo(targetEl);

        //Verify that rectangles changed their places
        $(sourceEl).$("header").shouldHave(Condition.exactText("B"));
        $(targetEl).$("header").shouldHave(Condition.exactText("A"));
    }
}
