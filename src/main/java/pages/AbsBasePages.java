package pages;

import annotations.Path;
import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public abstract class AbsBasePages<T> {

  protected Page page;
  private String  baseUrl =  System.getProperty("base.url");


  private String  getPath() {
    Class clazz = this.getClass();
    if(clazz.isAnnotationPresent(Path.class)) {
      Path path =  (Path) clazz.getAnnotation(Path.class);
      return path.value();
    }
    return "";
  }

  public AbsBasePages(Page page) {
    this.page = page;
  }

  public T open() {
    page.navigate(baseUrl + getPath());

    return (T) this;
  }

  public T checkPageUrl(String[] queryParams) {

    String params = String.join("&", queryParams);
    assertThat(page)
        .hasTitle(params);

    return (T)this;
  }
}
