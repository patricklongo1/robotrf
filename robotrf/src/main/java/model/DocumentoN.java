package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoN extends Navegador{ // Classe referente á execução do doc N
	public static WebDriver paginaDocNaberta;
	public static void inicioDocN() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocN = abrirNavegador("http://10.141.120.41/zabbix/index.php"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
																										//para ser manipulado na classe Documento"X"
			criarDiretorio();
			paginaDocNaberta = paginaDocN;
			paginaDocN.findElement(By.cssSelector("#name")).sendKeys("xxxxxxx");
			paginaDocN.findElement(By.cssSelector("#password")).sendKeys("xxxxxxx");
			paginaDocN.findElement(By.cssSelector("#enter")).click();
			paginaDocN.findElement(By.cssSelector("#sub_view > li:nth-child(1) > a")).click();
			
			Thread.sleep(3000);
			tirarPrint(paginaDocN, "parnamirim.trf5.gov.br");
			Navegador.fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! parnamirim.trf5.gov.br - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocN();
			}
		}
	}
}
