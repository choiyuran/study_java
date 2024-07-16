package javaStudy.week15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx4 {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of (
            new String[] {"abc", "def", "jkl"},
            new String[] {"ABC", "GHI", "JKL"}
        );

//        Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))     // 연속된 여러개의 공백 문자를 하나의 공백으로 처리해줌.
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
        // 배열로 바꿔서 사용할 경우
//        Stream<String> strStream = strStrmStrm
//                .map(s -> s.toArray(String[]::new))       // 스트림을 배열로 변환
//                .flatMap(Arrays::stream);

        // 리스트로 바꿔서 사용할 경우
        Stream<String> strStream = strStrmStrm
                .map(s -> s.collect(Collectors.toList())) // 스트림을 리스트로 변환
                .flatMap(List::stream); // 리스트를 평탄화

        strStream.map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
