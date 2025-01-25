package Functional.Streams;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        //        StreamSources.intNumbersStream().forEach((num) -> System.out.println(num));
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
   /*     StreamSources.intNumbersStream().filter(num -> num < 5)
                .forEach(n -> System.out.println(n));*/

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num > 5)
                .skip(1)
                .limit(2)
                .forEach(n -> System.out.println(n));
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num > 5)
                .findFirst()
                .ifPresentOrElse(n -> System.out.println(n), () -> System.out.println(-1));

        // Print first names of all users in userStream
        // TODO: Write code here

        /*StreamSources.userStream()
                .map(u -> u.getFirstName())
                .forEach(name -> System.out.println(name));*/
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().
                        anyMatch(num -> num == user.getId()))
                .map(u -> u.getFirstName())
                .forEach(s -> System.out.println(s));

        StreamSources.intNumbersStream()
                .flatMap(num -> { // to flatten Stream<Stream<User>>
                    Stream<User> userStream = StreamSources.userStream().filter(user -> user.getId() == num);
                    return userStream;
                })
                .map(u -> u.getFirstName())
                .forEach(n -> System.out.println(n));
        Stream<Stream<User>> streamStream = StreamSources.intNumbersStream()
                .map(num -> { // to flatten Stream<Stream<User>>
                    Stream<User> userStream = StreamSources.userStream().filter(user -> user.getId() == num);
                    return userStream;
                });


        Stream<Stream<Integer>> streamOfStreams = Stream.of(
                Stream.of(1, 2, 3),
                Stream.of(4, 5)
        );
        // Flatten the stream of streams
        Stream<Integer> flatStream = streamOfStreams.flatMap(stream -> stream);

    }

}
