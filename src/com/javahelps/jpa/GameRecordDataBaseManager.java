package com.javahelps.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GameRecordDataBaseManager {
    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JavaHelps");
/*
    public static void main(String[] args) {

        // Create two Students
        create("sapir", "Lrvel_1", 3, 69.09);
        create("yaniv", "Lrvel_2", 3, 49.09);
        create("sigi", "Lrvel_3", 3, 68.09);

    	
    	
    	
    	
        // Update the age of Bob using the id
        upate("sigi", "level_4", 6, 5.09);

        // Delete the Sapir from database
        delete("sapir");

        // Print all the Students
        List<GameRecord> rec = readAll();
        if (rec != null) {
            for (GameRecord user : rec) {
                System.out.println(user);
            }
        }

        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }
*/
    /**
     * Create a new Student.
     * @param userName
     * @param levelName
     * @param steps
     * @param timer
     */
    public static void create(String userName, String levelName, int steps,double timer) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new game record object
            GameRecord rec = new GameRecord();
            rec.setUserName(userName);
            rec.setLevelName(levelName);
            rec.setTimer(timer);
            rec.setSteps(steps);

            // Save the student object
            manager.persist(rec);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Read all the Students.
     * 
     * @return a List of Students
     */
    public static List<GameRecord> readAll(String levelName) {

        List<GameRecord> students = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            
            // Begin the transaction
            transaction.begin();

            String hql = "SELECT r FROM GameRecord r WHERE r.levelName LIKE :curr_level_name ORDER BY steps";
          //  Query query = session.createQuery(hql);
          //  query.setMaxResults(10);
          //  query.setParameter("curr_level_name", levelName);
            
            
            
            // Get a List of Students
            /*students = manager.createQuery("SELECT s FROM GameRecord",
                    GameRecord.class).getResultList();*/

            students = manager.createQuery(hql, GameRecord.class).setParameter("curr_level_name", levelName).setMaxResults(10).getResultList();
       //     students = manager.createQuery("FROM gameRecord R WHERE R.level_name = "+levelName+" ORDER BY R.timer ASC",
         //           GameRecord.class).getResultList();
            
            //query.setMaxResults(10);
            //query.setParameter("curr_level_name", levelName);
            
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    }

    public static List<GameRecord> readAllByUserName(String userName) {

    	List<GameRecord> students = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            
            // Begin the transaction
            transaction.begin();

            String hql = "SELECT r FROM GameRecord r WHERE r.userName LIKE :currUserName ORDER BY steps";
          //  Query query = session.createQuery(hql);
          //  query.setMaxResults(10);
          //  query.setParameter("curr_level_name", levelName);
            
            
            
            // Get a List of Students
            /*students = manager.createQuery("SELECT s FROM GameRecord",
                    GameRecord.class).getResultList();*/

            students = manager.createQuery(hql, GameRecord.class).setParameter("currUserName", userName).setMaxResults(10).getResultList();
       //     students = manager.createQuery("FROM gameRecord R WHERE R.level_name = "+levelName+" ORDER BY R.timer ASC",
         //           GameRecord.class).getResultList();
            
            //query.setMaxResults(10);
            //query.setParameter("curr_level_name", levelName);
            
            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;

    }

    
    /**
     * Delete the existing Student.
     * 
     * @param userName
     */
    public static void delete(String userName) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            GameRecord rec = manager.find(GameRecord.class, userName);

            // Delete the student
            manager.remove(rec);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Update the existing Student.
     * 
     * @param userName
     * @param levelName
     * @param age
     * @param timer
     */
    public static void upate(String userName, String levelName, int age,double timer) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            GameRecord stu = manager.find(GameRecord.class, userName);

            // Change the values
            stu.setLevelName(levelName);
            stu.setSteps(age);;
            stu.setTimer(timer);
         

            // Update the student
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
}
