package etc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExam {

	// https://futurecreator.github.io/2018/08/26/java-8-streams/
	// https://madplay.github.io/post/mistakes-when-using-java-streams/
	public static void main(String[] args) {
		// 스트림 생성
		// 1. 배열 스트림
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		// 2. 컬렉션 스트림
		List<String> list = Arrays.asList("a","b","c");
		stream = list.stream();
		Stream<String> parallelStream = list.parallelStream();
		
		//3. Stream.builder()를 사용하여 스트림에 직접 원하는 값 넣기
		Stream<String> builderStream = Stream.<String>builder().add("What").add("the").add("hell").build();
		
		//4. Stream.generate()
		
		
		//5. 기본 타입형 스트림 : auto-boxing 과정을 줄일 수 있다.
		//same as : Stream<Integer> boxedIntStream = IntStream.range(1,5).boxed();
		IntStream intStream = IntStream.range(1, 5);
		LongStream longStream = LongStream.range(1, 5);
		
		//6. Random 클래스를 활용한 난수 스트림 생성
		DoubleStream doubles = new Random().doubles(3); //난수 3개 생성
		//7. 문자열 스트림
		//8. 파일 스트림
		
		//9. 병렬 스트림 
		
		
		// 데이터 가공 : Method Chaining
		//10. Filtering
		List<String> names = Arrays.asList("Tom","CAT", "apache");
		Stream<String> filtered = names.stream().filter(str -> str.contains("a") || str.equals("Tom"));
		filtered.forEach(s -> System.out.println(s));
		
		//11. Mapping
//		Stream<String> mapped = names.stream().map(String::toUpperCase).filter(str -> str.contains("A"));
		String l = "CAT";
		Stream<String> mapped = names.stream().map(String::toUpperCase).filter(l::contains);
		StringBuilder sb = new StringBuilder();
		
		mapped.forEach(s -> System.out.println(s));
		
		//12. flatMap
		List<List<String>> listoflist = Arrays.asList(Arrays.asList("a"),Arrays.asList("b"));
		List<String> flatlist = listoflist.parallelStream().flatMap(Collection::stream).collect(Collectors.toList());
		
		//13. Sorting
		System.out.println(IntStream.of(10, 9 ,3, 53, 24).sorted().boxed().collect(Collectors.toList()));
		List<String> lang = Arrays.asList("Java", "Scala", "C++", "C#", "Swift");
		lang.stream().sorted(Comparator.reverseOrder());
		
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> sortByValue = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		
		//14. Iterating
		int sum = IntStream.of(1,2,3,4,5).peek(System.out::println).sum();
		System.out.println("sum : "+sum);
		
		// 결과 만들기 : calculate(sum,average...), reduce(부가작업), collect
		
		OptionalInt reduced = IntStream.range(1, 4).reduce( (a,b) -> a+b );
		System.out.println(reduced);
		List<String> temp = Arrays.asList("E","Er","AER","ARK");
		boolean anyMatch = temp.stream().anyMatch(str -> str.contains("E"));
	
		
				
	}
	
	public Stream<String> streamOf(List<String> list){
		return list==null||list.isEmpty()
				? Stream.empty()
				: list.stream();
	}
}
