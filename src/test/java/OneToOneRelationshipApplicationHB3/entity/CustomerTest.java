package OneToOneRelationshipApplicationHB3.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Customer}
     *   <li>{@link Customer#setAddress(String)}
     *   <li>{@link Customer#setCusTransaction(Cus_Transaction)}
     *   <li>{@link Customer#setEmail(String)}
     *   <li>{@link Customer#setId(long)}
     *   <li>{@link Customer#setName(String)}
     *   <li>{@link Customer#getAddress()}
     *   <li>{@link Customer#getCusTransaction()}
     *   <li>{@link Customer#getEmail()}
     *   <li>{@link Customer#getId()}
     *   <li>{@link Customer#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        actualCustomer.setAddress("42 Main St");
        Customer customer = new Customer();
        customer.setAddress("42 Main St");
        Cus_Transaction cusTransaction = new Cus_Transaction();
        customer.setCusTransaction(cusTransaction);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1L);
        customer.setName("Name");
        Cus_Transaction cusTransaction2 = new Cus_Transaction();
        cusTransaction2.setCustomer(customer);
        cusTransaction2.setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        cusTransaction2.setId(1L);
        cusTransaction2.setTotal(10.0d);
        Customer customer2 = new Customer();
        customer2.setAddress("42 Main St");
        customer2.setCusTransaction(cusTransaction2);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(1L);
        customer2.setName("Name");
        Cus_Transaction cusTransaction3 = new Cus_Transaction();
        cusTransaction3.setCustomer(customer2);
        cusTransaction3.setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        cusTransaction3.setId(1L);
        cusTransaction3.setTotal(10.0d);
        actualCustomer.setCusTransaction(cusTransaction3);
        actualCustomer.setEmail("jane.doe@example.org");
        actualCustomer.setId(1L);
        actualCustomer.setName("Name");
        assertEquals("42 Main St", actualCustomer.getAddress());
        Cus_Transaction cusTransaction4 = actualCustomer.getCusTransaction();
        Customer customer3 = cusTransaction4.getCustomer();
        assertEquals("42 Main St", customer3.getAddress());
        Cus_Transaction cusTransaction5 = customer3.getCusTransaction();
        Customer customer4 = cusTransaction5.getCustomer();
        assertEquals("42 Main St", customer4.getAddress());
        assertSame(cusTransaction3, cusTransaction4);
        assertSame(cusTransaction2, cusTransaction5);
        assertSame(cusTransaction, customer4.getCusTransaction());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("jane.doe@example.org", customer3.getEmail());
        assertEquals("jane.doe@example.org", customer4.getEmail());
        assertEquals(1L, actualCustomer.getId());
        assertEquals(1L, customer3.getId());
        assertEquals(1L, customer4.getId());
        assertEquals("Name", actualCustomer.getName());
        assertEquals("Name", customer3.getName());
        assertEquals("Name", customer4.getName());
    }
}

