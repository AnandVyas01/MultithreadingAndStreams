package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sq = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(sq.toString());

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
        String longestName = names.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(longestName);

        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );


        long num = sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).map(String::toLowerCase).distinct().count();
        System.out.println(num);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String concatWord = words.stream().filter(w -> w.length() % 2 == 0).limit(2).collect(Collectors.joining());
        System.out.println(concatWord);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long sumOfSq = numbers2.stream().filter(x -> x % 2 == 0).mapToInt(x -> x * x).sum();
        System.out.println(sumOfSq);

        List<Integer> numbers3 = Arrays.asList(10, 20, 30, 40, 50);
        int max = numbers3.stream().mapToInt(x -> x).max().getAsInt();
        int max2 = numbers3.stream().max(Integer::compare).orElse(0);
        System.out.println(max + " " + max2);

        List<Integer> numbers4 = Arrays.asList(3, 5, 1, 4, 2);
        List<Integer> sorted = numbers4.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted.toString());

        List<String> names2 = Arrays.asList("Alice", "Bob", "Annie", "Alex", "Charlie");
        List<String> strings = names2.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println(strings.toString());

        String input = "swiss"; // find first non repeted char
        List<Character> ch = input.chars().mapToObj(x -> (char) x).filter(x -> input.indexOf(x) == input.lastIndexOf(x)).limit(1).collect(Collectors.toList());
        System.out.println(ch.toString());

        List<String> names3 = Arrays.asList("java", "stream", "api");
        List<String> up = names3.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(up.toString());

        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        long sum = numbers5.stream().mapToInt(x -> x).sum();
        long sum2 = numbers5.stream().reduce(0, Integer::sum);
        System.out.println(sum + " " + sum2);

        List<String> strings2 = Arrays.asList("Java", "Stream API", "Lambda");
        String res = strings2.stream().filter(x -> x.contains("API")).limit(1).collect(Collectors.joining());
        boolean res2 = strings2.stream().anyMatch(x -> x.contains("API"));
        System.out.println(res + " " + res2);

        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        List<Integer> ans = numbers6.stream().filter(x -> numbers6.indexOf(x) != numbers6.lastIndexOf(x)).distinct().collect(Collectors.toList());
        System.out.println(ans.toString());

        List<String> words2 = Arrays.asList("Java", "Stream", "API", "Code", "Fun");
        Map<Integer, List<String>> collect = words2.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect.toString());

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> collect1 = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect1.toString());

        List<String> words3 = Arrays.asList("Stream", "API", "is", "powerful");
        String collect2 = words3.stream().collect(Collectors.joining(" "));
        System.out.println(collect2);

        List<String> words4 = Arrays.asList("Java", "Stream", "API", "Development");
        Optional<String> max1 = words4.stream().max(Comparator.comparing(String::length));
        words4.stream().reduce((x, y) -> x.length() > y.length() ? x : y).ifPresent(System.out::println);
        System.out.println(max1.toString());

        String input2 = "success"; // find freq of chars
        Map<Character, Long> collect3 = input2.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect3.toString());

        List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = numbers7.parallelStream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<String> words5 = Arrays.asList("Java", "Stream", "API");
        String collect4 = words5.stream().collect(Collectors.joining(", "));
        System.out.println(collect4.toString());

        List<String> words6 = Arrays.asList("Java", null, "Stream", null, "API");
        List<String> collect5 = words6.stream().filter(x -> x != null).collect(Collectors.toList());
        System.out.println(collect5.toString());


        numbers.stream().mapToInt(x -> x).average().ifPresent(System.out::println);

        List<String> words7 = Arrays.asList("Java", "Stream", "API");
        Map<String, Integer> collect6 = words7.stream().collect(Collectors.toMap(x->x, String::length));
        System.out.println(collect6.toString());

        List<Integer> numbers8 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> collect7 = numbers8.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect7.toString());

        List<Integer> numbers9 = Arrays.asList(10, 20, 50, 40, 30);
        Optional<Integer> first = numbers9.stream().sorted(Comparator.reverseOrder()).skip(2).limit(1).findFirst();
        System.out.println(first.toString());

        List<String> words8 = Arrays.asList("radar", "level", "world", "java");
        List<String> collect8 = words8.stream().filter(x -> x.equals(new StringBuilder(x).reverse().toString())).collect(Collectors.toList());
        System.out.println(collect8.toString());

        List<String> words9 = Arrays.asList("Java", "Stream", "API");
        List<String> collect9 = words9.stream().map(x -> new StringBuilder(x).reverse().toString()).collect(Collectors.toList());
        System.out.println(collect9.toString());

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 5);

        List<String> li = map.keySet().stream().collect(Collectors.toList());

        List<String> collect10 = li.stream().filter(x -> map.get(x) > 10).collect(Collectors.toList());
        System.out.println(collect10.toString());

        String input3 = "success"; //most freq
        input3.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
        .ifPresent(System.out::println);
        ;

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> collect11 = list1.stream().filter(x -> list2.contains(x)).collect(Collectors.toList());
        System.out.println(collect11.toString());

        List<Integer> numbers10 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum1 = numbers10.stream().filter(n -> n % 2 == 0).mapToInt(x -> x * x).sum();
        System.out.println(sum1);

        List<String> words10 = Arrays.asList("radar", "level", "java", "stream");
        Map<Boolean, List<String>> collect12 = words10.stream().collect(Collectors.partitioningBy(x -> x.equals(new StringBuilder(x).reverse().toString())));
        System.out.println(collect12.toString());

        List<Integer> numbers11 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect13 = numbers11.stream().skip(3).limit(2).collect(Collectors.toList());
        System.out.println(collect13.toString());
    }
}