package obr;

import java.util.Comparator;

public class LastNameOrder implements Comparator<Portfolios> {

	@Override
	public int compare(Portfolios one, Portfolios two) {
		if (one.getOwner().getLastName().compareTo( two.getOwner().getLastName())<0){
				
				return -1;
			}
		else if (one.getOwner().getLastName().compareTo(two.getOwner().getLastName())>0){
				
			return 1;
		}
		else {
			if (one.getOwner().getFirstName().compareTo(two.getOwner().getFirstName())<0){
				
				return -1;
			}
			else if (one.getOwner().getFirstName().compareTo(two.getOwner().getFirstName())>0){
				return 1;
			}
			else{
				return 0;
			}
		}
		
	}
}