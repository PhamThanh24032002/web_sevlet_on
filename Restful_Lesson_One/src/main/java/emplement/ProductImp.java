package emplement;

import java.util.List;

import org.hibernate.Session;


import dao.IDao;
import entity.Product;
import util.HibernateUtil;

public class ProductImp implements IDao<Integer, Product> {
	Session session;
	@Override
	public List<Product> getAll() {
		   Session session = HibernateUtil.getSession().openSession();
	        try {
	            session.beginTransaction();
	            List products = session.createQuery("from Product").list();
	            session.close();
	            return products;
	        }catch (Exception e){
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	            return null;
	        }
	}

	@Override
	public Product getById(Integer id) {
	     Session session = HibernateUtil.getSession().openSession();
	        try {
	            session.beginTransaction();
	            Product proFound = (Product) session.createQuery("from Product where id=:params").setParameter("params",id).uniqueResult();
	            session.close();
	            return proFound;
	        }catch (Exception e){
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	            return null;
	        }
	}

	@Override
	public List<Product> search(String name) {
		  String keywordTranslate = "%" + name + "%";
	        System.out.println("keywordTranslate: " + keywordTranslate);
	        Session session = HibernateUtil.getSession().openSession();
	        try {
	            session.beginTransaction();
	            List<Product> courseFound = session.createQuery("from Product where name like :params").setParameter("params",keywordTranslate).list();
	            return courseFound;
	        }catch (Exception e){
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	            return null;
	        }
	}

	@Override
	public boolean insert(Product object) {
		 Session session = HibernateUtil.getSession().openSession();
	        try {
	            session.beginTransaction();
	            int check = (Integer) session.save(object);
	            session.getTransaction().commit();
	            session.close();
	            if (check>0)
	                return true;
	            else
	                return false;

	        }catch (Exception e){
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	            return false;
	        }
	}

	@Override
	public boolean update(Product object) {
		  Session session = HibernateUtil.getSession().openSession();
	        try{
	            session.beginTransaction();
	            session.update(object);
	            session.getTransaction().commit();
	            session.close();
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	            return false;
	        }
	}

	@Override
	public boolean delete(Integer id) {
		   Session session = HibernateUtil.getSession().openSession();
	        try {
	            session.beginTransaction();
	            int check_delete = session.createQuery("delete Product where id=:params").setParameter("params",id).executeUpdate();
	            session.close();
	            if (check_delete>0)
	                return true;
	            return false;
	        }catch (Exception e){
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	            return false;
	        }
	}

}
