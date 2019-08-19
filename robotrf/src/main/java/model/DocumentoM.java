package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoM extends Navegador{ // Classe referente á execução do doc M
	public static WebDriver paginaDocMaberta;
	public static void inicioDocM() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocM = Navegador.abrirNavegador("http://www.trf5.jus.br/"); // Objeto tipo WebDriver recebe
																						// instancia da classe Navegador
																						// para ser manipulado na classe
																						// Documento"X"
			criarDiretorio();
			paginaDocMaberta = paginaDocM;
			tirarPrint(paginaDocM, "INDEX");
			segundaTelaDocM(paginaDocM);
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! INDEX - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocM(paginaDocMaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocM();
			}
		}

	}

	public static void segundaTelaDocM(WebDriver paginaDocM) {
		try {
			paginaDocM.get("http://www.trf5.jus.br/");
			paginaDocM.findElement(By.cssSelector("li.dropdown:nth-child(3) > a:nth-child(1)")).click();
			paginaDocM.findElement(
					By.cssSelector("li.dropdown:nth-child(3) > ul:nth-child(2) > li:nth-child(13) > a:nth-child(1)"))
					.click();
			Thread.sleep(2000);
			Navegador.tirarPrint(paginaDocM, "PLANTAO_JUD");
			terceiraTelaDocM(paginaDocM);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PLANTAO_JUD - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocM(paginaDocMaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTelaDocM(paginaDocMaberta);
			}
		}
	}

	public static void terceiraTelaDocM(WebDriver paginaDocM) {
		try {
			paginaDocM.findElement(By.cssSelector("li.dropdown:nth-child(3) > a:nth-child(1)")).click();
			paginaDocM.findElement(
					By.cssSelector("li.dropdown:nth-child(3) > ul:nth-child(2) > li:nth-child(8) > a:nth-child(1)"))
					.click();
			paginaDocM.findElement(By.cssSelector("#ui-id-15")).click();
			Thread.sleep(2000);
			Navegador.tirarPrint(paginaDocM, "PGTO_RPV");
			quartaTelaDocM(paginaDocM);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PGTO_RPV - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quartaTelaDocM(paginaDocMaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocM(paginaDocMaberta);
			}
		}
	}

	public static void quartaTelaDocM(WebDriver paginaDocM) {
		try {
		paginaDocM.findElement(By.cssSelector("#ui-id-16")).click();
		Thread.sleep(2000);
		Navegador.tirarPrint(paginaDocM, "PGTO_PRECATORIO");
		Navegador.fecharNavegador();
		}catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PGTO_PRECATORIO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quartaTelaDocM(paginaDocMaberta);
			}
		}
	}
}
