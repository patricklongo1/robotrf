package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoH extends Navegador{ // Classe referente á execução do doc H
	public static WebDriver paginaDocHaberta;
	public static void inicioDocH() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocH = Navegador.abrirNavegador("http://jef.trf5.jus.br/acompanhamentoProcessual/acompanhamentoProcessual.php");
			WebDriverWait wait = new WebDriverWait(paginaDocH, 30);
			criarDiretorio();
			paginaDocHaberta = paginaDocH;
			paginaDocH.findElement(By.cssSelector("#filtro")).sendKeys("0011308-81.2003.4.05.8300");
			paginaDocH.findElement(By.cssSelector("#submitConsulta")).click();
			controlarNovaAba(paginaDocH, paginaDocH.getCurrentUrl());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
			tirarPrint(paginaDocH, "CP_UNIFICADA_PROC");
			segundaTelaDocH(paginaDocH);
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CP_UNIFICADA_PROC - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocH(paginaDocHaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				fecharNavegador();
				inicioDocH();
			}
		}
	}
	
	public static void segundaTelaDocH(WebDriver paginaDocH) {
		try {
			WebDriverWait wait = new WebDriverWait(paginaDocH, 30);
			fecharAbas(paginaDocH);
			paginaDocH.get("http://jef.trf5.jus.br/acompanhamentoProcessual/acompanhamentoProcessual.php");
			Thread.sleep(3000);
			paginaDocH.findElement(By.cssSelector("#tipo_xmlnomparte")).click();
			paginaDocH.findElement(By.cssSelector("#filtro")).sendKeys("RUY CELESTINO NEVES");
			paginaDocH.findElement(By.cssSelector("#AL")).click();
			paginaDocH.findElement(By.cssSelector("#CE")).click();
			paginaDocH.findElement(By.cssSelector("#PB")).click();
			paginaDocH.findElement(By.cssSelector("#PE")).click();
			paginaDocH.findElement(By.cssSelector("#RN")).click();
			paginaDocH.findElement(By.cssSelector("#SE")).click();
			paginaDocH.findElement(By.cssSelector("#submitConsulta")).click();
			controlarNovaAba(paginaDocH, paginaDocH.getCurrentUrl());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
			tirarPrint(paginaDocH, "CP_UNIFICADA_NOME");
			terceiraTelaDocH(paginaDocH);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CP_UNIFICADA_NOME - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocH(paginaDocHaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				segundaTelaDocH(paginaDocHaberta);
			}
		}
	}
	
	public static void terceiraTelaDocH(WebDriver paginaDocH) {
		try {
			WebDriverWait wait = new WebDriverWait(paginaDocH, 30);
			fecharAbas(paginaDocH);
			paginaDocH.get("http://jef.trf5.jus.br/acompanhamentoProcessual/acompanhamentoProcessual.php");
			Thread.sleep(3000);
			paginaDocH.findElement(By.cssSelector("#tipo_xmladvoab")).click();
			paginaDocH.findElement(By.cssSelector("#uf")).sendKeys("AL");
			paginaDocH.findElement(By.cssSelector("#filtro")).sendKeys("4577");
			paginaDocH.findElement(By.cssSelector("#AL")).click();
			paginaDocH.findElement(By.cssSelector("#CE")).click();
			paginaDocH.findElement(By.cssSelector("#PB")).click();
			paginaDocH.findElement(By.cssSelector("#PE")).click();
			paginaDocH.findElement(By.cssSelector("#RN")).click();
			paginaDocH.findElement(By.cssSelector("#SE")).click();
			paginaDocH.findElement(By.cssSelector("#submitConsulta")).click();
			controlarNovaAba(paginaDocH, paginaDocH.getCurrentUrl());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
			tirarPrint(paginaDocH, "CP_UNIFICADA_OAB");
			Navegador.fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CP_UNIFICADA_OAB - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocH(paginaDocHaberta);
			}
		}
	}
}
