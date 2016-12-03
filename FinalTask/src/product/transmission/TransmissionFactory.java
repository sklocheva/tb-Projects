package product.transmission;

import main.Constants.Const;
import product.ProductValidationPlan;

public class TransmissionFactory {
	public ProductValidationPlan makeTrans(String label, String param) throws IllegalArgumentException {

		if (label.equals(Const.AUTO_TRANSMISSION)) {

			return new AutoTrans(param);

		} else if (label.equals(Const.MANUAL_TRANSMISSION)) {

			return new ManualTrans(param);

		} else {
			/* if the TransType is not valid, throw exception which will be
			caught in the createCommand*/
			throw new IllegalArgumentException();
		}

	}

}
