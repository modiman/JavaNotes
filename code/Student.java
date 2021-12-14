public class Student extends Person {
    private String major;

    public void setMajor(String m){
        major = m;
    }

    public String getMajor(){
        return major;
    }

    public String getDescription(){
        return "this is a good student whose major is "+major;
    }
}
