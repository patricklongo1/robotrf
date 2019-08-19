package model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controler.Navegador;
import view.TelaPrincipal;

public class DocumentoO extends Navegador{ // Classe referente á execução do doc N
	public static WebDriver paginaDocOaberta;
	public static void inicioDocO() { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			WebDriver paginaDocO = abrirNavegador("http://10.141.120.41/zabbix/index.php"); //Objeto tipo WebDriver recebe instancia da classe Navegador 
																										//para ser manipulado na classe Documento"X"
			criarDiretorio();
			paginaDocOaberta = paginaDocO;
			paginaDocO.findElement(By.cssSelector("#name")).sendKeys("monitor");
			paginaDocO.findElement(By.cssSelector("#password")).sendKeys("monitor");
			paginaDocO.findElement(By.cssSelector("#enter")).click();
			paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28479");
			tirarPrint(paginaDocO, "HOST_Canhotinho");
			segundaTelaDocO(paginaDocO);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Canhotinho - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				segundaTelaDocO(paginaDocOaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				fecharNavegador();
				inicioDocO();
			}
		}
	}
	
	public static void segundaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try {
			paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28733");
			tirarPrint(paginaDocO, "HOST_Escada");
			terceiraTelaDocO(paginaDocO);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Escada - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				terceiraTelaDocO(paginaDocOaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				segundaTelaDocO(paginaDocOaberta);
			}
		}
	}
	
	public static void terceiraTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try { 
			paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28733");
			tirarPrint(paginaDocO, "HOST_Girard03");
			quartaTelaDocO(paginaDocO);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Girard03 - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quartaTelaDocO(paginaDocOaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				terceiraTelaDocO(paginaDocOaberta);
			}
		}
	}
	
	public static void quartaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try { 
			paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28558");
			tirarPrint(paginaDocO, "HOST_Girard04");
			quintaTelaDocO(paginaDocO);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Girard04 - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				quintaTelaDocO(paginaDocOaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quartaTelaDocO(paginaDocOaberta);
			}
		}
	}
	
	public static void quintaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try { 
			paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28579");
			tirarPrint(paginaDocO, "HOST_Gravata");
			sextaTelaDocO(paginaDocO);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Gravata - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				sextaTelaDocO(paginaDocOaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				quintaTelaDocO(paginaDocOaberta);
			}
		}
	}
	public static void sextaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
		try { 
			paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28584");
			tirarPrint(paginaDocO, "HOST_Fluxus");
			setimaTelaDocO(paginaDocO);
		} catch (Exception e) {
			e.printStackTrace();
			int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Fluxus - Deseja tentar novamente?");
			TelaPrincipal.frame.setVisible(false);
			if (tn == 1) {
				setimaTelaDocO(paginaDocOaberta);
			}else if(tn == 2) {
				fecharNavegador();
				TelaPrincipal.frame.setVisible(true);
			}else {
				sextaTelaDocO(paginaDocOaberta);
			}
		}
		}
		public static void setimaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28807");
				tirarPrint(paginaDocO, "HOST_Itamaraca");
				oitavaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_Itamaraca - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					oitavaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					setimaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void oitavaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10473&graphid=48793");
				tirarPrint(paginaDocO, "HOST_maraial01");
				nonaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial01 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					nonaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					oitavaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void nonaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10474&graphid=48766");
				tirarPrint(paginaDocO, "HOST_maraial02");
				decimaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial02 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					nonaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10799&graphid=48793");
				tirarPrint(paginaDocO, "HOST_maraial03");
				decimaPrimeiraTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial03 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaPrimeiraTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaPrimeiraTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10800&graphid=48822");
				tirarPrint(paginaDocO, "HOST_maraial04");
				decimaSegundaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial04 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaSegundaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaPrimeiraTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaSegundaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=11564&graphid=48837");
				tirarPrint(paginaDocO, "HOST_maraial05");
				decimaTerceiraTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial05 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaTerceiraTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaSegundaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaTerceiraTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10801&graphid=48888 ");
				tirarPrint(paginaDocO, "HOST_maraial06");
				decimaQuartaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial06 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaQuartaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaTerceiraTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaQuartaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10802&graphid=48849");
				tirarPrint(paginaDocO, "HOST_maraial07");
				decimaQuintaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial07 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaQuintaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaQuartaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaQuintaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10803&graphid=48862");
				tirarPrint(paginaDocO, "HOST_maraial08");
				decimaSextaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial08 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaSextaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaQuintaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaSextaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?fullscreen=0&groupid=13&hostid=10803&graphid=48862");
				tirarPrint(paginaDocO, "HOST_maraial09");
				decimaSetimaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_maraial09 - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaSetimaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaSextaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaSetimaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28121");
				tirarPrint(paginaDocO, "HOST_moivre");
				decimaOitavaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_moivre - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaOitavaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaSetimaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaOitavaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28135");
				tirarPrint(paginaDocO, "HOST_moreno");
				decimaNonaTelaDocO(paginaDocO);
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_moreno - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1) {
					decimaNonaTelaDocO(paginaDocOaberta);
				}else if(tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaOitavaTelaDocO(paginaDocOaberta);
				}
			}
	}
		public static void decimaNonaTelaDocO(WebDriver paginaDocO) { // Metodo que inicia o execução do documento A (Acesso e manipulaçao da página)
			try { 
				paginaDocO.get("http://10.141.120.41/zabbix/charts.php?graphid=28638");
				tirarPrint(paginaDocO, "HOST_tacaratu");
				Navegador.fecharNavegador();
			} catch (Exception e) {
				e.printStackTrace();
				int tn = JOptionPane.showConfirmDialog(null, "Falha ao tirar print! HOST_tacaratu - Deseja tentar novamente?");
				TelaPrincipal.frame.setVisible(false);
				if (tn == 1 || tn == 2) {
					fecharNavegador();
					TelaPrincipal.frame.setVisible(true);
				}else {
					decimaNonaTelaDocO(paginaDocOaberta);
				}
			}
	}
}
