public class CompanySoftwareProject {
    int _numProgrammers;
    ProgrammingLanguage _myProgrammingLanguage;

    public CompanySoftwareProject(int _numProgrammers, ProgrammingLanguage _myProgrammingLanguage) {
        this._numProgrammers = _numProgrammers;
        this._myProgrammingLanguage = _myProgrammingLanguage;
    }

    public int getNumProgrammers() {
        return _numProgrammers;
    }

    public ProgrammingLanguage getMyProgrammingLanguage() {
        return _myProgrammingLanguage;
    }

    public void setNumProgrammers(int _numProgrammers) {
        this._numProgrammers = _numProgrammers;
    }

    public void setMyProgrammingLanguage(ProgrammingLanguage _myProgrammingLanguage) {
        this._myProgrammingLanguage = _myProgrammingLanguage;
    }

    public int computeProjectCost() {
        int salary = 50000;
        return salary * _numProgrammers;
    }

}