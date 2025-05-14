package Classes;

public class Paciente {
	
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private int id;
	
	public Paciente(){
		}
	
	public Paciente(String cpf, String nome, String email, String telefone, int id){
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
		
	}
	
	
	public Paciente(String cpf, String nome, String email, String telefone){
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		
	}
	
	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setIdade(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
	    return "Paciente{" +
	            "id=" + id +
	            ", nome='" + nome + '\'' +
	            ", cpf='" + cpf + '\'' +
	            ", telefone='" + telefone + '\'' +
	            '}';
	}
	
	

}
