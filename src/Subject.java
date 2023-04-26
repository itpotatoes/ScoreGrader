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
