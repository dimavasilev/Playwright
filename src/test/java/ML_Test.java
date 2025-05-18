import com.microsoft.playwright.*;
import extensions.UIExtensions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.SpecializationPage;

@ExtendWith(UIExtensions.class)
public class ML_Test {

  @Inject
  private Page page;
  @Inject
  private SpecializationPage specialization;


@Test
public void check() {
  specialization
      .open()
      .scrollTo("Преподаватели")
      .checkThatTheTilesAreDisplayed("Преподаватели")
      //.dragAndDropTeachers();
      .pushButton();
}
}
