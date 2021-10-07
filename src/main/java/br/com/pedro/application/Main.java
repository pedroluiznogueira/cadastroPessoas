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

        // fazendo a persistência dos dados, que nada mais é do que manipular os comandos dml, que será feita com o gerenciador
        em.persist(pessoaUm);
        em.persist(pessoaDois);
        em.persist(pessoaTres);

        System.out.println("Cadastrado com sucesso");

    }
}
