package view;

import Interface.ICrud;
import model.Paciente;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
public class TelaPrincipal extends JFrame implements ICrud {

    public void mostraGUI() {

        setTitle("Bem vindos ao Gerenciador de Pacientes");
        setVisible(true);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.black);

        // botoes
        JButton cadastrarButton = new JButton("Cadastrar Pacientes");
        JButton excluirButton = new JButton("Excluir Pacientes");
        JButton alterarButton = new JButton("Alterar Pacientes");
        JButton listarButton = new JButton("Listar Pacientes");

        // button position
        cadastrarButton.setBounds(1, 1, 180, 30);
        alterarButton.setBounds(1, 40, 180, 30);
        listarButton.setBounds(1, 80, 180, 30);
        excluirButton.setBounds(1, 120, 180, 30);

        // fonte
        Font font = new Font("Arial", Font.ITALIC, 15);

        cadastrarButton.setFont(font);
        alterarButton.setFont(font);
        excluirButton.setFont(font);
        listarButton.setFont(font);

        // cor
        Color corBackground = new Color(70, 41, 90);
        Color foreGround = new Color(255, 255, 255);

        cadastrarButton.setBackground(corBackground);
        excluirButton.setBackground(corBackground);
        alterarButton.setBackground(corBackground);
        listarButton.setBackground(corBackground);

        cadastrarButton.setForeground(foreGround);
        excluirButton.setForeground(foreGround);
        alterarButton.setForeground(foreGround);
        listarButton.setForeground(foreGround);

        add(cadastrarButton);
        add(alterarButton);
        add(listarButton);
        add(excluirButton);

        cadastrarButton.addActionListener(e -> new AdicionarPaciente().adicionaPaciente());
        alterarButton.addActionListener(e -> new EditarPaciente().editarPaciente());
        listarButton.addActionListener(e -> new ListarPacientes().listarPaciente());
        excluirButton.addActionListener(e -> new ExcluirPaciente().excluirPaciente());


    }
}
