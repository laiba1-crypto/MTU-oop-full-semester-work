public class Language {

    boolean _alphabetBased;
    int _numWorldSpeakers;

    public Language() {
    };

    public Language(boolean _alphabetBased, int _numWorldSpeakers) {
        this._alphabetBased = _alphabetBased;
        this._numWorldSpeakers = _numWorldSpeakers;
    }

    public boolean getAlphabetBased() {
        return _alphabetBased;
    }

    public int getNumWorldSpeakers() {
        return _numWorldSpeakers;
    }

    public void setAlphabetBased(boolean _alphabetBased) {
        this._alphabetBased = _alphabetBased;
    }

    public void setNumWorldSpeakers(int _numWorldSpeakers) {
        this._numWorldSpeakers = _numWorldSpeakers;
    }

    public int computeSalary() {

        int salary = 40000;
        if (_alphabetBased != true) {
            return salary;
        } else {
            if (_numWorldSpeakers > 30) {
                System.out.println("Salary can't be below 30000");
                return salary - 10000;
            } else if (_numWorldSpeakers == 30) {
                return salary + 20000 - 30000;
            } else if (_numWorldSpeakers >= 20) {
                return salary + 20000 - 20000;
            } else if (_numWorldSpeakers >= 10) {
                return salary + 20000 - 10000;
            } else if (_numWorldSpeakers >= 1) {

                return salary + 20000 - 1000;
            }
            return salary;
        }

    }

    public final int computeSalary(int _numYearsExperience) {
        int value = 5000;
        int total = (_numYearsExperience * value);
        return total;

    }

}