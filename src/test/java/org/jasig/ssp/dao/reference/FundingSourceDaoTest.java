package org.jasig.ssp.dao.reference;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.UUID;

import org.jasig.ssp.model.ObjectStatus;
import org.jasig.ssp.model.Person;
import org.jasig.ssp.model.reference.FundingSource;
import org.jasig.ssp.service.ObjectNotFoundException;
import org.jasig.ssp.service.impl.SecurityServiceInTestEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("dao-testConfig.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class FundingSourceDaoTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FundingSourceDaoTest.class);

	@Autowired
	private FundingSourceDao dao;

	@Autowired
	private SecurityServiceInTestEnvironment securityService;

	@Before
	public void setup() {
		securityService.setCurrent(new Person(Person.SYSTEM_ADMINISTRATOR_ID));
	}

	@Test
	public void testSaveNew() throws ObjectNotFoundException {
		UUID saved;

		FundingSource obj = new FundingSource();
		obj.setName("new name");
		obj.setObjectStatus(ObjectStatus.ACTIVE);
		dao.save(obj);

		assertNotNull(obj.getId());
		saved = obj.getId();

		LOGGER.debug(obj.toString());

		obj = dao.get(saved);
		assertNotNull(obj);
		assertNotNull(obj.getId());
		assertNotNull(obj.getName());

		Collection<FundingSource> all = dao.getAll(ObjectStatus.ACTIVE)
				.getRows();
		assertNotNull(all);
		assertTrue(all.size() > 0);
		assertList(all);

		dao.delete(obj);
	}

	@Test(expected = ObjectNotFoundException.class)
	public void testNull() throws ObjectNotFoundException {
		UUID id = UUID.randomUUID();
		FundingSource fundingSource = dao.get(id);

		assertNull(fundingSource);
	}

	private void assertList(Collection<FundingSource> objects) {
		for (FundingSource object : objects) {
			assertNotNull(object.getId());
		}
	}

	@Test
	public void uuidGeneration() {
		FundingSource obj = new FundingSource();
		obj.setName("new name");
		obj.setObjectStatus(ObjectStatus.ACTIVE);
		dao.save(obj);

		FundingSource obj2 = new FundingSource();
		obj2.setName("new name");
		obj2.setObjectStatus(ObjectStatus.ACTIVE);
		dao.save(obj2);

		LOGGER.debug("obj1 id: " + obj.getId().toString() + ", obj2 id: "
				+ obj2.getId().toString());

		dao.delete(obj);
		dao.delete(obj2);
	}

}
