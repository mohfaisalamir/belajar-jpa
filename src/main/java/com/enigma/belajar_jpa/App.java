package com.enigma.belajar_jpa;

import com.enigma.belajar_jpa.entity.Customer;
import jakarta.persistence.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("belajar_jpa");

        delete(emf);

        emf.close();
    }

    private static void delete(EntityManagerFactory emf) {
        // Remove
        try (EntityManager entityManager = emf.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            // find by id
            Customer customer = entityManager.find(Customer.class, 9);

            // remove
            entityManager.remove(customer);
            transaction.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private static void update(EntityManagerFactory emf) {
        // Update (merge method) -> kalau id tidak ada maka akan eksekusi insert, jika id ada maka akan melakukan eksekusi update
        try (EntityManager entityManager = emf.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Customer customer = new Customer(9, "Budi", "081234", true);
            entityManager.merge(customer);
            transaction.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findAll(EntityManagerFactory emf) {
        // FindAll
        // Criteria -> Programmatic
        // Query -> JPQL (Java Persistence Query Language)
        try (EntityManager entityManager = emf.createEntityManager()) {
            // Native : SELECT * FROM m_customer
            TypedQuery<Customer> query = entityManager.createQuery("select c.id, c.customerName, c.mobilePhoneNo, c.isMember from Customer c", Customer.class);
            query.setMaxResults(5);
            List<Customer> result = query.getResultList();
            System.out.println(result);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    private static Customer findById(EntityManagerFactory emf, Integer id) {
        try (EntityManager entityManager = emf.createEntityManager()) {
            return entityManager.find(Customer.class, id);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private static void save(EntityManagerFactory emf) {
        // entytyManager ini mirip seperti Connection di JDBC -> untuk melakukan query
        EntityManager entityManager = emf.createEntityManager();

        // CRUD di Hibernate/JPA ->
        /*
         * persist -> menyimpan object kedalam table/insert
         * find -> melakukan query select by id
         * merge -> melakukan query update
         * remove -> melakukan query remove
         * */
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = new Customer(9, "Budi", "081234", false);
        entityManager.persist(customer);
        transaction.commit();

        entityManager.close();
    }
}
