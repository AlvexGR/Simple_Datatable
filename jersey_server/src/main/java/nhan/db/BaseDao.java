package nhan.db;

import nhan.obj.BaseObj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BaseDao {
    protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("simple_datatable");

    public <T extends BaseObj> T getById(Class<T> objClass, Integer id) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            return entityManager.find(objClass, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public <T extends BaseObj> boolean insert(T obj) {
        if (obj == null) {
            return false;
        }

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(obj);
            entityTransaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    public <T extends BaseObj> boolean update(T obj) {
        if (obj == null) {
            return false;
        }

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(obj);
            entityTransaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    public <T extends BaseObj> boolean delete(T obj) {
        if (obj == null) {
            return false;
        }

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(obj);
            entityTransaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }
}
