package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaOrdemExecucao {

	public static JFrame frame = new JFrame();
	private JTextField txtTitulo;
	private JTextField txtDesc;
	private JTextField txtAnexos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaOrdemExecucao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 128));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("A")) {
					txtTitulo.setText("Monitoramento do WebService do SARH");
					txtDesc.setText("Colher a evidencia do XML");
					txtAnexos.setText("WSSARH");
				} else if (comboBox.getSelectedItem().equals("C")) {
					txtTitulo.setText("Monitoramento da Consulta Processual/RPV/Precatório (WEB)");
					txtDesc.setText("Averiguar se o serviço está funcionando normalmente");
					txtAnexos.setText("RPV , PRECATORIO , CONS_PROC");
				} else if (comboBox.getSelectedItem().equals("D")) {
					txtTitulo.setText("Monitoramento da Extração e consulta à atas de distribuição de processos");
					txtDesc.setText(
							"Averiguar se ocorreu a extração diária da Ata e se o Serviço de consulta está funcionando normalmente. Onde o serviço encontra-se em funcionamento.");
					txtAnexos.setText("ATA_DISTRIBUICAO");
				} else if (comboBox.getSelectedItem().equals("E")) {
					txtTitulo.setText("Monitoramento da Consulta à jurisprudência (Web)");
					txtDesc.setText("Averiguar se o serviço está funcionando normalmente.");
					txtAnexos.setText("JURIS_GERAL , JURIS_FISICO , JURIS_ELETRONICO");
				} else if (comboBox.getSelectedItem().equals("F")) {
					txtTitulo.setText("Monitoramento da Geração e consulta ao Inteiro Teor de Acórdãos (WEB)");
					txtDesc.setText(
							"Averiguar se ocorreu com sucesso a extração, conversão, transferência e indexação dos arquivos de Inteiro Teor dos Acórdãos disponibilizados na web.");
					txtAnexos.setText("INTEIRO_TEOR , EXTRACAO_ACORDAO");
				} else if (comboBox.getSelectedItem().equals("G")) {
					txtTitulo.setText("Monitoramento do TRF5Push");
					txtDesc.setText(
							"Monitorar o TRF5Push via web onde não foi detectado nenhum tipo de problema  e o serviço encontra-se disponível.");
					txtAnexos.setText("PUSH");
				} else if (comboBox.getSelectedItem().equals("H")) {
					txtTitulo.setText("Monitoramento das Consultas Processuais Unificadas (WEB)");
					txtDesc.setText(
							"Verificar se o serviço está funcionando normalmente via WEB, onde foi verificado que o mesmo encontra-se disponível no momento.");
					txtAnexos.setText("CP_UNIFICADA_PROC , CP_UNIFICADA_NOME , CP_UNIFICADA_OAB");
				} else if (comboBox.getSelectedItem().equals("I")) {
					txtTitulo.setText("Monitoramento das consultas dos beneficiários da lei 9.099");
					txtDesc.setText(
							"Monitoramento da Consulta de Beneficiários da Lei 9.099. Verificação do Status do Serviço: Ativo. Situação em funcionamento.");
					txtAnexos.setText("LEI9099");
				} else if (comboBox.getSelectedItem().equals("J")) {
					txtTitulo.setText(
							"Monitoramento das consultas, pautas de julgamento, decisões do conselho de administração, EAD JF5");
					txtDesc.setText(
							"Monitoramento das consultas, Pautas de Julgamento,Decisoes do Conselho de Adminstração, EAD JF5");
					txtAnexos.setText("PAUTA , DCA , EAD");
				} else if (comboBox.getSelectedItem().equals("K")) {
					txtTitulo.setText(
							"Monitoramento dos acessos Monitoramento da Consulta, IRDR, Fale Conosco, Organograma, Pergamun, Sustentação Oral");
					txtDesc.setText(
							"Verificar o funcionamento dos acessos dos sistemas de consulta, IRDR, Fale Conosco, Organograma, Pergamun, Sustentação Oral");
					txtAnexos.setText("ASSINATURA , IRDR , ORGAO , ORGANOGRAMA , PERGAMUN , SUSTENTACAO");
				} else if (comboBox.getSelectedItem().equals("L")) {
					txtTitulo.setText("Monitoramento atualização do Portal da Intranet");
					txtDesc.setText(
							"Verificar apresentação de informaçõesobsoletasou desatualizadas, especialmente quanto às seções de Clipping, Mural, Diários Oficiais, calendário de eventos, Avisos da página de abertura.");
					txtAnexos.setText("NOTICIA , MURAL , EVENTOS , DIARIO_JUD , DIARIO_ADMIN");
				} else if (comboBox.getSelectedItem().equals("M")) {
					txtTitulo.setText("Monitoramento atualização do Portal Internet");
					txtDesc.setText(
							"Verificar apresentação de informações obsoletas ou desatualizadas, especialmente quanto aos Avisos da Página de Abertura, Plantões da Judiciária, Faixa de RPV's e Precatórios a pagar.");
					txtAnexos.setText("INDEX , PLANTAO_JUD , PGTO_RPV , PGTO_PRECATORIO");
				} else if (comboBox.getSelectedItem().equals("N")) {
					txtTitulo.setText("Monitorar registro de log dos Sistemas e Servidores de Aplicação");
					txtDesc.setText(
							"Verificar ocorrência de anormalidades nos logs  e serviços no AIX, TSM,Nagios e  PROBE alertando  a equipe da cada qualquer problema.");
					txtAnexos.setText("LOG_parnamirim.trf5.gov.br");
				} else if (comboBox.getSelectedItem().equals("O")) {
					txtTitulo.setText("Monitoramento dos servidores de aplicação");
					txtDesc.setText("Monitoramento de Servidores de aplicação através do Nagios e Probe,verificando disponibilidade dos mesmos, passando para equipe da cada qualquer problema detectado em qualquer um dos servidores."
							);
					txtAnexos.setText("HOST_Canhotinho,HOST_Escada,HOST_Girard03,HOST_Girard04,HOST_Gravata,HOST_Fluxus,HOST_Itamaraca,HOST_maraial01,HOST_maraial02,HOST_maraial03,HOST_maraial04,HOST_maraial05,HOST_maraial06,HOST_maraial07,HOST_maraial08,HOST_moivre,HOST_morenoHOST_tacaratu"
							);
				} else if (comboBox.getSelectedItem().equals("P")) {
					txtTitulo.setText("Monitoramento do WebService do SARH");
					txtDesc.setText("Monitoramento do funcionamento das aplicações SARH - Fluxus Produção e Alagoas.");
					txtAnexos.setText(
							"LOG_TRF5.txt , LOG_JFAL.txt , LOG_JFCE.txt , LOG_JFPE.txt , LOG_JFSE.txt , LOG_JFRN.txt");
				} else if (comboBox.getSelectedItem().equals("Q")) {
					txtTitulo.setText("Monitoramento Sistema de Certidões");
					txtDesc.setText(
							"Monitorar através do Site a Certidão Eleitoral para que a mesma fique em pleno funcionamento.");
					txtAnexos.setText("CERTIDAO_ELEITORAL , CERTIDAO_DISTRIBUICAO , CERTIDAO_NEGATIVA");
				} else if (comboBox.getSelectedItem().equals("R")) {
					txtTitulo.setText("Monitoramento da Consulta Intimações Eletrônicas Pje");
					txtDesc.setText(
							"Verificar se o serviço de consulta de intimações está em pleno funcionamento via WEB.");
					txtAnexos.setText(
							"INTIMACOES_TRF5_,INTIMACOES_JFPE_,INTIMACOES_FJPB_,INTIMACOES_JFCE_,INTIMACOES_JFSE_,INTIMACOES_JFAL_,INTIMACOES_JFRN_");
				} else if (comboBox.getSelectedItem().equals("S")) {
					txtTitulo.setText(
							"Monitoramento das geração das estatisticas CJF do segundo grau jurisdição SICOM");
					txtDesc.setText(
							"Monitoramento da geração das Estatisticas CJF, Estatisticas do Segundo Grau, Jurisdição e SICOM.");
					txtAnexos.setText("EST1_SIM , EST1_DET , EST2_SIM , EST2_DET , DOCUM_EST , JURISDICAO , SICOM");
				} else if (comboBox.getSelectedItem().equals("U")) {
					txtTitulo.setText("Monitoramento sistema SEI");
					txtDesc.setText("Verificar a disponibilidade do sistema SEI em ambiente de Produção.");
					txtAnexos.setText("USUARIO_INTERNO, USUARIO_EXTERNO");
				} else {
					txtTitulo.setText("Aguardando seleção");
					txtDesc.setText("Aguardando seleção");
					txtAnexos.setText("Aguardando seleção");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "<Selecione um documento>", "A", "C", "D", "E", "F",
				"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "U" }));
		comboBox.setBounds(10, 28, 220, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblTtulo = new JLabel("Título:");
		lblTtulo.setForeground(new Color(0, 0, 128));
		lblTtulo.setBounds(257, 31, 63, 14);
		frame.getContentPane().add(lblTtulo);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setForeground(new Color(0, 0, 128));
		lblDescrio.setBounds(257, 56, 63, 14);
		frame.getContentPane().add(lblDescrio);

		JLabel lblAnexos = new JLabel("Anexos:");
		lblAnexos.setForeground(new Color(0, 0, 128));
		lblAnexos.setBounds(257, 81, 63, 14);
		frame.getContentPane().add(lblAnexos);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(330, 28, 803, 20);
		frame.getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDesc.setEditable(false);
		txtDesc.setColumns(10);
		txtDesc.setBounds(330, 53, 803, 20);
		frame.getContentPane().add(txtDesc);

		txtAnexos = new JTextField();
		txtAnexos.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAnexos.setEditable(false);
		txtAnexos.setColumns(10);
		txtAnexos.setBounds(330, 78, 803, 20);
		frame.getContentPane().add(txtAnexos);
		
		JLabel lblSelecioneODocumento = new JLabel("DOCUMENTOS :");
		lblSelecioneODocumento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelecioneODocumento.setForeground(new Color(0, 0, 128));
		lblSelecioneODocumento.setBounds(10, 11, 220, 14);
		frame.getContentPane().add(lblSelecioneODocumento);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1159, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
