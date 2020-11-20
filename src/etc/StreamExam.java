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
		// ��Ʈ�� ����
		// 1. �迭 ��Ʈ��
		String[] arr = new String[] {"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		// 2. �÷��� ��Ʈ��
		List<String> list = Arrays.asList("a","b","c");
		stream = list.stream();
		Stream<String> parallelStream = list.parallelStream();
		
		//3. Stream.builder()�� ����Ͽ� ��Ʈ���� ���� ���ϴ� �� �ֱ�
		Stream<String> builderStream = Stream.<String>builder().add("What").add("the").add("hell").build();
		
		//4. Stream.generate()
		
		
		//5. �⺻ Ÿ���� ��Ʈ�� : auto-boxing ������ ���� �� �ִ�.
		//same as : Stream<Integer> boxedIntStream = IntStream.range(1,5).boxed();
		IntStream intStream = IntStream.range(1, 5);
		LongStream longStream = LongStream.range(1, 5);
		
		//6. Random Ŭ������ Ȱ���� ���� ��Ʈ�� ����
		DoubleStream doubles = new Random().doubles(3); //���� 3�� ����
		//7. ���ڿ� ��Ʈ��
		//8. ���� ��Ʈ��
		
		//9. ���� ��Ʈ�� 
		
		
		// ������ ���� : Method Chaining
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
		
		// ��� ����� : calculate(sum,average...), reduce(�ΰ��۾�), collect
		
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
