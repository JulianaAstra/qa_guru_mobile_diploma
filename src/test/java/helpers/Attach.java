package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Attach {
//    @Attachment(value = "{attachName}", type = "image/png")
//    public static byte[] screenshotAs(String attachName) {
//        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        try {
            WebDriver driver = getWebDriver();

            // Вариант 1: Получаем как RAW объект для диагностики
            System.out.println("=== DEBUG: Getting screenshot ===");

            if (driver instanceof RemoteWebDriver) {
                RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;

                // Пробуем выполнить команду напрямую
                try {
                    // Получаем executor
                    CommandExecutor executor = remoteDriver.getCommandExecutor();

                    // Создаем команду для скриншота
                    Response response = executor.execute(
                            new Command(remoteDriver.getSessionId(), "screenshot", Collections.emptyMap())
                    );

                    Object value = response.getValue();
                    System.out.println("Response value class: " + (value != null ? value.getClass().getName() : "null"));
                    System.out.println("Response value toString: " + value);

                    // Проверяем, что это строка
                    if (value instanceof String) {
                        String strValue = (String) value;
                        System.out.println("String length: " + strValue.length());
                        System.out.println("First 500 chars: " +
                                (strValue.length() > 500 ? strValue.substring(0, 500) + "..." : strValue));

                        // Сохраняем в файл
                        try {
                            Files.write(Paths.get("browserstack-response.txt"),
                                    strValue.getBytes(StandardCharsets.UTF_8));
                            System.out.println("Saved response to browserstack-response.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error executing command: " + e.getMessage());
                    e.printStackTrace();
                }
            }

            // Вариант 2: Пробуем получить как bytes
            System.out.println("=== Trying to get screenshot as BYTES ===");
            try {
                byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                System.out.println("Success! Got " + bytes.length + " bytes");
                return bytes;
            } catch (Exception e) {
                System.out.println("Failed to get as BYTES: " + e.getMessage());
                e.printStackTrace();
            }

            return new byte[0];

        } catch (Exception e) {
            System.out.println("ERROR in screenshotAs: " + e.getMessage());
            return new byte[0];
        }
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + Browserstack.videoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }


    private static String findInvalidBase64Chars(String str) {
        // Base64 допустимые символы: A-Z, a-z, 0-9, +, /, =
        StringBuilder invalid = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isValidBase64Char(c)) {
                invalid.append(String.format("  Position %d: '%c' (code %d)%n", i, c, (int)c));
            }
        }
        return invalid.toString();
    }

    private static boolean isValidBase64Char(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9') ||
                c == '+' || c == '/' || c == '=' ||
                c == '\n' || c == '\r'; // иногда base64 может содержать переносы строк
    }

    private static void showInvalidCharsContext(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isValidBase64Char(c)) {
                int start = Math.max(0, i - 10);
                int end = Math.min(str.length(), i + 10);
                System.out.printf("Invalid char at position %d: '%c' (code %d)%n", i, c, (int)c);
                System.out.printf("Context: ...%s[%s]%s...%n",
                        str.substring(start, i),
                        str.charAt(i),
                        str.substring(i + 1, end));
            }
        }
    }
}
