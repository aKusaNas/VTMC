package lt.vtmc.praktiniai.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPraktiniai {

	public static List<Integer> returnSquareRoot(List<Integer> numbers) {

		return numbers.stream().map(sq -> (int) Math.sqrt(sq)).collect(Collectors.toList());

	}

	public static List<Integer> getAgeFromUsers(List<User> users) {
		return users.stream().map(ag -> ag.getAge()).collect(Collectors.toList());

	}

	public static List<Integer> getDistinctAges(List<User> users) {

		return users.stream().map(ag -> ag.getAge()).distinct().collect(Collectors.toList());

	}

	public static List<User> getLimitedUserList(List<User> users, int limit) {

		return users.stream().limit(limit).collect(Collectors.toList());

	}

	public static Integer countUsersOlderThen25(List<User> users) {

		long ats = users.stream().filter(old -> old.getAge() > 25).count();

		return (int) ats;
	}

	public static List<String> mapToUpperCase(List<String> strings) {

		return strings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());

	}

	public static Integer sum(List<Integer> integers) {

		return integers.stream().collect(Collectors.summingInt(Integer::intValue));

	}

	public static List<Integer> skip(List<Integer> integers, Integer toSkip) {

		return integers.stream().skip(toSkip).collect(Collectors.toList());

	}

	public static List<String> getFirstNames(List<String> names) {

		return names.stream().map(s -> s.substring(0, 5).trim()).collect(Collectors.toList());
		// return names.stream().map(word -> word.split("
		// ")).flatMap(Arrays::stream).collect(Collectors.toList());

	}

	public static List<String> getDistinctLetters(List<String> names) {
		return names.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());

	}

	public static String separateNamesByComma(List<User> users) {

		return users.stream().map(s -> s.getName()).collect(Collectors.joining(", "));

	}

	public static double getAverageAge(List<User> users) {

		return users.stream().mapToDouble(User::getAge).average().getAsDouble();

	}

	public static Integer getMaxAge(List<User> users) {

		return users.stream().mapToInt(User::getAge).max().getAsInt();

	}

	public static Integer getMinAge(List<User> users) {

		return users.stream().mapToInt(User::getAge).min().getAsInt();

	}

	public static boolean anyMatch(List<User> users, int age) {

		return users.stream().anyMatch(ages -> ages.getAge().equals(age));

	}

	public static boolean noneMatch(List<User> users, int age) {

		return users.stream().noneMatch(s -> s.getAge().equals(age));

	}

	public static Optional<User> findAny(List<User> users, String name) {

		return users.stream().filter(s -> s.getName().equals(name)).findAny();

	}

	public static List<User> sortByAge(List<User> users) {

		return users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());

	}

	public static Stream<Integer> getBoxedStream(IntStream stream) {

		return stream.boxed();

	}

	public static List<Integer> generateFirst10PrimeNumbers() {

		return IntStream.rangeClosed(2, 29).filter(x -> isPrime(x)).boxed().collect(Collectors.toList());

	}

	public static boolean isPrime(int number) {

		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> generate10RandomNumbers() {

		return IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

	}

	public static User findOldest(List<User> users) {

		return users.stream().max(Comparator.comparingInt(User::getAge)).get();

	}

	public static int sumAge(List<User> users) {

		return users.stream().mapToInt(User::getAge).sum();

	}

	// Pvz.:
	// Java 8 Streams API: Grouping and Partitioning a Stream
	// https://www.javacodegeeks.com/2015/11/java-8-streams-api-grouping-partitioning-stream.html

	public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public static Map<Integer, List<User>> groupByAge(List<User> users) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public static Map<Boolean, Long> countGender(List<User> users) {
		throw new UnsupportedOperationException("Not implemented");
	}

	public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
		throw new UnsupportedOperationException("Not implemented");
	}

}