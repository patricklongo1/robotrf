package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

import controler.Navegador;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;


import java.awt.Dialog.ModalExclusionType;


public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	protected static JLabel lblTempoReal = null;
	private JPanel pnlPrincipal;
	public static TelaPrincipal frame = new TelaPrincipal();
	private JTextField txtMonitoramentoDoWebservice;
	private JTextField txtMonitoramentoDaConsulta;
	private JTextField txtMonitoramentoDaExtrao;
	private JTextField txtMonitoramentoDaConsulta_1;
	private JTextField txtMonitoramentoDaGerao;
	private JTextField txtMonitoramentoDoTrfpush;
	private JTextField txtMonitoramentoDasConsultas;
	private JTextField txtMonitoramentoDasConsultas_1;
	private JTextField txtMonitoramentoDasConsultas_2;
	private JTextField txtMonitoramentoDosAcessos;
	private JTextField txtMonitoramentoAtualizaoDo;
	private JTextField txtMonitoramentoAtualizaoDo_1;
	private JTextField txtMonitorarRegistroDe;
	private JTextField txtMonitoramentoDosServidores;
	private JTextField txtMonitoramentoDosLogs;
	private JTextField txtMonitoramentoEmitir;
	private JTextField txtMonitoramentoDaConsulta_2;
	private JTextField txtMonitoramentoDaGerao_1;
	private JTextField txtMonitoramentoDoSistema;;
	public static Thread thread;
	public static String tempoReal;
	public static boolean rodando;
	public static JLabel lblAlarme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setRootPaneCheckingEnabled(false);
					relogioAlarme();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			deletaArquivosDownload();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tribunal Regional Federal\t");
		setBounds(100, 100, 1150, 700);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBackground(new Color(255, 255, 255));
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setBounds(882, 34, 2, 613);
		pnlPrincipal.add(separator);

		JLabel lblOrdemDeExecuo = new JLabel("ORDEM DE EXECUÇÃO");
		lblOrdemDeExecuo.setBackground(new Color(255, 255, 255));
		lblOrdemDeExecuo.setBounds(894, 13, 147, 16);
		pnlPrincipal.add(lblOrdemDeExecuo);
		lblOrdemDeExecuo.setForeground(Color.BLACK);
		lblOrdemDeExecuo.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel faixaFundo = new JPanel();
		faixaFundo.setBounds(10, 651, 1124, 14);
		pnlPrincipal.add(faixaFundo);
		faixaFundo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		faixaFundo.setBackground(Color.ORANGE);
		faixaFundo.setLayout(null);

		JPanel pnlDocs = new JPanel();
		pnlDocs.setBackground(new Color(255, 255, 255));
		pnlDocs.setBounds(30, 34, 842, 606);
		pnlPrincipal.add(pnlDocs);
		pnlDocs.setLayout(null);

		// BOTÕES INDIVIDUAIS
		// *******************************************************************************
		// ***************************************************************************************************
		JButton btnA = new JButton("A");
		btnA.setBounds(0, 0, 50, 21);
		pnlDocs.add(btnA);
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnC = new JButton("C");
		btnC.setBounds(0, 31, 50, 21);
		pnlDocs.add(btnC);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnD = new JButton("D");
		btnD.setBounds(0, 63, 50, 21);
		pnlDocs.add(btnD);
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnE = new JButton("E");
		btnE.setBounds(0, 95, 50, 21);
		pnlDocs.add(btnE);
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnF = new JButton("F");
		btnF.setBounds(0, 127, 50, 21);
		pnlDocs.add(btnF);
		btnF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnG = new JButton("G");
		btnG.setBounds(0, 159, 50, 21);
		pnlDocs.add(btnG);
		btnG.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnH = new JButton("H");
		btnH.setBounds(0, 191, 50, 21);
		pnlDocs.add(btnH);
		btnH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnI = new JButton("I");
		btnI.setBounds(0, 223, 50, 21);
		pnlDocs.add(btnI);
		btnI.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnJ = new JButton("J");
		btnJ.setBounds(0, 255, 50, 21);
		pnlDocs.add(btnJ);
		btnJ.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnK = new JButton("K");
		btnK.setBounds(0, 289, 50, 21);
		pnlDocs.add(btnK);
		btnK.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnL = new JButton("L");
		btnL.setBounds(0, 321, 50, 21);
		pnlDocs.add(btnL);
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnM = new JButton("M");
		btnM.setBounds(0, 353, 50, 21);
		pnlDocs.add(btnM);
		btnM.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnN = new JButton("N");
		btnN.setBounds(0, 385, 50, 21);
		pnlDocs.add(btnN);
		btnN.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnO = new JButton("O");
		btnO.setBounds(0, 417, 50, 21);
		pnlDocs.add(btnO);
		btnO.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnP = new JButton("P");
		btnP.setBounds(0, 451, 50, 21);
		pnlDocs.add(btnP);
		btnP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnQ = new JButton("Q");
		btnQ.setBounds(0, 483, 50, 21);
		pnlDocs.add(btnQ);
		btnQ.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnR = new JButton("R");
		btnR.setBounds(0, 515, 50, 21);
		pnlDocs.add(btnR);
		btnR.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnS = new JButton("S");
		btnS.setBounds(0, 547, 50, 21);
		pnlDocs.add(btnS);
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// ***************************************************************************************************
		JButton btnU = new JButton("U");
		btnU.setBounds(0, 579, 50, 21);
		pnlDocs.add(btnU);
		btnU.setFont(new Font("Tahoma", Font.PLAIN, 10));

		txtMonitoramentoDoWebservice = new JTextField();
		txtMonitoramentoDoWebservice.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDoWebservice.setBounds(60, 0, 772, 20);
		pnlDocs.add(txtMonitoramentoDoWebservice);
		txtMonitoramentoDoWebservice.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDoWebservice.setEditable(false);
		txtMonitoramentoDoWebservice.setText("Monitoramento do WebService do SARH");
		txtMonitoramentoDoWebservice.setColumns(10);

		txtMonitoramentoDaConsulta = new JTextField();
		txtMonitoramentoDaConsulta.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDaConsulta.setBounds(60, 31, 772, 20);
		pnlDocs.add(txtMonitoramentoDaConsulta);
		txtMonitoramentoDaConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDaConsulta.setText("Monitoramento da consulta processual/RPV/Precatório (WEB)");
		txtMonitoramentoDaConsulta.setEditable(false);
		txtMonitoramentoDaConsulta.setColumns(10);

		txtMonitoramentoDaExtrao = new JTextField();
		txtMonitoramentoDaExtrao.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDaExtrao.setBounds(60, 63, 772, 20);
		pnlDocs.add(txtMonitoramentoDaExtrao);
		txtMonitoramentoDaExtrao.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDaExtrao.setText("Monitoramento da Extração e consulta à atas de distribuição de processos");
		txtMonitoramentoDaExtrao.setEditable(false);
		txtMonitoramentoDaExtrao.setColumns(10);

		txtMonitoramentoDaConsulta_1 = new JTextField();
		txtMonitoramentoDaConsulta_1.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDaConsulta_1.setBounds(60, 95, 772, 20);
		pnlDocs.add(txtMonitoramentoDaConsulta_1);
		txtMonitoramentoDaConsulta_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDaConsulta_1.setText("Monitoramento da Consulta à jurisprudência (Web)");
		txtMonitoramentoDaConsulta_1.setEditable(false);
		txtMonitoramentoDaConsulta_1.setColumns(10);

		txtMonitoramentoDaGerao = new JTextField();
		txtMonitoramentoDaGerao.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDaGerao.setBounds(60, 127, 772, 20);
		pnlDocs.add(txtMonitoramentoDaGerao);
		txtMonitoramentoDaGerao.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDaGerao.setText("Monitoramento da Geração e consulta ao Inteiro Teor de Acórdãos (WEB)");
		txtMonitoramentoDaGerao.setEditable(false);
		txtMonitoramentoDaGerao.setColumns(10);

		txtMonitoramentoDoTrfpush = new JTextField();
		txtMonitoramentoDoTrfpush.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDoTrfpush.setBounds(60, 159, 772, 20);
		pnlDocs.add(txtMonitoramentoDoTrfpush);
		txtMonitoramentoDoTrfpush.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDoTrfpush.setText("Monitoramento do TRF5Push");
		txtMonitoramentoDoTrfpush.setEditable(false);
		txtMonitoramentoDoTrfpush.setColumns(10);

		txtMonitoramentoDasConsultas = new JTextField();
		txtMonitoramentoDasConsultas.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDasConsultas.setBounds(60, 191, 772, 20);
		pnlDocs.add(txtMonitoramentoDasConsultas);
		txtMonitoramentoDasConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDasConsultas.setText("Monitoramento das consultas processuais unificadas (WEB)");
		txtMonitoramentoDasConsultas.setEditable(false);
		txtMonitoramentoDasConsultas.setColumns(10);

		txtMonitoramentoDasConsultas_1 = new JTextField();
		txtMonitoramentoDasConsultas_1.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDasConsultas_1.setBounds(60, 223, 772, 20);
		pnlDocs.add(txtMonitoramentoDasConsultas_1);
		txtMonitoramentoDasConsultas_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDasConsultas_1.setText("Monitoramento das consultas dos beneficiários da lei 9.099");
		txtMonitoramentoDasConsultas_1.setEditable(false);
		txtMonitoramentoDasConsultas_1.setColumns(10);

		txtMonitoramentoDasConsultas_2 = new JTextField();
		txtMonitoramentoDasConsultas_2.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDasConsultas_2.setBounds(60, 255, 772, 20);
		pnlDocs.add(txtMonitoramentoDasConsultas_2);
		txtMonitoramentoDasConsultas_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDasConsultas_2.setText(
				"Monitoramento das consultas, Pautas de Julgamento, Decisoes do Conselho de Adminstração, EAD JF5");
		txtMonitoramentoDasConsultas_2.setEditable(false);
		txtMonitoramentoDasConsultas_2.setColumns(10);

		txtMonitoramentoDosAcessos = new JTextField();
		txtMonitoramentoDosAcessos.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDosAcessos.setBounds(60, 289, 772, 20);
		pnlDocs.add(txtMonitoramentoDosAcessos);
		txtMonitoramentoDosAcessos.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDosAcessos.setText(
				"Monitoramento dos acessos Monitoramento da Consulta, IRDR, Fale Conosco, Organograma, Pergamun, Sustentação Oral ");
		txtMonitoramentoDosAcessos.setEditable(false);
		txtMonitoramentoDosAcessos.setColumns(10);

		txtMonitoramentoAtualizaoDo = new JTextField();
		txtMonitoramentoAtualizaoDo.setBackground(new Color(255, 255, 255));
		txtMonitoramentoAtualizaoDo.setBounds(60, 321, 772, 20);
		pnlDocs.add(txtMonitoramentoAtualizaoDo);
		txtMonitoramentoAtualizaoDo.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoAtualizaoDo.setText("Monitoramento atualização do Portal da Intranet");
		txtMonitoramentoAtualizaoDo.setEditable(false);
		txtMonitoramentoAtualizaoDo.setColumns(10);

		txtMonitoramentoAtualizaoDo_1 = new JTextField();
		txtMonitoramentoAtualizaoDo_1.setBackground(new Color(255, 255, 255));
		txtMonitoramentoAtualizaoDo_1.setBounds(60, 353, 772, 20);
		pnlDocs.add(txtMonitoramentoAtualizaoDo_1);
		txtMonitoramentoAtualizaoDo_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoAtualizaoDo_1.setText("Monitoramento atualização do Portal Internet");
		txtMonitoramentoAtualizaoDo_1.setEditable(false);
		txtMonitoramentoAtualizaoDo_1.setColumns(10);

		txtMonitorarRegistroDe = new JTextField();
		txtMonitorarRegistroDe.setBackground(new Color(255, 255, 255));
		txtMonitorarRegistroDe.setBounds(60, 385, 772, 20);
		pnlDocs.add(txtMonitorarRegistroDe);
		txtMonitorarRegistroDe.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitorarRegistroDe.setText("Monitorar registro de log dos Sistemas e Servidores de Aplicação");
		txtMonitorarRegistroDe.setEditable(false);
		txtMonitorarRegistroDe.setColumns(10);

		txtMonitoramentoDosServidores = new JTextField();
		txtMonitoramentoDosServidores.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDosServidores.setBounds(60, 417, 772, 20);
		pnlDocs.add(txtMonitoramentoDosServidores);
		txtMonitoramentoDosServidores.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDosServidores.setText("Monitoramento dos servidores de aplicação");
		txtMonitoramentoDosServidores.setEditable(false);
		txtMonitoramentoDosServidores.setColumns(10);

		txtMonitoramentoDosLogs = new JTextField();
		txtMonitoramentoDosLogs.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDosLogs.setBounds(60, 451, 772, 20);
		pnlDocs.add(txtMonitoramentoDosLogs);
		txtMonitoramentoDosLogs.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDosLogs.setText("Monitoramento dos logs SARH - Fluxus Produção e Alagoas");
		txtMonitoramentoDosLogs.setEditable(false);
		txtMonitoramentoDosLogs.setColumns(10);

		txtMonitoramentoEmitir = new JTextField();
		txtMonitoramentoEmitir.setBackground(new Color(255, 255, 255));
		txtMonitoramentoEmitir.setBounds(60, 483, 772, 20);
		pnlDocs.add(txtMonitoramentoEmitir);
		txtMonitoramentoEmitir.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoEmitir.setText("Monitoramento - Emitir Certidões - Eleitoral");
		txtMonitoramentoEmitir.setEditable(false);
		txtMonitoramentoEmitir.setColumns(10);

		txtMonitoramentoDaConsulta_2 = new JTextField();
		txtMonitoramentoDaConsulta_2.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDaConsulta_2.setBounds(60, 515, 772, 20);
		pnlDocs.add(txtMonitoramentoDaConsulta_2);
		txtMonitoramentoDaConsulta_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDaConsulta_2.setText("Monitoramento da Consulta Intimações Eletrônicas Pje");
		txtMonitoramentoDaConsulta_2.setEditable(false);
		txtMonitoramentoDaConsulta_2.setColumns(10);

		txtMonitoramentoDaGerao_1 = new JTextField();
		txtMonitoramentoDaGerao_1.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDaGerao_1.setBounds(60, 547, 772, 20);
		pnlDocs.add(txtMonitoramentoDaGerao_1);
		txtMonitoramentoDaGerao_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDaGerao_1.setText(
				"Monitoramento da geração das Estatisticas CJF, Estatisticas do Segundo Grau, Jurisdição e SICOM");
		txtMonitoramentoDaGerao_1.setEditable(false);
		txtMonitoramentoDaGerao_1.setColumns(10);

		txtMonitoramentoDoSistema = new JTextField();
		txtMonitoramentoDoSistema.setBackground(new Color(255, 255, 255));
		txtMonitoramentoDoSistema.setBounds(60, 579, 772, 20);
		pnlDocs.add(txtMonitoramentoDoSistema);
		txtMonitoramentoDoSistema.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonitoramentoDoSistema.setText("Monitoramento do Sistema SEI");
		txtMonitoramentoDoSistema.setEditable(false);
		txtMonitoramentoDoSistema.setColumns(10);
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoU.inicioDocU();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoS.inicioDocS();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoR.inicioDocR();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoQ.inicioDocQ();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoP.inicioDocP();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoO.inicioDocO();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					// DocumentoN.inicioDocN();
					Navegador.fecharNavegador();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoM.inicioDocM();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoL.inicioDocL();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoK.inicioDocK();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoJ.inicioDocJ();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoI.inicioDocI();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoH.inicioDocH();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoG.inicioDocG();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoF.inicioDocF();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoE.inicioDocE();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoD.inicioDocD();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoC.inicioDocC();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoA.inicioDocA();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception e2) {
					e2.printStackTrace();
					Telas.telaErro();

				}
			}
		});

		JPanel FaixaLateral = new JPanel();
		FaixaLateral.setBounds(0, 0, 20, 665);
		pnlPrincipal.add(FaixaLateral);
		FaixaLateral.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		FaixaLateral.setBackground(new Color(25, 25, 112));
		FaixaLateral.setLayout(null);

		JPanel pnlOrdemExecucao = new JPanel();
		pnlOrdemExecucao.setBounds(894, 34, 240, 606);
		pnlPrincipal.add(pnlOrdemExecucao);
		pnlOrdemExecucao.setBackground(new Color(255, 255, 255));
		pnlOrdemExecucao.setLayout(null);

		JButton btnOe1 = new JButton("A | C | H | Q | R | U");
		btnOe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoA.inicioDocA();
					Navegador.fecharNavegador();
					DocumentoC.inicioDocC();
					DocumentoH.inicioDocH();
					DocumentoQ.inicioDocQ();
					DocumentoR.inicioDocR();
					DocumentoU.inicioDocU();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe1.setBounds(80, 0, 150, 21);
		pnlOrdemExecucao.add(btnOe1);
		btnOe1.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe02 = new JButton("D");
		btnOe02.setEnabled(false);
		btnOe02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoD.inicioDocD();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe02.setBounds(80, 32, 150, 21);
		pnlOrdemExecucao.add(btnOe02);
		btnOe02.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe03 = new JButton("E");
		btnOe03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoE.inicioDocE();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe03.setBounds(80, 64, 150, 21);
		pnlOrdemExecucao.add(btnOe03);
		btnOe03.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe04 = new JButton("F | G");
		btnOe04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					rodando = true;
					DocumentoF.inicioDocF();
					DocumentoG.inicioDocG();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe04.setBounds(80, 96, 150, 21);
		pnlOrdemExecucao.add(btnOe04);
		btnOe04.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe05 = new JButton("I | J | K | S | U");
		btnOe05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoI.inicioDocI();
					DocumentoJ.inicioDocJ();
					DocumentoK.inicioDocK();
					DocumentoS.inicioDocS();
					DocumentoU.inicioDocU();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe05.setBounds(80, 128, 150, 21);
		pnlOrdemExecucao.add(btnOe05);
		btnOe05.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe06 = new JButton("L | M");
		btnOe06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoL.inicioDocL();
					DocumentoM.inicioDocM();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe06.setBounds(80, 160, 150, 21);
		pnlOrdemExecucao.add(btnOe06);
		btnOe06.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe07 = new JButton("A | C | H | Q | R | U");
		btnOe07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoA.inicioDocA();
					DocumentoC.inicioDocC();
					DocumentoH.inicioDocH();
					DocumentoQ.inicioDocQ();
					DocumentoR.inicioDocR();
					DocumentoU.inicioDocU();
					frame.setVisible(true);
					Telas.telaConcluido();
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}

			}
		});
		btnOe07.setBounds(80, 192, 150, 21);
		pnlOrdemExecucao.add(btnOe07);
		btnOe07.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe08 = new JButton("N");
		btnOe08.setEnabled(false);
		btnOe08.setBounds(80, 224, 150, 21);
		pnlOrdemExecucao.add(btnOe08);
		btnOe08.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe09 = new JButton("O");
		btnOe09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoO.inicioDocO();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe09.setBounds(80, 256, 150, 21);
		pnlOrdemExecucao.add(btnOe09);
		btnOe09.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe10 = new JButton("A | C | H | Q | R | U");
		btnOe10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoA.inicioDocA();
					DocumentoC.inicioDocC();
					DocumentoH.inicioDocH();
					DocumentoQ.inicioDocQ();
					DocumentoR.inicioDocR();
					DocumentoU.inicioDocU();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe10.setBounds(80, 288, 150, 21);
		pnlOrdemExecucao.add(btnOe10);
		btnOe10.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe11 = new JButton("A | C | H | Q | R | U");
		btnOe11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoA.inicioDocA();
					DocumentoC.inicioDocC();
					DocumentoH.inicioDocH();
					DocumentoQ.inicioDocQ();
					DocumentoR.inicioDocR();
					DocumentoU.inicioDocU();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe11.setBounds(80, 320, 150, 21);
		pnlOrdemExecucao.add(btnOe11);
		btnOe11.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe12 = new JButton("P");
		btnOe12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoP.inicioDocP();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe12.setBounds(80, 352, 150, 21);
		pnlOrdemExecucao.add(btnOe12);
		btnOe12.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JButton btnOe13 = new JButton("A | C | H | Q | R | E | U");
		btnOe13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rodando = true;
					DocumentoA.inicioDocA();
					DocumentoC.inicioDocC();
					DocumentoH.inicioDocH();
					DocumentoQ.inicioDocQ();
					DocumentoR.inicioDocR();
					DocumentoU.inicioDocU();
					Telas.telaConcluido();
					frame.setVisible(true);
					rodando = false;
				} catch (Exception erro) {
					erro.printStackTrace();
					Telas.telaErro();
				}
			}
		});
		btnOe13.setBounds(80, 384, 150, 21);
		pnlOrdemExecucao.add(btnOe13);
		btnOe13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		// FIM DOS BOTÕES
		// AGRUPADOS***************************************************************************
		// ***************************************************************************************************

		JLabel label = new JLabel("08:00/20:00");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(0, 0, 70, 14);
		pnlOrdemExecucao.add(label);

		JLabel label_1 = new JLabel("08:30/20:30");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(0, 32, 70, 14);
		pnlOrdemExecucao.add(label_1);

		JLabel label_2 = new JLabel("09:00/21:00");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(0, 64, 70, 14);
		pnlOrdemExecucao.add(label_2);

		JLabel label_3 = new JLabel("09:00/21:40");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(0, 96, 70, 14);
		pnlOrdemExecucao.add(label_3);

		JLabel label_4 = new JLabel("10:00/22:00");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(0, 129, 70, 14);
		pnlOrdemExecucao.add(label_4);

		JLabel label_5 = new JLabel("11:00/23:00");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(0, 160, 70, 14);
		pnlOrdemExecucao.add(label_5);

		JLabel label_6 = new JLabel("12:00/00:00");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(0, 194, 70, 14);
		pnlOrdemExecucao.add(label_6);

		JLabel label_7 = new JLabel("12:30/00:30");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(0, 226, 70, 14);
		pnlOrdemExecucao.add(label_7);

		JLabel label_8 = new JLabel("13:00/01:00");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(0, 258, 70, 14);
		pnlOrdemExecucao.add(label_8);

		JLabel label_9 = new JLabel("14:00/02:00");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(0, 290, 70, 14);
		pnlOrdemExecucao.add(label_9);

		JLabel label_10 = new JLabel("16:00/04:00");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(0, 322, 70, 14);
		pnlOrdemExecucao.add(label_10);

		JLabel label_11 = new JLabel("17:50/05:50");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(0, 354, 70, 14);
		pnlOrdemExecucao.add(label_11);

		JLabel label_12 = new JLabel("18:00/06:00");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_12.setBounds(0, 386, 70, 14);
		pnlOrdemExecucao.add(label_12);

		lblTempoReal = new JLabel();
		lblTempoReal.setText("00:00:00");
		lblTempoReal.setForeground(new Color(0, 0, 128));
		lblTempoReal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTempoReal.setBounds(95, 581, 70, 14);
		pnlOrdemExecucao.add(lblTempoReal);

		JButton btnDetalhamentoAtividades = new JButton("Detalhamento atividades");
		btnDetalhamentoAtividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOrdemExecucao tela = new TelaOrdemExecucao();
				tela.frame.setVisible(true);
			}
		});
		btnDetalhamentoAtividades.setBounds(21, 433, 197, 23);
		pnlOrdemExecucao.add(btnDetalhamentoAtividades);

		JButton btnAtivarAlarme = new JButton("Desativar alarme");
		btnAtivarAlarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeBotao = btnAtivarAlarme.getText();
				if (nomeBotao.equalsIgnoreCase("Desativar Alarme")) {
					rodando = true;
					relogioAlarme();
					btnAtivarAlarme.setText("Ativar Alarme");
					lblAlarme.setText("Alarme Desativado");
					lblAlarme.setForeground(Color.red);
					
				}else if (nomeBotao.equalsIgnoreCase("Ativar Alarme")) {
					rodando = false;
					relogioAlarme();
					btnAtivarAlarme.setText("Desativar Alarme");
					lblAlarme.setText("Alarme Ativado");
					lblAlarme.setForeground(new Color(0, 128, 0));
				}

			}

		});
		btnAtivarAlarme.setBounds(21, 467, 197, 23);
		pnlOrdemExecucao.add(btnAtivarAlarme);
		
		lblAlarme = new JLabel("Alarme Ativado !");
		lblAlarme.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlarme.setForeground(new Color(0, 128, 0));
		lblAlarme.setBounds(21, 541, 150, 14);
		pnlOrdemExecucao.add(lblAlarme);

		JLabel lblDocumentosETtulos = new JLabel("DOCUMENTOS E TÍTULOS");
		lblDocumentosETtulos.setForeground(Color.BLACK);
		lblDocumentosETtulos.setFont(new Font("Tahoma ", Font.BOLD, 12));
		lblDocumentosETtulos.setBounds(30, 13, 240, 16);
		pnlPrincipal.add(lblDocumentosETtulos);

	}

	public static void relogioAlarme() {
		// Relógio
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(new Runnable() {
			public void run() {
				tempoReal = (new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lblTempoReal.setText(tempoReal);
				
				String vetorHora[] = { "00:00:00", "01:00:00", "02:00:00", "04:00:00", "05:50:00", "06:00:00",
						"08:00:00", "09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00", "16:00:00",
						"17:50:00", "18:00:00", "20:00:00", "21:00:00", "21:40:00", "22:00:00", "23:00:00" };

				if (rodando == false) {
					if (tempoReal.equalsIgnoreCase(vetorHora[0]) || tempoReal.equalsIgnoreCase(vetorHora[1])
							|| tempoReal.equalsIgnoreCase(vetorHora[2]) || tempoReal.equalsIgnoreCase(vetorHora[3])
							|| tempoReal.equalsIgnoreCase(vetorHora[4]) || tempoReal.equalsIgnoreCase(vetorHora[5])
							|| tempoReal.equalsIgnoreCase(vetorHora[6]) || tempoReal.equalsIgnoreCase(vetorHora[7])
							|| tempoReal.equalsIgnoreCase(vetorHora[8]) || tempoReal.equalsIgnoreCase(vetorHora[9])
							|| tempoReal.equalsIgnoreCase(vetorHora[10]) || tempoReal.equalsIgnoreCase(vetorHora[11])
							|| tempoReal.equalsIgnoreCase(vetorHora[12]) || tempoReal.equalsIgnoreCase(vetorHora[13])
							|| tempoReal.equalsIgnoreCase(vetorHora[14]) || tempoReal.equalsIgnoreCase(vetorHora[15])
							|| tempoReal.equalsIgnoreCase(vetorHora[16]) || tempoReal.equalsIgnoreCase(vetorHora[17])
							|| tempoReal.equalsIgnoreCase(vetorHora[18]) || tempoReal.equalsIgnoreCase(vetorHora[19])
							|| tempoReal.equalsIgnoreCase(vetorHora[20])) {
						try {
							Telas.telaAlarme();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}

			}

		}, 1, 1, TimeUnit.SECONDS); // Add 1 segundo na unidade de tempo

	}
	
	public static void deletaArquivosDownload() throws IOException {
		File folder = new File("C:\\Automação TRF5\\Downloads TRF5");
		if (folder.isDirectory()) {
			File[] sun = folder.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
	}
}
