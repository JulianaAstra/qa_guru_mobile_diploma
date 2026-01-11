package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;
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
            String result = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            String cleanedResult = result.replaceAll("[^A-Za-z0-9+/=]", "");

            System.out.println("========================================");
            System.out.println("RAW RESPONSE ANALYSIS:");
            System.out.println("========================================");
            System.out.println("Total length: " + result.length());

            // Проверим первые 20 символов в деталях
            System.out.println("First 20 characters with codes:");
            for (int i = 0; i < Math.min(20, result.length()); i++) {
                char c = result.charAt(i);
                System.out.printf("  [%d] '%c' (code: %d, hex: %02x)%n",
                        i, c, (int)c, (int)c);
            }

            // Проверим последние 20 символов
            System.out.println("Last 20 characters:");
            int start = Math.max(0, result.length() - 20);
            for (int i = start; i < result.length(); i++) {
                char c = result.charAt(i);
                System.out.printf("  [%d] '%c' (code: %d)%n", i, c, (int)c);
            }

            // Проверим, есть ли не-base64 символы
            String invalidChars = findInvalidBase64Chars(result);
            if (!invalidChars.isEmpty()) {
                System.out.println("INVALID BASE64 CHARACTERS FOUND:");
                System.out.println(invalidChars);

                // Покажем контекст вокруг невалидных символов
                showInvalidCharsContext(result);
            }

            System.out.println("========================================");

            // Пробуем декодировать
            return java.util.Base64.getDecoder().decode(result);

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR DECODING BASE64: " + e.getMessage());
            return new byte[0];
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
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
