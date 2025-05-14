package Classes;

public class Medico {
	
	private String nome;
	private String crm;
	private String especialidade;
	private String sexo;
	private int id;
	
	public Medico(){
		
	}
	
	public Medico(String nome, String crm, String especialidade, int id, String sexo){
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
		this.sexo = sexo;
		this.id = id;
		
	}
	
	public Medico(String nome, String crm, String especialidade, String sexo){
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
		this.sexo = sexo;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
	    return "Medico{" +
	            "id=" + id +
	            ", nome='" + nome + '\'' +
	            ", especialidade='" + especialidade + '\'' +
	            ", crm='" + crm + '\'' +
	            '}';
	}
	

}
