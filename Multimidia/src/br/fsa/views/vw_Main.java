package br.fsa.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.LayeredHighlighter;

import br.fsa.atividade.Ex1;
import br.fsa.utils.Imagem;
import br.fsa.utils.Frame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;

public class vw_Main {

	private JFrame frmEditorDeImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch(Exception e) {
	        System.out.println("Erro ao configurar o Look and Feel: " + e);
	    }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vw_Main window = new vw_Main();
					window.frmEditorDeImagem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vw_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmEditorDeImagem = new JFrame();
		frmEditorDeImagem.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmEditorDeImagem.setTitle("Editor de Imagem Java");
		frmEditorDeImagem.setBounds(100, 100, 800, 600);
		frmEditorDeImagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmEditorDeImagem.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mnArquivoAbrir = new JMenuItem("Abrir");

		mnArquivo.add(mnArquivoAbrir);

		JMenu mnFiltros = new JMenu("Filtros");
		menuBar.add(mnFiltros);
		
		JMenuItem mnFiltrosMedia4 = new JMenuItem("Média 4");
		mnFiltros.add(mnFiltrosMedia4);


		JMenuItem mnFiltrosMediar = new JMenuItem("Média R");
		mnFiltros.add(mnFiltrosMediar);
		
		JMenuItem mnFiltrosMediana4 = new JMenuItem("Mediana 4");
		mnFiltros.add(mnFiltrosMediana4);

		JMenuItem mnFiltrosMedianar = new JMenuItem("Mediana R");
		mnFiltros.add(mnFiltrosMedianar);
		
		JMenuItem mnFiltrosRoberts = new JMenuItem("Roberts Cross");
		mnFiltros.add(mnFiltrosRoberts);
		
		JMenuItem mnFiltrosSobel = new JMenuItem("Sobel Operator");
		mnFiltros.add(mnFiltrosSobel);
		
		JMenuItem mnFiltrosCanny = new JMenuItem("Canny");
		mnFiltros.add(mnFiltrosCanny);
		
		JMenuItem mnFiltrosGaussiana = new JMenuItem("Gaussian Blur");
		mnFiltros.add(mnFiltrosGaussiana);
		
		JMenuItem mnFiltrosDesagucar = new JMenuItem("Máscara de desaguçar");
		mnFiltros.add(mnFiltrosDesagucar);

		JMenu mnOperacoes = new JMenu("Operações");
		menuBar.add(mnOperacoes);

		JMenu mnAritmetica = new JMenu("Aritmética");
		mnOperacoes.add(mnAritmetica);

		JMenuItem mnAritmeticaBlending = new JMenuItem("Blending");
		mnAritmetica.add(mnAritmeticaBlending);

		JMenuItem mnAritmeticaSoma = new JMenuItem("Soma");
		mnAritmetica.add(mnAritmeticaSoma);

		JMenuItem mnAritmeticaSubtracao = new JMenuItem("Subtração");
		mnAritmetica.add(mnAritmeticaSubtracao);

		JMenuItem mnAritmeticaDivisao = new JMenuItem("Divisão");
		mnAritmetica.add(mnAritmeticaDivisao);

		JMenuItem mnAritmeticaMultiplicacao = new JMenuItem("Multiplicação");
		mnAritmetica.add(mnAritmeticaMultiplicacao);

		JMenu mnGeometrica = new JMenu("Geométrica");
		mnOperacoes.add(mnGeometrica);

		JMenuItem mnGeometricaTranslacao = new JMenuItem("Translação");
		mnGeometrica.add(mnGeometricaTranslacao);

		JMenuItem mnGeometricaRotacao = new JMenuItem("Rotação");
		mnGeometrica.add(mnGeometricaRotacao);

		JMenuItem mnGeometricaEscala = new JMenuItem("Escala");
		mnGeometrica.add(mnGeometricaEscala);

		JMenu mnLogica = new JMenu("Lógica");
		mnOperacoes.add(mnLogica);

		JMenuItem mnLogicaAnd = new JMenuItem("AND");
		mnLogica.add(mnLogicaAnd);

