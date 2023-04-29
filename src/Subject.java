public class Subject {
        String name;
        double credit;
        double midTermScore;
        double finalTermScore;
        double score;

        public String getName() {
                return name;
        }

        public double getCredit() {
                return credit;
        }

        public double getMidTermScore() {
                return midTermScore;
        }

        public double getFinalTermScore() {
                return finalTermScore;
        }

        public double getScore() {
                return score;
        }

        
        //과목 분류 및 학점에 맞게 정보 저장
        public Subject(String name, double midTermScore, double finalTermScore){
                this.name = name;
                this.midTermScore = midTermScore;
                this.finalTermScore = finalTermScore;
                this.score = (midTermScore+finalTermScore)/2;

                if(name.equals("Korean") || name.equals("English")){
                        credit = 3;
                }else if(name.equals("Math") || name.equals("Science")){
                        credit = 2;
                }


        }

}
