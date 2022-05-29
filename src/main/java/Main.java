import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    /* Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
     Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
      Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
     Sve elemente koji se koriste smestiti u intuitivno imenovane promenljive.
     Kod na git, screen recording puštanja i izvršavanja testa na Drive.*/
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\GIT project\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.stealmylogin.com/demo.html");
            WebElement inputUsername = driver.findElement(By.xpath("/html/body/form/input[1]"));
            inputUsername.sendKeys("Anabanana");
            Thread.sleep(2000);
            WebElement inputPassword = driver.findElement(By.xpath("/html/body/form/input[2]"));
            inputPassword.sendKeys("Ninamandarina");
            Thread.sleep(2000);
            WebElement btnLogin = driver.findElement(By.xpath("/html/body/form/input[3]"));
            btnLogin.click();
            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://example.com/")) {
                System.out.println("Nice");
            } else {
                System.out.println("Not nice");
            }
            driver.close();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
