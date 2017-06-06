package br.com.angeloakm.abstractfactory.copy;

public class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
		case GOLD:
			return new VisaGoldCreditCard();

		case SILVER:
			return new VisaSilverCreditCard();

		default:
			return null;
		}
	}

	@Override
	public Validator getValidator(CardType cardType) {

		switch (cardType) {
		case GOLD:
			return new VisaGoldValidadtor();

		case SILVER:
			return new VisaSilverValidadtor();

		default:
			return null;
		}

	}

}
