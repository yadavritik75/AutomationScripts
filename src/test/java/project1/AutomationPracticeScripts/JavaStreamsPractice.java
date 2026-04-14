package project1.AutomationPracticeScripts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsPractice {

	public static void main(String[] args) {
		//(1)Write a program to print the distinct elements from a list of strings using Java Streams.
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		list.add("apple");
		list.add("grape");
		list.add("banana");
		list.add("kiwi");
		
		//******(1)   list.stream().distinct().forEach(s-> System.out.println(s));
		
		//(2) Write a program to find duplicate elements in a list using streams.
		/*
		Set<String> unique = new HashSet<String>();
		List<String> duplicate = list.stream().filter((s->!unique.add(s))).distinct().collect(Collectors.toList());
		System.out.println(duplicate);
		*/
		
		//(3)Write a program to find the second highest number in a list.
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(5);
		numbers.add(15);
		numbers.add(25);
		numbers.add(9);
		/*
		Integer thirdHighest = numbers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
		
		System.out.println("Second highest number: " + thirdHighest);
		
		Integer Highestnumber = numbers.stream().sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println("Highest number: " + Highestnumber);
		
		Integer lowestNumber = numbers.stream().sorted().findFirst().get();
		System.out.println("Lowest number: " + lowestNumber);

		
		*/
		//Write a program to separate even and odd numbers from a list.
		
		/*
		List<Integer> evenNumbers = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println("Even numbers: " + evenNumbers);
		List<Integer> oddNumbers = numbers.stream().filter(n->n%2!=0).collect(Collectors.toList());
		System.out.println("Odd numbers: " + oddNumbers);

		*/
		
		//Write a program to convert a list of strings to uppercase.
		/*
		list.stream().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
	List<String> UpperCaseList = list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(UpperCaseList);
		System.out.println(UpperCaseList.get(0));
		
		*/
		//Write a program to check if a list contains only even numbers.
		/*
		boolean bool = numbers.stream().allMatch(n->n%2==0);
		System.out.println(bool);
		*/
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("papaya");
		list1.add("dragon Fruit");
		list1.add("Beetroot");
		list1.add("Ananas");
		list1.add("Raspberry");
		list1.add("banana");
		list1.add("kiwi");
		
		//Merge two lists and remove duplicates
		/*
		List<String> newList = Stream.concat(list.stream(), list1.stream()).distinct().collect(Collectors.toList());
		
		System.out.println(newList);
		
		*/
		
		//Write a program to find the sum, average numbers in a list.
		/*
		List<Integer> Sum = numbers.stream().map(n->n+1).collect(Collectors.toList());
		System.out.println(Sum); //[11, 21, 6, 16, 26, 10]
		*/
		
		/*
		
		Integer sum = numbers.stream().reduce(0,Integer::sum);
		System.out.println("Total Sum : "+sum);
		int Average = sum/numbers.size();
		System.out.println("Average : "+Average);
		
		*/
		
		
		
		//print the numbers 1 to 100 
		//Stream.iterate(1, n->n+1).limit(100).forEach(n->System.out.println(n));
		
		//print the even numbers from 1 to 100
		//Stream.iterate(2,n->n+2).limit(50).forEach(n->System.out.println(n));
		
		//print the odd numbers from 1 to 100
		
		//Stream.iterate(1,n->n+2).limit(50).forEach(n->System.out.println(n));
		
		
		
		
		
		
		
		
	}

}
