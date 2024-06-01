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

public class EditarPaciente {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void editarPaciente() {
        String nomeBusca = JOptionPane.showInputDialog("Digite o nome do paciente para buscar:");

        if (nomeBusca != null && !nomeBusca.isEmpty()) {
            for (Paciente paciente : Paciente.getListaDePacientes()) {
                if (paciente.getNome().equalsIgnoreCase(nomeBusca)) {
                    JTextField campoNome = new JTextField(paciente.getNome(), 20);
                    JFormattedTextField campoDataNascimento = criarCampoData();
                    campoDataNascimento.setText(paciente.getDataNascimento().format(formatter));
                    JTextField campoEndereco = new JTextField(paciente.getEndereco(), 30);
                    JTextField campoObservacoes = new JTextField(paciente.getObservacoes(), 50);

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

                    int resultado = JOptionPane.showConfirmDialog(null, painel, "Editar Paciente",
                            JOptionPane.OK_CANCEL_OPTION);
                    if (resultado == JOptionPane.OK_OPTION) {
                        try {
                            paciente.setNome(campoNome.getText());
                            paciente.setDataNascimento(LocalDate.parse(campoDataNascimento.getText(), formatter));
                            paciente.setEndereco(campoEndereco.getText());
                            paciente.setObservacoes(campoObservacoes.getText());
                            JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!");
                        } catch (DateTimeParseException ex) {
                            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy.", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
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
