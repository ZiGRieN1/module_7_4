package com.example.module7_5;

import com.example.module7_5.tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachmentManager {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] screenshot() {
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
