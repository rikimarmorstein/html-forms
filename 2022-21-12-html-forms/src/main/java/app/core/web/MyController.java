package app.core.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	public enum AlpabetPhoneticChar {
		ALPHA, BRAVO, CHARLIE, DELTA, ECHO, FOXTROT, GOLF, HOTEL, INDIA, JULIETT, KILO, LIMA, MIKE, NOVEMBER, OSCAR,
		PAPA, QUEBEC, ROMEO, SIERRA, TANGO, UNIFORM, VICTOR, WHISKEY, X_RAY, YANKEE, ZULU;

		public static AlpabetPhoneticChar getChar(Character character) {
			character = Character.toUpperCase(character);
			AlpabetPhoneticChar[] arr = AlpabetPhoneticChar.values();
			int index = character - 'A';
			return arr[index];
		}

		public static String convert(String text) {
			String msg = "";
			for (char c : text.toCharArray()) {
				if (c == ' ') {
					msg += " space - ";

				} else {
					msg += getChar(c) + " - ";
				}
			}
			return msg;
		}
	}

	@GetMapping("/random-char")
	public AlpabetPhoneticChar getRandomChar() {
		AlpabetPhoneticChar[] arr = AlpabetPhoneticChar.values();
		return arr[(int) (Math.random() * arr.length)];
	}

	@GetMapping("/specifialed-char")
	public AlpabetPhoneticChar getChar(@RequestParam("char") Character character) {
		return AlpabetPhoneticChar.getChar(character);
	}

	@GetMapping("/convert")
	public String convert(String text) {
		return AlpabetPhoneticChar.convert(text);
	}

	@GetMapping("/hobbies")
	public String sendHobies(@RequestParam("fav-color") String favoritColor, String... hobbies) {
		String response = "Your hobbies: <ul>";
		for (String hobby : hobbies) {
			System.out.println(hobby);
			response += "<li>" + hobby + "</li>";

		}
		response += "</ul>";
		response += "fav-color: " + favoritColor;
		return response;
	}

}
