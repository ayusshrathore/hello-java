package Generics;

public class User implements Comparable<User>{
    private int points;
    public User(int points){
       this.points = points;
    }
    @Override
    public int compareTo(User other) {
        // this < other return -1
        // this == other return 0
        // this > other return1
        return points - other.points;
    }

    @Override
    public String toString(){
        return "Points = " + points;
    }
}
