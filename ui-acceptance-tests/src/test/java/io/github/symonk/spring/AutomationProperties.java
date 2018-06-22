package io.github.symonk.spring;

import io.github.symonk.helpers.localisation.LanguageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

public class AutomationProperties {

  @Autowired private Environment environment;

  public String getBaseEnvironmentUrl() {
    return environment.getProperty("application.baseurl");
  }

  public String getSlackApiToken() {
    return environment.getProperty("slack.api.token").toUpperCase();
  }

  public boolean getRunOnSeleniumGrid() {
    return Boolean.valueOf(environment.getProperty("use.selenium.grid"));
  }

  public String getBrowser() {
    return environment.getProperty("browser").toUpperCase();
  }

  public String getSeleniumGridEndpoint() {
    return environment.getProperty("selenium.grid.endpoint");
  }

  public String getPlatform() {
    return environment.getProperty("platform").toUpperCase();
  }

  public LanguageType getLanguage() {
    return LanguageType.valueOf(environment.getProperty("language").toUpperCase());
  }

  public int getExplicitWaitTimeout() {
    return Integer.valueOf(environment.getProperty("explicit.wait.timeout.seconds"));
  }

  public Map<String, String> getAllPropertiesAsStrings() {
    return new HashMap<String, String>() {
      {
        put("application.baseurl", getBaseEnvironmentUrl());
        put("slack.api.token", getSlackApiToken());
        put("use.selenium.grid", String.valueOf(getRunOnSeleniumGrid()));
        put("selenium.grid.endpoint", getSeleniumGridEndpoint());
        put("platform", getPlatform());
        put("explicit.wait.timeout", String.valueOf(getExplicitWaitTimeout()));
      }
    };
  }

}
