package anagram;

import java.util.ArrayList;

public class Service {
	private Words words;
	private Reader reader;
	private Writer writer;
	private UI ui;

	public Service(Reader reader, Writer writer) {
		Helper helper = new Helper();
		ui = new UI(helper);
		words = new Words(helper);
		this.reader = reader;
		this.writer = writer;
	}

	public void start() {
		boolean serviceOn = true;

		while (serviceOn) {
			writer.printOut(ui.questionMessage());
			String userInput = reader.input();

			if(ui.requestExitService(userInput))
				break ;
			else
				writer.printLineOut(getResult(userInput) + "\n");
		}
		writer.printLineOut(ui.exitMessage());
	}

	public String getResult(String userInput) {
		if(checkAnagramMapContain(userInput)) {
			ArrayList<String> result = words.getAnagramFromMapBy(userInput);
			String anagramList = ui.stylizeAnagramResult(result, userInput).toString();

			return anagramList;
		}
		else
			return ui.errorMessage(userInput);
	}

	private boolean checkAnagramMapContain(String input) {
		return words.anagramMap.containsKey(input.toLowerCase());
	}
}
