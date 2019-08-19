package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoI extends Navegador{ // Classe referente á execução do doc I

	public static void inicioDocI() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocI = Navegador.abrirNavegador("https://www4.trf5.jus.br/temis/"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
			criarDiretorio();
			paginaDocI.findElement(By.id("frmLogin:login")).sendKeys("CWEB");
			paginaDocI.findElement(By.id("frmLogin:senha")).sendKeys("kiere20eg8");
			paginaDocI.findElement(By.id("frmLogin:btEntrar")).click();
			new WebDriverWait(paginaDocI, 20).until(ExpectedConditions.urlToBe("https://www4.trf5.jus.br/temis/consulta.jsf"));
			tirarPrint(paginaDocI, "LEI9099");
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LEI9099 - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocI();
			}
		}
	}
}
