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

        // removendo do banco de dados

        em.getTransaction().begin();

        Pessoa p = em.find(Pessoa.class, 1);
        System.out.println("O registro da pessoa agora é: " + p);

        p.setEmail("pedroluiz@pedroluiz.com");

        // primeiro busquei esse objeto no banco, agora vou deletá-lo
        em.remove(p);

        // eu removi o objeto que eu busquei mas o objeto usado para armazenar a consulta ainda possui informações
        System.out.println("Registro ainda guardado em p: " + p);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
