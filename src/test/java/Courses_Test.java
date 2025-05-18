import com.microsoft.playwright.*;
import extensions.UIExtensions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.CoursesPage;
import pages.UslugiPage;

@ExtendWith(UIExtensions.class)
public class Courses_Test {

  @Inject
  private Page page;
  @Inject
  private CoursesPage coursesPage;


  @Test
  public void check() {
    coursesPage
        .open();
  }
}
