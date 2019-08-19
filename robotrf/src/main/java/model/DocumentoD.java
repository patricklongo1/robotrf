package model;

import java.util.Calendar;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoD extends Navegador{ // Classe referente á execução do doc D
	public static WebDriver paginaDocDaberta;
	public static void inicioDocD() { // Metodo que inicia o execução do documento D(Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocD = Navegador.abrirNavegador("https://www4.trf5.jus.br/AtaDeDistribuicao/"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
			WebDriverWait wait = new WebDriverWait(paginaDocD, 30);																						  //para ser manipulado na classe Documento"X"
			
			criarDiretorio();
			paginaDocDaberta = paginaDocD;
			paginaDocD.findElement(By.cssSelector("#data")).sendKeys(definirDataPesquisa());
			paginaDocD.findElement(By.cssSelector("#wrapper > table > tbody > tr:nth-child(3) > td:nth-child(2) > input:nth-child(2)")).click();
			controlarNovaAba(paginaDocD, paginaDocD.getCurrentUrl());
			paginaDocD.manage().window().maximize();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
			tirarPrint(paginaDocD, "ATA_DISTRIBUICAO");
			paginaDocD.close();
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! ATA_DISTRIBUICAO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocD();
			}
		}
	}
	
	public static String definirDataPesquisa(){
		Calendar c1 = Calendar.getInstance();
		if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			c1.add(Calendar.DAY_OF_MONTH, -3);
		} else {
			c1.add(Calendar.DAY_OF_MONTH, -1);
		}
		String dia = String.format("%02d", c1.get(Calendar.DAY_OF_MONTH));
		String mes = String.format("%02d", c1.get(Calendar.MONTH) + 1);
		String ano = String.valueOf(c1.get(Calendar.YEAR));
		return dia+mes+ano;
		
	}
}
