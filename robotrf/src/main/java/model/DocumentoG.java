package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoG extends Navegador { // Classe referente á execução do doc G

	public static void inicioDocG() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			criarDiretorio();
			WebDriver paginaDocG = Navegador.abrirNavegador("https://www4.trf5.jus.br/TRF5_Push/Login.jsp");
			WebDriverWait wait = new WebDriverWait(paginaDocG, 30);
			paginaDocG.findElement(By.cssSelector(
					"#wrapper > form > table:nth-child(5) > tbody > " + "tr:nth-child(1) > td:nth-child(2) > input"))
					.sendKeys("bruno_bryan@hotmail.com");
			paginaDocG.findElement(By.cssSelector(
					"#wrapper > form > table:nth-child(5) > tbody > " + "tr:nth-child(2) > td:nth-child(2) > input"))
					.sendKeys("Ou8YIMRm");
			paginaDocG
					.findElement(By
							.cssSelector("#wrapper > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > input"))
					.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
					"#div_processos > table.processos > tbody > tr:nth-child(3) > td:nth-child(2) > input")));
			tirarPrint(paginaDocG, "PUSH");
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PUSH - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				fecharNavegador();
				inicioDocG();
			}
		}

	}

}
