package controler;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.automatedowl.tools.SeleniumDownloadKPI;

public class Navegador { // Classe utilizada para manipulação de métodos que rodam dentro do navegador,
							// recebendo parametros das classes de DOC.
	
	public static String caminho;
	private static WebDriver navAberto;

	// Getters and Setters
	public static String getCaminho() {
		return caminho;
	}
	public static void setCaminho(String caminho) {
		Navegador.caminho = caminho;
	}
//------------------------------------------------------------------------------------------------------
	// Metodos
	public static WebDriver abrirNavegador(String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Automação TRF5\\Drivers Navegadores\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			SeleniumDownloadKPI seleniumDownloadKPI = new SeleniumDownloadKPI("C:\\Automação TRF5\\Downloads TRF5");
			chromeOptions = seleniumDownloadKPI.generateDownloadFolderCapability();
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			@SuppressWarnings("deprecation")
			WebDriver navegador = new ChromeDriver(desiredCapabilities);
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			navegador.manage().window().maximize();
			navegador.get(url);
			navAberto = navegador;
			return navAberto;
		} catch (Exception e) { 
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Falha ao acessar a página. Verifique se o seu Chrome está devidamente instalado, "
							+ "								e se há conexão com a internet!");
			return null;
		}
	}

	public static void criarDiretorio() { // Metodo que cria diretorio no C:
		try {
			
			Date date = Calendar.getInstance().getTime();
			SimpleDateFormat ano = new SimpleDateFormat("yyyy");
			SimpleDateFormat mes = new SimpleDateFormat("MM");
			SimpleDateFormat dia = new SimpleDateFormat("dd");
			SimpleDateFormat hora = new SimpleDateFormat("HH");
			SimpleDateFormat minuto = new SimpleDateFormat("mm");
			// SimpleDateFormat segundo = new SimpleDateFormat("ss");
			// SimpleDateFormat anoReduzido = new SimpleDateFormat("yy");
			// SimpleDateFormat mesExtenso = new SimpleDateFormat("MMMM");
			Calendar c1 = Calendar.getInstance();
			int mesNome = c1.get(Calendar.MONTH);
			String mesString;
			if (mesNome == 0) {
				mesString = "Janeiro";
			} else if (mesNome == 1) {
				mesString = "Fevereiro";
			} else if (mesNome == 2) {
				mesString = "Março";
			} else if (mesNome == 3) {
				mesString = "Abril";
			} else if (mesNome == 4) {
				mesString = "Maio";
			} else if (mesNome == 5) {
				mesString = "Junho";
			} else if (mesNome == 6) {
				mesString = "Julho";
			} else if (mesNome == 7) {
				mesString = "Agosto";
			} else if (mesNome == 8) {
				mesString = "Setembro";
			} else if (mesNome == 9) {
				mesString = "Outubro";
			} else if (mesNome == 10) {
				mesString = "Novembro";
			} else {
				mesString = "Dezembro"; 
			}

			String dataAtual = "C:\\" + "Automação TRF5\\" + ano.format(date) + "\\" + mes.format(date) + " - " +mesString + "\\" + dia.format(date) + "\\"
					+ hora.format(date) + "-" + minuto.format(date) + "\\";
			caminho = dataAtual;
			File diretorio = new File(caminho);
			diretorio.mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao criar diretório. Verifique se há espaço no disco rígido C: ");
		}
	}

	public static void tirarPrint(WebDriver webDriver, String nomeArquivo) { // Metodo que printa tela atual do
																				// navegador e salva no
		// diretorio criado pelo metodo criarDiretorio()
		try {
			File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(caminho + nomeArquivo + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao salvar print no diretório. Contate o ADM do Robo!");
		}
	}

	public static void tirarPrint2(String nomeArquivo) throws AWTException, IOException { // Metodo que tira print da
																							// tela (Desktop e não
																							// navegador) para printar
																							// arquivos Excel.
		int y = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = Toolkit.getDefaultToolkit().getScreenSize().height;
		Robot bot = new Robot();
		BufferedImage print = bot.createScreenCapture(new Rectangle(y, x));
		ImageIO.write(print, "JPG", new File(caminho + nomeArquivo + ".jpeg"));
	}

	public static void fecharNavegador() {
		navAberto.quit();
	}

	String oldTab = navAberto.getWindowHandle();

	public static void controlarNovaAba(WebDriver driver, String oldTab) {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public static void fecharAbas(WebDriver webDriver) {
		try {
			Set<String> windows = webDriver.getWindowHandles();
			Iterator<String> iter = windows.iterator();
			String[] winNames = new String[windows.size()];
			int i = 0;
			while (iter.hasNext()) {
				winNames[i] = iter.next();
				i++;
			}
			if (winNames.length > 1) {
				for (i = winNames.length; i > 1; i--) {
					webDriver.switchTo().window(winNames[i - 1]);
					webDriver.close();
				}
			}
			webDriver.switchTo().window(winNames[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void criarRelatorio(String nomeArq, String texto) {
		FileWriter arquivo;

		try {
			arquivo = new FileWriter(new File(caminho + nomeArq + ".txt"));
			arquivo.write(texto);
			arquivo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(caminho);
	}
}