package dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.EventDto;
import entity.impl.Event;
import org.junit.Before;
import org.junit.Test;
import utils.IdeaModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tomas on 11.11.2017.
 */
public class EventDaoTest {

    private ObjectMapper objectMapper;

    private List<Event> events;

    private EventDao eventDao;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();

        EventDto firstEventDto = objectMapper.readValue("{\"ID\": \"0916d11d-06da-4573-88c9-ff4d6051487f\", " +
                "\"Node\": [{\"SW\": [\"Kippo\"], \"Name\": \"cz.tul.ward.kippo\", \"Type\": [\"Connection\", " +
                "\"Honeypot\", \"Recon\"], \"AggrWin\": \"00:05:00\"}], \"Note\": \"SSH login attempt\", " +
                "\"Format\": \"IDEA0\", \"Source\": [{\"IP4\": [\"116.31.116.40\"]}], \"Target\": [{\"IP4\": " +
                "[\"147.230.185.94\"], \"Port\": [22], \"Proto\": [\"tcp\", \"ssh\"]}], \"Category\": [\"Attempt.Login\"], " +
                "\"ConnCount\": 49, \"DetectTime\": \"2016-09-30T23:55:16+02:00\", \"WinEndTime\": " +
                "\"2016-10-01T00:00:01.317846+02:00\", \"WinStartTime\": \"2016-09-30T23:55:01.317861+02:00\"}", EventDto.class);

        EventDto secondEventDto = objectMapper.readValue("{\"ID\": \"2330255f-da84-418a-a377-ca21bcf26f6b\", \"Node\": [{\"SW\": " +
                "[\"Kippo\"], \"Name\": \"cz.tul.ward.kippo\", \"Type\": [\"Connection\", \"Honeypot\", \"Recon\"], \"AggrWin\": " +
                "\"00:05:00\"}], \"Note\": \"SSH login attempt\", \"Format\": \"IDEA0\", \"Source\": [{\"IP4\": [\"149.154.157.77\"]}], " +
                "\"Target\": [{\"IP4\": [\"147.230.80.123\"], \"Port\": [22], \"Proto\": [\"tcp\", \"ssh\"]}], \"Category\": " +
                "[\"Attempt.Login\"], \"ConnCount\": 3, \"DetectTime\": \"2016-09-30T23:59:09+02:00\", \"WinEndTime\": " +
                "\"2016-10-01T00:00:01.318036+02:00\", \"WinStartTime\": \"2016-09-30T23:55:01.318048+02:00\"}", EventDto.class);

        events = new ArrayList<>();

        IdeaModelMapper ideaModelMapper = new IdeaModelMapper();

        events.add(ideaModelMapper.map(firstEventDto, Event.class));
        events.add(ideaModelMapper.map(secondEventDto, Event.class));

        eventDao = new EventDao();
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
        assertEquals(eventDao.findById(event.getId()).getId(), event.getId());
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