package io.github.symonk.runvalidation;

import io.github.symonk.spring.AutomationProperties;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestExecutionListener {

    @Autowired private AutomationProperties properties;

    private static final String FILE_EXISTS = "environment.properties file already exists, deleting it";
    private static final String IO_DUPLICATE_FILES = "IO exception occurred when checking for duplicate files";

    public void checkEnvironmentIsOnline() {
        log.info("checking the specified test environment is reachable");
        log.info("Endpoint: " + properties.getBaseEnvironmentUrl());

    }


    public void pushReportEnvironmentDataToDirectory() {
        prepareReportEnvironmentVars();
    }

    private void prepareReportEnvironmentVars() {
            log.info("pushing environment content to the reporting directory");
            final Properties props = new Properties();
            properties.getAllPropertiesAsStrings().forEach(props::setProperty);

            FileOutputStream fos = null;
            try {
                Path pathToFile = Paths.get("target\\allure-results\\environment.properties");
                if (!removeFileIfExists(pathToFile)) {
                    Files.createDirectories(pathToFile.getParent());
                }
                Files.createFile(pathToFile);
                fos = new FileOutputStream(pathToFile.toString());
                props.store(fos, "Philips Reporting Properties");
            } catch (IOException exception) {
                abortTheTestRun("IO exception occurred when trying to include the environment report properties");
            } finally {
                try {
                    Objects.requireNonNull(fos).close();
                } catch (Exception exception) {
                    log.error("Failed to close output stream", exception);
                }
            }
        }

    private boolean removeFileIfExists(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                log.info(FILE_EXISTS);
                Files.delete(filePath);
                return true;
            }
        } catch (IOException exception) {
            log.error(IO_DUPLICATE_FILES, exception);
        }
        return false;
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException exception) {
            log.error("thread was interrupted...", exception);
        }
    }

    private void abortTheTestRun(String message) {
        log.info("Aborting the test run because the arguments passed at runtime do not create valid test conditions");
        throw new InvalidArgumentException(message);
    }

}
