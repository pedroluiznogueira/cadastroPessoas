package br.com.pedro.application;

import br.com.pedro.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        // passando null pois é auto incremento
        Pessoa pessoaUm = new Pessoa(null, "Kane", "pedro@pedro.com");
        Pessoa pessoaDois = new Pessoa(null, "Luiz", "luiz@luiz.com");
        Pessoa pessoaTres = new Pessoa(null, "Nogueira", "nogueira@nogueira.com");

        System.out.println(pessoaUm);
        System.out.println(pessoaDois);
        System.out.println(pessoaTres);

        // aqui criamos o fabricador da conexão que estamos usando, por isso passar o nome da persistenceUnit que demos no persistrence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("con-cadastro-pessoas");
        // aqui criamos o gerenciador dessa nossa conexão
        EntityManager em = emf.createEntityManager();

        // fazendo uma transação entre a aplicação e o banco

        // inicializando a transação
        // em.getTransaction().begin();

        // fazendo a persistência dos dados, que nada mais é do que manipular os comandos dml, que será feita com o gerenciador
        // em.persist(pessoaUm);
        // em.persist(pessoaDois);
        // em.persist(pessoaTres);

        // gravando a transação
        // em.getTransaction().commit();

        // consultando no banco de dados

        // com o método find eu passo a classe/entidade/tabela que eu quero consultar e qual a posição desse objeto
        Pessoa pessoaQuatro = em.find(Pessoa.class, 1);
        // retornando o objeto que veio na consulta
        System.out.println("A primeira pessoa registrada no banco é: " + pessoaQuatro);

        // finalizando a transação após o fim
        em.close();
        emf.close();

        // System.out.println("Cadastrado com sucesso");

    }
}
