
public class Module {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    String Title;
    int myCRN;
    boolean isCA;


    //---------------------------------------
    //	Constructor
    //---------------------------------------
    public Module(String myTitle, int myCRN, boolean isCA) {
        this.Title = myTitle;
        this.myCRN = myCRN;
        this.isCA = isCA;
    }


    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public String getTitle() {
        return Title;
    }

    public int getCRN() {
        return myCRN;
    }

    public boolean getIsCA() {
        return isCA;
    }


    //---------------------------------------
    //	Set Methods
    //---------------------------------------
    public void setTitle(String myTitle) {
        this.Title = myTitle;
    }

    public void setCRN(int myCRN) {
        this.myCRN = myCRN;
    }

    public void setIsCA(boolean CA) {
        isCA = CA;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public void printModuleInfo(int option) {
        if (option == 1) {
            System.out.println("Title : " + Title);

        } else if (option == 2) {
            System.out.println("CRN : " + myCRN);
        } else if (option == 3) {
            System.out.println("CA : " + isCA);
        } else {

        }
    }

    public int sumOfCRNDigits() {
        int sum = 0;
        while (myCRN != 0) {
            sum = sum + myCRN % 10;
            myCRN = myCRN / 10;
        }
        return sum;
    }

    public int numVowelsOnTitle() {
        String vowel = Title;
        vowel = vowel.toLowerCase();
        int count = 0;
        for (int i = 0; i < vowel.length(); i++) {
            // check if char[i] is vowel
            if (vowel.charAt(i) == 'a' || vowel.charAt(i) == 'e'
                    || vowel.charAt(i) == 'i'
                    || vowel.charAt(i) == 'o'
                    || vowel.charAt(i) == 'u') {
                // count increments if there is vowel in
                // char[i]
                count++;
            }
        }
        return count;
    }
}
