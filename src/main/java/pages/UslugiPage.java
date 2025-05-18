package pages;

import annotations.Path;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Path("/uslugi-kompaniyam")
public class UslugiPage extends AbsBasePages<UslugiPage> {

  public UslugiPage(Page page) {

    super(page);
  }

  public UslugiPage checkThatTheTilesAreDisplayed(String name) {;

    // Найти первый элемент h2 на странице c загаловком
    Locator h2 = page.locator("h2").getByText(name);
    h2.waitFor();
    assertTrue(h2.isVisible());
    return this;
  }


  public void dragAndDropTeachers() {

    // Локаторы элементов
    Locator draggable = page.locator("#draggable");
    Locator droppable = page.locator("#droppable");

    // Прокручиваем страницу вниз, чтобы droppable элемент был не виден
    page.evaluate("window.scrollBy(0, 500)");

    // Небольшая пауза для наглядности (в реальных тестах лучше использовать waitFor)
    page.waitForTimeout(1000);

    // Выполняем drag and drop с автоматической прокруткой
    draggable.dragTo(droppable, new Locator.DragToOptions()
        .setSourcePosition(10, 10)  // точка захвата на draggable
        .setTargetPosition(10, 10)  // точка сброса на droppable
        .setForce(true));           // принудительное выполнение

    // Проверяем результат
    Assertions.assertEquals("Dropped!", droppable.textContent());
  }
}
