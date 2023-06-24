package OneToOneRelationshipApplicationHB3;


import OneToOneRelationshipApplicationHB3.entity.Cus_Transaction;
import OneToOneRelationshipApplicationHB3.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class OneToOneRelationshipApplicationHb3Application {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session =factory.openSession();
		Transaction txs = session.beginTransaction();

		Customer customer1 = new Customer();
		customer1.setAddress("Kolhapur, India");
		customer1.setEmail("vijaymohitepayil@yahoo.com");
		customer1.setName("Vijay Mohitepatil");

		Cus_Transaction ct = new Cus_Transaction();
		ct.setDate(new Date());
		ct.setTotal(200);

		customer1.setCusTransaction(ct);
		ct.setCustomer(customer1);

		session.persist(customer1);
		txs.commit();

		session.close();
		System.out.println("Ok! Successful Done");

	}

}
