package model;

import java.util.List;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controler.ErroExcel;
import controler.Navegador;
import io.github.sukgu.Shadow;
import view.TelaPrincipal;

public class DocumentoR extends Navegador{
	private static String nomeArquivo;
	private static WebDriver paginaDocRaberto;
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) { 
		DocumentoR.nomeArquivo = nomeArquivo;
	}
	//	                                                                         1
	@SuppressWarnings("deprecation")
	public static void inicioDocR() { //Metodo que inicia o execução do documento R (Acesso e manipulaçao da página
		try {
			WebDriver paginaDocR = Navegador.abrirNavegador("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
																													//para ser manipulado na classe Documento"X
			paginaDocRaberto = paginaDocR;
			criarDiretorio();
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt70 > span")));
			inputaDatas(paginaDocR);
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000); 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(2000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(3000);
			tirarPrint(paginaDocR, "INTIMACOES_TRF5_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				abreExcel(arquivo);
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_TRF5_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel ");
			}
			//--------------------------- CSV PRINTADO
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				abreExcel(arquivo2);
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_TRF5_XLS");
				deletaArquivo(".xls");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- XLS PRINTADO
			segundaTelaDocR(paginaDocR);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! TRF5 - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocR(paginaDocRaberto);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocR();
			}
		}
	}
	// Fim da primeira tela DOC R
	//==================================================                               2
	// Segunda tela DOC R 			
	@SuppressWarnings("deprecation")
	public static void segundaTelaDocR(WebDriver paginaDocR) {
		try {
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt58_label")));
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_label")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_panel > div > ul > li:nth-child(2)")).click();
			Thread.sleep(2000);
			inputaDatas(paginaDocR);
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000);
			// Cria lista com TRs dos resultados da busca. 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(3000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(2000);
			tirarPrint(paginaDocR, "INTIMACOES_JFPE_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFPE_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- CSV PRINTADO
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo2));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFPE_XLS");
				deletaArquivo(".xls");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- XLS PRINTADO
			terceiraTelaDocR(paginaDocR);
		  }catch (Exception e) {
			  e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JFPE - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					terceiraTelaDocR(paginaDocRaberto);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					segundaTelaDocR(paginaDocRaberto);
				}
		}
	}
	// Fim da segunda tela DOC R
	@SuppressWarnings("deprecation")
	public static void terceiraTelaDocR(WebDriver paginaDocR) {
		try {
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt58_label")));
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_label")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_panel > div > ul > li:nth-child(3)")).click();
			Thread.sleep(2000);
			inputaDatas(paginaDocR);
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000);
			// Cria lista com TRs dos resultados da busca. 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(3000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(2000);
			tirarPrint(paginaDocR, "INTIMACOES_JFPB_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFPB_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- CSV PRINTADO
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo2));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFPB_XLS");
				deletaArquivo(".xls");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- XLS PRINTADO
			quartaTelaDocR(paginaDocR);
		  }catch (Exception e) {
			  e.printStackTrace();
			  int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JFPB - Deseja tentar novamente?");
			  TelaPrincipal.frame.setVisible(false);
			  	if (tn == 1) {
					quartaTelaDocR(paginaDocRaberto);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					terceiraTelaDocR(paginaDocRaberto);
				}
		}
	}
	// Fim da terceira tela DOC R
	@SuppressWarnings("deprecation")
	public static void quartaTelaDocR(WebDriver paginaDocR) {
		try {
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt58_label")));
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_label")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_panel > div > ul > li:nth-child(4)")).click();
			Thread.sleep(2000);
			inputaDatas(paginaDocR);
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000);
			// Cria lista com TRs dos resultados da busca. 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(3000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(2000);
			tirarPrint(paginaDocR, "INTIMACOES_JFCE_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFCE_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- CSV PRINTADO
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo2));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFCE_XLS");
				deletaArquivo(".xls");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- XLS PRINTADO
			quintaTelaDocR(paginaDocR);
		  }catch (Exception e) {
			  e.printStackTrace();
			  int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JFCE - Deseja tentar novamente?");
			  TelaPrincipal.frame.setVisible(false);
			  	if (tn == 1) {
					quintaTelaDocR(paginaDocRaberto);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					quartaTelaDocR(paginaDocRaberto);
				}
		}
	}
	// Fim da quarta tela DOC R
	//==================================================                                5
	// Quinta tela DOC R
	@SuppressWarnings("deprecation")
	public static void quintaTelaDocR(WebDriver paginaDocR) {
		try {
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt58_label")));
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_label")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_panel > div > ul > li:nth-child(5)")).click();
			Thread.sleep(2000);
			inputaDatas(paginaDocR);
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000);
			// Cria lista com TRs dos resultados da busca. 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(3000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(2000);
			tirarPrint(paginaDocR, "INTIMACOES_JFSE_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFSE_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- CSV PRINTADO
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo2));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFSE_XLS");
				deletaArquivo(".xls");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- XLS PRINTADO
			sextaTelaDocR(paginaDocR);
		  }catch (Exception e) {
			  e.printStackTrace();
			  int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JFSE - Deseja tentar novamente?");
			  TelaPrincipal.frame.setVisible(false);
			  	if (tn == 1) {
					sextaTelaDocR(paginaDocRaberto);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					quintaTelaDocR(paginaDocRaberto);
				}
		}
	}
	// Fim da quinta tela DOC R
	//==================================================                              6
	// Sexta tela DOC R
	@SuppressWarnings("deprecation")
	public static void sextaTelaDocR(WebDriver paginaDocR) {
		try {
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt58_label")));
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_label")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_panel > div > ul > li:nth-child(6)")).click();
			Thread.sleep(2000);
			inputaDatas(paginaDocR);
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000);
			// Cria lista com TRs dos resultados da busca. 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(3000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(2000);
			tirarPrint(paginaDocR, "INTIMACOES_JFAL_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFAL_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao abrir Excel");
			}
			//--------------------------- CSV PRINTADO
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo2));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFAL_XLS");
				deletaArquivo(".xls");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//--------------------------- XLS PRINTADO
			setimaTelaDocR(paginaDocR);
		  }catch (Exception e) {
			  e.printStackTrace();
			  int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JFAL - Deseja tentar novamente?");
			  TelaPrincipal.frame.setVisible(false);
			  	if (tn == 1) {
					setimaTelaDocR(paginaDocRaberto);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					sextaTelaDocR(paginaDocRaberto);
				}
		}
	}
	// Fim da sexta tela DOC R
	//==================================================                               7
	// Setima tela doc R
	@SuppressWarnings("deprecation")
	public static void setimaTelaDocR(WebDriver paginaDocR) {
		try {
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			WebDriverWait wait = new WebDriverWait(paginaDocR, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loginForm\\:j_idt58_label")));
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_label")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt58_panel > div > ul > li:nth-child(7)")).click();
			Thread.sleep(2000);
			inputaDatas(paginaDocR); 
			// Datas inputadas
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt70 > span")).click(); //Pesquisar
			Thread.sleep(2000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD")).click();
			paginaDocR.findElement(By.cssSelector("#loginForm\\:tabelaIntimacoes_rppDD > option:nth-child(3)")).click(); // Define lista de results com 15 itens
			Thread.sleep(2000);
			// Cria lista com TRs dos resultados da busca. 
			selecionaDataComDocValido(paginaDocR);
			Thread.sleep(2000);
			baixarArquivos(paginaDocR);
			paginaDocR.get("chrome://downloads/");
			Thread.sleep(3000);
			Shadow shadow = new Shadow(paginaDocR); // Objeto shadow acessa os elementos que estão dentro de
			WebElement element = shadow.findElement("#file-link");
			element.click();
			Thread.sleep(3000);
			controlarNovaAba(paginaDocR, paginaDocR.getWindowHandle());
			Thread.sleep(2000);
			tirarPrint(paginaDocR, "INTIMACOES_JFRN_PDF"); //Print
			fecharAbas(paginaDocR);
			paginaDocR.get("https://www4.trf5.jus.br/intimacoesEletronicasSecoes/");
			deletaArquivo(".pdf");
			Thread.sleep(2000);
			//--------------------------- PDF PRINTADO
			try {
				File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
				ErroExcel e = new ErroExcel();
				e.start();
				Thread.sleep(1000);
				Desktop.getDesktop().open((arquivo));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFRN_CSV");
				deletaArquivo(".csv");
				Thread.sleep(3000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//--------------------------- CSV PRINTADO 
			try {
				File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
				ErroExcel e = new ErroExcel();
				e.start();
				Desktop.getDesktop().open((arquivo2));
				Thread.sleep(10000);
				e.stop();
				e.interrupt();
				maximizaExcel();
				Thread.sleep(10000);
				tirarPrint2("INTIMACOES_JFRN_XLS");
				deletaArquivo(".xls");
				fecharNavegador();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//--------------------------- XLS PRINTADO 
		  }catch (Exception e) {
			  e.printStackTrace();
			  int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! JFRN - Deseja tentar novamente?");
			  TelaPrincipal.frame.setVisible(false);
			  	if (tn == 1) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					setimaTelaDocR(paginaDocRaberto);
				}
		  }
	}
	// Fim da setima tela DOC R
	// Metodos staticos ***********************************
	public static void baixarArquivos(WebDriver paginaDocR) {
		try {
			paginaDocR.findElement(By.cssSelector("#loginForm\\:modalProcessos > div.ui-dialog-content.ui-widget-content > table:nth-child(1) > tbody > tr > td:nth-child(2) > table > tbody > tr > td:nth-child(2) > a")).click();
			File arquivo = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".csv");
			do {Thread.sleep(1500);} while (!arquivo.exists());
			Thread.sleep(1000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt87")).click();
			
			paginaDocR.findElement(By.cssSelector("#loginForm\\:modalProcessos > div.ui-dialog-content.ui-widget-content > table:nth-child(1) > tbody > tr > td:nth-child(2) > table > tbody > tr > td:nth-child(3) > a")).click();
			File arquivo2 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".xls");
			do {Thread.sleep(1500);} while (!arquivo2.exists());
			Thread.sleep(1000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt87")).click();
			
			paginaDocR.findElement(By.cssSelector("#loginForm\\:modalProcessos > div.ui-dialog-content.ui-widget-content > table:nth-child(1) > tbody > tr > td:nth-child(2) > table > tbody > tr > td:nth-child(1) > a")).click();
			File arquivo3 = new File("C:\\Automação TRF5\\Downloads TRF5\\" + nomeArquivo + ".pdf");
			do {Thread.sleep(1500);} while (!arquivo3.exists());
			Thread.sleep(1000);
			paginaDocR.findElement(By.cssSelector("#loginForm\\:j_idt87")).click();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao baixar arquivos DOC R");
		}
	}
	
	public static void inputaDatas(WebDriver paginaDocR) throws InterruptedException {
		((JavascriptExecutor)paginaDocR).executeScript ("document.getElementById('loginForm:inicial_input').removeAttribute('readonly',0);"); //Habilita campo para inputar senha com Selenium
		paginaDocR.findElement(By.cssSelector("#loginForm\\:inicial_input")).clear();
		paginaDocR.findElement(By.cssSelector("#loginForm\\:inicial_input")).sendKeys(definirDataInicio());
		Thread.sleep(1000);
		((JavascriptExecutor)paginaDocR).executeScript ("document.getElementById('loginForm:final_input').removeAttribute('readonly',0);"); //Habilita campo para inputar senha com Selenium
		paginaDocR.findElement(By.cssSelector("#loginForm\\:final_input")).clear();
		paginaDocR.findElement(By.cssSelector("#loginForm\\:final_input")).sendKeys(definirDataFim());
	}
	
	public static void selecionaDataComDocValido(WebDriver paginaDocR) {
		// Cria lista com TRs dos resultados da busca. 
					List<WebElement> listaElementos = paginaDocR.findElement(By.id("loginForm:tabelaIntimacoes_data"))
							.findElements(By.tagName("tr"));
					int ultimo_dia_de_pesquisa = listaElementos.size() - 1;     // Armazena resultado total de buscas -1 (Dia anterior)
					int penultimo_dia_de_pesquisa = listaElementos.size() - 2;	// Armazena resultado total de buscas -2 (Antes de ontem - casos onde "ontem" não teve documento)
					
					/* Verifica se o resultado de "ontem" tem o spam "Não há docs para esta data" através do metodo existsElement e
					caso não tenha ele clica para abrir os documentos. Caso tenha o Spam clica para abrir os documentos de "antes de ontem"*/
		try {
			if (elementoExiste("#loginForm\\:tabelaIntimacoes_data > tr:nth-child(" + listaElementos.size()
					+ ") > td:nth-child(1) > span:nth-child(2)", paginaDocR) == true) {
				paginaDocR
						.findElement(By.xpath(
								"//*[@id=\"loginForm:tabelaIntimacoes:" + penultimo_dia_de_pesquisa + ":j_idt80\"]"))
						.click();
						penultimo_dia_de_pesquisa +=1;
				nomeArquivo = paginaDocR.findElement(By.xpath("//*[@id=\"loginForm:tabelaIntimacoes_data\"]/tr["+ penultimo_dia_de_pesquisa +"]/td[1]/span")).getText();
			} else {
				paginaDocR
						.findElement(By.xpath(
								"//*[@id=\"loginForm:tabelaIntimacoes:" + ultimo_dia_de_pesquisa + ":j_idt80\"]"))
						.click();
						ultimo_dia_de_pesquisa +=1;
				nomeArquivo = paginaDocR.findElement(By.xpath("//*[@id=\"loginForm:tabelaIntimacoes_data\"]/tr["+ ultimo_dia_de_pesquisa +"]/td[1]/span")).getText();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static String definirDataInicio() {
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, -13);

		String diaInicio = String.format("%02d", c1.get(Calendar.DAY_OF_MONTH));
		String mesInicio = String.format("%02d", c1.get(Calendar.MONTH) + 1);
		String anoInicio = String.valueOf(c1.get(Calendar.YEAR));

		String dataInicio = diaInicio + "-" + mesInicio + "-" + anoInicio;

		return dataInicio;
	}

	public static String definirDataFim() {
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DAY_OF_MONTH, 1);

		String diaFim = String.format("%02d", c2.get(Calendar.DAY_OF_MONTH));
		String mesFim = String.format("%02d", c2.get(Calendar.MONTH) + 1);
		String anoFim = String.valueOf(c2.get(Calendar.YEAR));

		String dataFim = diaFim + "-" + mesFim + "-" + anoFim;

		return dataFim;
	}

	// Verifica se tem a TD Spam "Não há docs para esta data" e caso verdadeiro
	// retorna True, caso não retorna False.
	private static boolean elementoExiste(String cssSelector, WebDriver paginaDocR) {
		try {
			boolean elemento = paginaDocR.findElement(By.cssSelector(cssSelector)).isDisplayed();
			//System.out.println(elemento);
			return elemento;
		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println("false");
			return false;
		}
	}
	
	public static void deletaArquivo(String extensao) throws IOException {
		final File file = new File("C:\\Automação TRF\\Downloads TRF5\\" + nomeArquivo + extensao);
	    Runtime.getRuntime().exec(
	            "cmd /c taskkill /f /im excel.exe");

	    new Thread(new Runnable() {

	        public void run() {

	            try {
	                   Thread.currentThread();
					Thread.sleep(2000);// you need to wait 1-2 sec to close file before delete
	                   file.delete();   

	               } catch (InterruptedException e) {

	                e.printStackTrace();
	            } 
	        }
	    }).start(); 
	}
	
	public static void maximizaExcel() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
	}
	
	public static boolean abreExcel(File f) {
		try {
			Desktop.getDesktop().open((f));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

