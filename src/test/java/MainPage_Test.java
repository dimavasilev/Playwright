import com.microsoft.playwright.*;
import extensions.UIExtensions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class MainPage_Test {

  @Inject
  private Page page;
  @Inject
  private MainPage mainPage;

@Test
public void check() {
  mainPage
      .open()
      .clickCourseCategory("Управление")
      .checkPageUrl(new String[]{"categories=marketing-business"})
      .checkBoxCategoryStatus("Управление", true);
}
}
