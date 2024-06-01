package view;

import model.Paciente;

import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class AdicionarPaciente {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void adicionaPaciente() {
        JTextField campoNome = new JTextField(20);
        JFormattedTextField campoDataNascimento = criarCampoData();
        JTextField campoEndereco = new JTextField(30);
        JTextField campoObservacoes = new JTextField(50);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2));
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("Data de Nascimento:"));
        painel.add(campoDataNascimento);
        painel.add(new JLabel("Endereço:"));
        painel.add(campoEndereco);
        painel.add(new JLabel("Observações:"));
        painel.add(campoObservacoes);

        int resultado = JOptionPane.showConfirmDialog(null, painel, "Adicionar Paciente", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == JOptionPane.OK_OPTION) {
            try {
                int id = Paciente.getProximoIdPaciente();
                String nome = campoNome.getText();
                LocalDate dataNascimento = LocalDate.parse(campoDataNascimento.getText(), formatter);
                String endereco = campoEndereco.getText();
                String observacoes = campoObservacoes.getText();

                Paciente paciente = new Paciente(id, nome, dataNascimento, endereco, observacoes);
                Paciente.adicionarPaciente(paciente);
                JOptionPane.showMessageDialog(null, "Paciente adicionado com sucesso!");
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JFormattedTextField criarCampoData() {
        try {
            MaskFormatter formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('_');
            return new JFormattedTextField(formatter);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JFormattedTextField();
        }
    }
}
