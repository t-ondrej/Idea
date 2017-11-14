@TypeDefs(
        @TypeDef(
                name = "jsonStringArray",
                typeClass = hibernate.types.JsonStringArrayUserType.class
        )
)
package entity;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

