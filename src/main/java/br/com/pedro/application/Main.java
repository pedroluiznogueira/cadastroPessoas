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

        // aqui criamos o fabricador da conexão que estamos usando, por isso passar o nome da persistenceUnit que demos no persistrence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("con-cadastro-pessoas");
        // aqui criamos o gerenciador dessa nossa conexão
        EntityManager em = emf.createEntityManager();

        // atualizando no banco de dados

        em.getTransaction().begin();

        Pessoa p = em.find(Pessoa.class, 1);
        System.out.println("O registro da pessoa agora é: " + p);

        p.setEmail("pedroluiz@pedroluiz.com");

        // esse objeto já havia sido persistido, se eu persistí-lo denovo após alterar os atributos, vou atualizá-lo
        em.persist(p);
        System.out.println("O registro da pessoa após o registro é:" + p);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
