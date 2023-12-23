public class ProgrammingLanguage extends Language {

    int _learningMonths;

    public ProgrammingLanguage(int _numWorldSpeakers, int _learningMonths) {
        super(true, _numWorldSpeakers);
        this._numWorldSpeakers = _numWorldSpeakers;
        this._learningMonths = _learningMonths;
    }

    public ProgrammingLanguage(int _learningMonths) {
        super(true, _learningMonths);
        this._learningMonths = _learningMonths;
    }

    public int getLearningMonths() {
        return _learningMonths;
    }

    public void setLearningMonths(int _learningMonths) {
        this._learningMonths = _learningMonths;
    }

    @Override
    public void setAlphabetBased(boolean _alphabetBased) {
        super.setAlphabetBased(true);

    }

    @Override
    public int computeSalary() {
        int salary = 30000;
        return salary + (1000 * _learningMonths);
    }

}