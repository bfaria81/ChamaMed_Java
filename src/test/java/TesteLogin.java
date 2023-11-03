import ChamadasLeitos.chamadas.ChamadasApplication;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootTest
//@CucumberOptions(
//        feature = "/Users/brunofaria/Desktop/Pasta Sem Título/Chamadas/src/test/resources/features",
//        glue = "ChamadasLeitos/chamadas/ChamadasApplication.java"
//)


public class TesteLogin {

    private WebDriver driver;
    private ConfigurableApplicationContext context;


    @Dado("que estou na tela de login")
    public void queEstouNaTelaDeLogin() {
        context = SpringApplication.run(ChamadasApplication.class);
        driver = new SafariDriver();
        System.setProperty("webdriver.safari.driver", "/System/Cryptexes/App/usr/bin/safaridriver");
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }



    @E("digito no campo matrícula o número {string}")
    public void digitoNoCampoMatrículaONúmero() {
        context = SpringApplication.run(ChamadasApplication.class);
        driver = new SafariDriver();
        System.setProperty("webdriver.safari.driver", "/System/Cryptexes/App/usr/bin/safaridriver");
        WebElement matriculaInput = driver.findElement(By.xpath("//*[@id=\"matricula\"]"));
        matriculaInput.sendKeys("12");
//        driver.manage().window().maximize();
    }

    @E("digito no campo senha a senha {string}")
    public void digitoNoCampoSenhaASenha() {
        context = SpringApplication.run(ChamadasApplication.class);
        WebElement senhaInput = driver.findElement(By.xpath("//*[@id=\"senha\"]"));
        senhaInput.sendKeys("12");
//        driver.manage().window().maximize();

    }

    @Quando("clico no botão login")
    public void clicoNoBotãoLogin() {
        context = SpringApplication.run(ChamadasApplication.class);
        driver.findElement(By.id("login")).click();
//        driver.manage().window().maximize();
    }

    @Então("eu entro na aplicação")
    public void euEntroNaAplicação() {
        context = SpringApplication.run(ChamadasApplication.class);
        driver.get("http://localhost:8080/home/");
        driver.manage().window().maximize();
    }

    @E("digito no campo matrícula o nome {string}")
    public void digitoNoCampoMatrículaONome(String arg0) {
    }

    @Então("a mensagem erro é exibida")
    public void aMensagemErroÉExibida() {
    }
}
