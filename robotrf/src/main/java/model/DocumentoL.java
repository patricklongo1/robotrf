package model;

import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoL extends Navegador { // Classe referente á execução do doc L
	public static WebDriver paginaDocLaberta;
	public static void inicioDocL() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocL = abrirNavegador("http://www.trf5.jus.br"); // Objeto tipo WebDriver recebe instancia
																				// da classe Navegador
																				// para ser manipulado na classe
																				// Documento"X"
			criarDiretorio();
			paginaDocLaberta = paginaDocL;
			paginaDocL.findElement(By.cssSelector("li.dropdown:nth-child(7) > a:nth-child(1)")).click();
			paginaDocL.findElement(
					By.cssSelector("li.dropdown:nth-child(7) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)"))
					.click();
			Thread.sleep(4000);
			tirarPrint(paginaDocL, "NOTICIA");
			segundaTelaDocL(paginaDocL);
			// JOptionPane.showMessageDialog(null, "Print salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! NOTICIA - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocL(paginaDocLaberta);
			} else if (tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				fecharNavegador();
				inicioDocL();
			}
		}

	}

	public static void segundaTelaDocL(WebDriver paginaDocL) {
		try {
			paginaDocL.findElement(By.cssSelector("li.dropdown:nth-child(7) > a:nth-child(1)")).click();
			paginaDocL.findElement(
					By.cssSelector("li.dropdown:nth-child(7) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)"))
					.click();
			List<WebElement> elements = paginaDocL.findElements(By.className("ui-state-hover"));
			elements.get(elements.size() - 1).click();
			Thread.sleep(5000);
			tirarPrint(paginaDocL, "MURAL");
			terceiraTelaDocL(paginaDocL);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! MURAL - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocL(paginaDocLaberta);
			} else if (tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				segundaTelaDocL(paginaDocLaberta);
			}
		}

	}

	public static void terceiraTelaDocL(WebDriver paginaDocL) {
		try {
			paginaDocL.get("http://www.trf5.jus.br");
			paginaDocL.findElement(By.cssSelector(".item-477 > a:nth-child(1)")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocL, "EVENTOS");
			quartaTelaDocL(paginaDocL);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! EVENTOS - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quartaTelaDocL(paginaDocLaberta);
			} else if (tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				terceiraTelaDocL(paginaDocLaberta);
			}
		}
	}

	public static void quartaTelaDocL(WebDriver paginaDocL) {

		try {
			paginaDocL.get("http://www.trf5.jus.br");
			paginaDocL.findElement(By.cssSelector("li.dropdown:nth-child(4) > a:nth-child(1)")).click();
			paginaDocL.findElement(
					By.cssSelector("li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)"))
					.click();
			;
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:orgao")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:orgao > option:nth-child(2)")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:edicao")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:edicao > option:nth-child(2)")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:periodo ")).sendKeys(definirAno());
			Thread.sleep(3000);
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:meses")).sendKeys(definirMes());
			Thread.sleep(3000);
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:j_id48")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocL, "DIARIO_JUD");
			quintaTelaDocL(paginaDocL);

		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! DIARIO_JUD - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quintaTelaDocL(paginaDocLaberta);
			} else if (tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				quartaTelaDocL(paginaDocLaberta);
			}
		}
	}

	public static void quintaTelaDocL(WebDriver paginaDocL) {
		try {
			paginaDocL.get("http://www.trf5.jus.br");
			paginaDocL.findElement(By.cssSelector("li.dropdown:nth-child(4) > a:nth-child(1)")).click();
			paginaDocL.findElement(
					By.cssSelector("li.dropdown:nth-child(4) > ul:nth-child(2) > li:nth-child(3) > a:nth-child(1)"))
					.click();
			;
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:orgao")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:orgao > option:nth-child(2)")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:edicao")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:edicao > option:nth-child(3)")).click();
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:periodo")).sendKeys(definirAno());
			Thread.sleep(3000);
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:meses")).sendKeys(definirMes());
			Thread.sleep(3000);
			paginaDocL.findElement(By.cssSelector("#frmVisao\\:j_id45")).click();
			Thread.sleep(3000);
			tirarPrint(paginaDocL, "DIARIO_ADMIN");
			Navegador.fecharNavegador();
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null,
					"Falha ao tirar print! DIARIO_ADMIN - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1 || tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			} else {
				quintaTelaDocL(paginaDocLaberta);
			}
		}
	}

	public static String definirAno() {
		Calendar c1 = Calendar.getInstance();
		String ano = String.valueOf(c1.get(Calendar.YEAR));

		return ano; // Retorna apenas o ano.
	}

	public static String definirMes() {
		Calendar c1 = Calendar.getInstance();
		int mes = c1.get(Calendar.MONTH);
		String mesString;
		if (mes == 0) {
			mesString = "Janeiro";
		} else if (mes == 1) {
			mesString = "Fevereiro";
		} else if (mes == 2) {
			mesString = "Março";
		} else if (mes == 3) {
			mesString = "Abril";
		} else if (mes == 4) {
			mesString = "Maio";
		} else if (mes == 5) {
			mesString = "Junho";
		} else if (mes == 6) {
			mesString = "Julho";
		} else if (mes == 7) {
			mesString = "Agosto";
		} else if (mes == 8) {
			mesString = "Setembro";
		} else if (mes == 9) {
			mesString = "Outubro";
		} else if (mes == 10) {
			mesString = "Novembro";
		} else {
			mesString = "Dezembro";
		}
		return mesString; // retorna o mês em String - Ex: int 0 == "Janeiro"
	}
}
