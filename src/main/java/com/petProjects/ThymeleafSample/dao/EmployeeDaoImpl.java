/*
package com.petProjects.ThymeleafSample.dao;
        import javax.transaction.Transactional;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.query.Query;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;

//this annotation to get the expection translations
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    // need to inject the sessionfactory
    //name should be the same as the beanId
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hibrnate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create the query... sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        //executing query and get the result list
        List<Customer> customers = theQuery.getResultList();

        //return the result
        return customers;
    }

    @Override
    public void saveCutomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        //save the customer
        currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, theId);
        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
        theQuery.setParameter("theCustomerId", theId);
        theQuery.executeUpdate();
    }

}
*/
