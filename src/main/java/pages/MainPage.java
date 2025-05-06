package pages;

import annotations.Path;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import jakarta.inject.Inject;

@Path("/")
public class MainPage extends AbsBasePages<MainPage> {

  @Inject
  private CatalogPage catalogPage;

  public MainPage(Page page) {
    super(page);
  }

  public CatalogPage clickCourseCategory(String name) {
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(name)).click();
    return catalogPage;
  }
}