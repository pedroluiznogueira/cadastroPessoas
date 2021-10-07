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

        // consultando no banco de dados
        em.getTransaction().begin();

        System.out.println("A primeira pessoa registrada no banco é: " + em.find(Pessoa.class, 1));
        System.out.println("A segunda pessoa registrada no banco é: " + em.find(Pessoa.class, 2));
        System.out.println("A terceira pessoa registrada no banco é: " + em.find(Pessoa.class, 3));

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
