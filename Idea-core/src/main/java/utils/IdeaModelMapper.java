package utils;

import dto.EventDto;
import entity.impl.Event;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;

/**
 * Created by Tomas on 12.11.2017.
 */
public final class IdeaModelMapper extends ModelMapper {

    public IdeaModelMapper() {
        initialize();
    }

    private void initialize() {
        configure();
        addPostConverters();
    }

    private void configure() {
        this.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    private void addPostConverters() {
        Converter<EventDto, Event> eventDtoConverter = mappingContext -> {
            Event event = mappingContext.getDestination();

            event.getAttachs().forEach(attach -> attach.setEvent(event));
            event.getNodes().forEach(node -> node.setEvent(event));
            event.getSources().forEach(source -> source.setEvent(event));
            event.getTargets().forEach(target -> target.setEvent(event));


            return event;
        };

        this.typeMap(EventDto.class, Event.class).setPostConverter(eventDtoConverter);
    }
}
