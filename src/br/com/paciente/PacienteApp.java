package br.com.paciente;

import view.TelaPrincipal;

import javax.swing.*;

public class PacienteApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new TelaPrincipal().mostraGUI());
    }
}