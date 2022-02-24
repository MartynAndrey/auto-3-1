package ru.netology.order;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderFormTest {

    @Test
    public void shouldSendOrderForm() {
        open("http://localhost:9999/");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Иван Петров");
        form.$("[data-test-id='phone'] input").setValue("+79991230000");
        form.$("[data-test-id='agreement']").click();
        form.$("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
