package pages;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class CatalogPage extends AbsBasePages<CatalogPage> {

  public CatalogPage(Page page) {
    super(page);
  }

  public CatalogPage checkBoxCategoryStatus(String name, boolean state) {
    Locator checkbox = page.locator("div", new Page.LocatorOptions()
        .setHas(page.locator("input[type='checkbox']")
            .and(page.locator("label", new Page.LocatorOptions().setHasText(name)))));

    if (state){
      assertThat(checkbox).isChecked();
    } else {
      assertThat(checkbox).not().isChecked();
    }

    return this;
  }
}
