package br.com.angeloakm.abstractfactory.copy;

public class AmexValidadtor implements Validator {

	@Override
	public boolean isValid(CreditCard creditCard) {
		return false;
	}

}
