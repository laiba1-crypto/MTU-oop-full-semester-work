public class OOPLanguage extends ProgrammingLanguage {

    boolean _isCompiled;

    public OOPLanguage(int _numWorldSpeakers, int _learningMonths, boolean _isCompiled) {
        super(_numWorldSpeakers, _learningMonths);
        this._numWorldSpeakers = _numWorldSpeakers;
        this._learningMonths = _learningMonths;
        this._isCompiled = _isCompiled;
    }

    public boolean getIsCompiled() {
        return _isCompiled;
    }

    public void setIsCompiled(boolean _iscompiled) {
        this._isCompiled = _iscompiled;
    }

    @Override
    public int computeSalary() {
        int salary = 50000;
        if (_isCompiled != true) {
            return salary;
        } else
            return super.computeSalary();

    }

}