package model;

import java.awt.Dialog.ModalityType;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controler.Navegador;
import io.github.sukgu.Shadow;
import view.TelaPrincipal;

import org.openqa.selenium.WebElement;

public class DocumentoQ extends Navegador {// Classe referente á execução do doc Q
	public static WebDriver paginaDocQaberta;
	private static boolean tela;


	public static void inicioDocQ() { // Metodo que inicia o execução do documento Q (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocQ = abrirNavegador("https://www4.trf5.jus.br/certidoes/paginas/certidaoeleitoral.faces");
			criarDiretorio();
			paginaDocQaberta = paginaDocQ;
			paginaDocQ.findElement(By.cssSelector("#form\\:nome")).sendKeys("FRANCISCO VALDECI RIBEIRO BARROS");
			paginaDocQ.findElement(By.cssSelector("#form\\:cpfCnpj")).sendKeys("465.219.844-20");
			Thread.sleep(500);
			tela = true;
				while (tela == true) {
					telaCaptcha();
					paginaDocQ.findElement(By.cssSelector("#form\\:panelBotoes > a.estilocomand")).click();
					Thread.sleep(2000);
					paginaDocQ.get("chrome://downloads/");
					Thread.sleep(4000);
					Shadow shadow = new Shadow(paginaDocQ); // Objeto shadow acessa os elementos que estão dentro de
					WebElement element = shadow.findElement("#file-link");
					element.click();
					Thread.sleep(4000);
					controlarNovaAba(paginaDocQ, paginaDocQ.getWindowHandle());
					Thread.sleep(3000);
					tirarPrint(paginaDocQ, "CERTIDAO_ELEITORAL");
					tela = false;
			}


		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CERTIDAO_ELEITORAL - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTela(paginaDocQaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocQ();
			}
		}
		segundaTela(paginaDocQaberta);
	}

	public static void segundaTela(WebDriver paginaDocQ) {
		try {
			fecharAbas(paginaDocQ);
			paginaDocQ.get("https://www4.trf5.jus.br/certidoes/paginas/certidaodistribuicao.faces");
			paginaDocQ.findElement(By.cssSelector("#form\\:nome")).sendKeys("FRANCISCO VALDECI RIBEIRO BARROS");
			paginaDocQ.findElement(By.cssSelector("#form\\:cpfCnpj")).sendKeys("465.219.844-20");
			paginaDocQ.findElement(By.cssSelector("#form\\:j_idt65\\:2")).click();
			telaCaptcha();
		
				while (tela == true) {
					paginaDocQ.findElement(By.cssSelector("#form\\:panelBotoes > a.estilocomand")).click();
					Thread.sleep(2000);
					paginaDocQ.get("chrome://downloads/");
					Thread.sleep(4000);
					Shadow shadow = new Shadow(paginaDocQ); // Objeto shadow acessa os elementos que estão dentro de
					WebElement element = shadow.findElement("#file-link");
					element.click();
					Thread.sleep(4000);
					controlarNovaAba(paginaDocQ, paginaDocQ.getWindowHandle());
					Thread.sleep(3000);
					tirarPrint(paginaDocQ, "CERTIDAO_DISTRIBUICAO");
					tela = false;
				}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CERTIDAO_DISTRIBUICAO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTela(paginaDocQaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTela(paginaDocQaberta);
			}
		}
		terceiraTela(paginaDocQ);
	}

	public static void terceiraTela(WebDriver paginaDocQ) {
		try {
			fecharAbas(paginaDocQ);
			paginaDocQ.get("https://www4.trf5.jus.br/certidoes/paginas/certidaocriminal.faces");
			paginaDocQ.findElement(By.cssSelector("#form\\:nome")).sendKeys("FRANCISCO VALDECI RIBEIRO BARROS");
			paginaDocQ.findElement(By.cssSelector("#form\\:cpfCnpj")).sendKeys("465.219.844-20");
			telaCaptcha();
		
				while (tela == true) {
					paginaDocQ.findElement(By.cssSelector("#form\\:panelBotoes > a.estilocomand")).click();
					Thread.sleep(2000);
					paginaDocQ.get("chrome://downloads/");
					Thread.sleep(4000);
					Shadow shadow = new Shadow(paginaDocQ); // Objeto shadow acessa os elementos que estão dentro de
					WebElement element = shadow.findElement("#file-link");
					element.click();
					Thread.sleep(4000);
					controlarNovaAba(paginaDocQ, paginaDocQ.getWindowHandle());
					Thread.sleep(3000);
					tirarPrint(paginaDocQ, "CERTIDAO_NEGATIVA");
					tela = false;
				}
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! CERTIDAO_NEGATIVA - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				fecharNavegador();
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTela(paginaDocQaberta);
			}
		}
		Navegador.fecharNavegador();
	}

	protected static boolean telaCaptcha() {
		
		JOptionPane optionPane = new JOptionPane("Digite o código abaixo e clique em 'Solicitar Certidão' aguarde retorno da consulta, pressione OK nesta janela e o processo seguinte será automatizado");
		JDialog dialog = optionPane.createDialog("ATENÇÃO!");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		TelaPrincipal.frame.setVisible(false);
		return tela = true;
	}
}
