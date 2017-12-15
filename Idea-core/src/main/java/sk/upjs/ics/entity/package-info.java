@TypeDefs(
        @TypeDef(
                name = "jsonStringArray",
                typeClass = JsonStringArrayUserType.class
        )
)
package sk.upjs.ics.entity;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import sk.upjs.ics.hibernate.types.JsonStringArrayUserType;

