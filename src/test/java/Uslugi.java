import com.microsoft.playwright.*;
import extensions.UIExtensions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import pages.SpecializationPage;
import pages.UslugiPage;

@ExtendWith(UIExtensions.class)
public class Uslugi {

  @Inject
  private Page page;
  @Inject
  private UslugiPage uslugiPage;


  @Test
  public void check() {
    uslugiPage
        .open();
  }
}
