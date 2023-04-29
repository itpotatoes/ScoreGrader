import java.util.*;

public class Main {

    // WhiteStarUML이 Java 1.5 버전을 사용하여 ArrayList 생성시 new ArrayList<>()에서 <> 사이에 타입을 작성해야 정상작동함
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<String> subjectNameList = new ArrayList<String>(Arrays.asList("Korean","English","Math","Science"));

    public static void main(String[] args) {

        //학생 정보 지정
        StudentSet();
        // 메뉴 호출
        PrintMenu();


    }
    
    
    //메뉴 출력 메소드
    static void PrintMenu(){
        int choice = 1;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("*********************");
            System.out.println("   성적 관리 프로그램   ");
            System.out.println("*********************");
            System.out.println(" 1. 과목별 수강생");
            System.out.println(" 2. 과목별 성적 순위");
            System.out.println(" 3. 전체 성적 순위");
            System.out.println(" 4. 전체 학생 교과목");
            System.out.println(" 0. 종료");
            System.out.print("메뉴 선택 : ");
            choice = scanner.nextInt();

            if(choice==1){
                subjectShow();
            }else if(choice==2){
                subjectRanking();
            }else if(choice==3){
                ranking();
            }else if(choice==4){
                studentInfo();
            }else if(choice==0){
                System.exit(0);
            }else{
                System.out.println("번호를 잘못 입력하셨습니다.");
            }

        }while(true);


    }


    //학생설정 ( 학생은 임의로 직접 입력 )
    static void StudentSet(){

        int midscore;
        int finalscore;
        Random random = new Random();

        
        //학생객체를 생성하여 리스트에 추가
        studentList.add(new Student(20190012,"김민지"));
        studentList.add(new Student(20190123,"이영희"));
        studentList.add(new Student(20190734,"박준형"));
        studentList.add(new Student(20190456,"최승우"));
        studentList.add(new Student(20190567,"임선영"));
        studentList.add(new Student(20190278,"정민재"));
        studentList.add(new Student(20190389,"홍길동"));
        studentList.add(new Student(20190990,"송재우"));
        studentList.add(new Student(20190801,"강지원"));
        studentList.add(new Student(20190612,"윤재영"));

        //과목지정
        //과목이름 리스트를 만들어 과목을 섞어 앞에 3과목을 학생에게 할당
        //점수는 랜덤으로 지정
        for (Student student : studentList) {
            Collections.shuffle(subjectNameList);

            midscore = random.nextInt(100)+1;
            finalscore = random.nextInt(100)+1;
            Subject s1 = new Subject(subjectNameList.get(0),midscore,finalscore);
            student.addSubject(s1);

            midscore = random.nextInt(100)+1;
            finalscore = random.nextInt(100)+1;
            Subject s2 = new Subject(subjectNameList.get(1),midscore,finalscore);
            student.addSubject(s2);

            midscore = random.nextInt(100)+1;
            finalscore = random.nextInt(100)+1;
            Subject s3 = new Subject(subjectNameList.get(2),midscore,finalscore);
            student.addSubject(s3);

            
            //점수계산
            student.calcScore();
        }



    }


    static void subjectShow(){
        //과목별 리스트 생성
        ArrayList<String> korean = new ArrayList<String>();
        ArrayList<String> English = new ArrayList<String>();
        ArrayList<String> Math = new ArrayList<String>();
        ArrayList<String> Science = new ArrayList<String>();

        //foreach를 사용하여 모든 학생들을 과목별 리스트로 분류
        for(Student student : studentList){
            for(int i = 0; i<3; i++){
                if(student.subjectList.get(i).name == "Korean"){
                    korean.add(student.name);
                }else if(student.subjectList.get(i).name == "English"){
                    English.add(student.name);
                }else if(student.subjectList.get(i).name == "Math"){
                    Math.add(student.name);
                }else if(student.subjectList.get(i).name == "Science"){
                    Science.add(student.name);
                }



            }
        }
        //과목별 리스트 출력
        System.out.println("Korean : " + Arrays.deepToString(korean.toArray()));
        System.out.println("English : " + Arrays.deepToString(English.toArray()));
        System.out.println("Math : " + Arrays.deepToString(Math.toArray()));
        System.out.println("Science : " + Arrays.deepToString(Science.toArray()));

    }

    static void subjectRanking(){

        //Student 타입으로 과목별 리스트 생성
        ArrayList<Student> Korean = new ArrayList<Student>();
        ArrayList<Student> English = new ArrayList<Student>();
        ArrayList<Student> Math = new ArrayList<Student>();
        ArrayList<Student> Science = new ArrayList<Student>();

        //학생들을 과목별 리스트로 분류
        for(Student student : studentList){
            for(int i = 0; i<3; i++){
                if(student.subjectList.get(i).name == "Korean"){
                    Korean.add(student);
                }else if(student.subjectList.get(i).name == "English"){
                    English.add(student);
                }else if(student.subjectList.get(i).name == "Math"){
                    Math.add(student);
                }else if(student.subjectList.get(i).name == "Science"){
                    Science.add(student);
                }
            }
        }

        //국어 과목 순위 정렬
        Collections.sort(Korean, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Subject s1 = o1.getSubject("Korean");
                Subject s2 = o2.getSubject("Korean");
                return s1.score>s2.score ? -1:(s1.score<s2.score?1:0);
            }
        });

        //영어 과목 순위 정렬
        Collections.sort(English, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Subject s1 = o1.getSubject("English");
                Subject s2 = o2.getSubject("English");
                return s1.score>s2.score ? -1:(s1.score<s2.score?1:0);
            }
        });

        //수학 과목 순위 정렬
        Collections.sort(Math, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Subject s1 = o1.getSubject("Math");
                Subject s2 = o2.getSubject("Math");
                return s1.score>s2.score ? -1:(s1.score<s2.score?1:0);
            }
           });
        //과학 과목 순위 정렬
        Collections.sort(Science, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Subject s1 = o1.getSubject("Science");
                Subject s2 = o2.getSubject("Science");
                return s1.score>s2.score ? -1:(s1.score<s2.score?1:0);
            }
        });


        //정렬된 과목별 순위 출력
        System.out.println("[ Korean Ranking ]");
        for (int i = 0; i < Korean.size(); i++) {
            System.out.println((i+1) +"등 :" + Korean.get(i).getName() + "   "+ Korean.get(i).getSubjectScore("Korean")+"점");
        }
        System.out.println();
        System.out.println("[ English Ranking ]");
        for (int i = 0; i < English.size(); i++) {
            System.out.println((i+1) +"등 :" + English.get(i).getName()+ "   "+ English.get(i).getSubjectScore("English")+"점");
        }
        System.out.println();
        System.out.println("[ Math Ranking ]");
        for (int i = 0; i < Math.size(); i++) {
            System.out.println((i+1) +"등:" + Math.get(i).getName()+ "   "+ Math.get(i).getSubjectScore("Math")+"점");
        }
        System.out.println();
        System.out.println("[ Science Ranking ]");
        for (int i = 0; i < Science.size(); i++) {
            System.out.println((i+1) +"등:" + Science.get(i).getName() +"   " +Science.get(i).getSubjectScore("Science")+"점");

        }


    }



    static void ranking(){

        //전체학생을 점수로 정렬
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double s1 = o1.getScore();
                double s2 = o2.getScore();
                return s1>s2 ? -1:(s1<s2?1:0);
            }
        });
        
        //순위 출력
        System.out.println();
        System.out.println("[ Total Ranking ]");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i+1) +"등:" + studentList.get(i).getName() +"   " +String.format("%.2f",studentList.get(i).score)+ "점");

        }


    }

    static void studentInfo(){


        //학생정보를 등수로 정렬 ( 과제 영상에서 등수로 출력하였기에 다시 정렬 )
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                double s1 = o1.getScore();
                double s2 = o2.getScore();
                return s1>s2 ? -1:(s1<s2?1:0);
            }
        });

        //출력
        System.out.println();
        System.out.println("[ Student Info ]");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("등수: "+(i+1) +", 학번: "+ studentList.get(i).getStno() +", 이름: "+studentList.get(i).getName()+", 성적: "+String.format("%.2f",studentList.get(i).getScore())+"점");
            System.out.println("과목이름 : "+ studentList.get(i).subjectList.get(0).name +" ( "+studentList.get(i).subjectList.get(0).credit+" ) " + studentList.get(i).subjectList.get(0).score + "점");
            System.out.println("과목이름 : "+ studentList.get(i).subjectList.get(1).name +" ( "+studentList.get(i).subjectList.get(1).credit+" ) " + studentList.get(i).subjectList.get(1).score + "점" );
            System.out.println("과목이름 : "+ studentList.get(i).subjectList.get(2).name +" ( "+studentList.get(i).subjectList.get(2).credit+" ) " + studentList.get(i).subjectList.get(2).score + "점");
            System.out.println();
        }



    }


}