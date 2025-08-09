package thuchanh3.src;

public class NNCollection {
	private NameNumber[] nnArray = new NameNumber[100];
	private int free;
	public NNCollection() {free = 0;}

	public void insert(NameNumber n) {
		int index = 0;
		for (int i = free++;
			 i != 0 && nnArray[i-1].getLastName().compareTo(n.getLastName()) > 0; i--) 
		{
			nnArray[i] = nnArray[i-1];
			index = i;
		}
		nnArray[index] = n;
	}
}

// Dummy NameNumber class for compilation
class NameNumber {
	private String lastName;
	private String number;

	public NameNumber(String lastName, String number) {
		this.lastName = lastName;
		this.number = number;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}
}