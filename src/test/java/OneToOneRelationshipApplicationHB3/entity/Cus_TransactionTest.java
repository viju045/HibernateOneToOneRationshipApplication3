package OneToOneRelationshipApplicationHB3.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;

class Cus_TransactionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Cus_Transaction}
     *   <li>{@link Cus_Transaction#setCustomer(Customer)}
     *   <li>{@link Cus_Transaction#setDate(Date)}
     *   <li>{@link Cus_Transaction#setId(Long)}
     *   <li>{@link Cus_Transaction#setTotal(double)}
     *   <li>{@link Cus_Transaction#getCustomer()}
     *   <li>{@link Cus_Transaction#getDate()}
     *   <li>{@link Cus_Transaction#getId()}
     *   <li>{@link Cus_Transaction#getTotal()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Cus_Transaction actualCus_Transaction = new Cus_Transaction();
        Cus_Transaction cusTransaction = new Cus_Transaction();
        Customer customer = new Customer();
        cusTransaction.setCustomer(customer);
        Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        cusTransaction.setDate(date);
        cusTransaction.setId(1L);
        cusTransaction.setTotal(10.0d);
        Customer customer2 = new Customer();
        customer2.setAddress("42 Main St");
        customer2.setCusTransaction(cusTransaction);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(1L);
        customer2.setName("Name");
        Cus_Transaction cusTransaction2 = new Cus_Transaction();
        cusTransaction2.setCustomer(customer2);
        Date date2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        cusTransaction2.setDate(date2);
        cusTransaction2.setId(1L);
        cusTransaction2.setTotal(10.0d);
        Customer customer3 = new Customer();
        customer3.setAddress("42 Main St");
        customer3.setCusTransaction(cusTransaction2);
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(1L);
        customer3.setName("Name");
        actualCus_Transaction.setCustomer(customer3);
        Date date3 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualCus_Transaction.setDate(date3);
        actualCus_Transaction.setId(1L);
        actualCus_Transaction.setTotal(10.0d);
        Customer customer4 = actualCus_Transaction.getCustomer();
        assertSame(customer3, customer4);
        Cus_Transaction cusTransaction3 = customer4.getCusTransaction();
        Customer customer5 = cusTransaction3.getCustomer();
        assertSame(customer2, customer5);
        Cus_Transaction cusTransaction4 = customer5.getCusTransaction();
        assertSame(customer, cusTransaction4.getCustomer());
        assertSame(date3, actualCus_Transaction.getDate());
        assertSame(date2, cusTransaction3.getDate());
        assertSame(date, cusTransaction4.getDate());
        assertEquals(1L, actualCus_Transaction.getId().longValue());
        assertEquals(1L, cusTransaction3.getId().longValue());
        assertEquals(1L, cusTransaction4.getId().longValue());
        assertEquals(10.0d, actualCus_Transaction.getTotal());
        assertEquals(10.0d, cusTransaction3.getTotal());
        assertEquals(10.0d, cusTransaction4.getTotal());
    }
}

