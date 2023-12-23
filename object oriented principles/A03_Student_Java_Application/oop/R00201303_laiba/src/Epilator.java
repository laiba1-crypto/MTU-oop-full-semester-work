/**
 * @author: Laiba Asif
 */
//--------------------------------------------------
//
//	CLASS Product
//
//--------------------------------------------------
/**
 * This class models a Epilator item of the drugstore<br>
 * .
 */
public class Epilator extends Product {

    // ---------------------------------------
    // Fields
    // ---------------------------------------
    private String make, model;
    private int blades;
    private boolean waterproof;

    public Epilator(String theMake, String theModel, int blade, boolean wp, float thePrice, String description) {
        setProductID(getIdGenerator());
        setIdGenerator(getIdGenerator() + 1); // increment static ID generator
        // ---------------------------------------
        // Constructor
        // ---------------------------------------
        make = theMake;
        model = theModel;
        blades = blade;
        waterproof = wp;
        setPrice(thePrice);
        setDescription(description);

        this.setName(make + " " + model + " " + blades + "\"");// For when Product.print() is called instead of
                                                               // epilator.print();
        if (waterproof == true) {
            this.setName(this.getName() + " Water Proof");
        }

    }
    // ---------------------------------------
    // GET METHODS
    // ---------------------------------------

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    // ---------------------------------------
    // SET METHODS
    // ---------------------------------------

    public void setType(String model) {
        this.model = model;
    }

    public int getBlades() {
        return blades;
    }

    public void setBlades(int blades) {
        this.blades = blades;
    }

    public boolean isWaterProof() {
        return waterproof;
    }

    public void setWaterProof(boolean iswp) {
        waterproof = iswp;
    }

    public void print() {

        System.out.println("Product ID:\t\t" + getProductID());
        System.out.println("Epilator Make:\t\t" + make);
        System.out.println("How Many Blades? :\t\t" + blades);
        System.out.println("Epilator Model:\t\t" + model);
        System.out.println("Is It WaterProof?\t\t" + waterproof);
        System.out.println("Product description:\t" + getDescription());
        System.out.println("Product price:\t\t" + getPrice());

    }

}
