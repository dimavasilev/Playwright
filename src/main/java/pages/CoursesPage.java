package pages;

import annotations.Path;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Path("/catalog/courses?duration=3-10")
public class CoursesPage extends AbsBasePages<CoursesPage> {

  public CoursesPage(Page page) {

    super(page);
  }

  public CoursesPage checkThatTheTilesAreDisplayed(String name) {;

    // Найти первый элемент h2 на странице c загаловком
    Locator h2 = page.locator("h2").getByText(name);
    h2.waitFor();
    assertTrue(h2.isVisible());
    return this;
  }
}