		JMenuItem mnLogicaOr = new JMenuItem("OR");
		mnLogica.add(mnLogicaOr);

		JMenuItem mnLogicaXor = new JMenuItem("XOR");
		mnLogica.add(mnLogicaXor);

		JMenuItem mnLogicaNot = new JMenuItem("NOT");
		mnLogica.add(mnLogicaNot);

		JMenu mnMascara = new JMenu("Máscara");
		mnOperacoes.add(mnMascara);

		JMenuItem mnMascaraBurn = new JMenuItem("Burn");
		mnMascara.add(mnMascaraBurn);

		JMenu mnPontuais = new JMenu("Pontuais");
		menuBar.add(mnPontuais);

		JMenuItem mnPontuaisCinzamedio = new JMenuItem("Cinza Médio");
		mnPontuais.add(mnPontuaisCinzamedio);

		JMenuItem mnPontuaisCinzantsc = new JMenuItem("Cinza NTSC");
		mnPontuais.add(mnPontuaisCinzantsc);

		JMenuItem mnPontuaisCinzahdtv = new JMenuItem("Cinza HDTV");
		mnPontuais.add(mnPontuaisCinzahdtv);

		JMenuItem mnPontuaisCinzahdr = new JMenuItem("Cinza HDR");
		mnPontuais.add(mnPontuaisCinzahdr);

		JMenuItem mnPontuaisHistograma = new JMenuItem("Histograma");
		mnPontuais.add(mnPontuaisHistograma);

		JMenuItem mnPontuaisLimiar = new JMenuItem("Limiar (Threshold)");
		mnPontuais.add(mnPontuaisLimiar);
		
		JMenu mnExtras = new JMenu("Extras");
		menuBar.add(mnExtras);
		
		JMenuItem mnExtrasThreshold = new JMenuItem("Threshold Regional");
		mnExtras.add(mnExtrasThreshold);
		
		JMenuItem mnExtrasContraste = new JMenuItem("Contraste Boost");
		mnExtras.add(mnExtrasContraste);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mnAjudaDocumentacao = new JMenuItem("Documentação");
		mnAjudaDocumentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			        Desktop.getDesktop().browse(new URL("https://github.com/kanashir0/fsa-image-editor").toURI());
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
				
			}
		});
		mnAjuda.add(mnAjudaDocumentacao);
		
		JMenuItem mnAjudaSobre = new JMenuItem("Sobre o desenvolvedor");
		mnAjudaSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			        Desktop.getDesktop().browse(new URL("https://gkana.dev/").toURI());
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
				
			}
		});
		mnAjuda.add(mnAjudaSobre);

		JLabel lbCamadas = new JLabel("Camadas");
		lbCamadas.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel lblFerramentas = new JLabel("Ferramentas");
		lblFerramentas.setFont(new Font("Dialog", Font.BOLD, 11));

		JDesktopPane mainDesktop = new JDesktopPane() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
//				Descomentar esse bloco para adicionar imagem de fundo no mainDesktop

