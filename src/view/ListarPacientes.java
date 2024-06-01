package view;

import model.Paciente;

import java.time.format.DateTimeFormatter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListarPacientes {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void listarPaciente() {
        String[] colunas = { "ID", "Nome", "Data de Nascimento", "Endereço", "Observações" };
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        for (Paciente paciente : Paciente.getListaDePacientes()) {
            Object[] dadosPaciente = { paciente.getId(), paciente.getNome(),
                    paciente.getDataNascimento().format(formatter), paciente.getEndereco(), paciente.getObservacoes() };
            modeloTabela.addRow(dadosPaciente);
        }

        JTable tabelaPacientes = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaPacientes);
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Pacientes", JOptionPane.INFORMATION_MESSAGE);
    }
}
