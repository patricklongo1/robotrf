package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoU extends Navegador {
	public static WebDriver paginaDocUaberta;
	
	public static void inicioDocU() {
		try {
			WebDriver paginaDocU = abrirNavegador("https://sei.trf5.jus.br/sei/");
			criarDiretorio();
			paginaDocUaberta = paginaDocU;
			tirarPrint(paginaDocU, "USUARIO_INTERNO");
			segundaTela(paginaDocUaberta);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! USUARIO_INTERNO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTela(paginaDocUaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocU();
			}
		}
	}
	public static void segundaTela(WebDriver paginaDocU) {
		try {
			paginaDocU.get("https://sei.trf5.jus.br/sei/controlador_externo.php?acao=usuario_externo_logar&id_orgao_acesso_externo=0");
			tirarPrint(paginaDocU, "USUARIO_EXTERNO");
			fecharNavegador();
		}catch(Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! USUARIO_INTERNO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTela(paginaDocUaberta);
			}
		}
	}
}
