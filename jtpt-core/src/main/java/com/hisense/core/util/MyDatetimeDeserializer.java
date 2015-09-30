package com.hisense.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * Created by bcm on 14-2-24.
 */
public class MyDatetimeDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser parser,
                            DeserializationContext context) throws IOException,
            JsonProcessingException {

        return SysUtil.str2Datetime(parser.getText());
    }
}
