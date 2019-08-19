package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoK extends Navegador{ // Classe referente á execução do doc K
	public static WebDriver paginaDocKaberta;
	public static void inicioDocK() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocK = Navegador.abrirNavegador("http://www5.trf5.jus.br/validar_assinatura/"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
																										//para ser manipulado na classe Documento"X"
			criarDiretorio();
			paginaDocKaberta = paginaDocK;
			tirarPrint(paginaDocK, "ASSINATURA");
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
			segundaTelaDocK(paginaDocK);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! ASSINATURA - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocK(paginaDocKaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocK();
			}
		}
	}
	
	public static void segundaTelaDocK(WebDriver paginaDocK) {
		try {
			paginaDocK.get("https://www4.trf5.jus.br/irdr/paginas/publico.xhtml");
			tirarPrint(paginaDocK, "IRDR");
			terceiraTelaDocK(paginaDocK);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! IRDR - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocK(paginaDocKaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTelaDocK(paginaDocKaberta);
			}
		}
	}

	public static void terceiraTelaDocK(WebDriver paginaDocK) {
		try {
			paginaDocK.get("http://www.trf5.jus.br/comentarios/?orgao=trf5");
			tirarPrint(paginaDocK, "ORGAO");
			quartaTelaDocK(paginaDocK);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! ORGAO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quartaTelaDocK(paginaDocKaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocK(paginaDocKaberta);
			}
		}
	}

	public static void quartaTelaDocK(WebDriver paginaDocK) {
		try {
			paginaDocK.get("http://www5.trf5.jus.br/organogramas/trf5/");
			tirarPrint(paginaDocK, "ORGANOGRAMA");
			quintaTelaDocK(paginaDocK);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! ORGANOGRAMA - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quintaTelaDocK(paginaDocKaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quartaTelaDocK(paginaDocKaberta);
			}
		}
	}

	public static void quintaTelaDocK(WebDriver paginaDocK) {
		try {
			paginaDocK.get("https://www2.jf.jus.br/pergamum/biblioteca/index.php");
			tirarPrint(paginaDocK, "PERGAMUM");
			sextaTelaDocK(paginaDocK);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! PERGAMUM - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				sextaTelaDocK(paginaDocKaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quintaTelaDocK(paginaDocKaberta);
			}
		}
	}

	public static void sextaTelaDocK(WebDriver paginaDocK) {
		try {
			paginaDocK.get("https://www4.trf5.jus.br/sustentacao-oral//login.html");
			tirarPrint(paginaDocK, "SUSTENTACAO");
			Navegador.fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null,
					"Falha ao tirar print! SUSTENTACAO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				sextaTelaDocK(paginaDocKaberta);
			}
		}
	}
}
