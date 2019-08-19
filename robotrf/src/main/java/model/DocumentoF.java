package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoF extends Navegador{ // Classe referente á execução do doc F
	public static WebDriver paginaDocFaberta;
	public static void inicioDocF() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocF = Navegador.abrirNavegador("https://www4.trf5.jus.br/InteiroTeor/"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
			criarDiretorio();
			paginaDocFaberta = paginaDocF;
			paginaDocF.findElement(By.cssSelector(".form-text")).sendKeys("0011308-81.2003.4.05.8300");
			paginaDocF.findElement(By.cssSelector("input.form-button-p01:nth-child(5)")).click();
			paginaDocF.findElement(By.cssSelector("body > div:nth-child(2) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > a:nth-child(1)")).click();
			controlarNovaAba(paginaDocF, paginaDocF.getCurrentUrl());
			new WebDriverWait(paginaDocF, 20).until(ExpectedConditions.urlToBe("https://www4.trf5.jus.br/data/2005/03/200383000113087_20050315.pdf"));
			Thread.sleep(3000);
			tirarPrint(paginaDocF, "INTEIRO_TEOR");
			segundaTelaDocF(paginaDocF);
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! INTEIRO_TEOR - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocF(paginaDocFaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				fecharNavegador();
				inicioDocF();
			}
		}

	}
	
	public static void segundaTelaDocF(WebDriver paginaDocF) {
		try {
			WebDriverWait wait = new WebDriverWait(paginaDocF, 30);
			paginaDocF.get("https://www4.trf5.jus.br/InteiroTeor/");
			paginaDocF.findElement(By.cssSelector(".form-text")).sendKeys("0011308-81.2003.4.05.8300");
			paginaDocF.findElement(By.cssSelector("input.form-button-p01:nth-child(5)")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#wrapper > table:nth-child(4) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")));
			paginaDocF.findElement(By.cssSelector("#wrapper > table:nth-child(4) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")).click();
			controlarNovaAba(paginaDocF, paginaDocF.getCurrentUrl());
			new WebDriverWait(paginaDocF, 20).until(ExpectedConditions.urlToBe("https://www4.trf5.jus.br/data/2005/03/200383000113087_20050315.pdf"));
			Thread.sleep(3000);
			tirarPrint(paginaDocF, "EXTRACAO_ACORDAO");
			fecharAbas(paginaDocF);
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EXTRACAO_ACORDAO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTelaDocF(paginaDocFaberta);
			}
		}
	}

}
