package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoJ extends Navegador { // Classe referente á execução do doc J
	public static WebDriver paginaDocJaberta;
	public static void inicioDocJ() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocJ = Navegador.abrirNavegador("http://www5.trf5.jus.br/pautas_julgamento/");  
			WebDriverWait wait = new WebDriverWait(paginaDocJ, 30);																							
			criarDiretorio();
			paginaDocJaberta = paginaDocJ;
			paginaDocJ.findElement(By.cssSelector("#orgao")).click();
			paginaDocJ.findElement(By.cssSelector("#orgao > option:nth-child(2)")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#boletim")));
			paginaDocJ.findElement(By.cssSelector("#boletim")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#boletim > option:nth-child(2)")));
			paginaDocJ.findElement(By.cssSelector("#boletim > option:nth-child(2)")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#consultar")));
			paginaDocJ.findElement(By.cssSelector("#consultar")).click();
			tirarPrint(paginaDocJ, "PAUTA");
			//JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
			segundaTelaDocJ(paginaDocJ);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PAUTA - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocJ(paginaDocJaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				fecharNavegador();
				inicioDocJ();
			}
		}
	}
	
	public static void segundaTelaDocJ(WebDriver paginaDocJ) {
		try {
			WebDriverWait wait = new WebDriverWait(paginaDocJ, 30);
			paginaDocJ.get("http://www5.trf5.jus.br/documento/?tipo=dca");
			paginaDocJ.findElement(By.cssSelector(".anos > td:nth-child(1) > a:nth-child(1)")).click();
			paginaDocJ.findElement(By.cssSelector(".tdLinha > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(1)")).click();
			Navegador.controlarNovaAba(paginaDocJ, paginaDocJ.getCurrentUrl());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#plugin")));
			Thread.sleep(3000);
			tirarPrint(paginaDocJ, "DCA");
			terceiraTelaDocJ(paginaDocJ);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! DCA - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocJ(paginaDocJaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				segundaTelaDocJ(paginaDocJaberta);
			}
		}
	}

	public static void terceiraTelaDocJ(WebDriver paginaDocJ) {
		try {
			paginaDocJ.get("https://ead.trf5.jus.br/login/index.php");
			Navegador.tirarPrint(paginaDocJ, "EAD");
			Navegador.fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EAD - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocJ(paginaDocJaberta);
			}
		}
	}
}
