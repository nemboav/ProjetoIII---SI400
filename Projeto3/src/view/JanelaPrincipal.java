package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class JanelaPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel painelStatus;
    private JLabel labelStatus;
    private JMenuBar menuBar;
    private JMenu menuArquivo;
    private JMenu menuAjuda;
    private JMenuItem menuItemSaida;
    private JMenuItem menuItemConectar;
    private JMenuItem menuItemAjuda;
    private JMenuItem menuItemSobre;

    JanelaPrincipal() throws HeadlessException {
        super(ConstantesGlobais.getNomeVersao());

        configuraJanela();
        criaAdicionaMenu();
        adicionaOuvinteMenus(this);
        inicializaAdicionaComponentes();
    }

    private void configuraJanela() {
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5 / 2),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.45));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));
    }

    private void inicializaAdicionaComponentes() {
        this.painelStatus = new JPanel();
        this.labelStatus = new JLabel();
        this.painelStatus.add(labelStatus);
        this.painelStatus.setBackground(Color.white);
        this.painelStatus.setBorder(BorderFactory.createEtchedBorder());
        this.add(painelStatus, BorderLayout.SOUTH);
    }

    void setMsgStatus(String texto) {
        this.labelStatus.setText(texto);
    }

    void inicia() {
        this.setMsgStatus(ConstantesGlobais.status);
        this.setVisible(true);
    }

    private void criaAdicionaMenu() {
        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic('A');

        menuItemConectar = new JMenuItem("Conectar");
        menuItemConectar.setMnemonic('C');
        menuArquivo.add(menuItemConectar);

        menuItemSaida = new JMenuItem("Sair");
        menuItemSaida.setMnemonic('S');
        menuArquivo.add(menuItemSaida);

        menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic('J');

        menuItemAjuda = new JMenuItem("Ajuda");
        menuItemAjuda.setMnemonic('U');
        menuAjuda.add(menuItemAjuda);

        menuItemSobre = new JMenuItem("Sobre");
        menuItemSobre.setMnemonic('O');
        menuAjuda.add(menuItemSobre);

        menuBar = new JMenuBar();
        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);

        this.setJMenuBar(menuBar);
    }

    void adicionaOuvinteMenus(ActionListener ouvinte) {
        for (Component menuPrincipal : this.getJMenuBar().getComponents()) {
            if (menuPrincipal instanceof JMenu) {
                adicionaOuvinteItemMenu(ouvinte, (JMenu) menuPrincipal);
            }
        }
    }

    private void adicionaOuvinteItemMenu(ActionListener ouvinte, JMenu menuPrincipal) {
        for (Component alvo : menuPrincipal.getMenuComponents()) {
            if (alvo instanceof JMenuItem) {
                ((JMenuItem) alvo).addActionListener(ouvinte);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        JOptionPane.showMessageDialog(this, evento.getActionCommand(), "Acao Solicitada",
                JOptionPane.INFORMATION_MESSAGE);

        if (evento.getSource() == menuItemSaida) {
            System.exit(NORMAL);
        }

        if (evento.getSource() == menuItemAjuda) {
            mostraTelaMensagem(new TelaDeMensagem(this, "Ajuda - " + ConstantesGlobais.getNomeVersao(),
                    ConstantesGlobais.getTextoAjuda()));
        }

        if (evento.getSource() == menuItemSobre) {
            mostraTelaMensagem(new TelaDeMensagem(this, "Sobre - " + ConstantesGlobais.getNomeVersao(),
                    ConstantesGlobais.getTextoSobre()));
        }
    }

    private void mostraTelaMensagem(TelaDeMensagem tela) {
        tela.setVisible(true);
    }
}
