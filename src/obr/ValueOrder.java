package obr;

import java.util.Comparator;

public class ValueOrder implements Comparator<Portfolios>  {

	@Override
	public int compare(Portfolios one, Portfolios two) {
		// TODO Auto-generated method stub
		if (one.getTotalValue(one.getAssetList())<two.getTotalValue(two.getAssetList())){
			return 1;
		}
		else if (one.getTotalValue(one.getAssetList())>two.getTotalValue(two.getAssetList())){
			return -1;
		}
		else{
			return 0;
		}

	}

}
