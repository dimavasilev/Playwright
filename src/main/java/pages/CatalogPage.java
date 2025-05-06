package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class CatalogPage extends AbsBasePages<CatalogPage> {

  public CatalogPage(Page page) {
    super(page);
  }

  public CatalogPage checkBoxCategoryStatus(String name, boolean state) {
    Locator checkbox = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName(name));

    if (state){
      assertThat(checkbox).isChecked();
    } else {
      assertThat(checkbox).not().isChecked();
    }

    return this;
  }
}
