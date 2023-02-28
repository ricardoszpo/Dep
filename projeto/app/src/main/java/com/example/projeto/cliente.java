package com.example.projeto;

public class cliente {
    String nome, telefone, sugestoes;
    int atendimento, infraestrutura, qualidadedoservico, preco;

    public cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public cliente() {
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

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
