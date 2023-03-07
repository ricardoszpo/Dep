package com.example.projeto;

public class Cliente {
    String nome, telefone, sugestoes, placa;
    int atendimento, infraestrutura, qualidadedoservico, conhecimento;

    public Cliente(String placa, String nome, String telefone) {
        this.placa = placa;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(int conhecimento) {
        this.conhecimento = conhecimento;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSugestoes() {
        return sugestoes;
    }

    public void setSugestoes(String sugestoes) {
        this.sugestoes = sugestoes;
    }

    public int getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(int atendimento) {
        this.atendimento = atendimento;
    }

    public int getInfraestrutura() {
        return infraestrutura;
    }

    public void setInfraestrutura(int infraestrutura) {
        this.infraestrutura = infraestrutura;
    }

    public int getQualidadedoservico() {
        return qualidadedoservico;
    }

    public void setQualidadedoservico(int qualidadedoservico) {
        this.qualidadedoservico = qualidadedoservico;
    }
}
