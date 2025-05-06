package extensions;

import com.google.inject.*;
import com.microsoft.playwright.*;
import modules.PlaywrightGuiceModule;
import org.junit.jupiter.api.extension.*;

import java.nio.file.*;

public class UIExtensions implements BeforeEachCallback, BeforeAllCallback, AfterAllCallback {

  private Playwright playwright;
  private BrowserContext browserContext;
  private Browser browser;
  private Page page;


  @Override
  public void beforeAll(ExtensionContext context) {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
  }

  @Override
  public void beforeEach(ExtensionContext context)  {
    browserContext = browser.newContext();
    page = browserContext.newPage();

    browser.startTracing(page, new Browser.StartTracingOptions().setPath(Path.of(System.getProperty("user.dir") + String.format("/$s_traces.zip", context.getTestInstance().get().getClass().getClass().getName()))));


    Guice.createInjector(new PlaywrightGuiceModule(page)).injectMembers(context.getTestInstance());
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    browser.stopTracing();
  }
}
