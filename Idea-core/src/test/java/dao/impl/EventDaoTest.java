package dao.impl;

import configuration.JpaTestConfiguration;
import dao.EventDao;
import entity.impl.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tomas on 11.11.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(executionPhase= Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts={"classpath:/sql/truncate.sql", "classpath:/sql/insert.sql"})
@ContextConfiguration(classes = {JpaTestConfiguration.class})
public class EventDaoTest {

    @Autowired
    private EventDao eventDao;

    @Test
    public void testGetAllEvents() {
        List<Event> events = eventDao.getAll();

        events.forEach(event -> assertNotNull(event.getId()));
        assertTrue(events.size() >= 1);
    }
}