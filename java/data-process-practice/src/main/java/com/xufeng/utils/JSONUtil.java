package com.xufeng.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.data.redis.hash.JacksonHashMapper;


public class JSONUtil {
    private static ObjectMapper mapper = null;

    static {
        if (mapper == null) {
            JsonFactory factory = new JsonFactory();
            mapper = new ObjectMapper(factory);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
        }
    }

    public static final String toJSON(Object bean) {
        boolean hasError = false;
        StringWriter sw = new StringWriter();
        try {
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, bean);
            gen.close();
        } catch (JsonGenerationException e) {
            hasError = true;
        } catch (JsonMappingException e) {
            hasError = true;
        } catch (IOException e) {
            hasError = true;
        }
        if (hasError) {
            return null;
        } else {
            return sw.toString();
        }
    }

    public static final Object toBean(String json, Class<?> clazz) {
        if (json == null || json.length() == 0) {
            return null;
        }
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return null;
    }
    
    public static final <T> T toBean(String json, TypeReference<T> t) {
        if (json == null || json.length() == 0) {
            return null;
        }
        try {
            return (T)mapper.readValue(json, t);
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return null;
    }
    
    public static final Map<String,String> toBean(String json){
    	return toBean(json,new TypeReference<Map<String,String>>(){});
    }
    
    /**
     * 读取JSON字符串成Map
     * @param json
     * @return
     */
    public static final Map<String, Object> simpleToBean(String json) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		map = mapper.readValue(json, HashMap.class);
    		return map;
		} catch (Exception e) {
			return null;
		}
    }
    
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    	String json = "{\"discount\":\"8.0\",\"discountPrice\":8640,\"freePost\":\"0\"}";
    	System.out.println(JSONUtil.toBean(json).get("discount"));
    	
    	// read string to bean
    	System.out.println(JSONUtil.toBean(json));
    	System.out.println(simpleToBean(json));
    	
    	// read bean(map) to string
    	System.out.println(toJSON(simpleToBean(json)));
	}
}
