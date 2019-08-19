package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoE extends Navegador{ // Classe referente á execução do doc E
	public static WebDriver paginaDocEaberta;
	public static void inicioDocE() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocE = Navegador.abrirNavegador("https://www4.trf5.jus.br/Jurisprudencia/"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
			WebDriverWait wait = new WebDriverWait(paginaDocE, 30);																						//para ser manipulado na classe Documento"X"
			criarDiretorio();
			paginaDocEaberta = paginaDocE;
			paginaDocE.findElement(By.cssSelector("#termos")).sendKeys("Wesley");
			paginaDocE.findElement(By.cssSelector("#pesquisar")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#resultado > div:nth-child(1) > a")));
			paginaDocE.findElement(By.cssSelector("#resultado > div:nth-child(1) > a")).click();
			tirarPrint(paginaDocE, "JURIS_GERAL");
			segundaTelaDocE(paginaDocE);
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JURIS_GERAL - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocE(paginaDocEaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocE();
			}
		}
	}
	
	public static void segundaTelaDocE(WebDriver paginaDocE) {
		try {
			WebDriverWait wait = new WebDriverWait(paginaDocE, 30);
			paginaDocE.findElement(By.cssSelector("#resultado-topo > div > input.direita")).click();
			Thread.sleep(3000);
			paginaDocE.findElement(By.cssSelector("#tipoProcesso")).sendKeys("Físico");
			paginaDocE.findElement(By.cssSelector("#magistrado")).sendKeys("A");
			paginaDocE.findElement(By.cssSelector("#pesquisar")).click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocE, paginaDocE.getCurrentUrl());
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#resultado > div:nth-child(1) > a")));
			paginaDocE.findElement(By.cssSelector("#resultado > div:nth-child(1) > a")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
			tirarPrint(paginaDocE, "JURIS_FISICO");
			terceiraTelaDocE(paginaDocE);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JURIS_FISICO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocE(paginaDocEaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}
			else {
				segundaTelaDocE(paginaDocEaberta);
			}
		}
		
		
		
	}
	
	public static void terceiraTelaDocE(WebDriver paginaDocE) {
		try {
			WebDriverWait wait = new WebDriverWait(paginaDocE, 30);
			paginaDocE.findElement(By.cssSelector("#resultado-topo > div > input.direita")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tipoProcesso")));
			paginaDocE.findElement(By.cssSelector("#tipoProcesso")).sendKeys("Eletrônico");
			paginaDocE.findElement(By.cssSelector("#magistrado")).sendKeys("A");
			paginaDocE.findElement(By.cssSelector("#pesquisar")).click();
			controlarNovaAba(paginaDocE, paginaDocE.getCurrentUrl());
				try {  // Se houver resultado na busca
					paginaDocE.findElement(By.cssSelector("#resultado > div:nth-child(1) > a")).click();
					Thread.sleep(3000);
					tirarPrint(paginaDocE, "JURIS_ELETRONICO");
				}catch (Exception e){ // Caso não hája resultado na busca, acessa o link de pesquisa de juris eletronico total e evidencia o resultado (o)
					paginaDocE.get("https://www4.trf5.jus.br/Jurisprudencia/JurisServlet?op=exibir&tipo=1");
					Thread.sleep(3000);
					tirarPrint(paginaDocE, "JURIS_ELETRONICO");
					fecharNavegador();
				}
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JURIS_ELETRONICO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocE(paginaDocEaberta);
			}
		}
		
	}
}
