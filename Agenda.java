import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

  
}

public class AgendaSwing extends JFrame implements ActionListener {
    private List<Contato> listaContatos;
    private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextField campoEmail;
    private JTextArea areaContatos;

    public AgendaSwing() {
        setTitle("Agenda de Contatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        listaContatos = new ArrayList<>();

       
        campoNome = new JTextField(20);
        campoTelefone = new JTextField(20);
        campoEmail = new JTextField(20);

       
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(this);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(this);

       
        areaContatos = new JTextArea();
        areaContatos.setEditable(false);

        
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 2));
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);
        painel.add(new JLabel("Email:"));
        painel.add(campoEmail);
        painel.add(btnAdicionar);
        painel.add(btnLimpar);

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(areaContatos), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Adicionar")) {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();

            Contato novoContato = new Contato(nome, telefone, email);
            listaContatos.add(novoContato);

            exibirContatos();
        } else if (e.getActionCommand().equals("Limpar")) {
            campoNome.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
        }
    }

    private void exibirContatos() {
        areaContatos.setText("");
        for (Contato contato : listaContatos) {
            areaContatos.append(contato.getNome() + " - " + contato.getTelefone() + " - " + contato.getEmail() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaSwing());
    }
}
