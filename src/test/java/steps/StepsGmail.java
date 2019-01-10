package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class StepsGmail {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	private void abrir() {

	}

	@Dado("^que estou na pagina \"([^\"]*)\"$")
	public void que_estou_na_pagina(String site) throws Throwable {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/filipe.jesus/Documents/Testes/scripts/jars/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(site);
		wait = new WebDriverWait(driver, 10);
	}

	@Quando("^eu informar \"([^\"]*)\" no campo \"([^\"]*)\" #name$")
	public void eu_informar_no_campo_name(String login, String name) throws Throwable {
		WebElement efEmail = driver.findElement(By.name(name));
		efEmail.sendKeys(login);
	}

	@Quando("^cliar no botão \"([^\"]*)\" #id$")
	public void cliarNoBotãoId(String id) throws Throwable {
		WebElement btnProsseguir = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
//		WebElement btnProsseguir = driver.findElement(By.id(id));
		btnProsseguir.click();
	}

	@Quando("^informar \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void informar_no_campo(String senha, String name) throws Throwable {
		WebElement efSenha = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
//		WebElement efSenha = driver.findElement(By.name(name));
		efSenha.click();
	}

	@Então("^deve logar no Gmail apresentando mensagem \"([^\"]*)\"$")
	public void deve_logar_no_Gmail_apresentando_mensagem(String id) throws Throwable {
		WebElement btnLogin = driver.findElement(By.id(id));
		btnLogin.click();
	}

	@After
	private void depois() {

	}

}
