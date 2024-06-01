package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String observacoes;

    private static List<Paciente> listaDePacientes = new ArrayList<>();
    private static int proximoIdPaciente = 1;

    public Paciente(int id, String nome, LocalDate dataNascimento, String endereco, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public static List<Paciente> getListaDePacientes() {
        return listaDePacientes;
    }

    public static void adicionarPaciente(Paciente paciente) {
        listaDePacientes.add(paciente);
    }

    public static void removerPaciente(Paciente paciente) {
        listaDePacientes.remove(paciente);
    }

    public static int getProximoIdPaciente() {
        return proximoIdPaciente++;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id :" + id + ", nome :'" + nome + '\'' + ", dataNascimento :" + dataNascimento
                + ", endereco :'" + endereco + '\'' + ", observacoes :'" + observacoes + '\'' + '}';
    }
}
