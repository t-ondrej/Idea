package dao.impl;

import configuration.JpaTestConfig;
import dao.EventDao;
import entity.impl.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import predicates.Operator;
import predicates.PredicateInfo;
import services.interfaces.IEventService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tomas on 11.11.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(executionPhase= Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts={"classpath:/sql/truncate.sql", "classpath:/sql/insert.sql"})
@ContextConfiguration(classes = {JpaTestConfig.class})
public class EventDaoTest {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private IEventService eventService;

    @Test
    public void testGetAllEvents() {
        List<Event> events = eventDao.getAll();

        events.forEach(event -> assertNotNull(event.getId()));
        assertTrue(events.size() >= 1);
    }

    @Test
    @Transactional
    public void testFilterEvents() {
        PredicateInfo[] predicates = new PredicateInfo[]{new PredicateInfo("relId", Operator.EQUALS, new String[]{"rellid"})};
        List<Event> events = eventDao.findAll(predicates);
        //List<Event> events = eventDao.doFulltextSearch(new String[]{"note", "category"}, "attempt");
        //Object obj = new Object();
      //  List<Event> events = eventService.doFulltextSearch("cesnak");
    //    Object obj = new Object();
    }
}