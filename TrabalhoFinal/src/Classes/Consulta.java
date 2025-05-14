package Classes;


import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private LocalDateTime dataHora;
    private String observacoes;
    private Paciente paciente;
    private Medico medico;

    // Construtor
    public Consulta(LocalDateTime dataHora, Paciente paciente, Medico medico, String observacoes) {
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.medico = medico;
        this.observacoes = observacoes;
    }

    // Getters e Setters (omiti alguns para brevidade)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", paciente=" + paciente.getNome() + " (ID: " + paciente.getId() + ")" +
                ", medico=" + medico.getNome() + " (CRM: " + medico.getCrm() + ")" +
                ", observacoes='" + observacoes + '\'' +
                '}';
}
}


