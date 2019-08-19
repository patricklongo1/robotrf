package model;

import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoA extends Navegador { // Classe referente á execução do doc A
	public static WebDriver paginaDocAaberta;

	public static void inicioDocA() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocA = abrirNavegador("http://www4.trf5.jus.br/WSSarh/sarh?wsdl");
			paginaDocAaberta = paginaDocA;
			criarDiretorio();
			tirarPrint(paginaDocA, "WSSARH");
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! WSSARH - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				fecharNavegador();
				inicioDocA();
			}
		}
	}
}
