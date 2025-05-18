package pages;

import annotations.Path;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Path("/lessons/ml-specialization/")
public class SpecializationPage extends AbsBasePages<SpecializationPage> {

  public SpecializationPage(Page page) {

    super(page);
  }

  public SpecializationPage checkThatTheTilesAreDisplayed(String name) {;

    // Найти первый элемент h2 на странице c загаловком
    Locator h2 = page.locator("h2").getByText(name);
    h2.waitFor();
    assertTrue(h2.isVisible());
    return this;
  }

public SpecializationPage  scrollTo(String name) {
  Locator element = page.locator(String.format( "xpath=//h2[text()='Преподаватели']", name));
  element.scrollIntoViewIfNeeded();
  return this;
}

  public void dragAndDropTeachers() {

    // Локаторы элементов
    Locator draggable = page.locator("xpath=//div[contains(@class, 'swiper-slide-active')]").first();
    Locator droppable = page.locator("xpath=//div[contains(@class, 'swiper-slide-next')]").first();

    // Прокручиваем страницу вниз, чтобы droppable элемент был не виден
    page.evaluate("window.scrollBy(0, 500)");

    // Небольшая пауза для наглядности (в реальных тестах лучше использовать waitFor)
    page.waitForTimeout(1000);

    // Выполняем drag and drop с автоматической прокруткой
    draggable.dragTo(droppable, new Locator.DragToOptions()
        .setSourcePosition(10, 10)  // точка захвата на draggable
        .setTargetPosition(10, 10)  // точка сброса на droppable
        .setForce(true));           // принудительное выполнение

  }
  public void pushButton() {

    // Локаторы для кнопок и карточек
    Locator prevButton = page.locator("button.carousel-prev"); // Кнопка "<"
    Locator nextButton = page.locator("button.carousel-next"); // Кнопка ">"
    Locator cards = page.locator(".carousel-card"); // Все карточки

    // Проверяем начальное состояние
    assertTrue(cards.nth(0).isVisible(), "Первая карточка должна быть видима");

    // Переключаем на следующую карточку
    nextButton.click();

    // Ждем анимации переключения
    page.waitForTimeout(500); // Или лучше использовать waitForFunction

    // Проверяем, что вторая карточка стала видимой
    assertTrue(cards.nth(1).isVisible(), "Вторая карточка должна быть видима после клика");

    // Возвращаемся к предыдущей карточке
    prevButton.click();
    page.waitForTimeout(500);

    // Проверяем, что снова видна первая карточка
    assertTrue(cards.nth(0).isVisible(), "Первая карточка должна быть видима после возврата");
  }

}
