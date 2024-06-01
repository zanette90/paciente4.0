package view;
import model.Paciente;
import javax.swing.JOptionPane;


public class ExcluirPaciente {

    public void excluirPaciente() {
        String nomeBusca = JOptionPane.showInputDialog("Digite o nome do paciente para excluir:");
        if (nomeBusca != null && !nomeBusca.isEmpty()) {
            for (Paciente paciente : Paciente.getListaDePacientes()) {
                if (paciente.getNome().equalsIgnoreCase(nomeBusca)) {
                    int resultado = JOptionPane.showConfirmDialog(null,
                            "Tem certeza de que deseja excluir o paciente " + paciente.getNome() + "?",
                            "Excluir Paciente", JOptionPane.YES_NO_OPTION);
                    if (resultado == JOptionPane.YES_OPTION) {
                        Paciente.removerPaciente(paciente);
                        JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
        }
    }
}
