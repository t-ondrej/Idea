package dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.EventDao;
import entity.impl.Event;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tomas on 11.11.2017.
 */
public class EventDaoTest {

    private static ObjectMapper objectMapper;

    private static List<Event> events;

    private static EventDao eventDao;

    @BeforeClass
    public static void prepareEnviroment() {
        objectMapper = new ObjectMapper();

        eventDao = new EventDao();
    }

    @Before
    public void setUp() throws Exception {
        events = new ArrayList<>();
    }

    @Test
    public void testGetAllEvents() {
        eventDao.merge(events.get(0));
        eventDao.merge(events.get(1));

        assertTrue(eventDao.getAll().size() >= 2);
    }

    @Test
    public void testRemoveSecondEvent() {
        Event event = events.get(0);
        event.setId("1");
        eventDao.merge(event);
        assertNotNull(eventDao.findById(event.getId()));
        eventDao.remove(event);
        assertNull(eventDao.findById(event.getId()));
    }

    @Test
    public void testFindByIdFirstEvent() {
        Event event = events.get(0);
        eventDao.merge(event);
        assertNotNull(eventDao.findById(event.getId()));
    }

    @Test
    public void testMerge() {
        Event event = events.get(0);
        eventDao.merge(event);
        event.setByteCount(42);
        eventDao.merge(event);

        assertEquals(eventDao.findById(event.getId()).getByteCount(), event.getByteCount());
    }

}