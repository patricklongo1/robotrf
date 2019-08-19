package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Telas extends TelaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void telaConcluido() throws InterruptedException {
		final JDialog dialog = new JDialog();
		JLabel mensagem = new JLabel("Execução finalizada", SwingConstants.CENTER);
		mensagem.setForeground(Color.black);
		dialog.setSize(300, 100);
		dialog.add(mensagem).setLocation(1000, 500);
		dialog.setLocationRelativeTo(null);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		dialog.setModalityType(JDialog.ModalityType.MODELESS);
		dialog.setBackground(Color.white);
		ScheduledExecutorService sch = Executors.newSingleThreadScheduledExecutor();
		sch.schedule(new Runnable() {
			public void run() {
				dialog.setVisible(false);
				dialog.dispose();
			}
		}, 4, TimeUnit.SECONDS);

	}

	public static void telaErro() {
		final JDialog dialog = new JDialog();
		JLabel mensagem = new JLabel("Execução apresentou erro, repita a operação ou abra chamado",
				SwingConstants.CENTER);
		mensagem.setForeground(Color.black);
		dialog.setSize(500, 100);
		dialog.add(mensagem).setLocation(1000, 500);
		dialog.setLocationRelativeTo(null);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		dialog.setModalityType(JDialog.ModalityType.MODELESS);
		dialog.setBackground(Color.white);
		ScheduledExecutorService sch = Executors.newSingleThreadScheduledExecutor();
		sch.schedule(new Runnable() {
			public void run() {
				dialog.setVisible(false);
				dialog.dispose();
			}
		}, 4, TimeUnit.SECONDS);

	}

	public static void telaAlarme() throws InterruptedException {

		final JDialog dialog = new JDialog();
		JLabel mensagem = new JLabel("Hora da execução, favor consultar próxima rotina ", SwingConstants.CENTER);
		mensagem.setForeground(Color.black);
		dialog.setSize(350, 150);
		dialog.add(mensagem).setLocation(1000, 500);
		dialog.setLocationRelativeTo(null);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		dialog.setModalityType(JDialog.ModalityType.MODELESS);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		String nomeAudio = "alarme (2)";
		URL url = TelaPrincipal.class.getResource(nomeAudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();

	}
}