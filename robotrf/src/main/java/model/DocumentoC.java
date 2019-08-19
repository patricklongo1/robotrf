package model;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoC extends Navegador { // Classe referente á execução do doc C
	public static WebDriver paginaDocCaberta;
	
	
	public static void inicioDocC() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		WebDriver paginaDocC = abrirNavegador("http://www5.trf5.jus.br/rpvprecatorio/");  
		WebDriverWait wait = new WebDriverWait(paginaDocC, 30);
		try {
			criarDiretorio();
			paginaDocCaberta = paginaDocC;
			paginaDocC.findElement(By.id("num_prec_rpv")).sendKeys("122386");
			paginaDocC.findElement(By.name("Pesquisar")).click();
			controlarNovaAba(paginaDocC, paginaDocC.getWindowHandle());
			paginaDocC.findElement(By.cssSelector(".linkar")).click();
			controlarNovaAba(paginaDocC, paginaDocC.getWindowHandle());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > table:nth-child(7)")));
			tirarPrint(paginaDocC, "RPV"); //Primeiro print tirado
			segundaTelaDocC(paginaDocC, wait);
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!"); 
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! RPV - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocC(paginaDocCaberta, wait);
			}else if (tn == 2){
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				fecharNavegador();
				inicioDocC();
			}
		}
	}
	
	public static void segundaTelaDocC(WebDriver paginaDocC, WebDriverWait wait) {
		
		try {
		fecharAbas(paginaDocC);
		paginaDocC.get("http://www5.trf5.jus.br/rpvprecatorio/");
		paginaDocC.findElement(By.id("num_prec_rpv")).sendKeys("122386");
		paginaDocC.findElement(By.id("radioPrec")).click();
		paginaDocC.findElement(By.name("Pesquisar")).click();
		controlarNovaAba(paginaDocC, paginaDocC.getWindowHandle());
		paginaDocC.findElement(By.cssSelector(".linkar")).click();
		controlarNovaAba(paginaDocC, paginaDocC.getWindowHandle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#component-content > div")));
		tirarPrint(paginaDocC, "PRECATORIO"); //Segundo print tirado
		terceiraTelaDocC(paginaDocC, wait);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PRECATORIO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocC(paginaDocCaberta, wait);
			}else if (tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTelaDocC(paginaDocCaberta, wait);
			}
		}
	}
	
	public static void terceiraTelaDocC(WebDriver paginaDocC, WebDriverWait wait) {
		try {
			paginaDocC.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
			fecharAbas(paginaDocC);
			paginaDocC.get("http://www5.trf5.jus.br/rpvprecatorio/");
			paginaDocC.findElement(By.id("ui-id-3")).click();
			paginaDocC.findElement(By.id("NumProc")).sendKeys("0011308-81.2003.4.05.8300");
			paginaDocC.findElement(By.id("formNumProc")).findElement(By.cssSelector(".Pesquisar")).click();
			controlarNovaAba(paginaDocC, paginaDocC.getWindowHandle());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
			tirarPrint(paginaDocC, "CONS_PROC"); //Terceiro print tirado
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CONS_PROC - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocC(paginaDocCaberta, wait);
			}
		}
	}
}

