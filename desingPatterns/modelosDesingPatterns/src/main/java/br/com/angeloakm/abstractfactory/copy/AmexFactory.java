package br.com.angeloakm.abstractfactory.copy;

public class AmexFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
		case GOLD:
			return new AmexGoldCreditCard();

		case SILVER:
			return new AmexSilverCreditCard();

		default:
			return null;
		}
	}

	@Override
	public Validator getValidator(CardType cardType) {
		switch (cardType) {
		case GOLD:
			return new AmexGoldValidadtor();

		case SILVER:
			return new AmexSilverValidadtor();

		default:
			return null;
		}

	}

}