//				ImageIcon icon = new ImageIcon(getClass().getResource("/br/fsa/imagem/fsa1.png"));
//				Image image = icon.getImage();
//				
//				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser saveFile = new JFileChooser();
				saveFile.setDialogTitle("Salvar imagem");
				File file = saveFile.getSelectedFile();
				
				Imagem imagem = new Imagem();
				
				try {
					ImageIO.write((RenderedImage) imagem, "PNG", file);
				} catch (IOException ex) {
				
				}
				
			}
		});
		
		JPanel panel = new JPanel();

		GroupLayout groupLayout = new GroupLayout(frmEditorDeImagem.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblFerramentas))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mainDesktop, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbCamadas)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addComponent(lblFerramentas))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lbCamadas)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(163, Short.MAX_VALUE))
				.addComponent(mainDesktop, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
		);

		frmEditorDeImagem.getContentPane().setLayout(groupLayout);

		mnArquivoAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Selecione uma imagem");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem (*.jpg, *.png)", "jpg", "png",
						"jpeg");

				fileChooser.setFileFilter(filter);
				Component c = null;
				int retorno = fileChooser.showOpenDialog(c);

				if (retorno == JFileChooser.APPROVE_OPTION) {
					if (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".jpg") ||
					fileChooser.getSelectedFile().getAbsolutePath().endsWith(".JPG") ||
					fileChooser.getSelectedFile().getAbsolutePath().endsWith(".png") ||
					fileChooser.getSelectedFile().getAbsolutePath().endsWith(".PNG")) {

						File file = fileChooser.getSelectedFile();
						Frame frame = new Frame(file);
						mainDesktop.add(frame);

					} else {

						JOptionPane.showMessageDialog(null, "Você deve selecionar uma imagem!");

					}
				}

			}
		});

		mnAritmeticaSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_AritmeticaSoma soma = new vw_AritmeticaSoma(frames);
					soma.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnAritmeticaSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_AritmeticaSubtracao subtracao = new vw_AritmeticaSubtracao(frames);
					subtracao.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnAritmeticaMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_AritmeticaMultiplicacao multiplicacao = new vw_AritmeticaMultiplicacao(frames);
					multiplicacao.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnAritmeticaDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_AritmeticaDivisao divisao = new vw_AritmeticaDivisao(frames);
					divisao.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnAritmeticaBlending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_AritmeticaBlending blending = new vw_AritmeticaBlending(frames);
					blending.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnLogicaAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_LogicaAnd and = new vw_LogicaAnd(frames);
					and.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnLogicaOr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_LogicaOr or = new vw_LogicaOr(frames);
					or.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnLogicaXor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_LogicaXor xor = new vw_LogicaXor(frames);
					xor.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnLogicaNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_LogicaNot not = new vw_LogicaNot(frames);
					not.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnPontuaisCinzamedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_PontuaisCinzamedio cinzaMedio = new vw_PontuaisCinzamedio(frames);
					cinzaMedio.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnPontuaisCinzantsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_PontuaisCinzantsc cinzaNTSC = new vw_PontuaisCinzantsc(frames);
					cinzaNTSC.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnPontuaisCinzahdr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_PontuaisCinzahdr cinzaHDR = new vw_PontuaisCinzahdr(frames);
					cinzaHDR.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnPontuaisCinzahdtv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_PontuaisCinzahdtv cinzaHDTV = new vw_PontuaisCinzahdtv(frames);
					cinzaHDTV.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnPontuaisHistograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_PontuaisHistograma histograma = new vw_PontuaisHistograma(frames);
					histograma.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnPontuaisLimiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_PontuaisLimiar limiar = new vw_PontuaisLimiar(frames);
					limiar.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnFiltrosMediar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_FiltrosMediar mediaR = new vw_FiltrosMediar(frames);
					mediaR.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnFiltrosMediana4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_FiltrosMediana4 mediana4 = new vw_FiltrosMediana4(frames);
					mediana4.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnFiltrosMedianar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_FiltrosMedianar medianaR = new vw_FiltrosMedianar(frames);
					medianaR.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnGeometricaTranslacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_GeometricaTranslacao translacao = new vw_GeometricaTranslacao(frames);
					translacao.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnGeometricaRotacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_GeometricaRotacao rotacao = new vw_GeometricaRotacao(frames);
					rotacao.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnGeometricaEscala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_GeometricaEscala escala = new vw_GeometricaEscala(frames);
					escala.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnExtrasThreshold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_ExtrasThreshold extraThreshold = new vw_ExtrasThreshold(frames);
					extraThreshold.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});
		
		mnExtrasContraste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainDesktop.getAllFrames() != null) { // TODO arrumar condição
					ArrayList<JInternalFrame> frames = new ArrayList<JInternalFrame>(Arrays.asList(mainDesktop.getAllFrames()));
					
					vw_ExtrasContraste extraContraste = new vw_ExtrasContraste(frames);
					extraContraste.setVisible(true);
				}else {
					System.out.println("Abra pelo menos uma imagem antes!");
				}

			}
		});

	}
}
