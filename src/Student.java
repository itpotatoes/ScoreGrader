import java.util.ArrayList;

public class Student {


    String name;
    int stno;

    ArrayList<Subject> subjectList = new ArrayList<Subject>();
    double score;

    public Student(int stno,String name){
        this.stno = stno;
        this.name = name;
    }
    public void addSubject(Subject subject){
        this.subjectList.add(subject);
    }

    public Subject getSubject(String SubjectName){
        for (Subject subject : subjectList) {
            if(subject.name.equals(SubjectName)){
                return subject;
            }
        }
        return null;
    }
    public double getSubjectScore(String SubjectName){
        for(Subject subject : subjectList){
            if(subject.name.equals(SubjectName)){
                return subject.score;
            }
        }
        return 0;
    }


    public String getName() {
        return name;
    }

    public int getStno() {
        return stno;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public double getScore() {
        return score;
    }


    //점수 계산
    public void calcScore(){
        double score = 0;
        int credit =0;

        for(Subject subject : subjectList){
            score += subject.getScore() * subject.credit;
            credit += subject.credit;
        }
        score /=credit;
        this.score = score;
    }
}
