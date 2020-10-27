package com.mmit.test;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.Item;
import com.mmit.entity.Orders;

class jpaTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("jpa-assignment-01");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em=emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test() {
		em.getTransaction().begin();
		
		
//		Item item=new Item();
//		item.setName("Pizza");
//		item.setPrice(15000);
		
		Orders order=new Orders();
		order.setOrder_date(LocalDate.now());
		order.setTotalAmt(300000);
		order.setTotalQty(20);
		
		em.persist(order);
		em.getTransaction().commit();
		
	}

}
