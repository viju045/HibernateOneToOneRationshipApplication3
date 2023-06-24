package OneToOneRelationshipApplicationHB3;

import OneToOneRelationshipApplicationHB3.entity.Cus_Transaction;
import OneToOneRelationshipApplicationHB3.entity.Customer;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToOneRelationshipApplicationHb3FetchData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction txs = session.beginTransaction();

        TypedQuery query = session.createQuery("from Customer customer");
        List<Customer> list = query.getResultList();
        Iterator<Customer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Customer customer2 = iterator.next();
            System.out.println(customer2.getName() + " " + customer2.getAddress() + " " + customer2.getEmail());

            Cus_Transaction cst = customer2.getCusTransaction();
            System.out.println(cst.getDate() + " " + cst.getTotal() );
        }
        session.close();
        System.out.println("Data Fetch successfully");
    }
}