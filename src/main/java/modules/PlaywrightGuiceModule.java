package modules;

import com.google.inject.*;
import com.microsoft.playwright.*;
import pages.CatalogPage;
import pages.CoursesPage;
import pages.SpecializationPage;
import pages.MainPage;
import pages.UslugiPage;

public class PlaywrightGuiceModule extends AbstractModule {
  private Page page;

  public PlaywrightGuiceModule(Page page) {
    this.page = page;
  }

  @Provides
  public Page getPage() {
    return this.page;
  }


  @Provides
  public MainPage getMainPage() {
    return new MainPage(this.page);
  }

  @Provides
  public CatalogPage getCatalogPage() {
    return new CatalogPage(this.page);
  }

  @Provides
  public SpecializationPage getMLspecialization() {
    return new SpecializationPage(this.page);
  }

  @Provides
  public UslugiPage  getUslugiPage() {return new UslugiPage(this.page);
  }

  @Provides
  public CoursesPage getCoursesPage() {return new CoursesPage(this.page);}
}
