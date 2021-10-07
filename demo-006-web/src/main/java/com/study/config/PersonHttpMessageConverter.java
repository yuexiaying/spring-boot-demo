package com.study.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.study.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Person消息类转换器
 *
 * @author fjding
 * @date 2021/10/7
 */
@Component
public class PersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {



    @Autowired
    private ObjectMapper objectMapper;

    protected PersonHttpMessageConverter() {
        // 指定content-type
        super(MediaType.APPLICATION_JSON);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 输入转对象
     *
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = inputMessage.getBody();
        String str = CharStreams.toString(new InputStreamReader(inputStream));
        Person person = objectMapper.readValue(str, Person.class);
        person.setAge(person.getAge() + 100);
        return person;
    }

    /**
     * 对象转输出
     *
     * @param person
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        person.setName(person.getName() + "转换后的名字");
        outputMessage.getBody().write(objectMapper.writeValueAsBytes(person));
    }
}
