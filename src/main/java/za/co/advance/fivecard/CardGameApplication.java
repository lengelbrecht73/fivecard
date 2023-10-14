package za.co.advance.fivecard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.advance.fivecard.definition.GameVariant;

@SpringBootApplication
public class CardGameApplication {

	static FiveCardApplication fiveCardGame = new FiveCardApplication();

	public static void main(String[] args){
	
		if (args.length == 0) {
			System.out.println("Please provide the required argument to specify the game variant.");
			return;
		}

		//Check if the game variant value is valid
		//Keep in mind that Badugi is not yet implemented,
		//but we would like to inform the user to come back soon for it
		try{
			Enum.valueOf(GameVariant.class,args[0]);
		}catch (IllegalArgumentException ex){
			System.out.println("Your game variant is not known to us.");
		}

		if(Enum.valueOf(GameVariant.class,args[0]).equals(GameVariant.BADUGI)){
			System.out.println("The Badugi game will soon be implemented. Please come back soon.");
		} else{
			SpringApplication.run(CardGameApplication.class, args);
			fiveCardGame.fiveCardGame();
		}
	}

}

