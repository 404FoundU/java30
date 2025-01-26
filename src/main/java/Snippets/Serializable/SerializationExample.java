package Snippets.Serializable;

import Functional.Streams.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person("John Doe", 30);

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Object has been serialized: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Object has been deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User(25, "Alice", "wonderland");
        String jsonString = objectMapper.writeValueAsString(user);
        System.out.println("Serialized JSON: " + jsonString);//{"id":25,"firstName":"Alice","lastName":"wonderland"}

        String sampleJson = "{\"id\":30,\"firstName\":\"Bob\",\"lastName\":\"bobby\"}";
        User deserializedUser = objectMapper.readValue(sampleJson, User.class);
        System.out.println("Deserialized User: " + deserializedUser);//User{id=30, firstName='Bob', lastName='bobby'}


    }
}

