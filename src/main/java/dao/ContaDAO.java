package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Conta;

public class ContaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancoPU");

	public Conta inserir(Conta conta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		return conta;
	}

	public Conta alterar(Conta conta) {
		Conta contaBanco = null;
		if (conta.getId() != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			contaBanco = buscarPorId(conta.getId());

			if (contaBanco != null) {
				contaBanco.setDescricao(conta.getDescricao());
				em.merge(contaBanco);
			}

			em.getTransaction().commit();
			em.close();
		}
		return contaBanco;
	}

	public void excluir(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, id);
		if (conta != null) {
			em.remove(conta);
		}
		em.getTransaction().commit();
		em.close();
	}

	public List<Conta> listarTodos() {
		EntityManager em = emf.createEntityManager();
		// hql: hibernate query language
		List<Conta> contas = em.createQuery("from Conta").getResultList();
		em.close();
		return contas;
	}
	// buscar todas as contas de acordo com o CPF
	// buscar todas as contas de acordo com o tipo da transação

	public List<Conta> buscarPorCpf(String cpf) {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("from Conta where cpfCorrentista='"+cpf+"'");
			em.close();
			return query.getResultList();
	}

	public Conta buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Conta conta = em.find(Conta.class, id);
		em.close();
		return conta;
		// return em.find(Conta.class, id);
		
	}
	public void validarCpf(String cpf) {
		// pegar os 9 primeiros dígitos
		String cpf ="9999999999";
//		String carac = cpf.replaceAll("[a-zA-Z&&[^xX]]"","");
		String[] arrayCpf =  cpf.split("");
		
	}
	
	public void sacar(doble valorOperacao,doble saldo) {
		
		public getValorOperacao() {
			return valorOperacao;
		}
		public void setValorOperacao(Double valoroperacao) {
			this.valorOperacao = valorOperacao;
		}
		if(valorOperacao > saldo) {
			System.out.println("Você não tem saldo o suficiente para efetuar o saque");
		}else {
			int novoSaldo = valorOperacao - saldo;
			System.out.println("Seu novo saldo após o saque é: "+novoSaldo);
		}
	}
	public void verificarSaldo(int saldo, int despesa) {
		if(saldo >  despesa) {
			System.out.println("Você tem saldo o suficiente para efetuar o pagamento");
		}else {
			System.out.println("Saldo indisponível");
		}
	}
	
	public void limitarpagamento(int despesaPix) {
		if(despesaPix > 300.00) {
			System.out.println("Limite indisponível");
		}else{
			System.out.println("Limite disponível");
		}
	}
	public void limitediario(int despesaPix) {
		if(despesapix > )
	}
	
}
