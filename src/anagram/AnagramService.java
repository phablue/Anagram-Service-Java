package anagram;

import java.util.Scanner;

public class AnagramService {
	public static void main(String[] args) {
		Reader reader = new Reader(new Scanner(System.in));
		Writer writer = new Writer();
		Service service = new Service(reader, writer);
		service.start();
	}
}
