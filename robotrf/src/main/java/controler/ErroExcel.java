package controler;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ErroExcel extends Thread { // Classe que trata mensagem de erro no Excel

	/*
	 * Caso ao tentar abrir um arquivo do excel, e o mesmo exibir mensagem de erro,
	 * este metodo seleciona o botão "SIM" para que o excel abra o arquivo mesmo com
	 * erro.
	 */
	// Atalho utilizado para dar "SIM" no excel é ALT+S.
	public void run() {
		try {
			Thread.sleep(5000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_ALT);
			r.keyRelease(KeyEvent.VK_S);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
