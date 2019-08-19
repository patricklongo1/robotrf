package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoS extends Navegador {
	public static WebDriver paginaDocSaberta;
	
	public static void inicioDocS() {
		try {
			WebDriver paginaDocS = abrirNavegador("https://www4.trf5.jus.br/EstatisticaCJF/");
			criarDiretorio();
			paginaDocSaberta = paginaDocS;
			paginaDocS.findElement(By.cssSelector("#iconj_id4")).click();
			paginaDocS.findElement(By.cssSelector("#j_id84\\:btnCons")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocS, "EST1_SIM");
			segundaTela(paginaDocSaberta);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EST1_SIM - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTela(paginaDocSaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocS();
			}
		}
	}

	public static void segundaTela(WebDriver paginaDocS) {
		try {
			paginaDocS.findElement(By.cssSelector("#iconj_id11")).click();
			paginaDocS.findElement(By.cssSelector("#j_id108\\:btnCons")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocS, "EST1_DET");
			terceiraTela(paginaDocS);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EST1_DET - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTela(paginaDocSaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTela(paginaDocSaberta);
			}
		}
	}

	public static void terceiraTela(WebDriver paginaDocS) {
		try {
			paginaDocS.findElement(By.cssSelector("#iconj_id24")).click();
			paginaDocS.findElement(By.cssSelector("#j_id84\\:btnCons")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocS, "EST2_SIM");
			quartaTela(paginaDocS);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EST2_SIM - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quartaTela(paginaDocSaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTela(paginaDocSaberta);
			}
		}
	}

	public static void quartaTela(WebDriver paginaDocS) {
		try {
			paginaDocS.findElement(By.cssSelector("#iconj_id37")).click();
			paginaDocS.findElement(By.cssSelector("#j_id84\\:btnCons")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocS, "EST2_DET");
			quintaTela(paginaDocS);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EST2_DET - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quintaTela(paginaDocSaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quartaTela(paginaDocSaberta);
			}
		}
	}

	public static void quintaTela(WebDriver paginaDocS) {
		try {
			paginaDocS.get("http://www5.trf5.jus.br/documento/?tipo=est");
			Thread.sleep(500);
			tirarPrint(paginaDocS, "DOCUM_EST");
			sextaTela(paginaDocS);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! DOCUM_EST - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				sextaTela(paginaDocSaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quintaTela(paginaDocSaberta);
			}
		}
	}

	public static void sextaTela(WebDriver paginaDocS) {
		try {
			paginaDocS.get("http://www5.trf5.jus.br/jurisdicao/");
			paginaDocS.findElement(By.cssSelector("#m_quinta_regiao2 > ul > li:nth-child(1) > a")).click();
			paginaDocS.findElement(By.cssSelector("#mapa > area:nth-child(16)")).click();
			tirarPrint(paginaDocS, "JURISDICAO");
			setimaTela(paginaDocS);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JURISDICAO - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				setimaTela(paginaDocSaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				sextaTela(paginaDocSaberta);
			}
		}
	}

	public static void setimaTela(WebDriver paginaDocS) {
		try {
			paginaDocS.get("https://www2.jf.jus.br/phpdoc/sicom/tabelaCorMor.php");
			Thread.sleep(500);
			paginaDocS.findElement(By.cssSelector(
					"#div_conteudo > table > tbody > tr:nth-child(8) > td:nth-child(2) > input[type=radio]:nth-child(1)"))
					.click();
			Thread.sleep(500);
			paginaDocS.findElement(By.cssSelector("#div_botoes > input[type=button]")).click();
			Thread.sleep(4000);
			controlarNovaAba(paginaDocS, paginaDocS.getWindowHandle());
			Thread.sleep(500);
			tirarPrint(paginaDocS, "SICOM");
			fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! SICOM - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				setimaTela(paginaDocSaberta);
			}
		}
	}
}
