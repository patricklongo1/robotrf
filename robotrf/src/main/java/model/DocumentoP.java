package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoP extends Navegador { // Classe referente á execução do doc A
	private static String texto;
	private static WebDriver paginaDocPaberta;

	public static void inicioDocP() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocP = abrirNavegador("http://10.141.120.42:8083/wss/trf/sarhfluxus/TRF/log.do");
			criarDiretorio();
			paginaDocPaberta = paginaDocP;
			WebElement element = paginaDocP.findElement(By.cssSelector("body > pre"));
			texto = element.getText();
			try {
				criarRelatorio("LOG_TRF5", texto);
			} catch (Exception e) {
				e.printStackTrace();

			}
			segundaTela(paginaDocP);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LOG_TRF5 - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTela(paginaDocPaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocP();
			}
		}

	}

	public static void segundaTela(WebDriver paginaDocP) {
		try {
			paginaDocP.get("http://10.141.120.42:8083/wss/trf/sarhfluxus/AL/log.do");

			WebElement element = paginaDocP.findElement(By.cssSelector("body > pre"));
			texto = element.getText();
			try {
				criarRelatorio("LOG_JFAL", texto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			terceiraTela(paginaDocP);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LOG_JFAL - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTela(paginaDocPaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTela(paginaDocPaberta);
			}
		}

	}

	public static void terceiraTela(WebDriver paginaDocP) {
		try {
			paginaDocP.get("http://10.141.120.42:8083/wss/trf/sarhfluxus/CE/log.do");

			WebElement element = paginaDocP.findElement(By.cssSelector("body > pre"));
			texto = element.getText();
			try {
				criarRelatorio("LOG_JFCE", texto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			quartaTela(paginaDocP);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LOG_JFCE - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quartaTela(paginaDocPaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTela(paginaDocPaberta);
			}
		}

	}

	public static void quartaTela(WebDriver paginaDocP) {
		try {
			paginaDocP.get("http://10.141.120.42:8083/wss/trf/sarhfluxus/PE/log.do");

			WebElement element = paginaDocP.findElement(By.cssSelector("body > pre"));
			texto = element.getText();
			try {
				criarRelatorio("LOG_JFPE", texto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			quintaTela(paginaDocP);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LOG_JFPE - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quintaTela(paginaDocPaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quartaTela(paginaDocPaberta);
			}
		}

	}

	public static void quintaTela(WebDriver paginaDocP) {
		try {
			paginaDocP.get("http://10.141.120.42:8083/wss/trf/sarhfluxus/SE/log.do");

			WebElement element = paginaDocP.findElement(By.cssSelector("body > pre"));
			texto = element.getText();
			try {
				criarRelatorio("LOG_JFSE", texto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sextaTela(paginaDocP);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LOG_JFSE - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				sextaTela(paginaDocPaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quintaTela(paginaDocPaberta);
			}
		}

	}

	public static void sextaTela(WebDriver paginaDocP) {
		try {
			paginaDocP.get("http://10.141.120.42:8083/wss/trf/sarhfluxus/RN/log.do");

			WebElement element = paginaDocP.findElement(By.cssSelector("body > pre"));
			texto = element.getText();
			try {
				criarRelatorio("LOG_JFRN", texto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! LOG_JFRN - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				sextaTela(paginaDocPaberta);
			}
		}
		fecharNavegador();
	}
	
}
