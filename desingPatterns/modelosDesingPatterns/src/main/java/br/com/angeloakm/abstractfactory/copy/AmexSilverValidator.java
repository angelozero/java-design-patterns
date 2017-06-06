package br.com.angeloakm.abstractfactory.copy;

public class AmexSilverValidator implements Validator{

	@Override
	public boolean isValid(CreditCard creditCard) {
		return false;
	}
	
	

}
