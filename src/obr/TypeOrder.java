package obr;

import java.util.Comparator;

public class TypeOrder implements Comparator<Portfolios> {

	@Override
	public int compare(Portfolios one, Portfolios two) {
		if(one.getManager().getType().compareTo(two.getManager().getType())<0){
			return -1;
		}
		else if (one.getManager().getType().compareTo(two.getManager().getType())>0){
			return 1;
		}
		else{
			if (one.getManager().getLastName().compareTo(two.getManager().getLastName())<0){
				return -1;
			}
			else if (one.getManager().getLastName().compareTo(two.getManager().getLastName())>0){
				return 1;
			}
			else{
				if(one.getManager().getFirstName().compareTo(two.getManager().getFirstName())<0){
					return -1;
				}
				else if(one.getManager().getFirstName().compareTo(two.getManager().getFirstName())>0){
					return 1;
				}
				else{
					return 0;
				}
			}
		}
		
	}

}
