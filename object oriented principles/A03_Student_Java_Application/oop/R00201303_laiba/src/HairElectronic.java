
/**
 * @author: Laiba Asif
 */
//--------------------------------------------------
//
//	CLASS Product
//
//--------------------------------------------------
/**
 * This class models a HairElectronic item of the drugstore<br>
 * .
 */
public class HairElectronic extends Product {

	// ---------------------------------------
	// Fields
	// ---------------------------------------
	private String make, type;
	private int power;

	public HairElectronic(String theMake, String theType, int thePower, double price, String description) {
		setProductID(getIdGenerator());
		setIdGenerator(getIdGenerator() + 1); // increment static ID generator
		// ---------------------------------------
		// Constructor
		// ---------------------------------------
		make = theMake;
		type = theType;
		power = thePower;
		setPrice(price);
		setDescription(description);

		this.setName(make + " " + type + " " + power + "Volts");// For when Product.print() is called instead of
																// hairelectronic.print();
	}
	// ---------------------------------------
	// GET METHODS
	// ---------------------------------------

	public String getMake() {
		return make;
	}

	// ---------------------------------------
	// SET METHODS
	// ---------------------------------------

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPoweer() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void print() {
		System.out.println("Product ID:\t\t" + getProductID());
		System.out.println("Hair Electronic Make:\t\t" + make);
		System.out.println("Hair Electronic Type:\t\t" + type);
		System.out.println("Hair Electronic Power(Volts):\t\t" + power + "Volts");
		System.out.println("Hair Electronic description:\t" + getDescription());
		System.out.println("Hair Electronic price:\t\t" + getPrice());
	}
}